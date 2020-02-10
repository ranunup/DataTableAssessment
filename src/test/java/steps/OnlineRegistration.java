package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.User;
import pages.OnlineRegistrationPage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnlineRegistration extends BaseUtil {

    private BaseUtil base;
    private OnlineRegistrationPage onlineRegPage;

    public OnlineRegistration(BaseUtil base) {
        this.base = base;
        this.onlineRegPage = new OnlineRegistrationPage(this.base.driver);
    }

    @Given("^I navigate to the iLab careers page$")
    public void iNavigateToTheILabCareersPage() {
        try {
            this.base.driver.navigate().to("https://www.ilabquality.com/careers/south-africa/");
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to navigate to iLab careers page, error - " + ex.getMessage());
        }
    }

    @And("^I select the country as South Africa$")
    public void iSelectTheCountryAsSouthAfrica() {
        try {
            this.onlineRegPage.selectSouthAfrica();
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to select South Africa, error - " + ex.getMessage());
        }
    }

    @And("^I select the first link under CURRENT OPENINGS$")
    public void iSelectTheFirstLinkUnderCURRENTOPENINGS() {
        try {
            this.onlineRegPage.selectTopOpening();
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to select top job opening, error - " + ex.getMessage());
        }
    }

    @And("^I click the Apply Online button$")
    public void iClickTheApplyOnlineButton() {
        try {
            this.onlineRegPage.selectApplyOnline();
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to click Apply Online, error - " + ex.getMessage());
        }
    }

    @And("^I enter the following personal details$")
    public void iEnterTheFollowingPersonalDetails(DataTable table) {
        try {

            // create user array
            List<User> users = new ArrayList<User>();

            // store all users
            users = table.asList(User.class);

            for (User user: users) {
                this.onlineRegPage.insertApplicantDetails(user.firstName, user.email);
            }
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to insert personal details, error - " + ex.getMessage());
        }
    }



    @And("^I insert an auto-generated phone number$")
    public void iInsertAnAutoGeneratedPhoneNumber() {
        try {
            this.onlineRegPage.insertAutoGeneratedPhoneNumber(this.autoGenPhoneNum());
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to insert auto-generated phone number, error - " + ex.getMessage());
        }
    }

    @And("^I click the Send button$")
    public void iClickTheSendButton() {
        try {
            this.onlineRegPage.clickSendApplication();
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to click Send button, error - " + ex.getMessage());
        }
    }

    @Then("^I validate the error text$")
    public void iValidateTheErrorText() {
        try {
            this.onlineRegPage.verifyErrorTextDisplayed();
        } catch (Exception ex) {
            System.err.println("[Online Reg Step Error] Failed to validate error text, error - " + ex.getMessage());
        }
    }

    private String autoGenPhoneNum() {

        try {

            Random rand = new Random();
            int grp1 = rand.nextInt(99) + 1;
            int grp2 = rand.nextInt(1000);
            int grp3 = rand.nextInt(1000);

            DecimalFormat df1 = new DecimalFormat("000");
            DecimalFormat df2 = new DecimalFormat("0000");

            String str1 = String.format("%03d", grp1);

            return str1 + ' ' + df1.format(grp2) + ' ' + df2.format(grp3);

        } catch (Exception ex) {
            System.err.println("[Selenium Error] Failed to auto generate phone number, error - " + ex.getMessage());
        }

        return null;
    }
}