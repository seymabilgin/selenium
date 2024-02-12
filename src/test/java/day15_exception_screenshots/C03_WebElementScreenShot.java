package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_WebElementScreenShot extends TestBase {

    //selenium 4 ile beraber specific bir WebElementin ekran goruntusunu alabiliyoruz
    @Test
    void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım
        WebElement resultText = driver.findElement(By.xpath("//*[ contains( text() , 'results for' )]"));
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src\\test\\java\\screenShots\\webElementsSS" + date + ".png";
        Files.write(Paths.get(dosyaYolu), resultText.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void test02() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        // waitForSecond(7);

        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım
        WebElement resultText = driver.findElement(By.xpath("//*[ contains( text() , 'results for' )]"));
        screenShotOfWebElement(resultText);
    }





}
