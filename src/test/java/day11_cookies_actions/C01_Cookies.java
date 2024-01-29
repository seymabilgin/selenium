package day11_cookies_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
  /*
    cookie denildiginde aklimiza manage() methodu gelmelidir,
    cookie ler ile ilgili tum islemleri bu method sayesinde yapabiliriz
     */

    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        driver.findElement(By.partialLinkText("Try different image")).click();//capthe cıkarsa bununla aş
        //2-tum cookie'leri consolda bir loop ile yazdirin
       Set<Cookie> cookieSet= driver.manage().getCookies();
        System.out.println("cookieSet = " + cookieSet);
        int counter=1;
        for (Cookie w: cookieSet){
            System.out.println(counter+"  .cookie ==> "+ w);
            System.out.println(counter+"  .cookie Name ==> "+ w.getName());
            System.out.println(counter+"  .cookie Value ==> "+ w.getValue());

        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualSize=cookieSet.size();
        Assertions.assertTrue(actualSize>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
      String actualCookieValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
      Assertions.assertEquals("USD",actualCookieValue,"value uyumlu değil");//fail olursa konsolda message kısmını görürüz


        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie'nin sayfaya eklendigini test
    cookieSet=driver.manage().getCookies();
    Assertions.assertTrue(cookieSet.contains(cookie));

        int counter2=1;
        for (Cookie w: cookieSet){
            System.out.println(counter2+"  .cookie ==> "+ w);
            System.out.println(counter2+"  .cookie Name ==> "+ w.getName());
            System.out.println(counter2+"  .cookie Value ==> "+ w.getValue());

        }
        Assertions.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assertions.assertNull(driver.manage().getCookieNamed("skin"));

        //2.yol
//        cookieSet=driver.manage().getCookies();
//        Assertions.assertFalse(cookieSet.contains(driver.manage().getCookieNamed("skin")));

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();//->cookieSet i güncellemeliyiz, cunku mevcut sepet uzerinden assertion yapiyoruz
        Assertions.assertTrue(cookieSet.isEmpty());


    }



}
