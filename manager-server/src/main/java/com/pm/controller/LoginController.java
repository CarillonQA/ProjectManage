package com.pm.controller;

import com.pm.common.entity.Payload;
import com.pm.common.entity.UserInfo;
import com.pm.common.enums.ExceptionEnum;
import com.pm.common.exception.PmException;
import com.pm.common.threadlocals.UserHolder;
import com.pm.common.utils.CookieUtils;
import com.pm.common.utils.JwtUtils;
import com.pm.config.JwtProperties;
import com.pm.entity.user.dto.UserDto;
import com.pm.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public ResponseEntity<UserInfo> login(@RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        UserInfo user = UserHolder.getUser();
        if (user != null) {
            throw new PmException(ExceptionEnum.REPEAT_LOGIN);
        }
        UserInfo res = userService.checkUser(userDto, request, response);
//        System.out.println(res);
        return ResponseEntity.ok(res);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户点击后会清理cookie中的token，需要前端收到成功的信息后清理登录的状态")
    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(jwtProperties.getTokenName());
        Payload<Object> infoFromToken = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
        // token失效时间
        long time = infoFromToken.getExpiration().getTime();
        // 获取当前毫秒值
        long l = System.currentTimeMillis();
        // 获取剩余时间
        long l1 = time - l;
        // 加入token黑名单
        redisTemplate.boundValueOps(token).set("",l1, TimeUnit.MILLISECONDS);
        CookieUtils.newBuilder().name(jwtProperties.getTokenName()).maxAge(0).value("0").request(request).response(response).domain(jwtProperties.getDomain()).build();
        return ResponseEntity.status(200).build();
    }

    @RequestMapping("/test")
    public List<String> test() {
        List<String> strings = new ArrayList<>();
        strings.add("test方法");
        strings.add("token有效吗");
        return strings;
    }

}
