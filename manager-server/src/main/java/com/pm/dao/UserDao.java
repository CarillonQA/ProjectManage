package com.pm.dao;

import com.pm.entity.user.CoreUser;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    CoreUser queryUserByUserName(@Param("username") String username);
}
