package day17_webtables_excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C03_Excel {
    @Test
    public void test01() throws IOException {


        String dosyaYolu ="src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println(cell);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin

        String actualCell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        Assertions.assertEquals("France",actualCell);


        //getPhysicalNumberOfRows() methodu ici dolu olan satirlarin SAYISINI verir
        //SAYI verdigi icin index 0 dan baslamaz 1 den baslar


        //Örnek 3: Kullanılan satır sayısın bulun
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());


        //getLastRowNum()); methodu bir excel sayfasindaki son satirin indexini verir
        //yani eger excel calisma sayfasinda toplam 5 satir varsa bu method 4 degerini verir
        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());



        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}

        Map<String,String> ulkeBaskentleri=new HashMap<>();

        for (int i = 0; i <=workbook.getSheet("Sheet1").getLastRowNum() ; i++) {

            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            System.out.println(country+" / "+capital);

            ulkeBaskentleri.put(country,capital);

        }
        System.out.println(ulkeBaskentleri);










    }
}
