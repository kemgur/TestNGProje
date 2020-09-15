package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class GlbSignUpTest {

    @Test
    public void test(){


        /*
         * 1. Adım : https://www.glbtrader.com/register-verified.html adresine gidelim
         * 2. Adım : GlbSignUpPage class'ından nesne üretip, webelementleri kullanalım.
         * 3. Adım : İçerisine ekleyeceğimiz bilgileri (name, email, phone vs) yine
         *           ConfigurationReader kullanarak, properties file'dan alalım.
         * 4. Adım : Sign-Up butonuna tıklayalım.
         * 5. Adım : Success yazısını görüp görmediğimi Assert ile doğrulayalım.
         */

        Driver.getDriver().get(ConfigurationReader.getProperty("glb_login"));
        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        glbSignUpPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("glb_email"));
        glbSignUpPage.nameKutusu.sendKeys(ConfigurationReader.getProperty("glb_name"));
        glbSignUpPage.mobileButonu.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        glbSignUpPage.passKutusu.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage.rePassKutusu.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage.signKutusu.click();
        // signUp butonuna tıkladıktan sonra, Success!! yazısını hemen alabilir miyim ?
        System.out.println(glbSignUpPage.succes.getText());
    }

}

