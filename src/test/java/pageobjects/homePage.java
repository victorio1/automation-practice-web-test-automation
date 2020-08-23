package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    WebDriver driver;

    // Constructor

    public homePage(WebDriver browser){
        driver = browser;
        PageFactory.initElements(driver,this);
    }

    // Locators

    @FindBy(css = "input#search_query_top")
    private WebElement lblbuscador;

    @FindBy(css = "button[type='submit'][name='submit_search']")
    private  WebElement btnbusqueda;

    // Actions

    public void writeProducto(String producto){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOf(lblbuscador));
        lblbuscador.sendKeys(producto);
    }

    public void clickBusqueda(){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOf(btnbusqueda));
        btnbusqueda.click();
    }

}
