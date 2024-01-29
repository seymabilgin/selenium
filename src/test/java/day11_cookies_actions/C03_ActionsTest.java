package day11_cookies_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {
    @Test
    public void test01() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.findElement(By.partialLinkText("Try different image")).click();//capthe cıkarsa bununla aş


        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountList= driver.findElement(By.id("nav-link-accountList"));
        Actions actions =new Actions(driver);
        actions.moveToElement(accountList).perform();

        waitForSecond(3);

        driver.findElement(By.xpath("//span[.='Account']")).click();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));




    }

}
