package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

// dataProvider ile xml'in farki ne?
// xml'de ayni test'i farkli degiskenlerle defalarca yapamayiz
// dataprovider tek test ile verileri dinamik yapabilme
// ve bu sekilde  sonsuz test yapma imkani sunar

public class C02_DataProviderKullanimi extends TestBaseRapor { // testimizi raporlamak icin extends yapiyoruz

    @Test
    public void cokluAramaTesti(){

        /*
            Bugune kadar ogrendigimiz yontemlerle
            birden fazla eleman icin test yapmak istedigimizde
            elemanlari bir array'e atayip
            for loop ile testleri yapmak istedik

            ANCAK, ilk failed olan urunde
            assertion exception firlatip calismayi durdurdu
            geriye kalan urunlerin var olup olmadigini kontrol etmedi
         */


        String[] aranacakUrunler ={"phone","java","dress","nutella","chair","tea"}; // string array
        String arananUrun;
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage(); // page'den elemanlara ihtiyacimiz var
        int actualUrunSayisi ;

        // coklu arma yapacagimiz icin bir for loop isimizi gorur..
        for (int i = 0; i < aranacakUrunler.length ; i++) {

            arananUrun = aranacakUrunler[i];

            // testotomasyonu anasayfaya gidin
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            // verilen urun listesindeki tum urunler icin arama yapip
            // urun listesi : phone, java, dress, nutella, chair, tea
            testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);

            // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin

            actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
            Assert.assertTrue(actualUrunSayisi > 0);

        }
    }


    @DataProvider
    public static Object[][] aranacakUrunlerDataProvider() {
        // data provider bize iki katli obje array'i donduren bir method'dur
        // yukardaki string array'i alip suslu parantezler ile cift katli array haline getirdik
        String[][] aranacakUrunler ={{"phone"},{"java"},{"dress"},{"nutella"},{"chair"},{"tea"}};

        // neden cift katli array?
        // daha fazla data girmesini saglamak icin
        // bir sonraki testte daha fazla data ornegini gorecegiz

        return aranacakUrunler;
    }

    // yukarda yaptigimiz ilk test icinde bir failed olunca diger testleri yapmadan test bitiyor
    // buna cozum olarak test methodunu disardan alalim demisler
    // asagida yeni bir method olusturduk
    // yukardaki string arananUrun'u methodun parametre'si olarak yaziyoruz
    // yukarda for loop icindeki testi kopyalayip asagiya yapistiriyoruz

    @Test(dataProvider = "aranacakUrunlerDataProvider")
    // bunun uzerine geldigimiz zaman bize bir obje olusturmamizi soyluyor,
    // hemen ustte olusturuyoruz, public static Object[][] aranacakUrunlerDataProvider()

    public void dataProviderIleCokluAramaTesti(String arananUrun){
        // burdaki aranan urun nerden gelecek?
        // bunun icin test method'unun yanina dataProvider'i olusturuyoruz
        extentTest = extentReports.createTest("data provider test","Belirlenen urun listesi icin arama yapilabilmeli");

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu anasayfaya gider");

        // verilen urun listesindeki tum urunler icin arama yapip
        // urun listesi : phone, java, dress, nutella, chair, tea
        testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);
        extentTest.info("verilen listesindeki "+arananUrun+" icin arama yapar"); // burda aranUrun'u ekleyerek bu kismi dinamik'lestirdik
        ReusableMethods.bekle(1); // her bir urun aramada 1 saniye bekle diyoruz

        // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin

        int actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualUrunSayisi > 0);
        extentTest.pass(arananUrun +" icin arama yapildiginda sonuc bulunabildigini test eder");
        // extentTest details kismina arananUrun'u yazarak bu kismi dinamik hale getirdik
    }
}