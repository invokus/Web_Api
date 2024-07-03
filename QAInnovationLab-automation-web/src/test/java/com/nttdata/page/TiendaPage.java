package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TiendaPage {
    private WebDriver driver;

    public static By fstep = By.id("_desktop_user_info");
    //private By emailField = By.xpath("field-email");
    private By passwordField = By.id("field-password");
    private By logginButton = By.id("submit-login");
    private By categoryopt = By.xpath("//*[@id='category-3']");
    private By subCategoryopt = By.xpath("//*[@id='left-column']/div[1]/ul/li[2]/ul/li[1]/a");
    private By selectProduct = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    private By addCart = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i");
    private By update = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    private By popupWindows = By.id("confirmation-popup");
    private By totalQuantity = By.id(".product-total > span:nth-child(2)");
    private By confirmBuy = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    private By totalBuy = By.id("div.cart-summary-line:nth-child(2) > span:nth-child(2)");


    public TiendaPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void login(String email, String password){
        driver.findElement(fstep).click();
        driver.findElement(passwordField).click();
        driver.findElement(logginButton).click();
    }

    public void Categories(String category, String subcategory){
        driver.findElement(categoryopt).click();
        driver.findElement(subCategoryopt).click();
    }

    public void addProduct(int quantity){
        driver.findElement(selectProduct).click();
        driver.findElement(addCart).click();
        driver.findElement(update).click();
    }

    public boolean confirmWindow(){
        return driver.findElement(popupWindows).isDisplayed();
    }

    public void selfCheckout(){
        driver.findElement(confirmBuy).click();
    }

    public String totalBuyconfirm(){
        return driver.findElement(totalBuy).getText();
    }

    public String Pages(){
        return driver.getTitle();
    }
}
