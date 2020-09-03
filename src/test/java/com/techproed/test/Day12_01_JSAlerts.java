package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_01_JSAlerts {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
        @Test
        public void jsAlertTest(){
           //https://the-internet.herokuapp.com/javascript_alerts
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            // <button onclick="jsAlert()">Click for JS Alert</button>
            // xpath, cssSelector, tagName
            WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
            button.click();
            //Alertin icerdigi mesaji almak icin kullaniriz.
           String alertMesaji = driver.switchTo().alert().getText();
            System.out.println(alertMesaji);

            //alertin icerisindeki okay butonuna tiklamak icin kullanilir
            driver.switchTo().alert().accept();
/*Alert alert = driver.switchTo().alert();
alert.dismiss();
alert.accept();
alert.getText();
alert.sendKeys("Gerek yok");*/
    }

    @Test
    public void jsConfirmTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();

        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        //alertin icerisindeki "Cansel" butonuna tiklar.
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void jsPromptTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        driver.switchTo().alert().sendKeys("Merhaba TestNG");
        driver.switchTo().alert().accept();
    }






}
