package com.pm.entity.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CoreTask", description = "任务实体类")
public class CoreTask {

    @ApiModelProperty(value = "任务ID")
    private Integer taskId;

    @ApiModelProperty(value = "任务上级ID")
    private Integer parentId;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "任务开始时间")
    private String startDate;

    @ApiModelProperty(value = "任务结束时间")
    private String endDate;

    @ApiModelProperty(value = "任务优先级（无，高，中，低）")
    private String taskPriority;

    @ApiModelProperty(value = "任务状态(0:未完成, 1:已完成)")
    private Integer taskState;

    @ApiModelProperty(value = "实际开始时间")
    private String realStartDate;

    @ApiModelProperty(value = "实际结束时间")
    private String realEndDate;

    @ApiModelProperty(value = "任务执行人的ID")
    private Integer taskExecutorId;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "任务所属项目的ID")
    private Integer projectId;

    @ApiModelProperty(value = "逻辑删除标记字段(0:未删除, 1:已删除)")
    private Integer delFlag;

}
