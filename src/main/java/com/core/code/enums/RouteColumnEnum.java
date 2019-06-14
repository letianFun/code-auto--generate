package com.core.code.enums;

/**
 * @author : lh
 * @version : 1.0.0
 * @description : 数据库路由字段
 * @date :  2019-06-14 09:59
 */
public enum  RouteColumnEnum {

    /**
     * 公司id
     */
    COMPANY_ID("company_id","companyId","Long"),
    /**
     * 城市id
     */
    CITY_ID("city_id","cityId","Long");

    /**
     * 数据库字段名称
     */
    private String column;

    /**
     * 类属性名称
     */
    private String property;

    /**
     * 类属性类型
     */
    private String propertyType;

    RouteColumnEnum(String column, String property,String propertyType) {
        this.column = column;
        this.property = property;
        this.propertyType = propertyType;
    }

    public String getColumn() {
        return column;
    }

    public String getProperty() {
        return property;
    }

    public String getPropertyType() {
        return propertyType;
    }}
