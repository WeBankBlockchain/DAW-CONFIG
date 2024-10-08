package com.webank.wsdaw.config.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AuditUserInfoEntity {
    private String auditUser;
    private String password;
    private String address;
    private String privateKey;
}
