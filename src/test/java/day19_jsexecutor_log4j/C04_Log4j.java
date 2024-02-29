package day19_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class C04_Log4j {
    /*
    1- Log4j kullanabilmek icin oncelikle ilgili dependency leri pom.xml e ekledik
    2- project seviyesinde bir tane resources klasörü olusturup bunu TestResourcesRoot olarak isaretledik ve
    3- log4j2.xml dosyasini bu klasör icinde olusturup configurasyon ayarlarini yapistirdik
     */

    @Test
    public void test01() {

        //LogManager classindan getLogger methodunu kullanarak parantez icinde belirtilen class icin
        // bir logger (loglayici) olusturur

        Logger logger = LogManager.getLogger(C04_Log4j.class);
        logger.info("Amazon web sayfasina gidildi");
        logger.info("arama kutusu locate edildi");
        logger.info("arama kutusunda selenium aratildi");



    }
}
