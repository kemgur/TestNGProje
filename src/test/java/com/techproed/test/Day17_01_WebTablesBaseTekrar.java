package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Day17_01_WebTablesBaseTekrar extends TestBase {

    public void giris(){// Bu methodu TestBase clasina da yazip ordanda cagirabilirdik. Biz buraya yazdik.
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }
    @Test
    public void table (){
        giris();

        try {// giris methodu calistiktan sonra bir kac saniye beklemek icin try-catch ekledik.
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        //Tum basliklari alabiliriz
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement baslik : basliklar){
            System.out.println(baslik.getText());
        }
    }

    @Test
    public void tumSatirlar(){
        giris();

      List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
    for (WebElement satir: tumSatirlar){
        System.out.println(satir.getText());
    }
    }

    @Test
    public void tumHucreler(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement hucre :tumHucreler){
            System.out.println(hucre.getText());// tum hucreleri yukaridan asagiya dogru
            //hepsini tek tek yazdirabiliriz.

        }

    }
    @Test
    public void belirliBirSutunYazdirdma(){
        giris();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  //tbody/tr/td[4] => burada 4.sutunu yazdirabiliriz
        List<WebElement> dorduncuSutun = driver.findElements(By.xpath("//tbody/tr/td[4]"));
        for(WebElement veri : dorduncuSutun){
            System.out.println(veri.getText());
        }


    }

    @Test
    public void calistir(){// dinamik method calistirilabilir.
        giris();
        hucreYazdir(3,5);
        hucreYazdir(4,6);
        hucreYazdir(6,8);
        hucreYazdir(1,4);

    }
    public void hucreYazdir(int satir, int sutun){//dinamik bir satir yazdiracagiz
        //   //tbody/tr[4]/td[6]
        String xpathDegerim = "//tbody/tr[" + satir + "]/td[" + sutun + "]";
        //   //tbody/tr[3]/td[5]
            WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());

    }
}
