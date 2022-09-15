package com.pm.service;

import com.pm.common.entity.UserInfo;
import com.pm.entity.user.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    UserInfo checkUser(UserDto userDto, HttpServletRequest request, HttpServletResponse response);
}
