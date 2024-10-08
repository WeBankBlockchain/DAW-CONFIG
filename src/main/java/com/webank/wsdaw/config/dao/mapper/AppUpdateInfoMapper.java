package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.AppUpdateInfoEntity;
import org.apache.ibatis.annotations.Select;

public interface AppUpdateInfoMapper {

    @Select("SELECT * FROM t_app_update_info ORDER BY pk_id DESC LIMIT 1")
    AppUpdateInfoEntity getLatestAppUpdateInfo();
}
