package day07_xpath_cssSelector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
   public void test01() throws InterruptedException {
        // https://www.facebook.com adresine gidin
        //           Cookies'i kabul edin
        //           "Create an Account" button'una basin
        //           "radio buttons" elementlerini locate edin
        //           Secili degilse cinsiyet butonundan size uygun olani secin

        driver.get("https://www.facebook.com ");

        //           "Create an Account" button'una basin

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();


       //   "radio buttons" elementlerini locate edin
        WebElement female= driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male= driver.findElement(By.xpath("//input[@value='2']"));

        Thread.sleep(3000);

        //           Secili degilse cinsiyet butonundan size uygun olani secin

       if (!female.isSelected()){

            female.click();
        }



      /*  if (!male.isSelected()){
            male.click();
        }*/




    }
}
