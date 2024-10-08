package com.webank.wsdaw.config.service.impl;

import cn.hutool.json.JSONUtil;
import com.webank.wsdaw.config.dao.entity.AssetSeriesEntity;
import com.webank.wsdaw.config.dao.mapper.AssetSeriesMapper;
import com.webank.wsdaw.config.service.AssetSeriesService;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssetSeriesServiceImpl implements AssetSeriesService {

    @Autowired private AssetSeriesMapper assetSeriesMapper;

    @Override
    public CommonResponse<List<AssetSeriesEntity>> getAssetSeriesByType(String type) {
        List<AssetSeriesEntity> assetSeriesEntities = assetSeriesMapper.findBySeriesType(type);
        log.info("asset info entity: {}", JSONUtil.toJsonPrettyStr(assetSeriesEntities));
        return CommonResponse.success(assetSeriesEntities);
    }
}
