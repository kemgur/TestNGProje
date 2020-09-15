package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {

    /**
     1.Adim: smoketest paketinin altinda FhcTripLoginTest
     2.Adim: icerisinde driver.get() ile properties dosyasinin icerisindeki
             fhc_login adresine gidin.
     3.Adim: FhcTripLoginPage class'inin icerisindeki webelementleri kullanin.
     4.Adim: webelementlerin icerrisinde ConfigurationReader class'inin icerisindeki
              getProperty methodunu kullanarak bilgilerini ekleyin.
     */

    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("fhc_login"));//driver.get ilede ayni islemi yapabilirdik.

        //simdi nesne(obje) olusturmaliyiz
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
       // loginPage.userNameKutusu.sendKeys("manager2");//Bu sekilde yaparsak hard code kullanmis oluruz.
        //Onun yerine dinamik code kullanmaliyiz.
        loginPage.userNameKutusu.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButonu.click();

    }
}
