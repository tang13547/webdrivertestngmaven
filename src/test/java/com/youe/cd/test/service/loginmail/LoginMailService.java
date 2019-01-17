package com.youe.cd.test.service.loginmail;

import com.youe.cd.test.pageobject.loginmail.LoginMailPage;
import com.youe.cd.test.util.action.ElementAction;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginMailService {
    LoginMailPage loginMailPage = new LoginMailPage();

    public void loginMail() throws InterruptedException {
        //切换到iframe表单中，126邮箱特别注意
        ElementAction.switchToFrame(By.xpath("//iframe"));

        //126邮箱登录页面输入用户名及密码
        loginMailPage.getElement("userName").clear();
        loginMailPage.getElement("userName").sendKeys("tang13547");
        loginMailPage.getElement("password").clear();
        loginMailPage.getElement("password").sendKeys("135470000");
        Thread.sleep(3000);

        //点“登录”提交
        loginMailPage.getElement("submit").click();
        Thread.sleep(3000);


    }
}
