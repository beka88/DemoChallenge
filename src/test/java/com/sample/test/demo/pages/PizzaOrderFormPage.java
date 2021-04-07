package com.sample.test.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PizzaOrderFormPage {
    public WebDriver driver;
    public PizzaOrderFormPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "pizza1Pizza")
    public WebElement pizza1;
    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
    public WebElement pizza1Toppings1;
    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
    public WebElement pizza1Toppings2;
    @FindBy(id = "pizza1Qty")
    public WebElement pizza1Quantity;
    @FindBy(id = "pizza1Cost")
    public WebElement pizza1Cost;

    @FindBy(id = "ccpayment")
    public WebElement radioCreditCard;
    @FindBy(id = "cashpayment")
    public WebElement radioCash;

    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "placeOrder")
    public WebElement placeOrderButton;
    @FindBy(id = "reset")
    public WebElement resetButton;

    @FindBy(id = "dialog")
    public WebElement dialog;
    @FindBy(id = "//div[@id='dialog']/p")
    public WebElement dialogText;

    @FindBy(id = "pizza1Qty")
    public WebElement quantityInpt;
    @FindBy(id = "pizza1Cost")
    public WebElement costInpt;

    @FindBy(xpath = "//*[@id='dialog']/p")
    public WebElement confirmationOrderTxt;

    public PizzaOrderFormPage selectDropDown(WebElement element, String value){
        Select oSelect=new Select(element);
        oSelect.selectByValue(value);
        return this;
    }

    public void fillOutForm(String pizza1Txt, String pizzaTopping1,String pizzaTopping2, String quantity,String namePerson, String emailPerson,String paymentType){
        selectDropDown(pizza1, "Small 6 Slices - no toppings");
        selectDropDown(pizza1Toppings1,"Diced Mango");
        selectDropDown(pizza1Toppings2,"Olives");
        quantityInpt.sendKeys("1");
        name.sendKeys("Mike Smith");
        email.sendKeys("mike@gmail.com");
        phone.sendKeys("9724565485");
        radioCreditCard.click();
        placeOrderButton.click();
        Assert.assertEquals(confirmationOrderTxt.getText(),"Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings");
    }



}
