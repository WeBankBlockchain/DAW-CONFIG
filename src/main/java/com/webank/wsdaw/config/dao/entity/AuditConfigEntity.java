package com.webank.wsdaw.config.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AuditConfigEntity {
    private String currentVersion;
    private boolean openFlag;
    private boolean hkFlag;
}
