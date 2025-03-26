package com.webank.wsdaw.config.controller;

import com.webank.wsdaw.config.dao.entity.AssetSeriesEntity;
import com.webank.wsdaw.config.service.AssetSeriesService;
import com.webank.wsdaw.config.vo.request.AssetSeriesRequest;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assetSeries")
public class AssetSeriesController {
    @Autowired private AssetSeriesService assetSeriesService;

    @PostMapping("getByType")
    public CommonResponse<List<AssetSeriesEntity>> getAssetSeriesByType(
            @RequestBody @Valid AssetSeriesRequest request) throws Exception {
        return assetSeriesService.getAssetSeriesByType(request.getSeriesType());
    }
}
