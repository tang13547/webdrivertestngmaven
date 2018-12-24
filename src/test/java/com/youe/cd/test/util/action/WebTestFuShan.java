package com.youe.cd.test.util.action;

import com.youe.cd.test.pageobject.home.BusinessPage;
import com.youe.cd.test.pageobject.home.HomePage;
import com.youe.cd.test.util.config.Config;

public class WebTestFuShan extends WebTest {
    static HomePage homePage = new HomePage();
    static BusinessPage businessPage = new BusinessPage();


    /**
     * goto到HomePage
     * @param
     */
    public static void goToHomePage() {
        driver.get(Config.homeUrl);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            logger.error("异常信息为：", e);
        }

    }

    public static void goToStabilityControlTaskPage() throws Exception {
        try {

            homePage.getElement("stabilityIcon").click();
            Thread.sleep(5000);

            //切换到不同窗口
            ElementAction.switchToLastWindow();
            Thread.sleep(3000);

            ElementAction.moveToElement(businessPage.getElement("keyPersonnelControl"));
            Thread.sleep(3000);

            businessPage.getElement("controlTaskManagement").click();
            Thread.sleep(3000);

        } catch (Exception e) {
            logger.error("异常信息为：", e);
            throw e;
        }

    }
}
