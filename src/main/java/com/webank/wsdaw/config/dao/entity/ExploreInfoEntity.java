package com.webank.wsdaw.config.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ExploreInfoEntity {
    private String pkId;
    private String name;
    private String title;
    private String url;
    private String icon;
    private int priority;
}
