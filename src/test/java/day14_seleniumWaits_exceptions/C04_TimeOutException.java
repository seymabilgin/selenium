package day14_seleniumWaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_TimeOutException extends TestBase {
     /*
    Eger TimeOutException aliyorsak;
    1) Explicit wait te kullandigimiz max.beklemesi gereken sureyi kontrol etmeliyiz
    2) Explicit wait ile aldigmiz locate i kontrol etmeliyiz
    3) Explicit wait ile locate aldigimiz element iframe icinde kalmis olabilir

    NOT :
    TimeOutException Explicit wait kullanildiginda alinan bir hatadir, implictly wait te sure yeterli olmaz ise
    NoSuchElementException aliriz
     */
     @Test
     public void test01() {

         //https://the-internet.herokuapp.com/dynamic_loading/1
         driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

         //Start buttonuna tıkla
         driver.findElement(By.xpath("//button")).click();

         //Hello World! Yazının sitede oldugunu test et
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
         WebElement helloWorld = driver.findElement(By.xpath("//*[.='Hello World!']"));
         wait.until(ExpectedConditions.visibilityOf(helloWorld));
         Assertions.assertEquals("Hello World!",helloWorld.getText());
     }

}
