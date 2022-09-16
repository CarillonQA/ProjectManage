package com.pm.entity.project;

import com.pm.entity.user.CoreUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "CoreProject", description = "项目实体类")
public class CoreProject {

    @ApiModelProperty(value = "项目ID")
    private Integer projectId;

    @ApiModelProperty(value = "项目名称")
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

    @ApiModelProperty(value = "逻辑删除标记字段(0:未删除, 1:已删除)")
    private Integer delFlag;

    // 以下为数据库不存在的字段
    @ApiModelProperty(value = "项目创建人")
    private CoreUser createdBy;

    @ApiModelProperty(value = "项目经理（可多人）")
    private List<CoreUser> projectManager;

    @ApiModelProperty(value = "项目成员（可多人）")
    private List<CoreUser> projectMember;

}
