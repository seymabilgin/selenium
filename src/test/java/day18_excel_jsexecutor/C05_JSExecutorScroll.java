package day18_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_JSExecutorScroll extends TestBase {
    @Test
    void test01() {
        Actions actions= new Actions(driver);
        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");
        //Challenges a kadar scroll yapiniz
        WebElement challenges=driver.findElement(By.xpath("/h2[.='Challenges']"));

        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",challenges);
        //true yazarsan ekranın üst kısmında false yaparsan ekranın alt kısmında element gözükür scroll yaptıgında.




    }
}
