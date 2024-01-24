package day03_driverMethods_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Work {
    public static void main(String[] args) throws InterruptedException {

        //  Yeni bir class olusturalim (Homework)

        //WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “Facebook” icerdigini dogrulayin (verify), degilse dogru basligi yazdirin.

        driver.get("https://www.facebook.com");
        String expectedTitleFacebook="Facebook";
        String actualTitleFacebook=driver.getTitle();

        if (actualTitleFacebook.equals(expectedTitleFacebook)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("Sayfa Baslıgı:"+actualTitleFacebook);
        }

       // Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("Sayfa Url'si = "+driver.getCurrentUrl());
        }

       // https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

      // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
       if (driver.getTitle().contains("Walmart.com")){
           System.out.println("TEST PASSED");
       }else{
           System.out.println("TEST FAILED"+"sayfa baslıgı = "+driver.getTitle());
       }

       // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

       //Sayfayi yenileyin
        driver.navigate().refresh();



       // sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();




       // Sayfayi kapatin*/
        driver.quit();







    }
}
