package day10_windowHandle_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

import java.util.Set;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("Opening a new window",actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Her")).click();

        waitForSecond(5);
        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.

        Set<String> windows = driver.getWindowHandles();

        for( String w : windows){
            if(!w.equals(ilkSayfaHandleDegeri)){
                driver.switchTo().window(w);
            }
        }

        String ikinciSayfaHandleDegeri= driver.getWindowHandle();
        Assertions.assertEquals("New Window",driver.getTitle());

        waitForSecond(3);

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandleDegeri);

    }

    //Reusable method kullanimi
    @Test
    public void test02() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("Opening a new window",actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Her")).click();

        waitForSecond(5);
        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        switchToWindow(1);
        Assertions.assertEquals("New Window",driver.getTitle());

        waitForSecond(3);

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        switchToWindow(0);
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  ikinci sayfaya tekrar geçin.
        switchToWindow(1);

        //  ilk sayfaya tekrar dönün.
        switchToWindow(0);

    }

}
