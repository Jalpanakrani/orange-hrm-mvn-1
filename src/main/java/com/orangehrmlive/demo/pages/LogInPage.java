package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends Utility {
    @FindBy(id = "txtUsername")
    WebElement userName;
    @FindBy(id = "txtPassword")
    WebElement passwordField;
    @FindBy(id = "btnLogin")
    WebElement loginBtn;
    @FindBy(id = "logInPanelHeading")
    WebElement loginPanelText;

    public void enterUserName(String uName){
        sendTextToElement(userName,uName);
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }

    public void clickOnLoginButton(){
        clickOnElement(loginBtn);
    }

    public void loginToApplication(String username, String password){
        sendTextToElement(userName,username);
        sendTextToElement(passwordField,password);
        clickOnElement(loginBtn);
    }

    public String getVerifyLoginPanelText(){
        return getTextFromElement(loginPanelText);
    }

}