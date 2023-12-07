package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@*='Autoriser tous les cookies'])[1]")
    public WebElement cookiesKabulButonu;

    @FindBy (id="email")
    public WebElement emailBox;

    @FindBy (id="pass")
    public WebElement passBox;

    @FindBy (name="login")
    public WebElement accessButton;

    @FindBy (className = "_9ay7")
    public WebElement message;
}
