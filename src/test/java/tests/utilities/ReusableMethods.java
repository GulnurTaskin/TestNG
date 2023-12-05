package tests.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){

        // yaptigimiz testten buraya bir list gonderecegiz
        // bu list webelement'lerden olusacak
        // o da bana string'lerden olusan bir list gonderecek
        // bu method bir list dondurecegi icin return type'i List yapiyoruz.
        // <> icine de String yaziyoruz, stringlerden olusacagi icin
        // bu yeni listenin ismini de stringListeDonustur koyduk.
        // peki bu yeni liste nerden beslenecek?
        // WebElement'lerden olusan elementlerListesi'nden..


        List<String> stringlerListesi = new ArrayList<>();
        // bir ArrayList olusturyoruz
        // buraya for each kullanarak eleman ekleyecegiz

        // each elementlerListesinden elementleri tek tek ele alacak
        for (WebElement each : elementlerListesi
        ) {
            stringlerListesi.add(each.getText()); // sonra each'in getirdigi element'in uzerindeki yaziyi bu method'la alacagiz
        }


        // for loop bitince return diyoruz
        // striglerListesi'ni geri dondurmesi icin

        return stringlerListesi;


    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver titleIleSayfaDegistir(WebDriver driver, String hedefSayfaTitle){



       Set<String> tumWhdSeti = driver.getWindowHandles();

       // burda bir for each loop olusturuyoruz,
       // each ile tumWhdSetindeki handle degerlerini ele aliyoruz
       // sonra eger diyoruz, ele aldigimiz her bir eachTitle, hedef sayfa title'a esitse
       // driver'i bu sayfaya return ile donduruyoruz
       for (String each: tumWhdSeti
       ) {
         String eachTitle = driver.switchTo().window(each).getTitle();
         if (eachTitle.equals(hedefSayfaTitle)){
             return driver;
         }

       }
        return driver;
    }

    public static String IlkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String> tumWhdSeti = driver.getWindowHandles();
        tumWhdSeti.remove(ilkSayfaWhd);
        for (String each:tumWhdSeti
        ){
            return each;
        }

            return null; // bu satirin hic calismayacagini biliyoruz ama
                         // bu return'u eklemeyince intellij uyari veriyor
                         // o yuzden..
                         // javanin gonlu olsun diye bu return'u ekliyoruz ;)
    }


    public static void tumSayfaTakeScreenshot(WebDriver driver) {

        // tum sayfanin fotografini cekip kaydedin, bunu 4 adimda yapiyoruz..

        // 1.adim tss objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver; // driver'a fotografci sapkasi takiyoruz :)

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim

        File tumSayfaScreenshot = new File("target/screenshots/tumSayfaScreenshot.jpg"); // fotonun adini koyuyoruz

        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE); // fotoyu cektik, kameranin dosyasinda su an, oyle dusunelim

        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot); // simdi basta olusturdugumuz dosya yoluna ,
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // yani asil kayit etmek istedigimiz yere fotyu kaydediyoruz..

        ReusableMethods.bekle(5);
    }

    public static void tumSayfaTakeScreenshot(String testAdi,WebDriver driver){

        // tum sayfanin fotografini cekip kaydedin

        // 1.adim tss objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver; // driver'i fotografci yapiyoruz

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
          // her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
          // kaydedilecek dosya yolunu dinamik yapabiliriz
          // dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim

        LocalDateTime localDateTime = LocalDateTime.now(); // lokal saat objesi olusturuyoruz
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss"); // saat'e format veriyoruz

          // ss'leri ayri ayri kaydedecegimiz dinamik dosya yolunu su sekilde olusturuyoruz
        String dinamikDosyaYolu = "target/screenshots/"+ // ilk kisim standart
                testAdi // method'dan geliyor
                +
                localDateTime.format(istenenFormat)+ // tarih
                ".jpg"; // fotograf icin uygun gordugumuz foto uzantisi

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);
    }
}