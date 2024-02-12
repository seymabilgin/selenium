package day17_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        //1)Projemizde resources package i altina koydugumuz excel dosyamizin yolunu almaliyiz
        String dosyaYolu ="src\\test\\java\\resources\\Capitals.xlsx";

        //2)FileInputStream bir dosyadan veri okumak icin bir stream (akis) olusturur
        //böylece dosyadan gelen datayi java programimiza aktarmayi saglar
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3) fis objecti uzerinden excel dosyasini yuklemek icin ve bu excel dosyasindaki verilere erismek icin
        //java ortaminda temsilini olusturduk
        Workbook workbook = WorkbookFactory.create(fis);  //excel dosyasını java ortamında açmıs olduk

        //4) Bir excel dosyasinda birden fazla sayfa bulunabilir, olusturdugumuz excel dosyasinda sayfa secmemiz gerekir
        //Sheet1 adli calisma sayfasini actik ve bu verilere erisim sagladik
        Sheet sheet = workbook.getSheet("Sheet1");

        //5)Bir excel sayfasinda birden fazla satir bulunur, belirttigimiz indexteki satiri almak ve bu satirdaki
        //verilere erismek icin kullanilir
        Row row = sheet.getRow(0);//index 0 dan baslar

        //6)Bir satir birden fazla hucre icerir bu kod ile belirttigimiz indexteki cell e erisim saglariz
        Cell cell = row.getCell(0);

        System.out.println(cell);

    }

    @Test
    public void test02() throws IOException {

        //1)Projemizde resources package i altina koydugumuz excel dosyamizin yolunu almaliyiz
        String dosyaYolu ="src\\test\\java\\resources\\Capitals.xlsx";

        //2)FileInputStream bir dosyadan veri okumak icin bir stream (akis) olusturur
        //böylece dosyadan gelen datayi java programimiza aktarmayi saglar
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3) fis objecti uzerinden excel dosyasini yuklemek icin ve bu excel dosyasindaki verilere erismek icin
        //java ortaminda temsilini olusturduk
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));




    }
}
