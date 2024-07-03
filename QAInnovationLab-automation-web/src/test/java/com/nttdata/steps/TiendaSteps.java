package com.nttdata.steps;

import com.nttdata.page.TiendaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TiendaSteps {

    private WebDriver driver;
    private TiendaPage tiendaPage;

    public TiendaSteps(WebDriver driver){
        this.driver = driver;
        tiendaPage = new TiendaPage(driver);
    }

    public void navegarA(String url){
        tiendaPage.navigateTo(url);
    }

    public void clickIngresar(){
        WebElement Ingreso = driver.findElement(TiendaPage.fstep);
        Ingreso.click();
    }

    public void ingresar(String email, String password){
        clickIngresar();
        tiendaPage.login(email, password);
    }

    public void selccionCategoria(String categoria, String subcategoria){
        tiendaPage.Categories(categoria, subcategoria);
    }

    public void agregarProductos(int cantidad){
        tiendaPage.addProduct(cantidad);
    }

    public void confirmarCompra(){
        tiendaPage.confirmWindow();
    }

    public void chequeo (double ppu, int cantidad){

    }

    public void terminarCompra(){
        tiendaPage.selfCheckout();
    }

}
