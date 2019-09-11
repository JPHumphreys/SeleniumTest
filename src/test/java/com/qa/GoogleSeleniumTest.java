package com.qa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("web.chrome.driver","resources/chromedriver.exe");

        driver = new ChromeDriver();


    }



    @After
    public void tearDown(){
        driver.close();
    }

}


