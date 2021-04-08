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
    @FindBy(xpath = "//div[@id='dialog']/p")
    public WebElement dialogText;

    @FindBy(id = "pizza1Qty")
    public WebElement quantityInpt;
    @FindBy(id = "pizza1Cost")
    public WebElement costInpt;



    public PizzaOrderFormPage selectDropDown(WebElement element, String value){
        Select oSelect=new Select(element);
        oSelect.selectByValue(value);
        return this;
    }

    public void fillOutForm(String pizza1Txt, String pizzaTopping1,String pizzaTopping2, String quantity,String namePerson, String emailPerson,String phoneNumber,String paymentType){
        selectDropDown(pizza1, pizza1Txt);
        selectDropDown(pizza1Toppings1,pizzaTopping1);
        selectDropDown(pizza1Toppings2,pizzaTopping2);
        quantityInpt.sendKeys(quantity);
        name.sendKeys(namePerson);
        email.sendKeys(emailPerson);
        phone.sendKeys(phoneNumber);
        if(paymentType.equals("CreditCard")){
            radioCreditCard.click();
        }else {
            radioCash.click();
        }
    }



}
