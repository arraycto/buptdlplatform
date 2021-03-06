package com.bupt.dlplatform.vo;

import com.bupt.dlplatform.model.MDataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Created by huhx on 2020/9/30
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MDataEntityOutputVO<T> {
    @ApiModelProperty(value ="id")
    @NotNull(message = "id不能为空")
    private String id;

    @ApiModelProperty(value = "数据名")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Long createTimestamp;

    @ApiModelProperty(value = "更新时间")
    private Long lastTimestamp;

    @ApiModelProperty(value = "数据类型")
    private String type;

    @ApiModelProperty(value ="值")
    private Object value;

    public MDataEntityOutputVO(MDataEntity mDataEntity){
        setId(mDataEntity.getId());
        setName(mDataEntity.getName());
        setCreateTimestamp(mDataEntity.getCreateTimestamp());
        setLastTimestamp(mDataEntity.getLastTimestamp());
        setType(mDataEntity.getType());
        setValue(mDataEntity.getValue());
    }

}
