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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\IdeaProjects\\SeleniumTest\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;


    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void clickIndexButton() throws InterruptedException{

        WebElement button = driver.findElementById("index-register-button");
        button.click();
        Thread.sleep(2000);

    }

    @Test
    public void clickRegisterButton() throws InterruptedException{
        WebElement button = driver.findElementById("register-button");
        button.click();
        Thread.sleep(2000);
    }

    @Test
    public void enterDetails_RegisterUsername() throws InterruptedException{

        WebElement input = driver.findElementById("register-username");
        input.sendKeys("selenium");
        Thread.sleep(2000);

    }

    @Test
    public void enterDetails_RegisterPassword() throws InterruptedException{

        WebElement input = driver.findElementById("register-password");
        input.sendKeys("selenium");
        Thread.sleep(2000);

    }




    @Test
    public void mainTest() throws InterruptedException {
        driver.manage().window().maximize();//max screen
        driver.get("http://127.0.0.1:5500/");
        Thread.sleep(3000);

        clickIndexButton();

        enterDetails_RegisterUsername();
        enterDetails_RegisterPassword();
        clickRegisterButton();

        //searchField.sendKeys("funny cat pictures");

        //WebElement submitButton = driver.findElement(By.name("btnK"));
        //submitButton.click();

        //WebElement linkToBiggerPictures = driver.findElementByLinkText("Images for funny cat");//partial link test too is an option
        //linkToBiggerPictures.click();

       // int counter = 1;
       // for(int i = 0; i < 100; i++)
       // {
       //     js.executeScript("window.scrollBy(" + i + "," + (counter++) +")"); //Scroll vertically down by 1000 pixels
       //     Thread.sleep(50);
       // }

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


