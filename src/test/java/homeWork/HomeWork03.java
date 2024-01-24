package homeWork;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork03 {

/*
ÖDEV:
https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
Add Element butonuna basin 100 kez basınız
Delete butonuna 90 kez basınız
Ve 90 kez basıldığını doğrulayınız
*/

    @Test
  public void test01() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin 100 kez basınız
        for (int i=0;i<100;i++){
            WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            addElement.click();
        }

        Thread.sleep(3000);
        //Delete butonuna 90 kez basınız
        int counter=0;
        for (int i = 0; i <90 ; i++) {
            WebElement deleteButton= driver.findElement(By.xpath("//button[text()='Delete']"));
            deleteButton.click();
            counter++;
        }
        Thread.sleep(3000);
        //Ve 90 kez basıldığını doğrulayınız
        int actualData=counter;
        int expectedData=90;

        Assertions.assertEquals(90, counter);

        driver.quit();





    }

}
