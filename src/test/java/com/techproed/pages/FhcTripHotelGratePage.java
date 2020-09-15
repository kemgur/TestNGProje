package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelGratePage { //Day18_05
    WebDriver driver;
    public FhcTripHotelGratePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "Code")
    public WebElement kodKutusu;

    @FindBy(id = "Name")
    public WebElement nameKutusu;

    @FindBy(id = "Adress")
    public WebElement adresKutusu;

    @FindBy(id = "Phone")
    public  WebElement telefonKutusu;

    @FindBy(id ="Email")
    public WebElement emailKutusu;

    @FindBy(id = "IDGroup")
    public WebElement selectKutusu;

    @FindBy (id = "btnSubmit")
    public WebElement saveButonu;


}
