package day04_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C04_Assertions {

    /*
       Junit 5 te assertion yapmak icin Assertions classi kullanilir
       Junit 4 te assertion yapmak icin Assert classi kullanilir
        */
    //Assertions.assertEquals(expectedData,actualData);
    //parantez icinde belirtilen iki deger esit ise test basarili olur degilse basarisiz olur

    @Test
    public void test01() {
        String expectedData="selenium";
        String actualData="selenium";
        Assertions.assertEquals(expectedData,actualData);
    }

    // Assertions.assertTrue
    //parantez icinde belirtilen kosul eger true ise basarili olur degilse basarisiz olur
    @Test
    public void test02() {
        Assertions.assertTrue("junit".contains("u"));
    }

    // Assertions.assertFalse
    //parantez icinde belirtilen kosul eger FALSE ise basarili olur degilse basarisiz olur
    @Test
    public void test03() {
        Assertions.assertFalse(13<5);
    }

    //Assertions.assertNotEquals
    //parantez icinde belirtilen iki deger esit degil ise test basarili olur esit ise basarisiz olur
    @Test
    public void test04() {
        Assertions.assertNotEquals("junit","testng");//Test Pass
        Assertions.assertNotEquals("junit","junit");//Test Fail
    }

    // Assertions.assertArrayEquals
    // Parantez icinde belirtilen iki array esit ise test basarili olur degilse basarisiz olur
    // Not: iki array in esit olabilmesi icin ayni index te ayni eleman olmalidir
    @Test
    public void test05() {
        char [] expectedArray ={'j','u','n','i','t'};
        char [] actualArray ={'j','u','i','n','t'};
        Assertions.assertArrayEquals(expectedArray,actualArray);
    }

    //Assertions.assertNull(str);
    //parantez icinde belirtilen deger null ise test basarili olur degilse basarisiz olur
    @Test
    public void test06() {
        String str =null;
        Assertions.assertNull(str);
    }

    //Assertions.assertNotNull(str);
    //parantez icinde belirtilen deger null degilse test basarili olur null ise basarisiz olur
    @Test
    public void test07() {
        String str ="junit";
        Assertions.assertNotNull(str);
    }

}
