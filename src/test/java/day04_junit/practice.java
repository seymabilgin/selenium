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
    static void beforeAll() {
        System.out.println("@BeforeAll: tüm kodlar calismaya basladi");
    }

    @BeforeEach
    void setUp() {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


}
