package com.pm.entity.project;

import com.pm.entity.user.CoreUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ProjectDto", description = "项目信息类，存放前端传来的项目数据")
public class ProjectDto {

    @ApiModelProperty(value = "项目ID")
    private Integer projectId;

    @ApiModelProperty(value = "项目名称", required = true)
    private String projectName;

    @ApiModelProperty(value = "项目图标")
    private String projectIcon;

    @ApiModelProperty(value = "项目区域")
    private String projectArea;

    @ApiModelProperty(value = "项目客户")
    private String projectCustomer;

    @ApiModelProperty(value = "项目开始日期")
    private String startDate;

    @ApiModelProperty(value = "项目结束日期")
    private String endDate;

    @ApiModelProperty(value = "项目创建者的ID")
    private Integer createdById;

    @ApiModelProperty(value = "项目创建日期")
    private String createdDate;

    @ApiModelProperty(value = "项目描述")
    private String describe;

    // 以下为数据库不存在的字段
    @ApiModelProperty(value = "项目创建人")
    private CoreUser createdBy;

    @ApiModelProperty(value = "项目经理（可多人）")
    private List<CoreUser> projectManager;

    @ApiModelProperty(value = "项目成员（可多人）")
    private List<CoreUser> projectMember;

}
