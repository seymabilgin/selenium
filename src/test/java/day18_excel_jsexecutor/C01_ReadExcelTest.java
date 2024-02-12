package day18_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcelTest extends TestBase {

    @Test
    void test01() throws IOException {

        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");
        //Login butonuna basalım
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm']")).click();
        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        String dosyaYolu ="src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String userEmail=workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String userPassword=workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement emailWebelement = driver.findElement(By.cssSelector("#formBasicEmail"));
        WebElement passwordWebelement = driver.findElement(By.cssSelector("#formBasicPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));

        emailWebelement.sendKeys(userEmail);
        passwordWebelement.sendKeys(userPassword);
        loginButton.click();

        //Login olduğumuzu doğrulayalım
      WebElement login=driver.findElement(By.cssSelector("#dropdown-basic-button"));
        Assertions.assertEquals("ayhan can",login.getText());


    }
}
