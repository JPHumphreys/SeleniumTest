package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\IdeaProjects\\SeleniumTesting\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;


    }



    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void searchTest() throws InterruptedException {
        driver.manage().window().maximize();//max screen
        driver.get("http://google.com");
        Thread.sleep(2000);

        WebElement searchField = driver.findElement(By.name("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pictures");
        Thread.sleep(5000);

        WebElement submitButton = driver.findElement(By.name("btnK"));
        submitButton.click();
        Thread.sleep(5000);

        WebElement linkToBiggerPictures = driver.findElementByLinkText("Images for funny cat");//partial link test too is an option
        linkToBiggerPictures.click();
        Thread.sleep(5000);

        int counter = 1;
        for(int i = 0; i < 100; i++)
        {
            js.executeScript("window.scrollBy(" + i + "," + (counter++) +")"); //Scroll vertically down by 1000 pixels
            Thread.sleep(50);
        }

        Thread.sleep(1000);

    }

    @Test
    public void seleniumSimpleInput() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(3000);

        WebElement searchField = driver.findElementById("user-message");
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("beep boop");
        Thread.sleep(3000);

        WebElement inp1 = driver.findElementById("sum1");
        inp1.sendKeys("12");

        WebElement inp2 = driver.findElementById("sum2");
        inp2.sendKeys("7");
        Thread.sleep(3000);
    }

    @Test
    public void seleniumCheckboxDemo() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(3000);

        WebElement checkbox = driver.findElementById("isAgeSelected");
        checkbox.click();
        Thread.sleep(2000);


    }

}


