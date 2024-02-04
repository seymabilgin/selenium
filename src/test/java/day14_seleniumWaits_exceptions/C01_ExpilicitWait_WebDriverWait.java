package day14_seleniumWaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExpilicitWait_WebDriverWait extends TestBase {
    /*
   Selenium waits
   1) Implicitly wait
       ==>Bir websayfasina gittikten sonra sayfadaki tum webelementlerin driver ile etkilesime gecebilmesi
       icin belirtmis oldugumuz maximum sure kadar driveri bekletiriz

   2) Explicit wait
       a)WebDriverWait
       ==>Bir websayfasi yuklendikten sonra bir webelement ile ilgli specific bir kosul icin maximumum belirtmis
       olduğumuz sure kadar bekletiriz, Bu sure default olarak yarim saniyelik araliklar ile olur
       ==>Bir kosulun gerceklesmesi farkli surelerde meydana gelebilir, boyle bir durumuda Thread.Sleep kullanmamiz
       profosyonel bir yaklasim olmaz, Bunun yerine WebDriverWait ile bir webelementin olusmansini beklemek daha mantikli olur

       b)FluentWait
       ==>Bir webelementin sayfaya yuklendikten sonra belli bir kosul icin etkilesime gecebilmesi amaciyla maximumu belirtmis
       oldugumuz sure kadar yine belirteceğimiz araliklar ile bekler
    */
    @Test
 public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();
        //Hello World! Yazının sitede oldugunu test et
        //waitForSecond(15); ==> hardwait kullanmaktan mumkun oldugunca kacinmaliyiz
         /*
        1)hangi webelement gorunur olana kadar beklemek istiyorsak o webelementi locate ediyoruz
        2)Webdriverwait objecti olusturuyoruz ve burada max. bekleyeceği sureyi tayin ediyoruz
        3)Olusturmus oldugumuz webdriverwait objecti uzerindten kosulumuzu beliritiyoruz
         */
        WebElement helloWorld=driver.findElement(By.xpath("//*[.='Hello World!']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assertions.assertEquals("Hello World!",helloWorld.getText());


    }

    @Test
   public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();
           /*
        Locate ini aldigimiz webelementi gorunur olana kadar bekle dedik ve gorunur olduktan sonrada o webelementi bize ver dedik
        Eger belirtilen sure icinde (20 sn) aradigimiz webelement gorunur hale gelirse bu kod o webelementi bize verir
        ama eger belirtilen sure icinde gorunur hale gelmez ise o zamanda TimeOutException firlatir
         */

WebElement helloWorldText=new WebDriverWait(driver,Duration.ofSeconds(20)).
        until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Hello World!']")));
        Assertions.assertEquals("Hello World!",helloWorldText.getText());

    }

}
