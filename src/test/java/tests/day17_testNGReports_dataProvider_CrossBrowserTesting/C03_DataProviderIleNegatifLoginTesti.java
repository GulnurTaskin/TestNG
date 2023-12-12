package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProviderIleNegatifLoginTesti {
    @AfterTest
    public void teardown(){
        Driver.closeDriver();
    }


    @DataProvider
    public static Object[][] kullaniciBilgileriDP() { // iki katli bir array donecek burdan

        String[][] kullaniciBilgileri ={{"kullanici1", "12345"},
                {"kullanici2", "23456"}, {"kullanici3", "34567"},
                {"kullanici4", "45678"}, {"kullanici5", "56789"}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciBilgileriDP") // boyle provider yok diyor, olusturalim, ustte
    public void cokluNegatifLoginTesti(String username, String password){
        // parametre olarak yazdigimiz string degerler nerden gelecek?
        // bu bilgiler dataProvider'dan gelecek


        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        // kullanici adi ve sifre olarak verilen listedeki
        // tum degerler icin giris yapilamadigini test edin
        testOtomasyonuPage.emailKutusu.sendKeys(username); // username her seferinde kullanicibilgileri'nden gelecek
        testOtomasyonuPage.passwordKutusu.sendKeys(password); // password de ayni sekilde
        testOtomasyonuPage.loginButonu.click();

        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
        // giris yapilamadigini nasil test ediyoruz?
        // email kutusu hala display ise, ulasilabilir ise giris yapilamamis demektir

        ReusableMethods.bekle(2);

        // kullanici1   12345
        // kullanici2   23456
        // kullanici3   34567
        // kullanici4   45678
        // kullanici5   56789
    }
}
