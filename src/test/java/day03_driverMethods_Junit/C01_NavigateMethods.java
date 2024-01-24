package day03_driverMethods_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        /*
        Thread.sleep(3000); JAVA dan gelen bir bekletme ozelligidir, selenium dan gelmiyor
        Test uzmanlari Thread.sleep() kullanmaktan mumkün oldugunca kacinmalidir, cunku gereksiz beklemeler neden olur
        Hard wait olarakta adlandirilir, onumuzdeki derslerde dynamic waitleri ögreneceğiz onlari kullanmaliyiz
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        // techproeducation ana sayfasina gidelim . https://www.techproeducation.com/
        driver.navigate().to("https://www.techproeducation.com/");
        Thread.sleep(3000);

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        //Tekrar techproeducation sayfasina donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(3000);

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();






    }
}
