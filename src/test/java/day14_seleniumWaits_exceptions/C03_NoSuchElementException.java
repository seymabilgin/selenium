package day14_seleniumWaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_NoSuchElementException extends TestBase {
     /*
    NoSuchElementException aliyorsak;
    1) Yanlis locate almis olabiliriz, dolayisiyla locatei kontrol etmemiz gerekir
    2) Wait / Syncronization problemi olabilir, implicitly wait te yeterli sure kadar bekledigimizden
    emin oluruz, yeterli degilse o sureyi artiririz
    3) Locate ini aldigimiz webelement iframe icindeyse ve iframe e geciy yapmassak bu hatayi aliriz
    4) Bazi sayfalarda locate etmek istedigimiz webelement sayfanin altinda olabilir ve driver bunu goremeyebilir
    Dolayisiyla scroll yaparak driver a bu webelementi gostererek hatayi handle edebiliriz
    5) Sayfadaki bir butona tiklama sonucunda yeni bir sayfa yada sekme acildiysa ve yeni acilan sayfaya driveri gecis
    yaptirmazsak bu saffadaki webelementi bulamaz ve bu hatayi aliriz
   */
    @Test
    public void test01() {
        driver.get("https://techproeducation.com");
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));
        searchBox.sendKeys("Batch210");

    }
}
