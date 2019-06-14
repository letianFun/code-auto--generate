package com.core.code.enums;

/**
 * @author mincc
 * @version V1.0
 * @description: 实体类类型枚举
 * @date 2018/8/22 13:59
 */
public enum ModelTypeEnum {
    /**
     *
     */
    //数据库对象
    DO("DO", "entity"),
    //视图对象
    VO("VO", "vo"),
    //数据传输对象
    DTO("DTO", "dto");
    private String key;

    private String value;

    ModelTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public String getKey() {
        return key;
    }
}
