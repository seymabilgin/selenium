package day18_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_WriteExcel extends TestBase {

    @Test
    void test01() throws IOException {

      /*
      Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
      ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
  */
        FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet customer_infoSheet = workbook.getSheet("customer_info");

        customer_infoSheet.getRow(0).createCell(3).setCellValue("Name");
        customer_infoSheet.getRow(1).createCell(3).setCellValue("ayhan");
        customer_infoSheet.getRow(2).createCell(3).setCellValue("beyhan");
        customer_infoSheet.getRow(3).createCell(3).setCellValue("ceyhan");
        customer_infoSheet.getRow(4).createCell(3).setCellValue("ali");
        customer_infoSheet.getRow(5).createCell(3).setCellValue("veli");
        customer_infoSheet.getRow(6).createCell(3).setCellValue("ahmet");
        customer_infoSheet.getRow(7).createCell(3).setCellValue("can");
        customer_infoSheet.getRow(8).createCell(3).setCellValue("sam");
        customer_infoSheet.getRow(9).createCell(3).setCellValue("kate");
        customer_infoSheet.getRow(10).createCell(3).setCellValue("raj");
        customer_infoSheet.getRow(11).createCell(3).setCellValue("pam");

        FileOutputStream fos = new FileOutputStream("src\\test\\java\\resources\\mysmoketestdata.xlsx");
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();

        /*
        ayni senaryo dynamic olarak loop ile yapılacak
         */

    }

    @Test
    void test02() throws IOException {
        FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet customer_infoSheet = workbook.getSheet("customer_info");

        List<String> list = Arrays.asList("Name", "ayhan", "beyhan", "ceyhan", "ali", "veli", "ahmet", "can", "sam", "kate", "raj", "pam");

       //1.yol list.forEach(t -> workbook.getSheet("customer_info").getRow(list.indexOf(t)).createCell(3).setCellValue(t));


        //2.yol
        for (int i=0;i<list.size();i++){

            workbook.getSheet("customer_info").getRow(i).createCell(3).setCellValue(list.get(i));

        }

        FileOutputStream fos = new FileOutputStream("src\\test\\java\\resources\\mysmoketestdata.xlsx");
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();

    }
}
