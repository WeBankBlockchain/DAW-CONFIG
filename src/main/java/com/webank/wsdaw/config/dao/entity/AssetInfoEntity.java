package com.webank.wsdaw.config.dao.entity;

import cn.hutool.json.JSONUtil;
import com.webank.wsdaw.config.vo.response.AssetConfig;
import com.webank.wsdaw.config.vo.response.AssetInfoResponse;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AssetInfoEntity {
    private String networkName;
    private String contractAddress;
    private String assetName;
    private String assetSymbol;
    private String assetType;
    private String assetIcon;
    private Integer assetStatus;
    private String assetConfig;

    public AssetInfoResponse toAssetInfoResponse() {
        AssetInfoResponse assetInfoResponse = new AssetInfoResponse();
        assetInfoResponse
                .setNetworkName(this.networkName)
                .setContractAddress(this.contractAddress)
                .setAssetName(this.assetName)
                .setAssetSymbol(this.assetSymbol)
                .setAssetType(this.assetType)
                .setAssetIcon(this.assetIcon)
                .setAssetStatus(this.assetStatus);
        AssetConfig ac = JSONUtil.toBean(assetConfig, AssetConfig.class);
        assetInfoResponse.setAssetConfig(ac);
        return assetInfoResponse;
    }
}
