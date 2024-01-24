package day07_xpath_cssSelector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathClassWork   {
    //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    //Add Element butonuna basin
    //Delete butonu'nun gorunur oldugunu test edin
    //Delete tusuna basin
    //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
    //sayfayı kapatınız

    @Test
   public void test01() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.xpath("//*[ contains (text(),'Add Ele' ) ]")).click();
        Thread.sleep(3000);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete'  ]"));
        Assertions.assertTrue(deleteButton.isDisplayed());

        //Delete tusuna basin
        Thread.sleep(3000);
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveText=driver.findElement(By.xpath("//*[.='Add/Remove Elements']"));
        Assertions.assertTrue(addRemoveText.isDisplayed());




        //sayfayı kapatınız
        driver.quit();


    }


}
