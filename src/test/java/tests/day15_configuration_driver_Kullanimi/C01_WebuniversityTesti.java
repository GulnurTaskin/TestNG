package tests.day15_configuration_driver_Kullanimi;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class C01_WebuniversityTesti {


        @Test
        public void negatifLoginTesti(){
            //1."http://webdriveruniversity.com/" adresine gidin

            getDriver().get("http://webdriveruniversity.com/");

            //2."Login Portal" a  kadar asagi inin

            WebuniversityPage webuniversityPage = new WebuniversityPage();
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webuniversityPage.loginPortalLinki);
              // ifneeded==> ihtiyac varsa asagi in

            //3."Login Portal" a tiklayin

            ReusableMethods.bekle(1);
            webuniversityPage.loginPortalLinki.click();

            //4.Diger window'a gecin

            ReusableMethods.titleIleSayfaDegistir("WebDriver | Login Portal");

            //5."username" ve  "password" kutularina rastgele deger yazdirin

            ReusableMethods.bekle(1);
            Faker faker = new Faker(); // faker class'tan faker objesi olusturuyoruz
            webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
            webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());

            //6."login" butonuna basin

            webuniversityPage.loginButonu.click();

            //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

            ReusableMethods.bekle(3);
            String expectedAlertYazisi = "validation failed";

            String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
            System.out.println(actualAlertYazisi); // bunu ben gormek icin ekledim

            Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

            //8.Ok diyerek Popup'i kapatin

            Driver.getDriver().switchTo().alert().accept();
            ReusableMethods.bekle(1);

            //9.Ilk sayfaya geri donun

            String ilkSayfaTitle = "WebDriverUniversity.com";
            ReusableMethods.titleIleSayfaDegistir(ilkSayfaTitle);

            //10.Ilk sayfaya donuldugunu test edin

            ReusableMethods.bekle(1);
            String actualTitle = Driver.getDriver().getTitle();

            Assert.assertEquals(actualTitle,ilkSayfaTitle);


            Driver.quitDriver();

}
}