package day08_relativeLocators_dropdown_testbase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import java.time.Duration;

public class C01_RelativeLocators {

    @Test
    public void test01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");



        WebElement NYC= driver.findElement(By.id("pid3_thumb"));
        WebElement Bay_Area = driver.findElement(By.id("pid8_thumb"));

        //Berlin'i relative locator ile locate edin

  WebElement berlin = driver.findElement(with(By.tagName("img")).below(NYC).toLeftOf(Bay_Area));
  // indexlerin kayma ihtimali vardır bu yönden bunu kullanmanın avantajı vardır. readable dır. Bu yöntemler çok kullanılmaz

        //Relative locator'larin dogru calistigini test edin
      String actualIDValue = berlin.getAttribute("id");
      String expectedIDValue ="pid7_thumb";
      Assertions.assertEquals(expectedIDValue,actualIDValue);

        //sayfayı kapatınız
  driver.quit();




    }

}
