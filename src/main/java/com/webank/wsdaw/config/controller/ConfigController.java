package com.webank.wsdaw.config.controller;

import com.webank.wsdaw.config.dao.entity.AuditConfigEntity;
import com.webank.wsdaw.config.service.ConfigService;
import com.webank.wsdaw.config.vo.response.AppUpdateInfoResponse;
import com.webank.wsdaw.config.vo.response.AssetInfoResponse;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class ConfigController {
    @Autowired private ConfigService configService;

    @PostMapping("getAssetInfo")
    public CommonResponse<List<AssetInfoResponse>> getAssetInfo() throws Exception {
        return configService.getAssetInfo();
    }

    @PostMapping("getAppVersion")
    public CommonResponse<AuditConfigEntity> getAppVersion() throws Exception {
        return configService.getAppVersion();
    }

    @PostMapping("getLatestAppUpdateInfo")
    public CommonResponse<AppUpdateInfoResponse> getLatestAppUpdateInfo() throws Exception {
        return configService.getLatestAppUpdateInfo();
    }
}
