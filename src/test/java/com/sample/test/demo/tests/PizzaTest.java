package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.pages.PizzaOrderFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PizzaTest extends TestBase {
    @Test
    public void verifyFormInputs() throws InterruptedException {
       PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
       formPage.fillOutForm("Small 6 Slices - no toppings","");
    }
    @Test
    public void verifyFormInputs2() throws InterruptedException {
        PizzaOrderFormPage formPage= new PizzaOrderFormPage(driver);
        formPage.fillOutForm("Small 6 Slices - no toppings","");
    }

}
