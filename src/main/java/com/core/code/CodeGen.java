package com.core.code;

public class CodeGen {

    public static void main(String[] args) throws Exception {
        AutoCreateCode auto = new AutoCreateCode("192.168.1.181", "houseagent-house-2", "root", "123456");
        auto.setCreateBiz(false);
        auto.setCreateAction(false);
        auto.setCreateService(false);
        auto.setOverride(true);
        auto.init("com.fqkj.house", "image", "house_image_record");
    }
}
