package day06_webelements_xpath;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {
   /*
   / ->Bu direkt bir childi secer
   //-> Bu belgenin herhangi bir yerindeki elementi secmek icin kullanılır
   @-> Bir webelementin attribute unu secmek icin kullanılır
   []-> Kosullar veya index belirtmek icin kullanilir
   * -> //* ==> ifadesi sayfadaki tüm elemenlleri secer

  SYNTAX :
       tagName [ @ attributeName = ' attributeValue ' ]
       //*[@ * = 'attribuet degeri']
    Not : Eger xpath ile birden fazla sonuc gelirse o webelementin indexini asagidaki sekilde belirtebiliriz
       ( tagName [ @ attributeName = ' attributeValue ' ] )[ index ]
    */


    @Test
  public  void test() throws InterruptedException {
        //web sayfasına gidin. https://www.amazon.com/
        //Arama kutusunda "city bike" aratin (arama kutusunu xpath ile locate edin)
        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        //Sadece sonuc sayısını yazdırınız
        //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
        //sayfayi kapatınız

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(15000);

        //Arama kutusunda "city bike" aratin (arama kutusunu xpath ile locate edin)
        // tagName [ @ attributeName = ' attributeValue ' ]
        WebElement searchBox =driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("city bike"+ Keys.ENTER);

        //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("aramaSonucu.getText() = " + aramaSonucu.getText());

        //Sadece sonuc sayısını yazdırınız      1-16 of 172 results for
        System.out.println(" sadece sonuc sayisi "+aramaSonucu.getText().split(" ")[2]);

        //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
        driver.findElement(By.xpath("(//h2)[1]/a")).click();

        //sayfayi kapatınız
        driver.quit();

    }
}
