package day02_driverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethodsTest {
    public static void main(String[] args) throws InterruptedException {

        //Amazon sayfasina gidelim. https://www.amazon.com/
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get(" https://www.amazon.com/");
//Sayfa basligini(title) yazdirin
        String actualAmazonTitle=driver.getTitle();

//Sayfa basliginin "Amazon" icerdigini test edin
        if (actualAmazonTitle.contains("Amazon")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

//Sayfa adresini(url) yazdirin
      String actualAmazonUrl =driver.getCurrentUrl();


//Sayfa url'inin "amazon" icerdigini test edin.
        if (actualAmazonUrl.contains("amazon")){
            System.out.println("test=pass");
        }
//Sayfa handle degerini yazdirin
       String amazonHandleDeğeri= driver.getWindowHandle();
        System.out.println("amazonHandleDeğeri = " + amazonHandleDeğeri);

        /*Handle değerlerini bir sepete koyarız konsolda gözüktüğü gibi olması bizi ilgilendirmez*/


        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().refresh();

//Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin

  String amazonHtmlCssCodes=driver.getPageSource();
if (amazonHtmlCssCodes.contains("Gateway")){
    System.out.println("TEST PASSED");
}else{
    System.out.println("TEST FAILED");
}
//Sayfayi kapatin.
        driver.quit();






    }
}
