package day11_cookies_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void actions() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);
        WebElement box=driver.findElement(By.id("hot-spot"));

        //Kutuya sag tıklayın
        actions.contextClick(box).perform();


        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin

       String  actualResult= driver.switchTo().alert().getText();
        Assertions.assertEquals("You selected a context menu",actualResult);

        waitForSecond(2);
        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();


    }
}
