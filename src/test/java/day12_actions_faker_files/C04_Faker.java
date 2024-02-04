package day12_actions_faker_files;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.util.Locale;

public class C04_Faker  {
    @Test
   public void test01() {

        Faker faker = new Faker();

        //faker objesi ile fake bir isim yazdırınız
        String firstName= faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println("fullAddress =" + faker.address().fullAddress());

        //faker objesi ile fake bir telefon No yazdırınız
        System.out.println("phoneNumber = " + faker.phoneNumber().phoneNumber());

        //faker objesi ile fake bir email yazdırınız
        System.out.println("emailAddress = " + faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        System.out.println(" number " + faker.number().digits(15));

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println("fullName" + faker.name().fullName());

    }

    @Test
   public void test02() {


        /*
        Eger belli bir bolgeye ozel fake datalar olusturmak istersek Faker constructor parantezi icinde Locale object i ile beliritmemiz yeterli
         */

        Faker faker = new Faker(new Locale("ENG"));

        //faker objesi ile fake bir isim yazdırınız
        String firstName= faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println("fullAddress =" + faker.address().fullAddress());



    }

    //HomeWork
    //1. "https://facebook.com" Adresine gidin
    //2. "create new account" butonuna basin
    //3. "firstName" giris kutusuna bir isim yazin
    //4. "surname" giris kutusuna bir soyisim yazin
    //5. "email" giris kutusuna bir email yazin
    //6. "email" onay kutusuna emaili tekrar yazin
    //7. Bir sifre girin
    //8. Tarih icin gun secin
    //9. Tarih icin ay secin
    //10. Tarih icin yil secin
    //11. Cinsiyeti secin
    //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test
    //edin.
    //13. Sayfayi kapatin


}
