package day07_xpath_cssSelector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Checkbox {
    WebDriver driver;
    @BeforeEach
  public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
   public void Test01() throws InterruptedException {

        //  Verilen web sayfasına gidin.
        //  https://the-internet.herokuapp.com/checkboxes
        //  Checkbox1 ve checkbox2 elementlerini locate edin.
        //  Checkbox1 seçili değilse onay kutusunu tıklayın
        //  Checkbox2 seçili değilse onay kutusunu tıklayın


        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

       //  Checkbox1 ve checkbox2 elementlerini locate edin.
       WebElement checkBox1= driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

//  Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){
           checkBox1.click();
        }
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }

    }
    @AfterEach
   public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
