package com.youe.cd.test.controller.modeldemo;

import org.testng.annotations.*;

public class OrgDemo {
    @BeforeSuite
    public void beforeSuit() {}

    @BeforeClass
    public void beforeClass() {}

    @BeforeMethod
    public void beforeMethod() {}

    @AfterMethod()
    public void afterMethod() {}

    @AfterClass()
    public void afterClass() {}

    @AfterSuite()
    public void afterSuite() {}

    @Test
    public void test1() {}

    @Test
    public void test2() {}

}
