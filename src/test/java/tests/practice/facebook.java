package tests.practice;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class facebook {
    //1- https://www.facebook.com/ adresine gidin
    //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
    //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
    //4- Basarili giris yapilamadigini test edin

    @Test
    public void facebookTest(){

        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));

        FacebookPage facebook=new FacebookPage();
        facebook.cookiesKabulButonu.click();
        Faker faker=new Faker();
        facebook.emailBox.sendKeys(faker.internet().emailAddress());
        facebook.passBox.sendKeys(faker.internet().password());
        facebook.accessButton.click();

        Assert.assertTrue(facebook.message.isDisplayed());
        System.out.println(facebook.message.getText());
        Driver.quitDriver();

    }

}