package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssertion {
    /*
    Bir test gorevinde
    verify deniyorsa ==> soft assert
    test edin deniyorsa ==> hard assert kullanilmasi tavsiye edilir
    ama tercih yine bize kalmis..

    ==>Asagidaki gorevlerde 'dogrulayin' cogunlukta oldugu icin biz soft assertion'u kullanacagiz
    hatalarin nerde oldugunu anlamak icin assertion parantezinin icine mesaj yazacagiz
    Failed oldugunda bize o mesajlar donecek
    */

    @Test
    public void softAssertionTesti(){

// 1. “http://zero.webappsecurity.com/” Adresine gidin ==>configuration.properties

        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

// 2. webbappsecurity ana sayafaya gittiginizi dogrulayin

        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        // !! burda "zeroUrl" kullanamayiz. o direk sayfaya gitmek icin. burda ise String url lazim bize..
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Anasayfada degiliz");

// 3. Sign in butonuna basin ==>ZeroPage'den singInLinki

        ZeroPage zeroPage = new ZeroPage();
        zeroPage.signInLinki.click();

// 4. Login kutusuna “username” yazin ==> ZeroPage'den usernameKutusu

        zeroPage.usernameKutusu.sendKeys("username");
        // eger username'i surekli kullanacaksak configuration.properties'de bir kisayol olusturabiliriz
        // bir defa kullanacaksak gerek yok

// 5. Password kutusuna “password” yazin ==> ZeroPage'den passwordKutusu

        zeroPage.passwordKutusu.sendKeys("password");

// 6. Sign in tusuna basin==> ZeroPage'den signInButonu

        zeroPage.signInButonu.click();

// 7. Back tusuna basin ==> navigate pencereler arasi geciste kullaniyoruz

        Driver.getDriver().navigate().back();

// 8. Giris yapilabildigi dogrulayin

        softAssert.assertTrue(zeroPage.onlineBankingLinki.isDisplayed(),"Giris yapilamadi");
        // softAssert icine mesajimizi yazdik

// 9. Online banking menusunu tiklayin ==> ZeroPage'den onlineBankingLinki

        zeroPage.onlineBankingLinki.click();

//10. Pay Bills sayfasina gidin ==> ZeroPage'den payBillsLinki

        zeroPage.payBillsLinki.click();

//11. “Purchase Foreign Currency” tusuna basin ==> ZeroPage'den purchaseForeignCurrencyLinki

        zeroPage.purchaseForeignCurrencyLinki.click();

//12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin ==> ZeroPage'den..

        softAssert.assertTrue(zeroPage.pcCurrencyDropdownElementi.isEnabled(),"currency dropdown kullanilamiyor");

//13. “Currency” dropdown menusunden Eurozone’u secin ==> ZeroPage'den

        Select select = new Select(zeroPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");

//14. "Eurozone (euro)" secildigini dogrulayin

        String expectedOption = "Eurozone (euro)";
        String actualSeciliOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSeciliOption,expectedOption,"Eurozone secilemedi");

//15. Dropdown menude 16 option bulundugunu dogrulayin.

        int expectedDropdownSize = 16;
        int actualDopdownSize = select.getOptions().size(); // opsiyonlari getir diyoruz
        softAssert.assertEquals(actualDopdownSize,expectedDropdownSize,"Dropdown beklenen boyutta degil");

//16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        // bunun icin bi listeye ihtiyacimiz var,
        // bu listeyi de cok kullanacaksak reusablemethods'ta method olusturabiliriz
        List<WebElement> dropdownElementleriList = select.getOptions();
        List<String> dropdownYazilariList = ReusableMethods.stringListeDonustur(dropdownElementleriList);
        softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Dropdown'da Canada Dolari yok");

//17. Sayfayi kapatin

        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.closeDriver();

    /*
         Bu testte Page kullaniminin pratikligini goruyoruz
         Bir defa page sayfamizda locate'leri olusturduktan sonra,
         yani raflara malzemelerimizi yerlestirince
         ihtiyac oldukca alip kullanacagiz.
         Bu sekilde ayni sayfa uzerinde binlerce test senaryosu hazirlayabiliriz

    */
    }
}




// HTML, "HyperText Markup Language" ifadesinin kısaltmasıdır. Türkçe'de "HiperMetin İşaretleme Dili"
// XML, "eXtensible Markup Language" ifadesinin kısaltmasıdır. Türkçe'de "Genişletilebilir İşaretleme Dili"


