package day19_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_jsScroll extends TestBase {


    @Test
    public void test01() {

        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Sayfanin en altina scroll yapalim

        JavascriptExecutor jse=(JavascriptExecutor)driver;
        //jse.executeScript("window.scrollTo(0,2222)");

        //Sayfanın toplam yuksekligini dynamic olarak aldik ve Y coordinatı olarak belirledik
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        waitForSecond(2);
        //sayfada yukarı cıkmak için - kullandık
        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    void test02() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        //Sayfanin en altina scroll yapalim
     jsScrollEnd();

     waitForSecond(2);

     //Sayfanın en ustune scroll yapalım
        jsScrollHome();
    }
}
