package homeWork;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class HomeWork06 extends TestBase {
 /*   ==========Homework 1===========================
            - http://szimek.github.io/signature_pad/ sayfasına gidiniz
            - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
- Çizimden sonra clear butonuna basınız
- Sayfayi kapatiniz
===========Homework 2==========================
    https://the-internet.herokuapp.com/dropdown adresine gidin.
            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.

        ===========Homework 3==========================
    https://testpages.herokuapp.com/ adresine gidiniz
    File Downloads a tiklayiniz
    Acilan sayfada Server Download a tiklayiniz
    Dosyanin basariyla indirildigini test ediniz
===========Homework 4==========================
    https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
    click me buttonu na tiklayiniz
"Event Triggered" yazisinin görüntülendigini dogrulayiniz
===========Homework 5==========================
    https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin.
    Username adını, Password ve textArea bolumlerini faker ile doldurun
    Bir dosya seçin ve yükleyin
    Tüm checkbox lari secin
    Radio button da radio 1 i secin
    Dropdown menü den 2'yi seçin
    submit'e tıklayın
    Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın
===========Homework 6==========================
            // https://www.saucedemo.com/ adresine gidin
            // Kullanici adini "standard_user" olarak girin
            // Şifreyi "secret_sauce" olarak girin
            // Login buttonuna tiklayin
            // Tum urunleri sepete ekleyin
            // Sepete tiklayarak gidin
            // Checkout a tiklayin
            // FirstName-LastName ve posta code unu doldurun
            // continue butonuna tiklayin
            // Toplam fiyatın 140,34$ olduğunu dogrulayin
            // finish e tiklayin
            // Checkout: Complete! yazisinin görüntülendigini doğrulayiniz
            ===========Homework 7==========================
    https://demo.guru99.com/test/drag_drop.html adresine gidin
    Sayfayi kesfederek turuncu webelementleri uygun kutulara sürükleyin
    Perfect! yazisinin görüntülendigini test edin


  */

    @Test
    void writingBoard() {
        /* ==========Homework 1===========================*/

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions=new Actions(driver);
     WebElement  writingBoard= driver.findElement(By.xpath("//canvas[@style='touch-action: none; user-select: none;']"));
     actions.clickAndHold(writingBoard)
             .moveByOffset(150,20)
             .moveByOffset(50,20)
             .moveByOffset(60,100)
             .moveByOffset(80,150)
             .release().perform();

        //Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[@class='button clear']")).click();
        
        // Sayfayi kapatiniz
    }

    @Test
    void DropDownMenu() {
       // ===========Homework 2==========================
       // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm=driver.findElement(By.id("dropdown"));
        Select select= new Select(ddm);

        waitForSecond(2);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        String selected=driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        System.out.println("selected = " + selected);

        waitForSecond(2);
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        String selected2=driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        System.out.println("selected2 = " + selected2);

        waitForSecond(1);
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        String selected3=driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        System.out.println("selected3 = " + selected3);
        System.out.println("==================================");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> options=select.getOptions();
        options.forEach(t-> System.out.println(t.getText()));
        System.out.println("==================================");

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        // False yazdırın.

        int expectedSize = 4;
        int actualSize = select.getOptions().size();

        // Assertion kullanarak sonucu konsola yazdırma
        try {
            Assertions.assertTrue(actualSize == expectedSize);
            System.out.println("True");
        } catch (AssertionError e) {
            System.out.println("False");
            e.printStackTrace();

    }

        System.out.println("==================================");

    }

    @Test
    void fileDownload() {

      //    ===========Homework 3==========================

        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\textfile.txt";

        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.err.println("DOSYA SILINEMEDİ!!!");
        }

         Actions action= new Actions(driver);

        // https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        // File Downloads a tiklayiniz
        WebElement fileDownload=driver.findElement(By.cssSelector("#download"));
       // action.scrollToElement(fileDownload).perform();

        fileDownload.click();

       // Acilan sayfada Server Download a tiklayiniz
        driver.findElement(By.id("server-download")).click();

       // Dosyanin basariyla indirildigini test ediniz*/
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("server-download"))).click();
        waitForSecond(2);
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }




    @Test
    void eventTriggered() throws AWTException {
    //  ===========Homework 4==========================

    //  https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        waitForSecond(2);

    //   click me buttonu na tiklayiniz
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='styled-click-button showgrow grown']"))).click();

        waitForSecond(2);
        //"Event Triggered" yazisinin görüntülendigini dogrulayiniz
        WebElement text=driver.findElement(By.xpath("//button[@id='growbutton']"));
        waitForSecond(2);
        Assertions.assertTrue(text.isDisplayed());



    }

    @Test
    void name2() {
      //  ===========Homework 5==========================
        //https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin.
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        Faker faker =new Faker();
        //Username adını, Password ve textArea bolumlerini faker ile doldurun
        driver.findElement(By.name("username")).sendKeys(faker.name().username());
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());
        driver.findElement(By.name("comments")).sendKeys(faker.lorem().paragraph());
        // Bir dosya seçin ve yükleyin
        WebElement fileButton=driver.findElement(By.name("filename"));
        String dosyaYolu="C:\\Users\\user\\Desktop\\Batch210.txt";
        fileButton.sendKeys(dosyaYolu);
        // Tüm checkbox lari secin
        driver.findElement(By.xpath("//input[@value='cb1']")).click();
        driver.findElement(By.xpath("//input[@value='cb2']")).click();
        driver.findElement(By.xpath("//input[@value='cb3']")).submit();
        // Radio button da radio 1 i secin
        WebElement radioButton=driver.findElement(By.xpath("//input[@value='rd1']"));
        radioButton.submit();
        //  Dropdown menü den 2'yi seçin
        WebElement ddm=driver.findElement(By.name("dropdown"));
        Select menu2Select=new Select(ddm);
        menu2Select.selectByIndex(1);
        // submit'e tıklayın
        driver.findElement(By.xpath("//input[@value='submit']")).click();
        // Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın*/
        String actualUploadFile=driver.findElement(By.id("_valuefilename")).getText();
        Assertions.assertEquals("Batch210.txt",actualUploadFile);
    }

    @Test
    void shoppingKart() {

       // ===========Homework 6==========================
            // https://www.saucedemo.com/ adresine gidin
            driver.get("https://www.saucedemo.com/");
            // Kullanici adini "standard_user" olarak girin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
            // Şifreyi "secret_sauce" olarak girin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
            // Login buttonuna tiklayin
        driver.findElement(By.id("login-button")).click();
            // Tum urunleri sepete ekleyin
        List<WebElement> allProducts= driver.findElements(By.xpath("//button[.='Add to cart']"));
        for (WebElement w:allProducts){
            w.click();
        }

            // Sepete tiklayarak gidin
        WebElement shoppingCart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
            // Checkout a tiklayin
        driver.findElement(By.id("checkout")).click();
            // FirstName-LastName ve posta code unu doldurun
        Faker faker=new Faker();
        driver.findElement(By.id("first-name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last-name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("postal-code")).sendKeys(faker.address().zipCode());
            // continue butonuna tiklayin
        driver.findElement(By.id("continue")).click();
            // Toplam fiyatın 140,34$ olduğunu dogrulayin
        WebElement totalText=driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(totalText);
        Assertions.assertEquals("Total: $140.34",totalText.getText());
            // finish e tiklayin
        driver.findElement(By.id("finish")).click();
            // Checkout: Complete! yazisinin görüntülendigini doğrulayiniz
        Assertions.assertTrue(driver.findElement(By.xpath("//span[.='Checkout: Complete!']")).getText().contains("Checkout: Complete!"));




    }

    @Test
    void name4() {


      //   ===========Homework 7==========================
    //https://demo.guru99.com/test/drag_drop.html adresine gidin
        driver.get("https://demo.guru99.com/test/drag_drop.html");
    // Sayfayi kesfederek turuncu webelementleri uygun kutulara sürükleyin
        Actions actions =new Actions(driver);

        WebElement drag1_5000=driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement dropAmount1=driver.findElement(By.id("amt7"));
        actions.dragAndDrop(drag1_5000,dropAmount1).perform();

        waitForSecond(2);
        WebElement drag2_5000=driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
        WebElement dropAmount2=driver.findElement(By.id("amt8"));
        actions.dragAndDrop(drag2_5000,dropAmount2).perform();

        waitForSecond(2);
        WebElement bank=driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement account1=driver.findElement(By.id("bank"));
        actions.dragAndDrop(bank,account1).perform();

        waitForSecond(2);
        WebElement sales=driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement account2=driver.findElement(By.id("loan"));
        actions.dragAndDrop(sales,account2).perform();

       waitForSecond(2);
        //Perfect! yazisinin görüntülendigini test edin
        WebElement perfectText=driver.findElement(By.xpath("//a[@class='button button-green']"));
        Assertions.assertTrue(perfectText.isDisplayed());



    }
}
