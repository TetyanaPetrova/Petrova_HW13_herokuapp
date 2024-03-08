package com.herokuapp.login.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.Login;
import com.herokuapp.pages.UnsuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testSuccessLogin() {

        Login objLogin = new Login(driver);
        objLogin.Login("tomsmith", "SuperSecretPassword!");
        HomePage objHomePage = new HomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageHeaderText().contains("Logout"));
    }


    @Test
    public void testUnsuccessLogin() {
        Login objLogin = new Login(driver);
                objLogin.Login("tomsmith1", "SuperSecretPassword!");
UnsuccessPage objUnsuccessPage = new UnsuccessPage(driver);
Assert.assertTrue(objUnsuccessPage.getUnsuccessPageHeaderText().contains("Your username is invalid!"));

    }
}
