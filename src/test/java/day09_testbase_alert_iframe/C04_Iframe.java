package day09_testbase_alert_iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Iframe extends TestBase {
    @Test
   public void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertTrue(actualText.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");


        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assertions.assertEquals("Elemental Selenium",elementalSelenium.getText());

        //driver.navigate().refresh(); ==> driver ana sayfaya gecis yapar
        //ama dikkatli kullanmaliyiz cunku eger form vb elementler var ise ve islem yapildi ise bu bilgiler ilk haline döner
        // driver.get(driver.getCurrentUrl()); //bu da bir cesit refresh


        //homework

        //https://html.com/tags/iframe/ sayfasina gidiniz
        // sayfada bulunan youtube videosunu baslatiniz



    }
}
