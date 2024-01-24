package day05_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ClassWork {
    @Test
    public void test01() {
        // Google sayfasına gidelim
        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
        // Aramayı yapalim
        //Başlığın selenium içerdiğini test edelim
        //Sayfada kaç tane link olduğunu yazdıralım
        //Sayfadaki linklerin metinleri varsa konsola yazdıralım
        //sayfayı kapatalım

     // Google sayfasına gidelim
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");

        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
        WebElement searchBox =driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        // Aramayı yapalim
        searchBox.submit();


        //Başlığın selenium içerdiğini test edelim
       // 1.yol
      /*
        String actualTitle= driver.getTitle();
        String expectedTitle="selenium";
        Assertions.assertTrue(actualTitle.contains(expectedTitle));
        */

        //2. yol
        Assertions.assertTrue(driver.getTitle().contains("selenium"));


        //Sayfada kaç tane link olduğunu yazdıralım

        /*Eger birden fazla web elementi locate etmek istiyorsak findElements Methodunu kullanırız
        bu method bir listin icinde webelemetlerini return eder
         */
       List<WebElement> links= driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayısı="+links.size());


        //Sayfadaki linklerin metinleri varsa konsola yazdıralım
        for (WebElement w : links){
           // System.out.println("w.getText"+w.getText());
           if (!w.getText().isEmpty()){
               System.out.println(w.getText());//Eger bir webelementin üzeindeki yaziyi almak istersek bu methodu kullaniriz
           }
        }

        //sayfayı kapatalım
        driver.close();
    }


}
