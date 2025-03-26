package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.AssetSeriesEntity;
import java.util.List;
import org.apache.ibatis.annotations.*;

public interface AssetSeriesMapper {

    @Insert(
            "INSERT INTO t_asset_series (series_name, series_icon, series_type, contract_address, status) "
                    + "VALUES (#{seriesName}, #{seriesIcon}, #{seriesType}, #{contractAddress}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(AssetSeriesEntity assetSeries);

    // 根据ID查询
    @Select("SELECT * FROM t_asset_series WHERE id = #{id}")
    AssetSeriesEntity findById(Long id);

    // 根据系列名称查询
    @Select("SELECT * FROM t_asset_series WHERE series_name = #{seriesName}")
    AssetSeriesEntity findBySeriesName(String seriesName);

    // 根据系列类型查询
    @Select("SELECT * FROM t_asset_series WHERE series_type = #{seriesType} and status = 0")
    List<AssetSeriesEntity> findBySeriesType(String seriesType);

    // 根据合约地址查询
    @Select("SELECT * FROM t_asset_series WHERE contract_address = #{contractAddress}")
    AssetSeriesEntity findByContractAddress(String contractAddress);

    // 根据状态查询
    @Select("SELECT * FROM t_asset_series WHERE status = #{status}")
    List<AssetSeriesEntity> findByStatus(int status);

    // 更新记录
    @Update(
            "UPDATE t_asset_series SET series_name = #{seriesName}, series_icon = #{seriesIcon}, "
                    + "series_type = #{seriesType}, contract_address = #{contractAddress}, status = #{status} "
                    + "WHERE id = #{id}")
    void update(AssetSeriesEntity assetSeries);

    // 查询所有记录
    @Select("SELECT * FROM t_asset_series")
    List<AssetSeriesEntity> findAll();
}
