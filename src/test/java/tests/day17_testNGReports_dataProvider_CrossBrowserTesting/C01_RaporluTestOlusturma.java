package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertTrue;

// oncelikle testtimizi testNG'de normal olarak yaziyoruz
// raporlamak icin, test class'imizi extends ile TestBaseRapor'a bagliyoruz
// TestBaseRapor'daki objeler buraya gelecek, orada 3 tane obje olusturmuqtuk
// extentReports, extentHTMLReporter ve extentTest objeleri
// ikiisne deger atamistik, burda da extentTest'e deger atamasi yapacagiz

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){
        extentTest = extentReports.createTest("Arama testi","Kullanici belirlenen kelimeyi aratip, dogru arama yapildigini test eder");

        // testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu ana sayfaya gider");
                        // bu sekilde istedigimiz yere aciklama ekliyoruz

        // belirlenen arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");
                   // bilgilendirmelerde info yapiyoruz

        // arama sonucunda urun bulunabildigini test edin
        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        assertTrue(aramaSonucSayisi > 0);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");
                   // assertion'larda pass yapiyoruz
        ReusableMethods.bekle(1);

        // ilk urunu tiklayin

        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk urunu tiklar");
        // acilan urun sayfasinda urun isminin
        // case sensitive olmadan belirlenen arama kelimesi icerdigini test edin

        String actualUrunIsmiKucukHarf = testOtomasyonuPage
                .urunSayfasindakiUrunIsimElementi
                .getText()
                .toLowerCase();
        assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));

        extentTest.pass("acilan urun sayfasinda urun isminin\ncase sensitive olmadan belirlenen arama kelimesi icerdigini test eder");

        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");

        // test'i run edince raporumuz test-output'da raporlanir
        // testte failed oldugu yerlerde screenshot alir ve test-output'un altinda dosyalar
    }
}