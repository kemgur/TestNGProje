package com.techproed.test;

import com.techproed.utilities.Day13_01_TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Day13_03_ActionsClassTest extends Day13_01_TestBase {

    @Test
    public void sagTiklama() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        //bir webelementi sag tiklamak icin bu kodu kullaniriz
        //actions class ile işlem yaparsanız, HER SEFERİNDE "PERFORM" yapmak zorundasınız.
        actions.contextClick(element).perform();

    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.
        // actions.doubleClick(button).perform();


        actions.doubleClick(button).perform();
    }

    @Test
    public void hoverOver() {
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
        // moveToElement methodunu kullabiliriz.
        actions.moveToElement(menu).perform();
    }

    @Test
    public void asagiYukari() {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void buyukKucukYazma() {
        //shift tusuna tiklama: MERHABA nasilsiniz LIVE channel.
        driver.get("https://google.com");
        //name="q"
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        //standart yazma methodumuz.
        // aramaKutusu.sendKeys("shift tusuna tiklama: merhaba nasilsiniz live channel.");

        //Bu sekilde her karakteri buyuk yazabilir.
        //aramaKutusu.sendKeys(Keys.SHIFT +"merhaba nasilsiniz");
        Actions actions = new Actions(driver);
        actions.moveToElement(aramaKutusu).click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasilsiniz")
                .perform();

    }

    @Test
    public void dragAndDrop() {  // sürükle - bırak
        driver.get("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        WebElement logo = driver.findElement(By.id("hplogo"));
        Actions actions = new Actions(driver);
        // logo webelementini, aramaKutusu webelementine sürükle ve bırak.
        actions.dragAndDrop(logo, aramaKutusu).perform();
    }
}