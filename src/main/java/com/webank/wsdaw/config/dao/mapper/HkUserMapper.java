package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.HkUserEntity;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HkUserMapper {
    @Insert(
            "INSERT INTO t_hk_user (email, first_name, last_name, company, phone_code, phone_number, status) "
                    + "VALUES (#{email}, #{firstName}, #{lastName}, #{company}, #{phoneCode}, #{phoneNumber}, #{status})")
    public void insertUser(HkUserEntity userEntity);

    @Select("SELECT * FROM t_hk_user WHERE pk_id = #{id}")
    public HkUserEntity getUserById(@Param("id") Long id);

    @Select("SELECT * FROM t_hk_user")
    public List<HkUserEntity> getAllUsers();

    @Update(
            "UPDATE t_hk_user SET email=#{email}, first_name=#{firstName}, last_name=#{lastName}, "
                    + "company=#{company}, phone_code=#{phoneCode}, phone_number=#{phoneNumber}, status=#{status} "
                    + "WHERE pk_id = #{pkId}")
    public void updateUser(HkUserEntity userEntity);

    @Select("SELECT COUNT(*) > 0 FROM t_hk_user WHERE email = #{email}")
    public boolean emailExists(@Param("email") String email);

    @Select("SELECT COUNT(*) > 0 FROM t_hk_user WHERE email = #{email} and status = 0")
    public boolean emailNormal(@Param("email") String email);

    @Select("SELECT * FROM t_hk_user WHERE email = #{email} and status = 0")
    public HkUserEntity getNormalUserByEmail(@Param("email") String email);
}
