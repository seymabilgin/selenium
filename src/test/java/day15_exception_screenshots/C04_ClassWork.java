package day15_exception_screenshots;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ClassWork extends TestBase {
    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");
        //Ana sayfanın başarıyla yüklendiğini doğrula.
        Assertions.assertEquals("https://techproeducation.com/",driver.getCurrentUrl());
        //Sayfanın ekran görüntüsünü alin
        screenShot();
        //Sayfada görüntülenen telefon numarasinin +1 585 304 29 59 oldugunu dogrulayin
        WebElement phone = driver.findElement(By.xpath("(//a[.='+1 585 304 29 59'])[1]"));
        Assertions.assertEquals("+1 585 304 29 59",phone.getText());

        //goruntulenen telefon numarasinin ekran goruntusunu alin
        screenShotOfWebElement(phone);

        //arama kutusunda selenium yazdirin ve arama kutusunun ekran goruntusunu alin
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));
        searchBox.sendKeys("selenium");
        screenShotOfWebElement(searchBox);


    }



}
