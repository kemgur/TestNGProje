package com.techproed.test;

import com.techproed.utilities.Day13_01_TestBase;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day17_02_Ornek_WebTable extends TestBase {

    // 1. "http://fhctrip-qa.com/admin/HotelRoomAdmin" bu adrese gidiniz.
    // 2. Tbody'nin içerisinde kaç satır var, satır sayısını ekrana yazdırınız.
    //    tbody/tr -> findElements
    // 3. Üçüncü satırdaki verileri ekrana yazdırınız.
    //    tbody/tr[3]

    @Test
    public void test(){
       giris();// // 1. "http://fhctrip-qa.com/admin/HotelRoomAdmin" bu adrese gidiniz.

        // 2. Tbody'nin içerisinde kaç satır var, satır sayısını ekrana yazdırınız.
        //    tbody/tr -> findElements
       List<WebElement> tumSatirSayisi = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Tum satirlar " + tumSatirSayisi.size() +" tanedir");

         // 3. Üçüncü satırdaki verileri ekrana yazdırınız.
         //    tbody/tr[3]
        WebElement ucuncuSatir = driver.findElement(By.xpath("//tbody/tr[3]"));
        System.out.println(ucuncuSatir.getText());




    }
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }




}
