package com.webank.wsdaw.config.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoRaw {
    String signUserId;
    String appId;
    String address;
    String publicKey;
    String privateKey;
    String description;
    int encryptType;
    String setId;
}
