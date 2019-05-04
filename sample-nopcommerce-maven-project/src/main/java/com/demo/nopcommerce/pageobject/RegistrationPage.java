package com.demo.nopcommerce.pageobject;

import com.demo.nopcommerce.utility.Util;
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

    public String randomEmail(){
    return ("myemail"+generateRandomNumber()+"@email.com");
    }

    public void clickOnRegister(){
        clickOnElement(registerLink);
    }

    public void clickOnFemale(){
        clickOnElement(femaleGender);
    }

    public void EnterFirstName(String str){
        sendTextToElement(firstName, str);
    }

    public void EnterLastName(String str){
        sendTextToElement(lastName, str);
    }

    public void selectDateOfBirth(int i){
        select_By_Index(dateOfBirth,i);
    }

    public void selectMonthOfBirth(int i){
        select_By_Index(monthOfBirth,i);
    }

    public void selectYearOfBirth(int i){
        select_By_Index(yearOfBirth,i);
    }

    public void EnterAutoEmail(){
        sendTextToElement(email,randomEmail());
    }

    public void EnterPassword(String str){
        sendTextToElement(password, str);
    }

    public void EnterConfirmPassword(String str){
        sendTextToElement(confirmPassword,str);
    }

    public void EnterCompanyName(String str){
        sendTextToElement(company,str);
    }

    public void clickNewsLetter(){
        clickOnElement(newsLetter);
    }

    public void clickOnRegisterBtn(){
        clickOnElement(registerBtn);
    }

    public String getRegisterText(){
       return getTextFromElement(registerText);
    }

}
