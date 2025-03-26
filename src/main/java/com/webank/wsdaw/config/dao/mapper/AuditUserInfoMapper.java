package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.AuditUserInfoEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AuditUserInfoMapper {
    @Insert(
            "INSERT INTO t_audit_user_info (audit_user, password, address, private_key) VALUES (#{auditUser}, #{password}, #{address}, #{privateKey})")
    void insertUser(AuditUserInfoEntity user);

    @Select("SELECT * FROM t_audit_user_info WHERE audit_user = #{auditUser}")
    @Results({
        @Result(property = "auditUser", column = "audit_user"),
        @Result(property = "password", column = "password"),
        @Result(property = "address", column = "address"),
        @Result(property = "privateKey", column = "private_key")
    })
    AuditUserInfoEntity findByUserName(@Param("auditUser") String auditUser);

    @Select("SELECT * FROM t_audit_user_info WHERE address = #{address}")
    @Results({
        @Result(property = "auditUser", column = "audit_user"),
        @Result(property = "password", column = "password"),
        @Result(property = "address", column = "address"),
        @Result(property = "privateKey", column = "private_key")
    })
    AuditUserInfoEntity findByAddress(@Param("address") String address);
}
