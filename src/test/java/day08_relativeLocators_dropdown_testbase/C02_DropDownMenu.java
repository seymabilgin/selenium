package day08_relativeLocators_dropdown_testbase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropDownMenu {
 /*
        DropDown Menuyu automate etmek icin
        1- DropDown weblementini locate etmeliyiz
        2- Select Objecti olusturulur
        3- Select objecti üzerinden cesitli methodlar kullanarak dropdown seceneklerine erisim saglariz

        SYNTAX
                Select select = new Select(DDM Weblementi);
                a) selectByVisibleText() -> DD Menu deki gorunur metin ile secmek icin kullanilir
                b) selectByIndex() -> index ile secmek icin kullanilir (index sifir dan baslar)
                c) selectByValue() -> value attribute degeri ile secmek icin kullanilir (option tag i ile baslar)
                d) getOptions() -> Locatini aldigimiz DD Menudeki tum secenekleri bize verir
                e) getFirstSelectedOption() -> DropDown menudeki secili olan secenegi bize verir
     */

  /*
   Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
   -3 farklı test methodu oluşturalım
       1.Method:
           a. Yil,ay,gün dropdown menu'leri locate ediniz
           b. Select objesi olustur
           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       2.Method:
           a. Tüm eyalet isimlerini yazdıralım
       3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

    */
  WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() throws InterruptedException {
        // 1.Method:
        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        //           b. Select objesi olustur
        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        //           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        selectYear.selectByIndex(0);// index 0 dan basladigi icin birinci elementi secmis olduk
        Thread.sleep(3000);
        selectMonth.selectByValue("4");//<option value="4">May</option> daki value degerine göre secer
        Thread.sleep(3000);
        selectDay.selectByVisibleText("15");//-> ekranda gorulen degere gore secilir


    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //  driver.quit();
    }


}