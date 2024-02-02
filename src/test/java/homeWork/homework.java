package homeWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class homework extends TestBase {
    @Test
   public void youtube() {
        //homework
        //https://html.com/tags/iframe/ sayfasina gidiniz
        // sayfada bulunan youtube videosunu baslatiniz


       //https://html.com/tags/iframe/ sayfasina gidiniz
        driver.get("https://html.com/tags/iframe/");
        waitForSecond(2);
        // İframe'e geçiş yapılır
        driver.switchTo().frame(0);
       // WebElement iframeElement = driver.findElement(By.xpath("(//iframe)[1]"));

        waitForSecond(2);
        // sayfada bulunan youtube videosunu baslatiniz
        // iframe içindeki YouTube video button elementi bulunur.
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

       //iframeden çıkılabilir
        driver.switchTo().defaultContent();
    }
}
