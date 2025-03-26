package com.webank.wsdaw.config.service.impl;

import com.webank.wsdaw.config.dao.entity.BannerInfoEntity;
import com.webank.wsdaw.config.dao.entity.ExploreInfoEntity;
import com.webank.wsdaw.config.dao.mapper.BannerInfoMapper;
import com.webank.wsdaw.config.dao.mapper.ExploreInfoMapper;
import com.webank.wsdaw.config.service.ExploreService;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExploreServiceImpl implements ExploreService {

    @Autowired private ExploreInfoMapper exploreInfoMapper;
    @Autowired private BannerInfoMapper bannerInfoMapper;

    @Override
    public CommonResponse<List<ExploreInfoEntity>> getExploreInfo() {
        List<ExploreInfoEntity> exploreInfoEntities = exploreInfoMapper.selectAll();
        return CommonResponse.success(exploreInfoEntities);
    }

    @Override
    public CommonResponse<List<ExploreInfoEntity>> searchExploreInfo(String text) {
        List<ExploreInfoEntity> exploreInfoEntities = exploreInfoMapper.selectByNameLike(text);
        return CommonResponse.success(exploreInfoEntities);
    }

    @Override
    public CommonResponse<List<BannerInfoEntity>> getBannerInfo() {
        List<BannerInfoEntity> bannerInfoEntities = bannerInfoMapper.selectAll();
        return CommonResponse.success(bannerInfoEntities);
    }
}
