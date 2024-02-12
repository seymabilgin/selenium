package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {

    /*
    selenium da bir sayfanın ekran goruntusunu almak istiyorsak;
    1-Ekran goruntulerini projelerimizde kaydetmek icin bir klasor olusturup yolunu aliriz
    2-TakeScreenShot tipinde object declare ederiz ve driver i bu objeye assign edecegiz

    TakesScreenShot ts=driver;

    3-Files classindan write() methodu kullanarak icinde parametre olarak aldıgımız ekran goruntusunu nereye
    kaydedeceğimizi belirtiriz

  getScreenShotAs() methodu ile ekran gorunutusunu alarak kaydetmek icin almis oldugumuz dosya yolunu belirtiriz
     */




    @Test
   public void name() throws IOException {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Sayfanin ekran goruntusunu alalim

        String dosyaYolu="src\\test\\java\\screenShots\\techpro.png"; //techpro.png kısmını suan biz manul yazdık daha sonra otomate edicez

        TakesScreenshot ts= (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));




    }

    @Test
    void test02() throws IOException {

        driver.get("https://google.com");
        String dosyaYolu = "src\\test\\java\\screenShots\\google.jpeg";

        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));// Files.write fotograf cinsini BYTES ARRAY
        //cinsinden istedigi icin BYTES seciyoruz



    }

    @Test
    void test03() throws IOException {
    //facebook sayfasina gidiniz
        driver.get("https://facebook.com");

   //sayfanin ekran goruntusunu aliniz
       // LocalDateTime.now();
      String date=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String dosyaYolu="src\\test\\java\\screenShots\\facebook"+date+".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    void test04() {
    //facebook sayfasina gidiniz
        driver.get("https://facebook.com");


        //sayfanin ekran goruntusunu aliniz
        screenShot();//TestBase classına koymus oldugumuz reusable method ile ekran görüntüsü almıs olduk
    }


}
