package com.pm.entity.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CoreUser", description = "用户实体类")
public class CoreUser {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "头像")
    private String headPortrait;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "权限")
    private String authority;

    @ApiModelProperty(value = "密钥")
    private String salt;

    @ApiModelProperty(value = "是否为领导（0：否，1：是）")
    private Integer isLeader;

    @ApiModelProperty(value = "是否为经理（0：否，1：是）")
    private Integer isManager;

}
