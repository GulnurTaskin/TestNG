package tests.day14_testNG;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class C06_DropdownTesti {

    @Test
    public void dropdownTesti(){
        // ● https://testotomasyonu.com/form adresine gidin.

        Driver.getDriver().get("https://testotomasyonu.com/form");
           // bu sayfaya manuel olarak da gidiyoruz
           // sonraki asamalarda dogum tarihi gun,ay ve yil locate'lerine ihtiyacimiz olacak
           // o yuzden bunlari tek seferde yapip testotomasyonuFormPage sayfasina ekliyoruz

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
           // dropdaown kullaniyorsak dropdown'i locate etmemiz lazim
           // testOtomasyonuFormPage'de locate ettik
           // simdi bi seelect objesi olusturuyoruz

        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
           // page sayfasindan web element kullanacagimiz icin burda bir testOtomasyonuFormPage objesi olusturuyoruz

        Select selectGun = new Select(testOtomasyonuFormPage.dropdownMenuElementleriList.get(0));
           // gun dropdown'i dropdownMenuElementlerList 0. index'te oldugu icin bu sekilde yaziyoruz

        selectGun.selectByIndex(5);
           // gunleren 5'i seciyoruz. burdaki index numarasi 5, baska yerlerde farkli olabilir
           // biz aradigimiz secenegin index'ini aliyoruz

        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        // yeni bi select objesi olusturuyoruz, selectAy
           // bunun icine bir webelement koymamiz lazim
           // webelement'i nerde locate etmistik, hazir duruyor?
           // dogru cevap: TestOtomasyonuFormPage'da

        Select selectAy = new Select(testOtomasyonuFormPage.dropdownMenuElementleriList.get(1));
           // ay dropdown'i 1. index'te

        selectAy.selectByValue("nisan");
           // nisan'i seciyoruz


        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

           // yukardaki adimlari tekrar ediyoruz
        Select selectYil = new Select(testOtomasyonuFormPage.dropdownMenuElementleriList.get(2));
        selectYil.selectByVisibleText("1990");

        // 4. Secilen değerleri konsolda yazdirin

        System.out.println(selectGun.getFirstSelectedOption().getText() + "/" +
        selectAy.getFirstSelectedOption().getText()+"/"+
        selectYil.getFirstSelectedOption().getText());
           // ilk secili elemanlari getir sonra da yazdir diyoruz

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<String> aylarListesi = ReusableMethods.stringListeDonustur(selectAy.getOptions());
           // getOptions, webelemntlerden olusan bir liste getiriyor
           // opsiyonlar, yani diger secenekler
        System.out.println(aylarListesi);

        // 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        Assert.assertEquals(selectAy.getOptions().size(),13);

        ReusableMethods.bekle(3);
        Driver.closeDriver();


    }
}
