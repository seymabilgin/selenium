package day16_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ExtentReport {

  /*
    ExtentReport kullanabilmek icin 3 tane classa ihtiyacimiz var
    1) ExtentReports classi ==> raporlamayi baslatmasi icin bir object olustururuz
    2) ExtentHtmlReporter classi==> raporu html formatinda olusturmasi icin bir object olustururuz
    3) ExtentTest classindan test adimlarina bilgi ekleyebilmek icin bir object olustururuz
     */

ExtentReports extentReports;
ExtentHtmlReporter extentHtmlReporter;
ExtentTest extentTest;


    @Test
    void extentHtmlReportTemplate() {

        //bu object i raporlari olusturmak ve yonetmek icin kullanacağız
        extentReports = new ExtentReports();

        /*
        oncelikle olusturmak istedigimiz html reportu projemizde nerede saklamak istiyorsak bir
        dosya yolu olusturmaliyiz, cünkü bu pathi kullanarak bir tane html report olusturacağız
        bunun icin ExtentHtmlReporter classindan object olusturmaliyiz

         */

        String date =DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler
        //Bu raporun html formatinda olusmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporun browser sekmesinde title kısmında goruntulenir
        extentHtmlReporter.config().setDocumentTitle("Batch 210 Test");

        //Raporun adini ayarlar, bu raporda goruntulenecek olan genel basliktir
        extentHtmlReporter.config().setReportName("My Extent Report");

        //Raporun sistem bilgi bolumune cesitli istedigimiz bilgileri ekleriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali");

        //Amazon test adinda yeni bir test olusturur ve bu teste TestSteps aciklamasini ekler
        extentTest=extentReports.createTest("AmazonTest","Test Steps");

        //===========Sablon ayarlamalari burada bitti====================================

        //Testin basarili oldugunu belirtir ve rapora pass notu ekler
        extentTest.pass("PASS");

        //Testle ilgili bilgilendirici not ekler
        extentTest.info("Bilgilendirme Notu");

        //Testin basarisiz oldugunu belirtir ve rapora fail mesaji notu ekler
        extentTest.fail("fail mesaji");

        //Testle ilgil dikkat edilmesi gereken önemli bir konu oldugunu isaret eder
        extentTest.warning("uyari mesaji");

        //Test sirasinda ciddi bir hata mesaji oldugunu belirtir ve rapora bu notu ekler
        extentTest.fatal("ciddi hata mesaji");


        //Tum test verilerini kaydeder ve html rapor olusturulmasini tamamlar
        extentReports.flush(); //tüm testler sonunda bu sekilde kapanıs yapmayı unutmuyoruz



    }
}
