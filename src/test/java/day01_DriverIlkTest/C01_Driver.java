package day01_DriverIlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Driver {

    public static void main(String[] args) {

/*
ChromeDriver, selenium'dan gelen komutlari alir ve chrome un anlayacagi sekilde cevirir.
Bunun için javadan         System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); kodu ile
selenium a chromeDriver in konumunu bildirerek chrome browser in doğru bir sekilde baslatilmasını sağlar.

 */
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver (1).exe");
        /*MYnot:setProperty sistem özelliklerini ayararlamak için kullanılır*/

        /*Mynot:chromedriver selenium ile chrome arasında aracı,
         selenium ile yazdığımız kodları chrome ın anlayacağı dile cevirir.
         */

       WebDriver driver=new ChromeDriver(); // biz bu kod ile boş bir chrome sayfası açıyoruz

        driver.get("https://google.com");//get methodu ile string olarak belittiğimiz url e gideriz

        driver.quit();//oturumu sonlanrırız

    }


}
