package com.pm.entity.area;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Area", description = "地区实体")
public class Area {

    @ApiModelProperty(value = "地区ID")
    private Integer areaId;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

}
