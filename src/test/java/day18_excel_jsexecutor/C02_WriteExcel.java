package day18_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel extends TestBase {
    @Test
    void test01() throws IOException {
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz


        String dosyaYolu ="src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

       Sheet customer_infoSheet= workbook.getSheet("customer_info");
       //Hangi satirda yazma islemi yapacaksak bunu belirtmemiz gerekir
       Row firstRow=customer_infoSheet.getRow(0);
       //ucuncu cell(sütun Baslıgı) olusturduk
       Cell cell3= firstRow.createCell(2);

       //ucuncu cell e status baslıgı atadık
       cell3.setCellValue("STATUS");

       customer_infoSheet.getRow(1).createCell(2).setCellValue("valid");
        customer_infoSheet.getRow(2).createCell(2).setCellValue("valid");
        customer_infoSheet.getRow(3).createCell(2).setCellValue("invalid");

        //Classımızdan belittigimiz path de bulunan dokumana aktarilmak uzere bir akis objecti olusturur
        String path ="src\\test\\java\\resources\\mysmoketestdata.xlsx";
        FileOutputStream fos = new FileOutputStream(path);


        //workbook a akis objecti uzerinden yazar
        workbook.write(fos);

        //kapanıslar
        workbook.close();
        fis.close();
        fos.close();



    }


}
