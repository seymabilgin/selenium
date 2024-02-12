package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class practice extends TestBase {
    @Test
    void test01() throws IOException {

        driver.get("https://facebook.com");

      String date=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu="src/test/java/screenShots//facebook"+date+".jpeg";

        TakesScreenshot ts=(TakesScreenshot) driver;
        Files.write(Path.of(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));

    }




}
