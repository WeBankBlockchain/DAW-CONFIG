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
public class HkUserEntity {
    private long pkId;
    private String email;
    private String firstName;
    private String lastName;
    private String company;
    private String phoneCode;
    private String phoneNumber;
    private int status = 0;
    private Date createTime;
    private Date updateTime;
}
