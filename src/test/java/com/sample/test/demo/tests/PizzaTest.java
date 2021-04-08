package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.pages.PizzaOrderFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaTest extends TestBase {
    //Happy path scenarios
    @Test
    public void verifyFormInputs() {
       PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
       formPage.fillOutForm(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName(), PizzaToppings.MANGOS.getDisplayName(),PizzaToppings.OLIVES.getDisplayName(),"1","Mike Smith","mike@gmail.com","9724565485","CreditCard");
       formPage.placeOrderButton.click();
       Assert.assertTrue(formPage.dialogText.getText().contains(PizzaTypes.SMALL_NOTOPPINGS.getDisplayName()));
      }
    @Test
    public void verifyFormInputs2(){
        PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
        formPage.fillOutForm(PizzaTypes.SMALL_ONETOPPINGS.getDisplayName(),PizzaToppings.OLIVES.getDisplayName(),PizzaToppings.MUSHROOMS.getDisplayName(),"3","Mike Smith","mike@gmail.com","9724565485","Cash");
        formPage.placeOrderButton.click();
        Assert.assertTrue(formPage.dialogText.getText().contains(PizzaTypes.SMALL_ONETOPPINGS.getDisplayName()));
    }

    @Test
    public void verifyFormInputs3(){
        PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
        formPage.fillOutForm(PizzaTypes.LARE_NOTOPPINGS.getDisplayName(),PizzaToppings.SALAMI.getDisplayName(),PizzaToppings.EXTRACHEESE.getDisplayName(),"4","Mike Smith","mike@gmail.com","9724565485","CreditCard");
        formPage.placeOrderButton.click();
        Assert.assertTrue(formPage.dialogText.getText().contains(PizzaTypes.LARE_NOTOPPINGS.getDisplayName()));
    }

    //Negative Scenarios
    @Test
    public void verifyMissingPhoneNumber(){
        PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
        formPage.fillOutForm(PizzaTypes.LARE_NOTOPPINGS.getDisplayName(),PizzaToppings.SALAMI.getDisplayName(),PizzaToppings.EXTRACHEESE.getDisplayName(),"4","Mike Smith","mike@gmail.com","","CreditCard");
        formPage.placeOrderButton.click();
        Assert.assertTrue(formPage.dialogText.getText().contains("Missing phone number"));
    }
    @Test
    public void verifyMissingNameAndPhoneNumber(){
        PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
        formPage.fillOutForm(PizzaTypes.LARE_NOTOPPINGS.getDisplayName(),PizzaToppings.SALAMI.getDisplayName(),PizzaToppings.EXTRACHEESE.getDisplayName(),"4","","mike@gmail.com","","CreditCard");
        formPage.placeOrderButton.click();
        Assert.assertTrue(formPage.dialogText.getText().contains("Missing name"));
        Assert.assertTrue(formPage.dialogText.getText().contains("Missing phone number"));
    }



}
