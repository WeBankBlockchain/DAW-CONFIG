package com.webank.wsdaw.config.dao.mapper;

import com.webank.wsdaw.config.dao.entity.EmailVerificationEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmailVerificationMapper {

    @Insert(
            "INSERT INTO t_hk_email_code (email, verification_code) "
                    + "VALUES (#{email}, #{verificationCode})")
    public void insert(EmailVerificationEntity emailVerification);

    @Insert(
            "INSERT INTO t_hk_email_code (email, verification_code) "
                    + "VALUES (#{email}, #{verificationCode})")
    public void newCode(
            @Param("email") String email, @Param("verificationCode") String verificationCode);

    @Select("SELECT * FROM t_hk_email_code WHERE pk_id = #{pkId}")
    public EmailVerificationEntity selectById(@Param("pkId") Long pkId);

    @Select(
            "SELECT * FROM t_hk_email_code WHERE email = #{email} order by create_time desc limit 1")
    public EmailVerificationEntity selectLatestByEmail(@Param("email") String email);

    @Update(
            "UPDATE t_hk_email_code SET verified = 1 WHERE email = #{email} and verification_code = #{verificationCode}")
    public void verify(
            @Param("email") String email, @Param("verificationCode") String verificationCode);

    @Update("UPDATE t_hk_email_code SET verified = 1 WHERE pk_id = #{pkId}")
    public void verifyByPkId(@Param("pkId") Long pkId);
}
