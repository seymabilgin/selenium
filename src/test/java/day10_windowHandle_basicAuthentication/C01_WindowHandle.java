package day10_windowHandle_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandle extends TestBase {
    /*
    Eger bir sayfaya gittikten sonra yeni sekme yada yeni bir pencere acmak istersek bunun icin     driver.switchTo().newWindow()
    methodu kullanmaliyiz, bu method sizden method parantezi icinde yeni acilacak olan sayfanin bir sekmemi yoksa bir yeni pencere mi oldugunu belirtmenizi ister
    bunu su sekilde yapabiliriz

    1- driver.switchTo().newWindow(WindowType.WINDOW) ==> yeni bir pencere acar ve driveri buraya gecis yaptirir
    2- driver.switchTo().newWindow(WindowType.TAB) ==> yeni bir sekme acar ve driveri buraya gecis yaptirir

    eger handle degeri ile bir sayafaya gecis yapmak istersek bu defa da driver.switchTo().window() methodunu kullaniriz ve parantez icinde
    gecis yapmak istedigimiz sayfanin handle degerini belirtiriz
     */
    @Test
    public void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        waitForSecond(2);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);//=>yeni bir pencere actik ve driver buraya gecis yapar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        waitForSecond(2);
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        waitForSecond(2);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        waitForSecond(5);
    }

    @Test
    public void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        waitForSecond(2);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//=>yeni bir pencere actik ve driver buraya gecis yapar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        waitForSecond(2);
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        waitForSecond(2);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        waitForSecond(5);
    }

    @Test
    public void test03() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");


        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        waitForSecond(2);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//=>yeni bir pencere actik ve driver buraya gecis yapar
        driver.get("https://www.youtube.com");


        waitForSecond(2);
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        waitForSecond(2);


        List<String> windowHandles = new ArrayList<>(  driver.getWindowHandles() );
        /*
        Acilmis olan tum pencerelerin window handle degerlerini getWindowHandles methodu ile aldik,
        Bu method bir set return eder, ancak set lerde index kullanarak istedigimiz bir elemani secmek mumkun degildir
        Bu nedenle bizde bu seti kullanarak bir tane list olusturduk
        List lerde get() methodu sayesinde index kullanrak istedigmiz penecereye rahatlikla gecis yapabiliriz
         */


        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(windowHandles.get(0));
        waitForSecond(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(windowHandles.get(1));
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(windowHandles.get(2));
        waitForSecond(5);
    }



    @Test
    public void test04() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        waitForSecond(2);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//=>yeni bir pencere actik ve driver buraya gecis yapar
        driver.get("https://www.youtube.com");

        waitForSecond(2);
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        waitForSecond(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        waitForSecond(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        waitForSecond(5);
    }
}
