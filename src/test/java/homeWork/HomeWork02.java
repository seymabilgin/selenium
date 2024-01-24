package homeWork;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork02 {
      /*2
            homework
       https://www.google.com/ adresine gidin
       cookies uyarisi cikarsa kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Selenium” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */
      WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Testler başladı..");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //https://www.google.com/ adresine gidin
        driver.get("https://google.com");
        Thread.sleep(5000);
        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        Assertions.assertTrue(driver.getTitle().contains("Google"));
        //Arama cubuguna “Selenium” yazip aratin
        WebElement searcBox = driver.findElement(By.xpath("//div/textarea[@id='APjFqb']"));
        searcBox.sendKeys("Selenium", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement ResultStats = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String bulunanSonuclar =ResultStats.getText();
        System.out.println("Bulunan Sonuçlar = " + bulunanSonuclar);
        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin Yaklaşık 208.000.000 sonuç bulundu (0,26 saniye)
        String sonucSayisiString = bulunanSonuclar.split(" ")[1].replace(".","");
        int sonucSayisiInt = Integer.parseInt(sonucSayisiString);
        Assertions.assertTrue(sonucSayisiInt>10000000);

    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Testler tamamlandı..");
    }



}
