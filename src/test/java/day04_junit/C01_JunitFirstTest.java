package day04_junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_JunitFirstTest {
  @Test
public void test01(){

      WebDriver driver =new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get("https://techproeducation.com");
      driver.close();//Driver in en son üzerinde islem yaptigi pencereyi kapatir
      // driver.quit(); Bizim otomasyon ile actigimiz birden fazla sekmeye veya penecere kapatmak icin kullanilir

    }

    @Test
    public void test02(){
/*
        WebDriver driver =new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
        driver.close();*/
    }

    @Test
    public void test03(){

        WebDriver driver =new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
        driver.close();
    }



}
