package com.pm.service.impl;

import com.pm.common.entity.UserInfo;
import com.pm.common.enums.ExceptionEnum;
import com.pm.common.exception.PmException;
import com.pm.common.utils.JwtUtils;
import com.pm.config.JwtProperties;
import com.pm.dao.UserDao;
import com.pm.entity.user.CoreUser;
import com.pm.entity.user.dto.UserDto;
import com.pm.service.PasswordService;
import com.pm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    PasswordService passwordService;

    @Autowired
    UserDao userDao;

    @Override
    public UserInfo checkUser(UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        // 获取用户数据，存放于用户实体类
        CoreUser coreUser = userDao.queryUserByUserName(userDto.getUsername());
        if (coreUser == null) {
            throw new PmException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        // 验证密码
        boolean passwordValid = passwordService.isPasswordValid(userDto.getPassword(), coreUser.getSalt(), coreUser.getPassword());
        if (!passwordValid) {
            throw new PmException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        // 将用户信息写入userInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setId(coreUser.getId());
        userInfo.setUsername(coreUser.getUsername());
        userInfo.setRealName(coreUser.getRealName());
        userInfo.setHeadPortrait(coreUser.getHeadPortrait());
        userInfo.setNickname(coreUser.getNickname());
        userInfo.setPhoneNumber(coreUser.getPhoneNumber());
        userInfo.setAuthority(coreUser.getAuthority());
        // 生成token
        String s = JwtUtils.generateTokenExpireInSeconds(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        response.setHeader(jwtProperties.getTokenName(), s);
        System.out.println(s);
        return userInfo;
    }

}
