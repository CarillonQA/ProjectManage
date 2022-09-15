package com.pm.common.threadlocals;

import com.pm.common.entity.UserInfo;

/**
 * 保证线程之间的用户不冲突
 */
public class UserHolder {
    private static final ThreadLocal<UserInfo> TL = new ThreadLocal<>();

    public static void setUser(UserInfo userInfo) {
        TL.set(userInfo);
    }

    public static UserInfo getUser() {
        return TL.get();
    }

    public static void removeUser() {
        TL.remove();
    }
}
