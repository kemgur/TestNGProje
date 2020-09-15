package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {//Day19_01
    WebDriver driver;
    public FacebookLoginPage(WebDriver driver){//Contructor
            this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    //Facebook'a gidip kullanici adi ve sifre olusturacegiz.
    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "pass")
    public WebElement sifreKutusu;


}
