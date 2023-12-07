package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebuniversityPage {
    // bu sekilde her web sitesi icin ayri bir locate class'i olusturuyoruz
    // ilerde ihtiyac oldukca bir web sitesinin 1'den fazla locate class'i olusturabiliriz
    // oncelikle constractor'umuzu public yapiyoruz
    // sonra da driver'imizi buraya tanitiyoruz

    public WebuniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement loginPortalLinki;

    @FindBy(xpath = "//*[@id='text']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginButonu;


}
