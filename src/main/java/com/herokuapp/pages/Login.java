package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(name = "username")
    WebElement inputUserName;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//*[@class='radius']")
    WebElement loginButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//Set username
    public void setUserName(String strUserName) {
        inputUserName.sendKeys(strUserName);
    }

    //Set password
    public void setPassword(String strPassword) {
        inputPassword.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin() {
        loginButton.click();
    }

    public void Login(String strUserName, String strPassword) {
        //Fill username
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();
    }
}
