package com.webank.wsdaw.config.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AssetSeriesEntity {
    private String seriesName;
    private String seriesIcon;
    private String seriesType;
    private String contractAddress;
    private int status = 0;
}
