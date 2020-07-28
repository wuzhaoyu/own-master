package com.own.annotation.type;

/**
 * 类功能说明: 日志类型
 * 类修改者	创建日期2020/7/28
 * 修改说明
 * @author wzy
 * @version V1.0
 **/
public enum LogActionType {

    ADD("新增"),
    SELECT("查询"),
    UPDATE("更新"),
    DETELE("删除");

    private String value;

    LogActionType(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }

}
