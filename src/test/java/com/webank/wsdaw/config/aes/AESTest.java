package com.webank.wsdaw.config.aes;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.symmetric.AES;
import com.webank.wsdaw.config.ServerApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AESTest extends ServerApplicationTests {

    @Autowired private AES aes;

    @Test
    public void testAES() throws Exception {
        String encryptHexResult =
                aes.encryptHex("2e5661734b787379759a6ee7532e45785ee2c0439f16804a0b2e12773e7d8a06");
        String decryptResult = aes.decryptStr(encryptHexResult);
        Assert.equals(
                "2e5661734b787379759a6ee7532e45785ee2c0439f16804a0b2e12773e7d8a06", decryptResult);
    }
}
