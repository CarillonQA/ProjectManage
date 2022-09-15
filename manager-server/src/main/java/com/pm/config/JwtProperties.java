package com.pm.config;


import com.pm.common.utils.RsaUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@Data
@ConfigurationProperties(prefix = "pm.jwt")
public class JwtProperties {

    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);


    private String publicKeyPath;
    private String privateKeyPath;
    private String tokenName;
    private Integer expire;
    private String secret;
    private Integer cookieMaxAge;
    private String domain;


    private PublicKey publicKey;
    private PrivateKey privateKey;


    /**
     * @PostConstruct 注解意为在构造方法执行后执行此方法
     */
    @PostConstruct
    public void init() {
        try {
            File pubKey = new File(publicKeyPath);
            File priKey = new File(privateKeyPath);
            // 判断如果没有生成公钥私钥则生成
            if (!priKey.exists() || !pubKey.exists()) {
                RsaUtils.generateKey(publicKeyPath, privateKeyPath, secret,10);
            }
            this.publicKey = RsaUtils.getPublicKey(publicKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(privateKeyPath);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("初始化公钥，私钥失败！", e);
            throw new RuntimeException();
        }
    }
}
