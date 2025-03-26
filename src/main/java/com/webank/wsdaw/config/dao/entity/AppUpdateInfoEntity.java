package com.webank.wsdaw.config.dao.entity;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AppUpdateInfoEntity {

    private long pkId;

    private String version;

    private String androidUrl;

    private String iosUrl;

    private String introUrl;

    private Date createTime;
}
