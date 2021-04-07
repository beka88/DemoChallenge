package com.sample.test.demo.tests;

import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

public class DemoTest extends TestBase {

    @Test
    public void demoTest() throws InterruptedException {
        System.out.println("HELLO WORLD");
        Thread.sleep(10000);
    }

}
