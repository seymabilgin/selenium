package day19_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsLocate extends TestBase {

    /*JSExecutor ile bir web elementin locatetini document.getElementById('twotabsearchtextbox') methodu ile alabiliriz.
    */
    @Test
  public void test01() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //jsexecutor ile aramakutusunu locate edelim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox')");
        searchBox.sendKeys("selenium");

      //bu yöntem getAttribute benzer. bu yöntemle sadece value degil tüm elementlerini alabiliriz.
     String searchBoxValue=js.executeScript("return document.getElementById('twotabsearchtextbox').value").toString();
     String searchBoxTypeAttributeDegeri=js.executeScript("return document.getElementById('twotabsearchtextbox').type").toString();
    }

    @Test
    void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Events yazısinı BATCH210 ile degistirelim
        WebElement eventsText=driver.findElement(By.xpath("//h2[.='Events']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent='BATCH 210'",eventsText);

    }
}
