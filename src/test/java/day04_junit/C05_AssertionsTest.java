package day04_junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_AssertionsTest {
    // Google Web sitesine gidin
    // Sayfa basliginin Google oldugunu dogrulayin
    // Sayfayi kapatin
    // Google Web sitesine gidin
    // Sayfa url nin https://www.google.com/ oldugunu dogrulayin
    // Sayfayi kapatin


    @Test
   public void testPageTitle() {

        // Google Web sitesine gidin
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("htttps://google.com");

        // Sayfa basliginin Google oldugunu dogrulayin
        String expectedTitle= "Google";
        String actualTitle= driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);
        
        // Sayfayi kapatin
        driver.close();

    }
    // Google Web sitesine gidin
    // Sayfa url nin https://www.google.com/ oldugunu dogrulayin
    // Sayfayi kapatin

    @Test
   public void URLdogrulamaTesti() {
        // Google Web sitesine gidin
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");

        // Sayfa url nin https://www.google.com/ oldugunu dogrulayin
        String expectedUrl="https://www.google.com/";
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

        // Sayfayi kapatin
        driver.close();


    }
}
