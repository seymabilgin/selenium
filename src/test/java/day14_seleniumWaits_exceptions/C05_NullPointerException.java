package day14_seleniumWaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class C05_NullPointerException {


    /*
    NullPointerException
    Eger bir object olusturulup assignment yapilmadan kullanilmak istenirse bu exceptionu aliriz
     */
    Faker faker;
    WebDriver driver;

    @Test
    public void name() {
        /*
        class seviyesinde bir object olusturup initialize yapmazsak bu objectin degeri null oldugundan kullanmak istedigmizde
        bu hatayi aliriz
         */
        // driver = new ChromeDriver();
        driver.get("https://google.com");
        faker = new Faker();
        System.out.println(faker.name().fullName());
    }

}
