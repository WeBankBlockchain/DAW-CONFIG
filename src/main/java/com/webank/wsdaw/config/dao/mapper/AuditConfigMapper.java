package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.AuditConfigEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AuditConfigMapper {

    @Select("SELECT * FROM t_audit_config")
    @Results({
        @Result(property = "current_version", column = "currentVersion"),
        @Result(property = "openFlag", column = "open_flag")
    })
    AuditConfigEntity find();
}
