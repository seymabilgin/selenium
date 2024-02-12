package day18_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutorClick extends TestBase {


    @Test
    void test01() {

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");


        //sayfadaki sell linkine tikalayalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        sellLinki.click();

        //ElementClickInterceptedException -> Bir webelementin baska bir webelement (pop-up, reklam) tarafindan engellenmesi durumunda alinir
    }

    @Test
    void test02() {

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //sayfadaki sell linkine tikalayalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",sellLinki);

    }

    @Test
    void test03() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //sayfadaki sell linkine tikalayalim
        WebElement sellLink= driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sellLink);
    }
}
