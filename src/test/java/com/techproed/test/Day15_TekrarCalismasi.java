package com.techproed.test;

import com.techproed.utilities.Day13_01_TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15_TekrarCalismasi extends Day13_01_TestBase {

    @Test
    public void test01() {

        driver.get("http://google.com");
        //google arama kutusuna gidelim. // id name ="q"
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys(Keys.SHIFT + "live channel");

        Actions actions = new Actions(driver);// Mausu bir webelementin ustune goturur ve tiklatir.
        actions.moveToElement(aramaKutusu).click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasilsin")
                .perform();//bu method olmazsa olmazimizdir. Mutlaka yazilmalidir.
    }

    @Test
    public void dosyaVarMi (){
        //sout'a yazdirdigimizda bulundugumuz dosyanin path'ini verir.

        System.out.println(System.getProperty("user.dir"));///Users/kemalgurler/IdeaProjects/TestNGProje
        System.out.println(System.getProperty("user.home"));///Users/kemalgurler

        String kullaniciDosyaYolu = System.getProperty("user.dir");
        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        // System.out.println(varMi);
        Assert.assertTrue(varMi);

    }
    @Test
    public void implicitlyWait(){

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //Explicit Wait kullanmak için, WebDriverWait class'ından nesne üretmek zorundayız.
        WebElement removeButtonu = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButtonu.click();

        WebElement addElementi = driver.findElement(By.xpath("//*[.='A dd']"));

        WebDriverWait wait = new WebDriverWait(driver, 20);




//


    }



}
