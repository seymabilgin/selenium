package day03_driverMethods_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();


        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");


        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin konumu"+driver.manage().window().getPosition());
        System.out.println("Sayfanin olculeri"+ driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin

        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        driver.manage().window().getPosition();
        driver.manage().window().getSize();

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        driver.manage().window().getPosition();
        driver.manage().window().getSize();

        //Sayfayi kapatin
        driver.quit();



    }
}
