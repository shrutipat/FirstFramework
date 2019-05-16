package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class RegistrationPage extends Util {

    By registerLink = By.xpath("//a[@class='ico-register']");
    By femaleGender = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By dateOfBirth = By.name("DateOfBirthDay");
    By monthOfBirth = By.name("DateOfBirthMonth");
    By yearOfBirth = By.name("DateOfBirthYear");
    By email = By.id("Email");
    By password = By.name("Password");
    By confirmPassword = By.name("ConfirmPassword");
    By company = By.id("Company");
    By newsLetter = By.id("Newsletter");
    By registerBtn = By.id("register-button");
    By registerText = By.xpath("//h1[contains(text(),'Register')]");
    By registrationSuccessfulText = By.xpath("//div[@class='result']");

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public String randomEmail() {
        log.info("random email generated");
        return ("myemail" + generateRandomNumber() + "@email.com");
    }

    public void clickOnRegister() {
        log.info("click on register");
        clickOnElement(registerLink);
    }

    public void clickOnFemale() {
        log.info("click on female");
        clickOnElement(femaleGender);
    }

    public void enterFirstName(String str) {
        log.info("enter first name");
        sendTextToElement(firstName, str);
    }

    public void enterLastName(String str) {
        log.info("enter last name");
        sendTextToElement(lastName, str);
    }

    public void selectDateOfBirthByIndex(int i) {
        log.info("select date of birth");
        select_By_Index(dateOfBirth, i);
    }

    public void selectMonthOfBirthByIndex(int i) {
        log.info("select month of birth");
        select_By_Index(monthOfBirth, i);
    }

    public void selectYearOfBirthByIndex(int i) {
        log.info("select year of birth");
        select_By_Index(yearOfBirth, i);
    }

    public void enterAutoEmail() {
        log.info("enter auto email");
        sendTextToElement(email, randomEmail());
    }

    public void enterPassword(String str) {
        log.info("enter password");
        sendTextToElement(password, str);
    }

    public void enterConfirmPassword(String str) {
        log.info("enter confirm password");
        sendTextToElement(confirmPassword, str);
    }

    public void enterCompanyName(String str) {
        log.info("enter company name");
        sendTextToElement(company, str);
    }

    public void clickNewsLetter() {
        log.info("click newsletter checkbox");
        clickOnElement(newsLetter);
    }

    public void clickOnRegisterBtn() {
        log.info("click on register button");
        clickOnElement(registerBtn);
    }

    public String getRegisterText() {
        log.info("get register page text");
        return getTextFromElement(registerText);
    }

    public String getRegistrationSuccessfulText() {
        log.info("get registration successful text");
        return getTextFromElement(registrationSuccessfulText);
    }

}
