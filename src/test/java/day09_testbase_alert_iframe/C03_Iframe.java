package day09_testbase_alert_iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Iframe extends TestBase {
    /*
    Sayfadaki bir webelementi locate ettigimizde eger NoSuchElementException aliyorsak once locate i kontrol ederiz
    buna ragmen ayni hatayi aliyorsak locate etmek istedigimiz webelemenet iframe icine olabilir
    Dolayisiyla iframe icindeki bir webelementi locate edebilmek icin driver i iframe gecis yaptirmak gerekir

    1) driver.switchTo.frame (  sayfadaki iframeni index ini  ) index 0 dan baslar
    2) driver.switchTo.frame (  <iframe> tagindaki id / name attribute degeri ile  )
    3) driver.switchTo.frame (  iframe in locatini alarak  )

    => Eger tekrar ana sayfaya gecmek istersek defaultContent() methodu ile iframe den cikip anasayfaya gecebiliriz
    => Eger ic ice iframe lere gecis yaptiysak ve bir üst frame tekrar gecis yapmamiz gerekiyorsa bunu parentFrame() ile yapabiliriz
      */
    @Test
  public  void test01() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String actualText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assertions.assertTrue(actualText.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        WebElement applicationsList = driver.findElement(By.xpath("//*[.='Applications lists']"));
        Assertions.assertTrue(applicationsList.isDisplayed());

        //Son olarak sayfa başlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().defaultContent();//ana sayfaya gecis yaptik
        String iframeText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("iframe",iframeText);

    }
}
