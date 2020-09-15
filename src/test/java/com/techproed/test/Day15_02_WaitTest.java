package com.techproed.test;

import com.techproed.utilities.Day13_01_TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Day15_02_WaitTest extends Day13_01_TestBase {

    @Test
    public void implicitlyWait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButonu = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButonu.click();
        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));

        //Explicit Wait kullanmak için, WebDriverWait class'ından nesne üretmek zorundayız.
        WebDriverWait wait = new WebDriverWait(driver,30);

        WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getText());
    }
    @Test
    public void explicitWait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //Explicit Wait kullanmak için, WebDriverWait class'ından nesne üretmek zorundayız.
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();
        WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getText());
    }


}
