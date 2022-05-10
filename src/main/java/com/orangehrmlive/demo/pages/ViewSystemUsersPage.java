package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class ViewSystemUsersPage extends Utility {
    public void inIt() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'System Users')]")
    WebElement SystemUsersText;
    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement usernameField;
    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRollDropDown;
    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employeeNameField;
    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement statusDropDown;
    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;
    @FindBy(xpath = "//input[@id='resetBtn']")
    WebElement resetButton;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;
    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;
    @FindBy(xpath = "//tr[@class=\"odd\"]/descendant::td/following::td/child::a")
    WebElement userNameText;
    @FindBy(id = "ohrmList_chkSelectRecord_46")
    WebElement userCheckBox;
    @FindBy(id = "//input[@id='dialogDeleteBtn']")
    WebElement okButton;
    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement userNotFoundText;
    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement PopupButton;
    @FindBy(xpath = "//div[@id=\"successBodyDelete\"]")
    WebElement SuccessfullyDeletedText;
    @FindBy(xpath = "")
    WebElement UsershouldbeinResultlistText;


    public String getSuccessfullyDeletedText(){
        return getTextFromElement(SuccessfullyDeletedText);
    }
    public String getSystemUsersText() {
        return getTextFromElement(SystemUsersText);
    }

        public void enteruserName(String username){
        sendTextToElement(usernameField,username);
    }

    public void selectRoleFromDropDown(String role){
        selectByVisibleTextFromDropDown(userRollDropDown,role);
    }

    public void enterEmployee(String employeeName){
        sendTextToElement(employeeNameField,employeeName);
    }

    public void selectStatusFromDropDown(String status){
        selectByVisibleTextFromDropDown(statusDropDown,status);
    }

    public void clickOnPopupButton(){
        clickOnElement(PopupButton);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
    }
    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    public void clickOnAddButton(){
        clickOnElement(addButton);
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
    }

    public String getVerifyUseraNameText(){
        return getTextFromElement(userNameText);
    }

    public void clickOnUserRecordCheckBox(){
        clickOnElement(userCheckBox);
    }

    public void clickOnOkButton(){
        clickOnElement(okButton);
    }

    public String getVerifyUserNotFoundText(){
        return getTextFromElement(userNotFoundText);
    }
}
