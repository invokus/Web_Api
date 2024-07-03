package com.nttdata.stepsdefinitions;

import com.nttdata.steps.TiendaSteps;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TiendaStepDef {

    private TiendaSteps tiendaSteps;
    private WebDriver driver;
    private Scenario scenario;

    @Before(order = 0)
    public void setUp() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    private void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Given("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        tiendaSteps = new TiendaSteps(driver);
        tiendaSteps.navegarA("https://qalab.bensg.com/store");
        screenShot();
    }

    @Then("click en Iniciar Sesion")
    public void clickEnIniciarSesion() {
    }

    @And("ingreso el usuario {string} y contraseña {string}")
    public void ingresoElUsuarioYContraseña(String email, String password) {
        tiendaSteps.ingresar(email, password);
        screenShot();
    }

    @When("selecciono la categoría {string} y la subcategoría {string}")
    public void seleccionoLaCategoríaYLaSubcategoría(String categoria, String subcategoria) {
        tiendaSteps.selccionCategoria(categoria, subcategoria);
        screenShot();
    }

    @And("añado {int} unidades del primer producto al carrito")
    public void añadoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        tiendaSteps.agregarProductos(cantidad);
        screenShot();
    }

    @And("verifico que el monto total en el popup sea calculado correctamente")
    public void verificoQueElMontoTotalEnElPopupSeaCalculadoCorrectamente() {
        //tiendaSteps.confirmarCompra();
        double ppu = 19.2;
        int cantidad = 2;
        tiendaSteps.chequeo(ppu, cantidad);
        screenShot();
    }

    @Then("el monto total mostrado coincide con el precio de los productos agregados")
    public void elMontoTotalMostradoCoincideConElPrecioDeLosProductosAgregados() {
        screenShot();
    }

    @And("termino la compra")
    public void terminoLaCompra() {
        tiendaSteps.terminarCompra();
    }

    @Then("Confirmo nombre del Carrito")
    public void confirmoNombreDelCarrito() {
    }

}
