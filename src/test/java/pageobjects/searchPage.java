package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage {

    WebDriver driver;

    // Constructor

    public searchPage(WebDriver browser){
        driver = browser;
        PageFactory.initElements(driver,this);
    }

    // Locators

    @FindBy(css = "div[class='content_price col-xs-5 col-md-12'] span[itemprop='price']")
    private  WebElement txtprecio;

    @FindBy(css = "li#list")
    private WebElement btnList;

    // Actions

    public String getPrecio(){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOf(txtprecio));
        return txtprecio.getText();
    }

    public void clickModeList(){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOf(btnList));
        btnList.click();
    }


}
