package pages;

import org.bouncycastle.util.test.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuFormPage {
    // bir page sayfasi olusturdugumuzda ilk olarak yapmamiz gereken sey
    // constractor'i gorunur hale getirip
    // bunun icine driver'imizi tanimliyoruz

    public TestOtomasyonuFormPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    // artik bundan sonra istedigimiz kadar locate alabiliriz

    @FindBy(xpath = "//select[@class='form-control']")
    public List<WebElement> dropdownMenuElementleriList;

    @FindBy(id = "gridCheck4")
    public WebElement carpintiCheckboxKutusu;

    @FindBy(id = "gridCheck5")
    public WebElement sirtAgrisiCheckboxKutusu;

    @FindBy(id = "hastalikCheck2")
    public WebElement sekerCheckboxKutusu;

    @FindBy(id = "hastalikCheck7")
    public WebElement epilepsiCheckboxKutusu;
}
