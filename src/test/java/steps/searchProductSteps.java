package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobjects.homePage;
import pageobjects.searchPage;

import java.net.MalformedURLException;

public class searchProductSteps {

    private WebDriver driver;
    String actual = null;
    String expected = null;

    @Before
    public void setUp() throws MalformedURLException{

        driver = new ChromeDriver();

    }

    @Given("^El cliente se encuentra en la pagina de busqueda$")
    public void openPage(){

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }

    @When("^realiza la busqueda de productos con el termino \"([^\"]*)\"$")
    public void searchProduct(String product){
        homePage homeElements = new homePage(driver);
        homeElements.writeProducto("blouse");
        homeElements.clickBusqueda();
    }

    @And("^cambia la visualizacion de resultados a modo lista$")
    public void changeToList(){
        searchPage searchElements = new searchPage(driver);
        searchElements.clickModeList();
    }

    @Then("^se muestra el producto con el precio \"([^\"]*)\"$")
    public void getPrice(String price){
        searchPage searchElements = new searchPage(driver);

        actual = searchElements.getPrecio();
        expected = price;

        Assert.assertEquals(actual,expected,"Test Exitoso");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
