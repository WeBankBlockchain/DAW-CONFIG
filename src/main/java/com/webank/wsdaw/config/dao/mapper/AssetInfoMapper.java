package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.AssetInfoEntity;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface AssetInfoMapper {
    @Select("SELECT * FROM t_asset_info WHERE pk_id = #{pkId}")
    AssetInfoEntity getAssetInfoById(Long pkId);

    @Select("SELECT * FROM t_asset_info WHERE asset_symbol = #{assetSymbol}")
    AssetInfoEntity getAssetInfoByAssetSymbol(String assetSymbol);

    @Select("SELECT * FROM t_asset_info")
    List<AssetInfoEntity> getAllAssetInfo();
}
