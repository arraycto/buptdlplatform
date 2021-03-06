package com.bupt.dlplatform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "模型记录输入")
public class ModelRecordInputVO extends BaseInputVO {

    @ApiModelProperty(value = "模型Id")
    private String modelId;

}
