package com.webank.wsdaw.config;

import cn.hutool.crypto.symmetric.AES;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.v3.crypto.CryptoSuite;
import org.fisco.bcos.sdk.v3.crypto.keypair.CryptoKeyPair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class GenerateKeyTest extends ServerApplicationTests {
    @Autowired AES aes;
    @Autowired CryptoSuite cryptoSuite;

    @Test
    public void generateAccessKey() {
        CryptoKeyPair cryptoKeyPair = cryptoSuite.generateRandomKeyPair();
        String hexPrivateKey = cryptoKeyPair.getHexPrivateKey();
        String encryptHex = aes.encryptHex(hexPrivateKey);

        log.info("access key encrypt succeed: {}", encryptHex);
        log.info("access key hex succeed: {}", hexPrivateKey);
    }
}
