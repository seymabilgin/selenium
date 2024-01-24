package day07_xpath_cssSelector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {


    @Test
    public void test01() throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("#signin_button")).click();

        //Login alanine  “username” yazdirin
        //Password alanine “password” yazdirin
        //Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("#user_login"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        driver.navigate().back();//-> sayfaya giris yapabilmek icin back() yaptik

        //Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#onlineBankingMenu")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
        Thread.sleep(3000);

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina “2020-09-10” yazdirin
        //Pay buttonuna tiklayin
        WebElement amount = driver.findElement(By.cssSelector("#sp_amount"));
        amount.sendKeys("1000",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);


        //“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement succesMessage = driver.findElement(By.xpath("//span[.='The payment was successfully submitted.']"));
        Assertions.assertEquals("The payment was successfully submitted.",succesMessage.getText());

        //sayfayı kapatınız
        driver.quit();

    }

    }
