package com.webank.wsdaw.config.advice;

import com.webank.wsdaw.config.enums.CodeEnum;
import com.webank.wsdaw.config.vo.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalAdvice {

    @ExceptionHandler({Exception.class})
    public CommonResponse unhandledException(Exception ex) {
        log.error("unhandled exception", ex);
        return CommonResponse.error(CodeEnum.UNKNOWN_ERROR);
    }
}
