package com.youe.cd.test.service.keypersoncontrol;

import com.youe.cd.test.pageobject.keypersoncontrol.AddControlTaskPage;
import com.youe.cd.test.util.action.ElementAction;
import com.youe.cd.test.util.config.RunTimeConfig;

public class ControlManagementService {
    AddControlTaskPage addControlTaskPage = new AddControlTaskPage();

    public void preStepMac() throws Exception {
        addControlTaskPage.getElement("addControlTask").click();
        Thread.sleep(3000);

        addControlTaskPage.getElement("taskNameInput").click();
        addControlTaskPage.getElement("taskNameInput").sendKeys(RunTimeConfig.controlTaskName);
        Thread.sleep(1000);
        addControlTaskPage.getElement("multipulControlRadio").click();
        Thread.sleep(1000);
        addControlTaskPage.getElement("featureCodeSelect").click();
        Thread.sleep(3000);
        ElementAction.clickBySpanText("Mac地址");


    }

    public void addMac(String mac) throws Exception {
        addControlTaskPage.getElement("macInput").sendKeys(mac);
        Thread.sleep(100);
        addControlTaskPage.getElement("addButton").click();
        Thread.sleep(100);

    }

    public void afterStepMac() throws Exception {
        addControlTaskPage.getElement("gatherAlarmRadio").click();
        Thread.sleep(1000);
        addControlTaskPage.getElement("gatherNumberInput").sendKeys("1000");
        Thread.sleep(1000);

        addControlTaskPage.getElement("taskLevel").click();
        Thread.sleep(1000);
        addControlTaskPage.getElement("systemRemind").click();
        Thread.sleep(1000);

        addControlTaskPage.getElement("saveButton").click();
        Thread.sleep(3000);
        addControlTaskPage.getElement("controlReasonInput").sendKeys("人员布控理由test001");
        Thread.sleep(1000);
        addControlTaskPage.getElement("approvalPersonSelect").click();
        Thread.sleep(3000);
        ElementAction.clickBySpanText("栾家警务室-局长-测试名01");
        Thread.sleep(1000);
        addControlTaskPage.getElement("approvalPersonText").click();  //点审批人三个字让弹窗消失
        Thread.sleep(2000);

        addControlTaskPage.getElement("confirmButton").click();
        Thread.sleep(3000);
    }
}
