package com.techproed.test;

import com.sun.deploy.util.OrderedHashSet;
import com.techproed.utilities.Day13_01_TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class Day13_02_WindowHandleTest extends Day13_01_TestBase {


    @Test
    public void cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);
        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> tumPenceler = driver.getWindowHandles();
        for(String handle : tumPenceler){
            System.out.println(handle);
        }
        String[] array = (String[]) tumPenceler.toArray();
        String ikinciSayfaHandle = array[array.length - 1];
        System.out.println(ikinciSayfaHandle);
    }
}