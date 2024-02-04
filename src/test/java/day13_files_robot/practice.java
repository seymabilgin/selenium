package day13_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class practice extends TestBase {

    @Test
    void filesExistTest() {
        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitForSecond(5);
        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        //"C:\Users\\user\Downloads\b10 all test cases, code (6).docx"
        String ortakDosyaYolu="\\Downloads\\b10 all test cases, code (6).docx";
       String dynamicPath=System.getProperty("user.home")+ortakDosyaYolu;
       Assertions.assertTrue(Files.exists(Path.of(dynamicPath)));






    }
}
