package day19_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSSetAttribute extends TestBase {

    @Test
public void sendKeys() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='selenium",searchBox);

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
         placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
          aria-label="Search Amazon" spellcheck="false">
         */




    }

    @Test
    void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        jsSendKeys(searchBox,"selenium");

    }

    @Test
    void test03() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('id','Seyma'",searchBox);


        waitForSecond(2);
        //degistirmis oldugumuz id ile arama kutusunu locate ederek java aratalim
        driver.findElement(By.id("mehmet")).sendKeys("java");



    }
}
