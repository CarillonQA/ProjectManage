package com.pm.service.impl;

import com.pm.common.security.CredentialsDigest;
import com.pm.common.utils.Encodes;
import com.pm.service.PasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Resource(name = "credentialsDigest")
    private CredentialsDigest credentialsDigest;

    @Override
    public boolean isPasswordValid(String rawPass, String salt, String encPass) {
        byte[] saltBytes = Encodes.decodeHex(salt);
        String rawPassEnc = credentialsDigest.digest(rawPass, saltBytes);
        return rawPassEnc.equals(encPass);
    }
}
