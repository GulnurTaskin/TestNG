package tests.day15_configuration_driver_Kullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegatifLoginTesti {

    // 1- https://www.testotomasyonu.com/ anasayfasina gidin
    // 2- login linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin


    @Test(groups = "smoke")
    public void gecersizPasswordTesti(){
    // 1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

    // 2- account linkine basin

    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

    // 3-  3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password

        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

    //4- Login butonuna basarak login olun

        ReusableMethods.bekle(1);
        testOtomasyonuPage.loginButonu.click();

    //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed()); // negatif testimiz..
        // bir onceki class'taki assert ile nerdeyse tamamen ayni formul
        // burda yukardaki satirlarda gecersiz password girdik
        // pasword gecersiz oldugu icin bir sonraki asamaya gecemedi
        // bu durumda email kutusu hala gorunuyor olmasi lazim
        // isDisplayed ile onu sorguladik

        ReusableMethods.bekle(2);
        Driver.closeDriver();
}

// simdi yukardaki ayni testi copy-paste yaparak asagida iki test daha olusturuyoruz
// copy-paste yaptik ama uzerinde ufak degisiklikler yapiyoruz
// bu sekilde testNG'nin bize sagladigi kolayliklari daha iyi gormus oluyoruz
// ihtiyacimiz olan seyler Page'de ve configuration.properties'de
// istedigimiz malzemeler raflarda , raflardan alip lazim olan yerde kullaniyoruz

    @Test(groups = "regression")
    public void gecersizEmailTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        // 3- gecersiz username, gecerli password ==> burda degisiklik var
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- Login butonuna basarak login olun
        ReusableMethods.bekle(1);
        testOtomasyonuPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test(priority = 5)
    public void gecersizEmailGecersizPasswordTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        // 3- gecersiz username, gecersiz password ==> burda degisiklik var
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- Login butonuna basarak login olun
        ReusableMethods.bekle(1);
        testOtomasyonuPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }

}
