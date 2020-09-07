package com.techproed.test;

import com.techproed.utilities.Day13_01_TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.ws.Action;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Day14_1_OrnekAmazonKayitSayfasiTekrar extends Day13_01_TestBase {

    @Test
    public void test01(){
    driver.get("https://amazon.com");


        WebElement webElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        //mouse'u webelementin uzerine goturur.
        actions.moveToElement(webElement).perform();

        // xpath==> //*[.='start here.']
        WebElement startHere = driver.findElement(By.xpath("//*[.='Start here.']"));
        startHere.click();

        //3.adim: Sayfanin title'i Amazon registraton ise testiniz basarili;
        //Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
       // Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
        Assert.assertEquals(driver.getTitle(),"Amazon Registration");



}

    @Test(dependsOnMethods = "test01")
    public void test02(){
        WebElement yourName = driver.findElement(By.id("ap_customer_name"));
        yourName.sendKeys("kemalgurler");

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("kemgur52@gmail.com");

        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("kemgur52");

        WebElement rePassword = driver.findElement(By.id("ap_password_check"));
        rePassword.sendKeys("kemgur52");

        WebElement create = driver.findElement(By.id("continue"));
        create.click();



}


}
