package com.pm.common.security;

/**
 * 证书加密
 */
public interface CredentialsDigest {
	/**
	 * 散列生成摘要
	 * @Title: digest
	 * @param plainCredentials 密码明文
	 * @param salt 混淆码数组
	 * @return: String
	 */
	public String digest(String plainCredentials, byte[] salt);

	/**
	 * 密码是否匹配
	 * @Title: matches
	 * @param credentials  加密后摘要 digest方法得到
	 * @param plainCredentials 密码原文
	 * @param salt 混淆码数组
	 * @return: boolean
	 */
	public boolean matches(String credentials, String plainCredentials,
                           byte[] salt);
}
