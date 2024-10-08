package com.webank.wsdaw.config.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AssetConfig {
    private String chainID;
    private String groupID;
    private String rechargeWithdrawContractAddress;
}
