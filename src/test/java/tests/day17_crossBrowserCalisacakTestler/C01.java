package tests.day17_crosBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

// cross browser ne demek?
// bir testin farkli farli browser'lar ile calistirilmasidir
// testlerin tum farkli browserlarda calismasi lazim
// configuration.properties'de varsayilan browser'a farkli browser'lar atayarak yapabiliriz
// ama crossBrowser bu degildir, bundan farkli bisey
// mesela 1000'lerce testimiz var, bunlari hergun calistirmayiz
// ama smoke testleri hergun calistiririz. can alici noktalar oldugu icin
// bu sekilde ozellikle farkli browser'larda calsimasini istedigimiz noktalari,
// crossBrowser ile test ederiz
// biz toplu calistirmayi xml'den yapiyoruz
// bunun icin xml'e gidip crosBrowserCalisacakTestler olusturuyoruz

public class C01 extends TestBaseCross {

    @Test
    public void aramaTesti(){


        driver.get(ConfigReader.getProperty("toUrl"));
        // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        /*

        configReader'e diyoruz ki bize toUrl'i getir
        ben boyle dersem, gonderdigim parametre'nin bir anlami var mi?
        buraya disardan bir parametre geldi..
        once xml'i olusturduk, xml'de bir parametre olusturduk, adi crossBrowser
        value'leri de chrome ve firefox
        bu bizim test methodumuza geldi ( day17'deki testler)
        burda driver'i getirme icin Driver class'a gidiyor
        Ordan da configuration.properties'e
        config'deki browser ne? chrome.. ama bize firefox da lazim
        bu sekilde xml'de crossBrowserCalisacakTestler'e yazdigimiz parametrelerin hic bi anlami kalmaz
        turkcesi bu Driver'i kullanmayacagiz yani
        bize yeni bir driver methodu lazim
        bu durumda utilities'e yenibir class olusturuyoruz
        TestBaseCross..
        ve daha sonra TestBaseCross'u bu class'a, extends ile bagliyoruz

        */

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//div[@class= 'product-box my-2  py-1']"));

        int actualSonucSayisi  = bulunanUrunElementleriList.size();

        Assert.assertTrue(actualSonucSayisi > 0);


    }
}