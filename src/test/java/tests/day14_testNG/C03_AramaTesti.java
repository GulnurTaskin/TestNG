package tests.day14_testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test(priority = 1)
    public void anasayfaTesti(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- testotomasyonu anasayfaya gidp dogru adrese gittiginizi test edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrl = "https://www.testotomasyonu.com";
        String actualUrl = driver.getCurrentUrl();

    }

    @Test(priority = 2)
    public void aramaTesti(){
        // 2- phone icin arama yapip arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


    }

    @Test(priority = 3)
    public void urunIsimTesti(){
        // 3- ilk urune tuiklayip acilan urun sayfasinda ,
    }
}
