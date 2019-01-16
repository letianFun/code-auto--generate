package com.hshb.core.code.utils;

/**
 * @author mincc
 * @version V1.0
 * @description: 实体类类型枚举
 * @date 2018/8/22 13:59
 */
public enum ModelTypeEnum {

    DO("DO", "entity"), //数据库对象
    VO("VO", "vo"),//视图对象
    DTO("DTO", "dto"),//数据传输对象
    BO("BO", "bo");//业务对象

    private String key;

    private String value;

    ModelTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
