package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

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
        Thread.sleep(1000);

    }


    public void clickRegisterButton() throws InterruptedException{
        WebElement button = driver.findElementById("register-button");
        assertTrue(button.isDisplayed());
        button.click();
        Thread.sleep(1000);
    }


    public void enterDetails_RegisterUsername() throws InterruptedException{

        WebElement input = driver.findElementById("register-username");
        assertTrue(input.isDisplayed());
        input.sendKeys("selenium");
        Thread.sleep(1000);

    }


    public void enterDetails_RegisterPassword() throws InterruptedException{

        WebElement input = driver.findElementById("register-password");
        assertTrue(input.isDisplayed());
        input.sendKeys("selenium");
        Thread.sleep(500);

    }

    public void registerUser() throws InterruptedException{
        //register user
        enterDetails_RegisterUsername();
        enterDetails_RegisterPassword();
        clickRegisterButton();
    }

    public void enterDetails_LoginUsername() throws InterruptedException {

        WebElement input = driver.findElementById("login-username");
        assertTrue(input.isDisplayed());
        input.sendKeys("selenium");
        Thread.sleep(500);
    }

    public void enterDetails_LoginPassword() throws InterruptedException {
        WebElement input = driver.findElementById("login-password");
        assertTrue(input.isDisplayed());
        input.sendKeys("selenium");
        Thread.sleep(500);
    }

    public void clickLoginButton() throws InterruptedException {
        WebElement button = driver.findElementById("login-button");
        assertTrue(button.isDisplayed());
        button.click();
        Thread.sleep(500);
    }

    public void loginUser() throws InterruptedException {
        enterDetails_LoginUsername();
        enterDetails_LoginPassword();
        clickLoginButton();

    }

    public void moveToLogin() throws InterruptedException {
        WebElement nav = driver.findElementById("nav-login-item");
        assertTrue(nav.isDisplayed());
        nav.click();
        Thread.sleep(1000);
    }

    public void moveToClan() throws InterruptedException {
        WebElement nav = driver.findElementById("nav-clan-pages");
        assertTrue(nav.isDisplayed());
        nav.click();
        Thread.sleep(1000);
    }

    public void selectClan() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/button[2]"));
        assertTrue(button.isDisplayed());
        button.click();
        WebElement option = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/button[4]")));
        assertTrue(option.isDisplayed());
        option.click();
        Thread.sleep(1000);
    }

    public void selectSide() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/button[2]"));
        assertTrue(button.isDisplayed());
        button.click();
        WebElement option = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/button[2]"));
        assertTrue(option.isDisplayed());
        option.click();
        Thread.sleep(1000);
    }

    public void searchClan() throws InterruptedException {

        selectClan();
        selectSide();

        WebElement button = driver.findElementById("search-button");
        assertTrue(button.isDisplayed());
        button.click();
        Thread.sleep(1000);
    }

    public void testGunso(){
        WebElement gunso = driver.findElementById("akodo-gunso");
        assertTrue(gunso.isDisplayed());
        gunso.click();
    }

    public void addRating() throws InterruptedException {

        testGunso();

        WebElement text = driver.findElementById("add-rating-text");
        assertTrue(text.isDisplayed());
        text.sendKeys("4.5");
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[1]"));
        assertTrue(button.isDisplayed());
        button.click();
        Thread.sleep(2000);
    }

    public void testUpdateGunso() throws InterruptedException {
        WebElement gunso = driver.findElementById("akodo-gunso-update");
        assertTrue(gunso.isDisplayed());
        gunso.click();
        WebElement rating = driver.findElementById("update-rating-text");
        assertTrue(rating.isDisplayed());
        rating.sendKeys("5.6");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]"));
        assertTrue(button.isDisplayed());
        button.click();
    }

    public void moveToDeckbuild() throws InterruptedException {
        WebElement nav = driver.findElement(By.xpath("/html/body/div[1]/nav/div/ul/li[1]/a"));
        assertTrue(nav.isDisplayed());
        nav.click();
        Thread.sleep(2000);
    }

    public void selectDeck() throws InterruptedException {
        WebElement name = driver.findElementById("deck-name");
        assertTrue(name.isDisplayed());
        name.sendKeys("v8vwhjihwih");

        WebElement prim = driver.findElementById("primary-crane");
        assertTrue(prim.isDisplayed());
        prim.click();
        WebElement prim2 = driver.findElementById("primary-crane");
        assertTrue(prim2.isDisplayed());
        prim2.click();

        WebElement sec = driver.findElementById("splash-crane");
        assertTrue(sec.isDisplayed());
        sec.click();
        WebElement sec2 = driver.findElementById("splash-dragon");
        assertTrue(sec2.isDisplayed());
        sec2.click();

        WebElement role = driver.findElementById("keeper-button");
        assertTrue(role.isDisplayed());
        role.click();

        WebElement element = driver.findElementById("air-button");
        assertTrue(element.isDisplayed());
        element.click();

        Thread.sleep(3000);

        WebElement submit = driver.findElementById("submit-button");
        assertTrue(submit.isDisplayed());
        submit.click();

    }

    public void deckManipulation() throws InterruptedException {
        WebElement update = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[1]/button[1]"));
        assertTrue(update.isDisplayed());
        update.click();
        Thread.sleep(1000);

        WebElement old = driver.findElementById("old-input-deckname-text");
        assertTrue(old.isDisplayed());
        old.sendKeys("v8vwhjihwih");

        WebElement nw = driver.findElementById("input-deckname-text");
        assertTrue(nw.isDisplayed());
        nw.sendKeys("new");

        Thread.sleep(1000);

        WebElement button = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]"));
        assertTrue(button.isDisplayed());
        button.click();
        Thread.sleep(2000);
    }

    public void closeAndCopy() throws InterruptedException {
        WebElement close = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));
        assertTrue(close.isDisplayed());
        close.click();
        Thread.sleep(1000);

        WebElement copy = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[1]/button[2]"));
        assertTrue(copy.isDisplayed());;
        copy.click();
        Thread.sleep(1000);

    }

    @Test
    public void mainTest() throws InterruptedException {
        driver.manage().window().maximize();//max screen
        driver.get("http://127.0.0.1:5500/");
        Thread.sleep(3000);

        clickIndexButton();

        //register user
        registerUser();
        handleAlert();

        moveToLogin();
        //Login
        loginUser();

        //checks decks empty
        Thread.sleep(2000);


        //vote
        moveToClan();
        searchClan();
        addRating();
        handleAlert();


        //deckbuild
        moveToDeckbuild();
        selectDeck();
        Thread.sleep(2000);


        //check deck
        deckManipulation();
        closeAndCopy();





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


