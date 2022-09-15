package com.pm.common.security;

/**
 * SHA1证书加密
 */
public class Sha1CredentialsDigest extends AbstractHashCredentialsDigest {
	@Override
	protected byte[] digest(byte[] input, byte[] salt) {
		return Digests.sha1(input, salt, HASH_INTERATIONS);
	}
}
