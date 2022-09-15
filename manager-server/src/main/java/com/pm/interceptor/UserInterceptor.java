package com.pm.interceptor;

import com.pm.common.entity.Payload;
import com.pm.common.entity.UserInfo;
import com.pm.common.threadlocals.UserHolder;
import com.pm.common.utils.JwtUtils;
import com.pm.config.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    StringRedisTemplate redisTemplate;


    /**
     * 为了避免引入中间件，我在token中存入了token的过期时间
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token信息
        String token = request.getHeader(jwtProperties.getTokenName());
        UserHolder.setUser(null);
        if (token == null || token.trim().equals("")) {
            // 如果此时没有token进入需要查询权限的接口时，可以给前端抛出401异常
            return true;
        }
        if (redisTemplate.hasKey(token)) {
            log.error("TOKEN已过期");
            return true;
        }
        Payload<UserInfo> infoFromToken = null;
        try {
            infoFromToken = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey(), UserInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("TOKEN解析失败");
            return true;
//            throw new LzException(ExceptionEnum.UNAUTHORIZED);
        }
        UserInfo userInfo = infoFromToken.getInfo();
        Date expiration = infoFromToken.getExpiration();
        long time = DateTime.now().toDate().getTime();
        long time1 = expiration.getTime();
        if (time1 < time) {
            // 此时token已过期，cookie却未过期,强制cookie过期
            log.info("TOKEN已过期");
            return true;
        }
        // token剩余毫秒值
        long l = time1 - time;
        if (l < jwtProperties.getCookieMaxAge() * 500) {
            // 剩余时间少于既定时间一半，重新签发token,并使前一个token失效
            String s = JwtUtils.generateTokenExpireInSeconds(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
            redisTemplate.boundValueOps(token).set("",l, TimeUnit.SECONDS);
            response.setHeader(jwtProperties.getTokenName(),s);
        }else {
            response.setHeader(jwtProperties.getTokenName(),token);
        }
        UserHolder.setUser(userInfo);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求结束后执行remove方法，这里是为了避免出现内存泄漏
        UserHolder.removeUser();
    }
}
