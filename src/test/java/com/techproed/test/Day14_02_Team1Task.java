package com.techproed.test;

import com.techproed.utilities.Day13_01_TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;

public class Day14_02_Team1Task extends Day13_01_TestBase {

    @Test
    public void teamTask(){
        //1-Amazon'a gidin.
        driver.get("https://amazon.com");

       WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
        }
        select.selectByVisibleText("Baby");

    }

}
