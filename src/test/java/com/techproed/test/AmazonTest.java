package com.techproed.test;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.Day13_01_TestBase;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {//Day18_04

    @Test
    public void aramaTesti(){
        driver.get("http://amazon.com");
        // AmazonPage'in içerisindeki bulmuş olduğumuz WebElement'i
        // kullanabilmek için AmazonPage class'ından nesne üretiyoruz.
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("Baby Stroller");
    }
}