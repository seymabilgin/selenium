package day10_windowHandle_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class practice extends TestBase {
    @Test
   public void test01() {

    /*
   https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

Bir metod olusturun: acceptAlert
      birinci butona tıklayın,
      uyarıdaki OK butonuna tıklayın
      result mesajının  "You successfully clicked an alert" oldugunu test edin.

Bir metod olusturun: dismissAlert
       ikinci butona tıklayın,
       uyarıdaki Cancel butonuna tıklayın
       result mesajının "successfuly" icermedigini test edin.

Bir metod olusturun: sendKeysAlert
       ucuncu butona tıklayın,
       uyarıdaki  metin kutusuna isminizi yazin,
       OK butonuna tıklayın
       result mesajında isminizin görüntülendiğini doğrulayın.
    */


    }

    @Test
  public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        



    }
}
