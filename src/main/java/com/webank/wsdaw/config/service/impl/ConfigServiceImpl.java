package com.webank.wsdaw.config.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.webank.wsdaw.config.dao.entity.AppUpdateInfoEntity;
import com.webank.wsdaw.config.dao.entity.AssetInfoEntity;
import com.webank.wsdaw.config.dao.entity.AuditConfigEntity;
import com.webank.wsdaw.config.dao.mapper.AppUpdateInfoMapper;
import com.webank.wsdaw.config.dao.mapper.AssetInfoMapper;
import com.webank.wsdaw.config.dao.mapper.AuditConfigMapper;
import com.webank.wsdaw.config.enums.CodeEnum;
import com.webank.wsdaw.config.service.ConfigService;
import com.webank.wsdaw.config.vo.response.AppUpdateInfoResponse;
import com.webank.wsdaw.config.vo.response.AssetInfoResponse;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {

    @Autowired private AssetInfoMapper assetInfoMapper;
    @Autowired private AuditConfigMapper auditConfigMapper;
    @Autowired private AppUpdateInfoMapper appUpdateInfoMapper;

    @Override
    public CommonResponse<List<AssetInfoResponse>> getAssetInfo() {
        List<AssetInfoEntity> assetInfoEntity = assetInfoMapper.getAllAssetInfo();
        if (CollectionUtils.isEmpty(assetInfoEntity)) {
            log.error("ONError: assets not config");
            return CommonResponse.error(CodeEnum.CONFIG_ERROR);
        }
        List<AssetInfoResponse> assetInfoResponses =
                assetInfoEntity.stream()
                        .map(AssetInfoEntity::toAssetInfoResponse)
                        .collect(Collectors.toList());
        log.info("asset info entity: {}", JSONUtil.toJsonPrettyStr(assetInfoResponses));
        return CommonResponse.success(assetInfoResponses);
    }

    @Override
    public CommonResponse<AuditConfigEntity> getAppVersion() {
        AuditConfigEntity auditConfigEntity = auditConfigMapper.find();
        if (ObjectUtils.isEmpty(auditConfigEntity)) {
            log.error("ONError: audit config not config");
            return CommonResponse.error(CodeEnum.CONFIG_ERROR);
        }
        return CommonResponse.success(auditConfigEntity);
    }

    @Override
    public CommonResponse<AppUpdateInfoResponse> getLatestAppUpdateInfo() {
        AppUpdateInfoEntity appUpdateInfoEntity = appUpdateInfoMapper.getLatestAppUpdateInfo();
        if (appUpdateInfoEntity == null) {
            log.error("ONError: appUpdateInfo not config");
            return CommonResponse.error(CodeEnum.CONFIG_ERROR);
        }
        AppUpdateInfoResponse appUpdateInfoResponse =
                BeanUtil.copyProperties(appUpdateInfoEntity, AppUpdateInfoResponse.class);
        log.info("appUpdateInfoResponse: {}", JSONUtil.toJsonPrettyStr(appUpdateInfoResponse));
        return CommonResponse.success(appUpdateInfoResponse);
    }
}
