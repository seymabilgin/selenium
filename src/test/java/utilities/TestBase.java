package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class TestBase {
 protected ExtentReports extentReports;
  protected ExtentHtmlReporter extentHtmlReporter;
   protected ExtentTest extentTest;

   //ExtentReport


   protected void createExtentReport(String testName) {

       //bu object i raporlari olusturmak ve yonetmek icin kullanacağız
       extentReports = new ExtentReports();

        /*
        oncelikle olusturmak istedigimiz html reportu projemizde nerede saklamak istiyorsak bir
        dosya yolu olusturmaliyiz, cünkü bu pathi kullanarak bir tane html report olusturacağız
        bunun icin ExtentHtmlReporter classindan object olusturmaliyiz

         */
       String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
       String path = "target/extentReport/" + date + "htmlReport.html";
       extentHtmlReporter = new ExtentHtmlReporter(path);

       //ExtentReports a Html raporlayiciyi ekler
       //Bu raporun html formatinda olusmasini saglar
       extentReports.attachReporter(extentHtmlReporter);

       //Html raporun browser sekmesinde title kısmında goruntulenir
       extentHtmlReporter.config().setDocumentTitle("Batch 210 Test");

       //Raporun adini ayarlar, bu raporda goruntulenecek olan genel basliktir
       extentHtmlReporter.config().setReportName("My Extent Report");

       //Raporun sistem bilgi bolumune cesitli istedigimiz bilgileri ekleriz
       extentReports.setSystemInfo("Environment", "QA");
       extentReports.setSystemInfo("Browser", "Chrome");
       extentReports.setSystemInfo("Test Automation Engineer", "Ali");

       //Amazon test adinda yeni bir test olusturur ve bu teste TestSteps aciklamasini ekler
       extentTest = extentReports.createTest(testName, "Test Steps");
       //============= rapor öncesi sablon ayarlamalalir yapmalayiz

   }

    protected WebDriver driver;

  /* public abstract void test();{
 } bunu mantık geçsin diye yaptık. */

//  abstract classı kullanmak istiyorsak o kılasın methodlarını override etmemiz lazım (absrrac kuralı).
//abstarckt kılaslardan obje olusturulamaz.


    @BeforeEach
   public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
   public void tearDown() {
      // driver.quit();
    }
    //Hard wait
    public void waitForSecond(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//DDM den visible text ile secim
public void selectVisibleText(WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
}


public void selectIndex(WebElement ddm, int idx){
    Select select= new Select(ddm);
    select.selectByIndex(idx);

}
    public void SelectByIndexTest(WebElement ddm, int idx) {
        Select select = new Select(ddm);
        select.selectByIndex(idx);

    }

    public void SelectByValueTest(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByValue(option);

    }

    public void SelectByVisibleTextTest (WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

public void printAllTest() {
    List<WebElement> List= driver.findElements(By.id("dropdown"));
    List.forEach(t-> System.out.println(t.getText()));

}

public void sizeTest(int sayı){

    List<WebElement> List= driver.findElements(By.id("dropdown"));
   int size=List.size();
    Assertions.assertTrue(size>=sayı);

}
    //index ile windowa gecis yapma
        public void switchToWindow ( int index){
            driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
        }
    //File Upload Robot Class
    public void uploadFilePath(String dosyaYolu) {
        /*

StringSelection sınıfı, Java'da bir metin dizisini bir Transferable nesnesine dönüştürmek için kullanılan bir sınıftır.
 Bu, genellikle metin verilerini panoya kopyalamak veya yapıştırmak gibi işlemlerde kullanılır.
Bu sınıf, Java'nın "Java AWT" (Abstract Window Toolkit) paketinde bulunan java.awt.datatransfer paketinde yer almaktadır.
Bu sınıfın temel amacı, bir metin dizisini içeren bir StringSelection nesnesi oluşturarak,
bu nesneyi bir transferable nesnesine dönüştürmektir. Ardından, bu transferable nesnesini kullanarak,
metni panoya kopyalama veya panodan yapıştırma işlemlerini gerçekleştirebilirsiniz.
         */
        try {
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }
  //screenshot


    @Test
  public void screenShot() {

        String date= DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu="src\\test\\java\\screenShots\\screenShotOf"+date+".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+dosyaYolu);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //webelement screenshot
    public void screenShotOfWebElement( WebElement webElement){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now());
        String dosyaYolu ="src\\test\\java\\screenShots\\webElementsSS"+date+".png";
        try {
            Files.write(Paths.get(dosyaYolu),webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


  //jsExcetuter click methodu

public void jsClick(WebElement element){

    try {
        element.click();
    }catch (Exception e){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",element);
    }

}



}


