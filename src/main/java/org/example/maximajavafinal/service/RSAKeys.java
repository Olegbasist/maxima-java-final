package org.example.maximajavafinal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service
public class RSAKeys {

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    @Value("${rsa.privatekey.path}")
    private String privetKeyPath;

    @Value("${rsa.publickey.path}")
    private String publicKeyPath;

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

}
