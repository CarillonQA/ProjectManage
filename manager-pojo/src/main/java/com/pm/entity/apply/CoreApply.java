package com.pm.entity.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CoreApply", description = "申请实体类")
public class CoreApply {

    @ApiModelProperty(value = "申请ID")
    private Integer applyId;

    @ApiModelProperty(value = "所属项目的ID")
    private Integer projectId;

    @ApiModelProperty(value = "所属任务的ID")
    private Integer taskId;

    @ApiModelProperty(value = "申请人")
    private String applicant;

    @ApiModelProperty(value = "申请日期时间")
    private String applyDate;

    @ApiModelProperty(value = "申请理由")
    private String applyReason;

    @ApiModelProperty(value = "任务预计结束日期")
    private String taskExpectedEndDate;

    @ApiModelProperty(value = "审核经理")
    private String applyManager;

    @ApiModelProperty(value = "审核领导")
    private String applyLeader;

    @ApiModelProperty(value = "经理审核结果")
    private String managerApplyResult;

    @ApiModelProperty(value = "经理审核内容")
    private String managerApplyContent;

    @ApiModelProperty(value = "经理审核日期时间")
    private String managerApplyDate;

    @ApiModelProperty(value = "领导审核结果")
    private String leaderApplyResult;

    @ApiModelProperty(value = "领导审核内容")
    private String leaderApplyContent;

    @ApiModelProperty(value = "领导审核日期时间")
    private String leaderApplyDate;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
