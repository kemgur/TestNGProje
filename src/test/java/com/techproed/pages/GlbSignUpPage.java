package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

  public GlbSignUpPage() {
      PageFactory.initElements(Driver.getDriver(), this);

  }
      @FindBy(  id = "email" )
      public WebElement emailKutusu;

      @FindBy (  name = "name" )
      public WebElement nameKutusu;

      @FindBy ( id ="mobile" )
      public WebElement mobileButonu;

      @FindBy (  id = "password" )
      public WebElement passKutusu;

      @FindBy ( id ="re_password" )
      public WebElement rePassKutusu;

      @FindBy ( name ="submit" )
      public WebElement signKutusu;

      @FindBy(xpath = "//*[.='Success!']")
      public WebElement succes;




}
