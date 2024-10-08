package com.webank.wsdaw.config.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.webank.wsdaw.config.constant.CommonConstant;
import com.webank.wsdaw.config.dao.entity.EmailVerificationEntity;
import com.webank.wsdaw.config.dao.mapper.EmailVerificationMapper;
import com.webank.wsdaw.config.enums.CodeEnum;
import com.webank.wsdaw.config.service.EmailVerifyService;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailVerifyServiceImpl implements EmailVerifyService {

    @Autowired private EmailVerificationMapper emailVerificationMapper;

    @Override
    public CommonResponse<String> sendVerificationCode(String email) {
        EmailVerificationEntity entity = emailVerificationMapper.selectLatestByEmail(email);
        // TODO 方便调试，写死
        // String verificationCode = RandomUtil.randomNumbers(6);
        String verificationCode = "123456";
        if (entity != null) {
            Date sendtime = entity.getCreateTime();
            long diff = DateUtil.betweenMs(sendtime, new Date());
            if (Math.abs(diff) <= CommonConstant.GENERATE_OTP_INTERVAL_MS) {
                log.warn(" {} get code too frequent", email);
                return CommonResponse.error(CodeEnum.OPER_FREQUENT_ERROR);
            }
        }
        log.info("send code, email {}, code {}", email, verificationCode);
        emailVerificationMapper.newCode(email, verificationCode);
        return CommonResponse.success(verificationCode);
    }

    @Override
    public CommonResponse<String> verifyEmailCode(String email, String code) {
        EmailVerificationEntity entity = emailVerificationMapper.selectLatestByEmail(email);
        if (entity == null) return CommonResponse.error(CodeEnum.NOT_GET_CODE_ERROR);
        Date sendtime = entity.getCreateTime();
        long diff = DateUtil.betweenMs(sendtime, new Date());
        if (Math.abs(diff) > CommonConstant.OTP_VALIDITY_MINUTES) {
            log.warn(" {} get code out of time {}", email, diff);
            return CommonResponse.error(CodeEnum.CODE_OUT_OF_TIME_ERROR);
        }
        boolean verified = entity.isVerified();
        if (verified) {
            log.warn(" {} get code already used", email);
            return CommonResponse.error(CodeEnum.INVALID_CODE);
        }
        String vCode = entity.getVerificationCode();
        if (StrUtil.equals(vCode, code)) {
            emailVerificationMapper.verifyByPkId(entity.getPkId());
            return CommonResponse.success();
        } else {
            return CommonResponse.error(CodeEnum.INVALID_CODE);
        }
    }
}
