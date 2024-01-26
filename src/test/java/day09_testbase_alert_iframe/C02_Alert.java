package day09_testbase_alert_iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {

  /*
        Eger bir safyadaki bir buttona tikladigimzda bir uyari penceresi aciliyorsa ve bu acilan pencereye sag tiklayarak inspect yapamiyorsak
        (locate edemiyorsak) bu bir JS Alerttir

        JS Alert ü handle edebilmek icin driverimizi o acilan pencereye gecirmemiz gerekir
        bunu switchTo() methodu ile ve alert() methodunu secerek yapariz

     */

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




    @Test
  public void acceptAlert() {

       // Bir metod olusturun: acceptAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        waitForSecond(2);
       // birinci butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        waitForSecond(1);
        //  uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();
       // result mesajının  "You successfully clicked an alert" oldugunu test edin.
      String actualResultMessage=driver.findElement(By.cssSelector("#result")).getText();
      String expectedResultMassage="You successfully clicked an alert";
        Assertions.assertEquals(expectedResultMassage,actualResultMessage);


    }

    @Test
  public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //       ikinci butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        //       uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();//cancel butonuna basar

        //       result mesajının "successfuly" icermedigini test edin.
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        String unExpectedResultMessage="successfuly";
        //icerir kodunun false oldugunu doğrulamaliyiz
        Assertions.assertFalse(actualResultMessage.contains(unExpectedResultMessage));

    }

    @Test
  public void sendKeysAlert() {
        //  Bir metod olusturun: sendKeysAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //  ucuncu butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //          uyarıdaki  metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("mehmet");

        //  OK butonuna tıklayın
        driver.switchTo().alert().accept();

        //  result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assertions.assertTrue(actualResultMessage.contains("mehmet"));
    }
}
