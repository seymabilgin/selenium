package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_StaleElementReferenceException extends TestBase {

  /*
  StaleElementReferenceException nasıl alınır ?
  ==> Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde sakladıkdan sonra o sayfada herhangi
  bir yenileme islemi (navigate.refresh(),back(),forward()) methodları kullanıldıgında tekrar almalıyız

  Bu hatayi nasil handle ederiz?
    => Bu exceptionu handle etmek icin locate i (navigate.refresh(), back(), forward()) methodlari kullanildiginda tekrar almaliyiz
  */


    @Test
   public void test01() {


        driver.get("https://techproeducation.com");
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));

       driver.navigate().refresh();

       searchBox= driver.findElement(By.id("searchHeaderInput"));
       searchBox.sendKeys("Bu webelement stale");


    }

    @Test
    void InvalidArgumentException() {
        //InvalidArgumentException -> Bir method parametresine gecersiz bir arguman gonderirsek aliriz
        driver.get("123454654");
    }

    @Test
    void InvalidSelectorException() {
        //Belirtilen bir locator gecersiz oldugunda ortaya cikar
        driver.get("https://techproeducation.com");
        WebElement searchBox = driver.findElement(By.cssSelector("//*searchHeaderInput"));
    }

    //WebDriverException -> WebDriver ile ilglii kurulum, yada versiyon uyumsuzluklari yada internet kesintisi vs..
    //ElementClickInterceptedException -> Bir webelementin baska bir webelement (pop-up, reklam) tarafindan engellenmesi durumunda alinir


}
