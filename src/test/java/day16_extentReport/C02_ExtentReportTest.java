package day16_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ExtentReportTest extends TestBase {

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    void extentReportTest() {

        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        extentReports.attachReporter(extentHtmlReporter);

        extentHtmlReporter.config().setDocumentTitle("Batch 210 Test");

        extentHtmlReporter.config().setReportName("My Extent Report");

        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali");


        extentTest=extentReports.createTest("TechProEducation","Test Steps");
        //============= rapor öncesi sablon ayarlamalalir yapmalayiz


        //TechproEducation sayfasina gidelim
        driver.get("https://techproeducation.com/");
        extentTest.info("Kullanici TechproEducation sayfasina gider");


        //TechproEducation ana sayfada oldugunuzu dogrulayin
        Assertions.assertEquals("https://techproeducation.com/",driver.getCurrentUrl());
        extentTest.info("Kullanici ana sayfada oldugunu dogrular");
        extentTest.pass("Ana sayfa url testi basarili");


        //Ana Sayfada sosyal medya iconlarinin goruntulendigini dogrulayin
        WebElement icons = driver.findElement(By.xpath("//*[@class='toolbar-sl-share']"));
        Assertions.assertTrue(icons.isDisplayed());
        extentTest.pass("Kullanici ana sayfadaki sosyal medya ikonlarinin goruntulendigini dogrular");

        extentReports.flush();


    }
}
