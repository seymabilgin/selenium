package day13_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {

    @Test
  public  void filesExistsTest() {

        //  System.getProperty("user.dir") kodu java da programın şuanda çalıştığı dizini
//yani (current working directory) yi string olarak return eder
        System.out.println(System.getProperty("user.dir"));//C:\Users\\user\IdeaProjects\B210SeleniumJunitDT
/*
System.getProperty("user.home") methodu ile bilgisayarımızın bize özgü olan ana yolunu
dynamic olarak alabilir ve projedeki herkes için ortak olan yol ile concatenation yaparak dosya yolunu tum
kullanıcılar için dynamic bir forma donusturebiliriz.
 */

        System.out.println(System.getProperty("user.home"));//C:\Users\\user
/*
Bilgisayarımızdaki herhangi bir dosyanın varlıgını test edebilmek için;
1- Öncelikle varlıgını test etmek istediğimiz dosyanın yolunu almalıyız
2- Aldığımız dosya yolunu Files.exists () methodunu kullanarak test edebiliriz.
 */


        //Bilgisayarımızdaki herhangi bir dosyanın varlıgını test edelim

        //C:\Users\\user        \Desktop\Batch210.txt


        /*Files.exists(Paths.get(dynamicPath)) methodunu kullanarak belirtilen path objesinin
        dosya sisteminde var olup olmadıgını test ettik */

       String ortakYol="\\Desktop\\Batch210.txt";
    String dynamicPath=System.getProperty("user.home")+ortakYol;
    Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));


    }
}
