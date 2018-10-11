package com.hshb.core.code;

public class CodeGen {

    public static void main(String[] args) throws Exception {

        //AutoCreateCode auto = new AutoCreateCode("192.168.1.110", "fnsco_big_data", "root", "123456");
        //AutoCreateCode auto = new AutoCreateCode("192.168.1.110", "fnsco_risk_data", "root", "123456");
        AutoCreateCode auto = new AutoCreateCode("192.168.1.5", "hbwebsite", "web", "123456");
        //AutoCreateCode auto = new AutoCreateCode("192.168.1.110", "fnsco_big_data", "root", "123456");
        //AutoCreateCode auto = new AutoCreateCode("192.168.1.110", "hb-withhold-platform", "root", "123456");
        auto.setCreateBiz(false);
        auto.setCreateAction(false);
        auto.setCreateService(true);
        auto.setOverride(true);

        //auto.init("com.hshb.trading", "third.ticket", "t_sys_msg");
        auto.init("com.hshb", "activity", "t_activity");
        
    }
}
