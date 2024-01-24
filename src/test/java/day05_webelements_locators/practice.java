package day05_webelements_locators;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class practice {
    // Google sayfasına gidelim
    // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
    // Aramayı yapalim
    //Başlığın selenium içerdiğini test edelim
    //Sayfada kaç tane link olduğunu yazdıralım
    //Sayfadaki linklerin metinleri varsa konsola yazdıralım
    //sayfayı kapatalım


    @Test
   public void test() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
       searchBox.submit();

    String actualTitle=driver.getTitle();
    String expectedTitle="selenium";
        Assertions.assertTrue(actualTitle.contains(expectedTitle));
        Assertions.assertTrue(driver.getTitle().contains("selenium"));


     List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayisi " + links.size());

for (WebElement w : links ){

    if (!w.getText().isEmpty()){
        System.out.println(w.getText());
    }
}


    }
}