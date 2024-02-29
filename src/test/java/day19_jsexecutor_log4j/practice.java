package day19_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class practice extends TestBase {
    @Test
    void test01() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Sayfanin en altina scroll yapalim
         JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Sayfanın toplam yuksekligini dynamic olarak aldik ve Y coordinatı olarak belirledik


        waitForSecond(2);
        //sayfada yukarı cıkmak için - kullandık
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    void name() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);
        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
   JavascriptExecutor js= (JavascriptExecutor)driver;
   js.executeScript("arguments[0].value='selenium'",searchBox);
   jsSendKeys(searchBox,"java");
    }
}
