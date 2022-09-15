package com.pm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "pm.cms")
@Data
public class CmsProperties {
    // 推送到站群数据的站点映射
    private Map<Integer, List<Integer>> shareChannelIdMap;

    // 专题的映射
    private Map<Integer,Integer> specialChannelId;

//    顶部菜单栏的映射
    private Map<Integer,Integer> topMenuId;

    // 两微一端映射
    private Map<Integer,Integer> bothEnds;

    // 背景映射
    private Map<Integer,Integer> background;

    // 文件后缀名的映射
    private Map<String,List<String>> suffix;

    // 部门的映射
    private Map<Integer,Integer> department;

    // 快捷通道的映射
    private Map<Integer,Integer> shortcut;

    // 侧栏映射
    private Map<Integer,Integer> sideColumn;

    // 国内链接
    private Integer theNationalLink;

    // 省内链接
    private Integer theAreaLink;

    // 全市链接
    private Integer theCityLink;

    // 市院通知
    private Integer notice;

    private Integer systemId;
    // 飘窗管理
    private Map<Integer,Integer> bayWindow;

    private Map<Integer, Integer> trends;

    // 各盟市ip网段
    private Map<String, String> leagueCity;

    // 各盟市对应市名
    private Map<String,String> cityMap;

    // 下载栏目
    private Map<Integer,Integer> download;
}
