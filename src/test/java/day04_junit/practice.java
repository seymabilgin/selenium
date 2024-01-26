package day04_junit;

import org.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practice {
    // Google Web sitesine gidin
    // Sayfa basliginin Google oldugunu dogrulayin
    // Sayfayi kapatin
    // Google Web sitesine gidin
    // Sayfa url nin https://www.google.com/ oldugunu dogrulayin
    // Sayfayi kapatin

WebDriver driver;
    @BeforeAll
   public static void beforeAll() {
        System.out.println("Tüm kodlar calısmaya basladı");

    }

    @BeforeEach
   public void setUp() {
        driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
   public void test01() {
driver.get("https://www.google.com/");
String actualTitle=driver.getTitle();
String expectedTitle="Google";
Assertions.assertEquals(expectedTitle,actualTitle);

    }
}
