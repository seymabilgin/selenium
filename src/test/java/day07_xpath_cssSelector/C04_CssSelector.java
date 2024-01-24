package day07_xpath_cssSelector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CssSelector {

    /*
    Syntax
    1)  tagName [ attributeName = 'attributeValue' ]
    2)  eger id ile css locate almak istersek #idAttributeValue
    3)  eger class ile css locate almak istersek .classAttributeValue

    X-Path ile Css Selector arasindaki farklar
    1)  cssSelector X-Path e gore daha hizlidir
    2)  X-Path ile bir webelementi index belirterek tek e indirgeyebiliriz
        Ama CSS selector de index kullanamayiz
    3)  X-Path ile bir webelementi sadece text'i ile locate edebiliriz
        Ama Css selector ile bunu yapamayiz
     */

    @Test
    public void test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
   driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();

        //Delete butonu'nun gorunur oldugunu test edin
  WebElement deleteButton=driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
  Assertions.assertTrue(deleteButton.isDisplayed());


Thread.sleep(3000);
  //Delete tusuna basin
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
      WebElement addRemoveElement= driver.findElement(By.cssSelector("h3"));
      Assertions.assertTrue(addRemoveElement.isDisplayed());

        //sayfayı kapatınız
        driver.quit();

    }




}
