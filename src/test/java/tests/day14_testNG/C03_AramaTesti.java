package tests.day14_testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_AramaTesti {

    // gerekli ayarlamalari yapin
    // uc test methodu olusturun
    // 1- testotomasyonu anasayfaya gidp dogru adrese gittiginizi test edin
    // 2- phone icin arama yapip arama sonucunda urun bulunabildigini test edin
    // 3- ilk urune tuiklayip acilan urun sayfasinda ,
    // urun isminin case sensitive olmadan phone icerdigini test edin

    WebDriver driver;

    @Test //(priority = 1)
    public void anasayfaTesti(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- testotomasyonu anasayfaya gidip dogru adrese gittiginizi test edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrl = "https://www.testotomasyonu.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test(dependsOnMethods = "anasayfaTesti") //(priority = 2)
    public void aramaTesti(){

        // 2- phone icin arama yapip
        //    arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unexpectedSonucYazisi = "0 Products Found";
        String actualSonucyazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(unexpectedSonucYazisi,actualSonucyazisi);

    }

    @Test(dependsOnMethods = "aramaTesti")//(priority = 3)
    public void urunIsimTesti(){
        // 3- ilk urune tiklayip acilan urun sayfasinda ,
        // urun isminin case sensitive olmadan phone icerdigini test edin

        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();

        WebElement urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsimKucukHarf = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualIsimKucukHarf.contains(expectedIsimIcerik));

        driver.close();

        /*
        priority ile siralama yapmak her zaman isimizi kolaylastirmaz
        burada priority yaptik ama ilk test fail oldugunda diger testleri yapmaya devam etti.
        bu de toplamda daha uzun zaman aldi
        bunun yerine depends methodu ile testleri birbirine baglayabiliriz.
        Boylelikle ilk test calismazsa digerine gecmez ve zaman kaybetmeden testimiz sonuclanir

         */
    }
}
