package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Eger bir class'tan NESNE URETILMESINI ISTEMIYORSANIZ
    //CONSTRUCTOR'I PRIVATE YAPABILIRSINIZ(  Class)
    private Driver(){

    }
    //WebDriver nesnemizi, static olarak olusturduk,
    // cunku program baslar baslamaz hafizada yer almasini istiyoruz.
    static WebDriver driver;

    //Programin herhangi bir yerinden getDriver() methodu cagtilarak
    // hafizada STATIC  olarak olusturulmus DRIVER nesnesine erisebiliriz.
    //Yani yeniden WebDriver nesnesi olusturmak zorunda degiliz.
    public static WebDriver getDriver(){

        //getDriver methodunu her seferinde cagirdimizda
        // yeni bir ChromeDriver nesnesi olusacak mi?
        //Eger driver null ise, olusturulmamissa yeniden olusturmana gerek yok
        //Eger null ise; yeniden olusturabilirsin.
//        if(driver == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();

        if(driver == null) {
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }


        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
}
    public static void closeDriver(){
        // Eğer driver nesnesi NULL değilse, yani hafızada varsa
        if (driver != null){
            driver.quit();  // driver'ı kapat
            driver = null;  // driver'ı hafızadan temizle.
        }
    }

}
