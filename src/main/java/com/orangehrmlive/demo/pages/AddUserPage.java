package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {
    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUserText;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRoleDropDown;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeNameField;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement usernameField;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement statusDropDown;
    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='btnCancel']")
    WebElement cancelButton;

    public String getVerifyAddUserText(){
        return getTextFromElement(addUserText);
    }

    public void selectRoleFromDropDown(String role){
        selectByVisibleTextFromDropDown(userRoleDropDown,role);
    }

    public void enterEmployee(String employeeName){
        sendTextToElement(employeeNameField,employeeName);
    }

    public void enterUserName(String username){
        sendTextToElement(usernameField,username);
    }

    public void selectStatusFromDropDown(String status){
        selectByVisibleTextFromDropDown(statusDropDown,status);
    }

    public void enterpassword(String password){
        sendTextToElement(passwordField,password);
    }

    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordField,confirmPassword);
    }


    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }

    public void clickOnCancelButton(){
        clickOnElement(cancelButton);
    }
}