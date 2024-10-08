package com.webank.wsdaw.config.service;

import com.webank.wsdaw.config.dao.entity.AssetSeriesEntity;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;

public interface AssetSeriesService {
    CommonResponse<List<AssetSeriesEntity>> getAssetSeriesByType(String type);
}
