package homeWork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class HomeWork04 extends TestBase {
 /*
 =======homework1================================================0
 http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
            -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
-Çıkan alert'te iptal butonuna basınız
            -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
-Çıkan mesajı konsola yazdırınız
-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
==========Homework 2===========================
//https://the-internet.herokuapp.com/dropdown adresine gidin
//1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
//2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin
//3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
//4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin
//5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin
//6.sizeTest adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin,
            ==========Homework 3===========================
            - ebay sayfasına gidiniz
- electronics bölümüne tıklayınız
- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
- Her sayfanın sayfa başlığını yazdıralım

  */

    @Test
    void test01() {
//homework1
// -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
//  -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
// -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
 String alertText=driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);
        waitForSecond(2);
        driver.switchTo().alert().accept();
// -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.cssSelector("a[href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//-Çıkan alert'te iptal butonuna basınız
waitForSecond(1);
        driver.switchTo().alert().dismiss();
//-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.partialLinkText("Alert with Textbox")).click();
waitForSecond(1);
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
//-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
       driver.switchTo().alert().sendKeys("Seyma");
       waitForSecond(1);
        driver.switchTo().alert().accept();

//-Çıkan mesajı konsola yazdırınız
   String message= driver.findElement(By.cssSelector("#demo1")).getText();
        System.out.println("message = " + message);
// -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assertions.assertEquals("Hello Seyma How are you today",message);
    }

    @Test
    void test02() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown ");

        //1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
        WebElement ddm = driver.findElement(By.id("dropdown"));
        Select select = new Select(ddm);
        SelectByIndexTest(ddm, 1);

        waitForSecond(2);

        //2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin
        SelectByValueTest(ddm, "2");
        waitForSecond(1);
        //3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
        SelectByVisibleTextTest(ddm, "Option 1");
        waitForSecond(1);
        //4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin

        List<WebElement> List = driver.findElements(By.id("dropdown"));
        for (WebElement w : List) {
            if (w.equals("Option 2")) {

                Assertions.assertTrue(w.getText().contains("Option 2"));
            }

        }
//5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin

        String defaultText = driver.findElement(By.xpath("//*[.='Please select an option']")).getText();
        Assertions.assertTrue(defaultText.contains("Please select an option"));

//6.sizeTest adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin,

        int actualSize = select.getOptions().size();
        int expectedSize = 3;
        Assertions.assertEquals(expectedSize, actualSize);


    }

    @Test
   public void test03() {
      /*  - ebay sayfasına gidiniz
        - electronics bölümüne tıklayınız
        - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        - Her sayfanın sayfa başlığını yazdıralım    */


 //  - ebay sayfasına gidiniz
    driver.get("https://ebay.com");
//- electronics bölümüne tıklayınız
        WebElement elektronics = driver.findElement(By.linkText("Electronics"));
        elektronics.click();



//- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
//- Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (WebElement w : images) {
            waitForSecond(1);
            w.click();
            waitForSecond(2);
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }



    }
}
