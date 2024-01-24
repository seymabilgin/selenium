package day03_driverMethods_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ImplicitlyWait {
    public static void main(String[] args) {

 /*     Nasil ki bir websayfasin manual olarak actigimizda maximize yapiyorsak otomasyon ilede maximize yapmaliyiz
        Cünkü Driver tum webelementleri net bir seklide görebilmesi icin bunu yapmaliyiz
        Bir websayfasina gittigimizde internet yada baska sebeplerle weblementler hemen olusmayabilir
        Dolayasiyla islem yapilmak istenen webelement bulunamayacağı icin hata aliriz,
        Bu nedenle implicitly wait kullanarak isimizin cogunu hallederiz
        bazi extra dynamic beklemeler icin explicit wait kullanmayi ögreneceğiz
        Implicitly wait sayfadaki webelementlerin olusmasini maximum olarak belirttigmiz süre kadar bekler
        eger bu süre dolmadan yuklenme gerceklesirse dirver beklemeye devam etmez  yoluna devam eder
         */

        //WebDriverManager.chromedriver().setup(); //-->selenium un son versiyonu ile buna gerek kalmadı
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //techpro sayfasına gidiniz
        driver.get("https://techproeducation.com");



        //sayfa başlığının TechPro Education olduğunu test ediniz
        String expectedData ="TechPro Education";
        String actualData=driver.getTitle();

        if (actualData.equals(expectedData)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }

        //facebook sayfasına gidiniz
        driver.get("https://www.facebook.com");

        //sayfa url'inin facebook içerdiğini test ediniz

        if(driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        //techpro sayfasına geri dönününüz
       driver.navigate().back();

        //Geri döndüğünüzü test ediniz
        actualData= driver.getTitle();

        System.out.println("actualData = " + actualData);
        if (actualData.equals("TechPro Education IT Programmers")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }

        //sayfayı kapatınız

        driver.quit();


    }
}
