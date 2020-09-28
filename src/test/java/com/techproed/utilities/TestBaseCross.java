package com.techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBaseCross {
    protected WebDriver driver;
    // @Optional: Eger browser diye herhangi bir parametre
    // gelmezse bile burasi calissin diyoruz.

    //Bize parametre olarak browser gelecek.
    //Bizde o parametreyi kullacagiz
    // Bu parametre, xml dosyasindan gelecek.
    @Parameters("browser")
    @BeforeMethod
    public void surUp(@Optional String browser){
        driver = DriverCross.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        DriverCross.closeDriver();
    }
}
