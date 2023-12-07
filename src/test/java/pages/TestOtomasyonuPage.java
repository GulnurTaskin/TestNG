package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {
    // bizim driver'imizi bu class'a tanimlamaliyiz
    // bunun icin C05_pageClassKullanimi'ndaki aciklamayi oku
    // sonra tekrar buraya gel
    // basta burda bir constactor var ama gorunur degil
    // gorunur hale getiriyoruz
    // public TestOtomasyonuPage(){}
    // bunun icine standart bi cumle yaziyoruz
    // PageFactory.initElements(Driver.getDriver(),this);
    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        // init==> elementlere ilk deger atamasi yap
        // neye deger atamasi yap? Driver.getDriver bu sayfada tanimli olsun
    }

    @FindBy(id ="global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "//div[@class= 'product-box my-2  py-1']")
    // burda 1'den fazla element oldugu icin, bir liste olusturup oraya atiyoruz
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement urunSayfasindakiUrunIsimElementi;

    @FindBy(xpath = "(//a[@class='e-cart'])[1]")
    public WebElement accountLinki;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutLinki;

}