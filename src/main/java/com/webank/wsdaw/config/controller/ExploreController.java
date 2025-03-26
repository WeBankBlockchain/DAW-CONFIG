package com.webank.wsdaw.config.controller;

import com.webank.wsdaw.config.dao.entity.BannerInfoEntity;
import com.webank.wsdaw.config.dao.entity.ExploreInfoEntity;
import com.webank.wsdaw.config.service.ExploreService;
import com.webank.wsdaw.config.vo.request.SearchRequest;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/explore")
public class ExploreController {
    @Autowired private ExploreService exploreService;

    @PostMapping("getExploreInfo")
    public CommonResponse<List<ExploreInfoEntity>> getExploreInfo() throws Exception {
        return exploreService.getExploreInfo();
    }

    @PostMapping("searchExploreInfo")
    public CommonResponse<List<ExploreInfoEntity>> searchExploreInfo(
            @RequestBody @Valid SearchRequest request) throws Exception {
        return exploreService.searchExploreInfo(request.getText());
    }

    @PostMapping("getBannerInfo")
    public CommonResponse<List<BannerInfoEntity>> getBannerInfo() throws Exception {
        return exploreService.getBannerInfo();
    }
}
