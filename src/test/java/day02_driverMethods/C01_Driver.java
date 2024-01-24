package day02_driverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class C01_Driver {
    public static void main(String[] args) {
/*
WebDriverManager sayesinde istedigimiz browser icin setup yaparak otomasyonda kullanabiliriz.
Bu sayede browser a gore gerekli olan driver i bilgisayarimiza indirmek ve yapilandirmak zorunda
kalmayiz.
*/
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver =  new ChromeDriver();
        chromeDriver.get("https://google.com");
        chromeDriver.quit();

 /*
        WebDriverManager.firefoxdriver().setup();
        WebDriver fireFoxDriver = new FirefoxDriver();
        fireFoxDriver.get("https://google.com");
        fireFoxDriver.quit();  */
/*pc de firefox yoksa bu kod çalışmaz*/

        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver= new EdgeDriver();
        edgeDriver.get("https://google.com");
        edgeDriver.quit();

  /*      WebDriverManager.safaridriver().setup();
        WebDriver safariDriver=new SafariDriver();
        safariDriver.get("https://google.com");
        safariDriver.quit();
        */

    }
}
