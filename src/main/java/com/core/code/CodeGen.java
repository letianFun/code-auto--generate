package com.core.code;

import com.core.code.utils.AutoCreateCode;
import com.core.code.enums.RouteColumnEnum;

public class CodeGen {

    public static void main(String[] args) throws Exception {
        AutoCreateCode auto = new AutoCreateCode("192.168.1.181", "houseagent-house-2", "root", "123456");
        auto.setCreateBiz(false);
        auto.setCreateAction(false);
        auto.setCreateService(false);
        auto.setOverride(true);
        //数据库路由字段
        auto.setRouteColumn(RouteColumnEnum.COMPANY_ID);
        auto.init("com.fqkj.house", "image", "house_image_record");
    }
}
