package com.hshb.core.code;

public class CodeGen {

    public static void main(String[] args) throws Exception {

        AutoCreateCode auto = new AutoCreateCode("192.168.1.181", "houseagent-house", "root", "123456");
        auto.setCreateBiz(false);
        auto.setCreateAction(false);
        auto.setCreateService(false);
        auto.setOverride(true);
        //auto.init("com.hshb", "estate", "common_estate");
        auto.init("com.fqkj.house", "secondHouse", "common_custom_columns");
    }
}
