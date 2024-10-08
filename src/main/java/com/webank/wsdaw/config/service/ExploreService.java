package com.webank.wsdaw.config.service;

import com.webank.wsdaw.config.dao.entity.BannerInfoEntity;
import com.webank.wsdaw.config.dao.entity.ExploreInfoEntity;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;

public interface ExploreService {
    public CommonResponse<List<ExploreInfoEntity>> getExploreInfo();

    public CommonResponse<List<ExploreInfoEntity>> searchExploreInfo(String text);

    public CommonResponse<List<BannerInfoEntity>> getBannerInfo();
}
