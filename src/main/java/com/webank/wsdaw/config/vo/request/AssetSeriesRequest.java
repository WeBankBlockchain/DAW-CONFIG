package com.webank.wsdaw.config.vo.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AssetSeriesRequest extends CommonRequest {
    @NotBlank(message = "seriesType can not be null.")
    private String seriesType;
}
