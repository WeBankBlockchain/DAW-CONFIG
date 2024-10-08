package com.webank.wsdaw.config.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BannerInfoEntity {
    private String name;
    private String url;
    private String img;
    private int priority;
}
