package day12_actions_faker_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_ActionsClassWork extends TestBase {
    @Test
  public void test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Events yazisina kadar scroll yapalim
        Actions actions = new Actions(driver); // bu tur sayfa kaydırmalarda olcu birimi genelde pixeldir.olcuyu pixel cinsinden ver
        actions.scrollByAmount(0,1000).perform();
        waitForSecond(5);
        actions.scrollByAmount(0,-1000).perform(); // -1000 dersen yukarı cıkar
        waitForSecond(5);

     }

    @Test
    public void test02() {

        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Events yazisina kadar scroll yapalim
        WebElement eventsText=driver.findElement(By.xpath("//h2[.='Events']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,eventsText.getLocation().getY()).perform();
        waitForSecond(5);

        //Events yazısının görünür oldugunu test edin
        Assertions.assertTrue(eventsText.isDisplayed());

    }

    @Test
   public void test03() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Events yazisina kadar scroll yapalim
        WebElement eventsText=driver.findElement(By.xpath("//h2[.='Events']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(eventsText).perform();//bu method bazen calışsada exeption fırlatabiliyor.Kullanımı biraz riskli


    }



}
