package com.webank.wsdaw.config.dao.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmailVerificationEntity {
    private Long pkId;
    private String verificationCode;
    private String email;
    private boolean verified = false;
    private Date createTime;
    private Date updateTime;
}
