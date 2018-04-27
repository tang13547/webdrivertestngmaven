package com.youe.cd.test.util;

public class RegexUtil {
    //校验QQ号，要求：必须是5~15位数字，0不能开头
    public static boolean matchesQQ(String qq) {
        //String reg = "[1-9][0-9]{4,14}";
        String reg = "[1-9]\\d{4,14}";
        System.out.println(qq.matches(reg)?"合法qq":"非法qq");

        return qq.matches(reg);
        //return qq.matches(reg)?true:false;
    }

    //匹配手机号段只有 13xxx 15xxx 18xxxx的
    public static boolean matchesPhone(String phone) {
        String reg = "1[358]\\d{9}";

        return phone.matches(reg);
    }

    //匹配域名后缀中包含.com或。cn或.net的
    public static boolean matchesDomain(String domain) {
        String reg = "(.*?)\\.((com)|(cn)|(net))";
        //System.out.println(domain.matches(reg)?"所需domain":"非所需domain");

        return domain.matches(reg);
    }

}
