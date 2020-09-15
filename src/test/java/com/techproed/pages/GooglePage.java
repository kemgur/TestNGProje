package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {//Day18_01


        WebDriver driver;// boş bir tane driver değişkeni oluşturduk.
        public GooglePage(WebDriver driver){//Constructor
        this.driver = driver;//TestBase'teki driver i' burdaki driver'a esitledik.
        PageFactory.initElements(driver,this);// Bu yukaridaki 4 satir kaliptir ve oldugu gibi ezberlemeliyiz.
        // birazdan bulacağımız webelementleri hazır hale getirdik.
            // parametre olarak gelen driver nesnesini, bu class'ta oluşturduğumuz
            // (11. satırdaki) driver nesnesine eşitledik. Bu şekilde yeniden boş bir
            // driver oluşturmak yerine, zaten halihazırda kullandığımız driver'ı bu nesneye
            // eşitlemiş olduk.


            PageFactory.initElements(driver,this);
        }

        @FindBy(name ="q")
    public WebElement aramaKutusu;

    @FindBy (id = "id_degeri")
    public WebElement elementim;//findElement

     /*
    @FindBy ( xpath = "//tbody/tr")
    public List<WebElement> liste;  // findElements (s harfine dikkat)
    */

}

