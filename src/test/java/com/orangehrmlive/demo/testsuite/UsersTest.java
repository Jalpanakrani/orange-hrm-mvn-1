package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sun.awt.HKSCS;

public class UsersTest extends TestBase {
    LogInPage loginPage;
    HomePage homePage;
    ViewSystemUsersPage viewSystemUsersPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LogInPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        dashboardPage = new DashboardPage();
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        String expectedMessage = "SystemUsersText";
        String actualMessage = viewSystemUsersPage.getSystemUsersText();
        softAssert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        viewSystemUsersPage.clickOnAddButton();
        String actualAddUserText = "Add User";
        String expectedAddUserText = addUserPage.getVerifyAddUserText();
        softAssert.assertEquals(expectedAddUserText,actualAddUserText,"text is not match");
        addUserPage.selectRoleFromDropDown("Admin");
        addUserPage.enterEmployee("Ananya Dash");
        addUserPage.enterUserName("xyz");
        addUserPage.selectStatusFromDropDown("Disabled");
        addUserPage.enterpassword("Xyz123@");
        addUserPage.enterConfirmPassword("Xyz123@");
        addUserPage.clickOnSaveButton();
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        String actualSystemUserText = "System Users";
        String expectedSystemUserText = viewSystemUsersPage.getSystemUsersText();
        softAssert.assertEquals(expectedSystemUserText,actualSystemUserText,"text is not match");
        viewSystemUsersPage.enteruserName("Admin");
        viewSystemUsersPage.selectRoleFromDropDown("Admin");
        viewSystemUsersPage.selectStatusFromDropDown("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
        String actualUserName = "Admin";
        String expectedUserName = viewSystemUsersPage.getVerifyUseraNameText();
        softAssert.assertEquals(expectedUserName,actualUserName,"username is not match");
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin", "admin123");
        homePage.clickOnAdminTab();
        String expectedMessage = "SystemUsersText";
        String actualMessage = viewSystemUsersPage.getSystemUsersText();
        softAssert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        viewSystemUsersPage.enterEmployee("Ananya Dash");
        viewSystemUsersPage.selectRoleFromDropDown("Admin");
        viewSystemUsersPage.selectStatusFromDropDown("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        softAssert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        viewSystemUsersPage.clickOnUserRecordCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.clickOnPopupButton();
       // Assert.assertTrue(viewSystemUsersPage.getSuccessfullyDeletedText();
        softAssert.assertAll();

    }

    @Test(groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        String expectedMessage = "SystemUsersText";
        String actualMessage = viewSystemUsersPage.getSystemUsersText();
        softAssert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        viewSystemUsersPage.enteruserName("aaa");
        viewSystemUsersPage.selectRoleFromDropDown("Admin");
        viewSystemUsersPage.selectStatusFromDropDown("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        String actualUserNotFoundText = "No Records Found";
        String expectedUserNotFoundText = viewSystemUsersPage.getVerifyUserNotFoundText();
        softAssert.assertEquals(expectedUserNotFoundText,actualUserNotFoundText,"text is not match");

        softAssert.assertAll();
    }
}
