package tests.day15_configuration_driver_Kullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_configurationPropertiesKullanimi {

    @Test
    public void aramaTesti(){

        // full dinamik bi test yapacagiz
        // yani bu sayfada hic bir test datasi olmayacak

        // 1. test otomasyonu anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
           // configReader ara eleman gibi dusunebiliriz , arada getir gotur islerini o yapiyor
           // configreader actual url gibi configuration.properties'deki key'lerin value'lerini getirir

        // 2. configuration.properties'de belirlenmis olan aranacak urunu aratin

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        // 3. arama sonucunda urun bulunabildigini test edin

        int bulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanUrunSayisi>0);

        // 4. ilk urune tiklayin

        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // 5. acilan sayfada urun isminin case sensitive olmadan
        //  configuration.properties'de belirlenmis olan aranacak kelimeyi icerdigini test edin

        String actualUrunIsmiKucukHarf = testOtomasyonuPage
                .urunSayfasindakiUrunIsimElementi
                .getText()
                .toLowerCase();
        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}

