package com.techproed.test;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.Day13_01_TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends Day13_01_TestBase { //Day18_05

    @Test(  groups = {"fhctrip", "login"} )
    public void test() {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userNameKutusu.sendKeys("manager2");
        loginPage.passwordKutusu.sendKeys("Man1ager2!");
        loginPage.loginButonu.click();
    }


}
