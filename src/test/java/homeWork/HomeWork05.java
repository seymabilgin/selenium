package homeWork;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class HomeWork05 extends TestBase {
    @Test
   public void homework() {
       /* ÖDEV:
        //google sayfasına gidelim
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        */

        //google sayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement searchBox= driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Selenium", Keys.ENTER);
        waitForSecond(2);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        Actions actions = new Actions(driver);
        searchBox= driver.findElement(By.id("APjFqb")); //Bu kod, arama kutusunu tekrar bulur.
        actions.doubleClick(searchBox).keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();
        waitForSecond(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        waitForSecond(2);
        searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(Keys.CONTROL + "v", Keys.ENTER);
        waitForSecond(2);

   /*
   searchBox= driver.findElement(By.id("APjFqb")); kodunu iki kere kullanmamızın sebebi,
    her seferinde farklı bir işlem için arama kutusunu bulmamız gerektiğidir.
    Birinci kullanımda arama kutusuna metin yazmak için, ikinci kullanımda ise kestiğimiz kelimeyi yapıştırmak için kullanıyoruz.
    */

    }
    @Test
    public void homework02() {
        //HomeWork
        //1. "https://facebook.com" Adresine gidin
        //2. "create new account" butonuna basin
        //3. "firstName" giris kutusuna bir isim yazin
        //4. "surname" giris kutusuna bir soyisim yazin
        //5. "email" giris kutusuna bir email yazin
        //6. "email" onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test
        //edin.
        //13. Sayfayi kapatin


        Faker faker= new Faker();

        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. "create new account" butonuna basin
        waitForSecond(2);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        waitForSecond(3);
        //3. "firstName" giris kutusuna bir isim yazin
          driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
          waitForSecond(2);
        //4. "surname" giris kutusuna bir soyisim yazin
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        waitForSecond(2);
        //5. "email" giris kutusuna bir email yazin
       WebElement emailAdress= driver.findElement(By.name("reg_email__"));
        String fakeEmailAdress=faker.internet().emailAddress();
        emailAdress.sendKeys(fakeEmailAdress);
        waitForSecond(2);
        //6. "email" onay kutusuna emaili tekrar yazin
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(fakeEmailAdress);
        //7. Bir sifre girin
        driver.findElement(By.id("password_step_input")).sendKeys(faker.internet().password(8,12,true,true));
        waitForSecond(2);
        //8. Tarih icin gun secin
        WebElement day =driver.findElement(By.cssSelector("#day"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(15);
        waitForSecond(2);
        //9. Tarih icin ay secin
        WebElement month =driver.findElement(By.cssSelector("#month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("3");
        waitForSecond(2);
        //10. Tarih icin yil secin
        WebElement year =driver.findElement(By.cssSelector("#year"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2020");
        waitForSecond(2);
        //11. Cinsiyeti secin
        WebElement cinsiyetKadın=driver.findElement(By.xpath("//input[@value='1']"));
        cinsiyetKadın.click();
        WebElement cinsiyetErkek=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement cinsiyetOzel=driver.findElement(By.xpath("//input[@value='-1']"));
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin
        Assertions.assertTrue(cinsiyetKadın.isSelected());
        Assertions.assertFalse(cinsiyetErkek.isSelected());
        Assertions.assertFalse(cinsiyetOzel.isSelected());

        //13. Sayfayi kapatin
        //Test Base den kapatıyor
    }
}
