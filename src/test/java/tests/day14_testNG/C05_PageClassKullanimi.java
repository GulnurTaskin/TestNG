package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_PageClassKullanimi {
    @Test
    public void aramaTesti() {

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(3);

        // phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(3);

        // bulunan sonuc sayisinin 1'den cok oldugunu test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size() > 1);

        // arama sonuc sayisini yazdirin
        System.out.println(testOtomasyonuPage.sonucYaziElementi.getText());
        // sayfayi kapatin
        Driver.closeDriver();

        // page sayfalarini kullanmak icin her seferinde her seferinde bir obje olusturuyoruz
        // TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        // peki obje olusturmak icin constractor calisiyor mu? TestOtomasyonuPage(); ==> evet
        // o zaman biz bu driver tanitma isini constractor'un icine koyalim
        // simdi direction ==>TestOtomasyonuPage
    }
}