package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class FhcTripHotelRoomCreateTest extends TestBase {
    public void giris(){
        driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }
    @Test
    public void test01(){
        // ConfigurationReader class'ına diyoruzki, .properties dosyasının içerisindeki
        // room_create_url (anahtarının) değerini al.
        //room_create_url = http://fhctrip-qa.com/admin/HotelroomAdmin/Create
        driver.get(ConfigurationReader.getProperty("room_create_url"));
        giris();
        //page clasindan nesne uretecegiz.
        FhcTripHotelRoomCreatePage page = new FhcTripHotelRoomCreatePage(driver);

        //Dropdown kullanmak icin Select clasindan nesne uretiyoruz
        Select select = new Select(page.idHotelDropDown);
        select.selectByIndex(3);
        page.codeKutusu.sendKeys("1234");
        page.nameKutusu.sendKeys("Hamza Yılmaz");
        page.locationKutusu.sendKeys("Almanya");
        page.descKutusu.sendKeys("Day 20'den selamlar..");
        //Action clasini kullanarak nesne ureterek drag and drop yapabiliriz.
        //Action clasinin icerisine parametre olarak "driver"'i gondermemiz gerekiyor.
        //.perform() yazmayi unutmayin
        Actions actions = new Actions(driver);
        actions.dragAndDrop(page.price500, page.priceKutusu).perform();//Burada virgulden once
        // tasiyacagimiz kutuyu, virgulden sonra da tanicak kutuyu yaziyoruz.Sonuna ".perform()" yazmayi unutmayin
// Select clasini her dropdown icin olusturmamiz gerekiyor.
// Ama action clasini bir kez olusturmamiz yeterli.

        //2. kez dropdown kullanacagimiz icin yine Select clasindan nesne uretmemiz gerekiyor.

        Select select1 = new Select(page.idGroupRoomTypeDropDown);//Burayada parametre olarak
        // kullanmak istedigimiz dropdown'i gonderiyoruz.
        select1.selectByIndex(2);
        page.maxAdultCountKutusu.sendKeys("2");
        page.maxChildCountKutusu.sendKeys("5");
        page.saveButonu.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(page.basariliYazisi.getText());
        boolean basariliMi = page.basariliYazisi.isDisplayed();
        Assert.assertTrue(basariliMi);
    }


}
