package day16_extentReport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class C03_ExtentReportTest extends TestBase {
    @Test
  public  void test01() {

        createExtentReport("Amazon Title Test");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanici amazon sayfasina gider");
        screenShot();

        waitForSecond(1);
        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        screenShotOfWebElement(searchBox);

        searchBox.sendKeys("selenium", Keys.ENTER);
        extentTest.info("Arama kutusunda selenium yazilarak aratildi");


        waitForSecond(2);
        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assertions.assertTrue(driver.getTitle().contains("selenium"));
        extentTest.pass("Sayfa basliginin selenium icerdigi dogrulandi");
        screenShot();

        extentReports.flush();




    }


}
