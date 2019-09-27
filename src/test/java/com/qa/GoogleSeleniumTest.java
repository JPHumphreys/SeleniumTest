package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private static WebDriver Driver;
    private ChromeDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\J\\IdeaProjects\\API\\SeleniumTest\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;


    }

    @After
    public void tearDown(){
        driver.close();
    }

    public void handleAlert(){
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }
    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException ex){
            return false;
        }
    }



    public void clickIndexButton() throws InterruptedException{

        WebElement button = driver.findElementById("index-register-button");
        button.click();
        Thread.sleep(2000);




    }


    public void clickRegisterButton() throws InterruptedException{
        WebElement button = driver.findElementById("register-button");
        assertTrue(button.isDisplayed());
        button.click();
        Thread.sleep(2000);
    }


    public void enterDetails_RegisterUsername() throws InterruptedException{

        WebElement input = driver.findElementById("register-username");
        assertTrue(input.isDisplayed());
        input.sendKeys("selenium");
        Thread.sleep(2000);

    }


    public void enterDetails_RegisterPassword() throws InterruptedException{

        WebElement input = driver.findElementById("register-password");
        assertTrue(input.isDisplayed());
        input.sendKeys("selenium");
        Thread.sleep(2000);

    }

    public void registerUser() throws InterruptedException{
        //register user
        enterDetails_RegisterUsername();
        enterDetails_RegisterPassword();
        clickRegisterButton();
    }

    public void checkRegisterItems() throws InterruptedException{
        WebElement username = driver.findElementById("register-username");
        Thread.sleep(1000);
        assertFalse(username.isDisplayed());

        WebElement password = driver.findElementById("register-password");
        Thread.sleep(1000);
        assertFalse(password.isDisplayed());
    }

    @Test
    public void mainTest() throws InterruptedException {
        driver.manage().window().maximize();//max screen
        driver.get("http://127.0.0.1:5500/");
        Thread.sleep(3000);

        clickIndexButton();

        //register user
        checkRegisterItems();
        registerUser();
        handleAlert();

        //Login


        //vote


        //checks decks empty


        //deckbuild


        //check deck





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




}


