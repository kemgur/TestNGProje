package com.techproed.test;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {//Day18_02

    @Test
    public void aramaTesti(){
        driver.get("https://google.com");
        // GooglePage class'indan bir tane nesne olusturduk.
        //Parametre su an kullandigimiz driver'i gonderdik.
      GooglePage googlePage = new GooglePage(driver);

        googlePage.aramaKutusu.sendKeys("SElamlar");





    }


}
