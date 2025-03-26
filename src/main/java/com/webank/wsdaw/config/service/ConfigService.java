package com.webank.wsdaw.config.service;

import com.webank.wsdaw.config.dao.entity.AuditConfigEntity;
import com.webank.wsdaw.config.vo.response.AppUpdateInfoResponse;
import com.webank.wsdaw.config.vo.response.AssetInfoResponse;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;

public interface ConfigService {
    public CommonResponse<List<AssetInfoResponse>> getAssetInfo();

    public CommonResponse<AuditConfigEntity> getAppVersion();

    CommonResponse<AppUpdateInfoResponse> getLatestAppUpdateInfo();
}
