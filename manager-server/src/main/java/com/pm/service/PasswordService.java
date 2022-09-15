package com.pm.service;

public interface PasswordService {
    /**
     * 判断密码是否有效
     * @param rawPass 明文密码
     * @param salt 混淆码
     * @param encPass 加密密码
     * @return boolean类型
     */
    boolean isPasswordValid(String rawPass, String salt, String encPass);
}
