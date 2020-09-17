package com.techproed.test;

import com.techproed.pages.FhcTripHotelGratePage;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelGrateTest extends TestBase {


    @Test(  groups = {"fhctrip", "hotelolusturma"} )
    public void giris01() {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userNameKutusu.sendKeys("manager2");
        loginPage.passwordKutusu.sendKeys("Man1ager2!");
        loginPage.loginButonu.click();

    }
    @Test()
    public void test01(){
        giris01();
        FhcTripHotelGratePage fhcTripHotelGratePage = new FhcTripHotelGratePage(driver);
        fhcTripHotelGratePage.kodKutusu.sendKeys("1234");
        fhcTripHotelGratePage.adresKutusu.sendKeys("Cikmaz sk");
        fhcTripHotelGratePage.emailKutusu.sendKeys("techproed@techproed.com");
        fhcTripHotelGratePage.nameKutusu.sendKeys("Techproed");
        fhcTripHotelGratePage.telefonKutusu.sendKeys("1223454534");

         Select select =new Select(fhcTripHotelGratePage.selectKutusu);
         select.selectByIndex(2);

         fhcTripHotelGratePage.saveButonu.click();

    }
}
