package com.webank.wsdaw.config.vo.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HkEmailRequest extends CommonRequest {
    @NotBlank(message = "email cannot be null.")
    String email;
}
