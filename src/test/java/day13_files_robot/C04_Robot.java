package day13_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C04_Robot extends TestBase {
    @Test
 public void test01() throws AWTException {
/*Robot class java ya ait bir classdır. Driver mızın windows uygulamalarında gezinmesini sağlar.
(Actions class selenium a ait bir classtır.Robot class ile actions class işlev olarak benzerlik gösterir */
  /*
        Upload file yaparken sendKeys() methodu islemedigi durumlarda TestBase classinda olusturdugumuz
        uploadFilePath() methodu ile dosya yi yukleyebiliriz
        Bu method kullanilirken manual olarak klavye yada mouse u kullanmamamiz gerekir
         */
        //Robot classi java nin yerel kütüphanesinde bulunur ve seleniumdaki actions class gibi mouse ve
        //klavye islemlerini simule eder

        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS); //VK_WINDOWS başlat kısmına basmamızı sağlar
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.delay(3000); // delay methodu wait medhodu gibi bekleme süresi tanımlar

        robot.keyPress(KeyEvent.VK_N); //VK_N searchBox a istenilen karakteri girer
        robot.keyRelease(KeyEvent.VK_N);
        robot.delay(3000);

    }

    @Test
  public void robotTest() {


        //"https://www.ilovepdf.com/compress_pdf" sayfasina gidilir
        driver.get("https://www.ilovepdf.com/compress_pdf");
        //   yuklenmek istenen dosya yuklenir
        driver.findElement(By.id("pickfiles")).click();
         waitForSecond(2);

       String dosyaYolu=System.getProperty("user.home")+"Desktop\\Batch 210upload.pdf";
       uploadFilePath(dosyaYolu);

        //   dosyanin basariyla yuklendigini test edilir
        WebElement verify = driver.findElement(By.xpath("//span[.='Batch 210upload.pdf']"));
        Assertions.assertTrue(verify.isDisplayed());



    }
}
