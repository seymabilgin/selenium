package day14_seleniumWaits_exceptions;

public class ExplicitWait_WebDriverWait_FluentWait {
/*
    WebDriverWait ve FluentWait, Selenium WebDriver ile yapılan otomasyon testlerinde kullanılan iki farklı bekleme
     (wait) türüdür.
     Her ikisi de sayfanın yüklenmesini veya belirli bir durumun gerçekleşmesini beklemek için kullanılır,
     ancak aralarında bazı önemli farklar vardır.

    Wait Türleri:
     WebDriverWait: Sabit bir süre boyunca belirli bir durumu bekler. Yani, belirli bir elementin görünür olmasını,
     tıklanabilir olmasını vb. belirli bir süre içinde kontrol eder.

    FluentWait: WebDriverWait'e benzer, ancak daha esnek bir yapı sunar. Belirli bir durumu beklerken, belirli bir
    aralıkta ve belirli bir frekansta kontrol edilmesine olanak tanır.

    Esneklik:

    WebDriverWait: Sabit bir süre boyunca belirli bir durumu kontrol eder. Eğer beklenen durum belirtilen süre içinde
    gerçekleşmezse, bir TimeoutException hatası fırlatılır.


    FluentWait: Belirli bir durumu kontrol ederken esnek bir yapı sağlar. Belirli bir durumu beklerken, belirli bir
    aralık ve frekansta kontrol ederek belirli bir zaman diliminde gerçekleşmesine izin verir.

    Bekleme Stratejisi:

    WebDriverWait: Belirli bir durumu beklerken, belirli bir süre boyunca belirli bir aralık ve frekansta kontrol eder.
    FluentWait: Bekleme stratejisinin daha esnek bir yapıda olmasına izin verir. Belirli bir durumu kontrol ederken,
    belirli bir aralık ve frekansta kontrol etmek için ayrı ayrı tanımlanmış objeler kullanabilirsiniz.

   Performans:

   WebDriverWait: Daha az esnek olmasına rağmen, genellikle FluentWait'ten daha hızlıdır.
   FluentWait: Daha fazla esneklik sunar, ancak bu da performansı biraz etkileyebilir.


   Genel Tavsiyeler:

  WebDriverWait: Web elementleri ile basit bekleme işlemleri için idealdir.
  FluentWait: Daha karmaşık bekleme işlemleri veya web elementleri dışındaki nesnelerle bekleme işlemleri için idealdir.


    İki bekleme türü de sayfa yüklenmeleri, elementlerin görünürlüğü, tıklanabilirliği gibi durumları kontrol etmek için
    kullanışlıdır. Seçim, projenin ihtiyaçlarına, kullanım durumuna ve geliştiricinin tercihlerine bağlı olarak değişebilir.
    FluentWait daha esnek bir yapıya sahip olduğu için bazı durumlarda tercih edilebilir, ancak kullanım örneğinize ve
    gereksinimlerinize bağlı olarak WebDriverWait de uygun olabilir.
*/

}
