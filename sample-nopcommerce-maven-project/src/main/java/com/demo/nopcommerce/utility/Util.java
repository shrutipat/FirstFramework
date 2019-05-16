package com.demo.nopcommerce.utility;

import com.demo.nopcommerce.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Util extends BasePage {

    //click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    //send text to element
    public void sendTextToElement(By by, String str){
        driver.findElement(by).sendKeys(str);
    }

    //get text from locator
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    //select by index
    public void select_By_Index(By by, int i){
        Select dob = new Select(driver.findElement(by));
        dob.selectByIndex(i);
    }

    //select by value
    public void select_By_Value(By by, String str){
        Select dom = new Select(driver.findElement(by));
        dom.selectByValue(str);
    }

    //select by visible text
    public void select_By_Visible_Text(By by, String txt){
        Select doy = new Select(driver.findElement(by));
        doy.selectByVisibleText(txt);
    }

    //mouse over locator
    public void mouseOver(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    //scroll up or down
    public void scrollUpDown(int i){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+i+")");
    }

    //scroll left or right
    public void scrollLeftRight(int i){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+i+",0)");
    }

    //generate random number
    public static int generateRandomNumber() {
        return (int)(Math.random() * 5000 + 1);
    }

    //mouse over element
    public void mouseOverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    //click and hold element
    public void clickAndHold(WebElement element){
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }

    //click and hold locator
    public void clickAndHold(By by){
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(by)).build().perform();
    }

    //drag and drop element
    public void dragAndDropElement(WebElement fromElement, WebElement toElement){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(fromElement,toElement).release().perform();
    }

    //drag and drop element
    public void dragAndDropElement(WebElement element){
        Actions actions = new Actions(driver);
        driver.switchTo().frame(1);
        actions.dragAndDropBy(element,135,40).build().perform();
    }

    //verify that element is displayed
    public boolean verifyThatElementIsDisplayed(By by){
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    //verify that text is displayed
    public boolean verifyThatTextIsDisplayed(By by, String text){
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())){
            return true;
        }else {
            return false;
        }
    }

  /*  public void waitUntilPresenceOfElementLocated(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilPresenceOfElementClickable(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilVisibilityOfElementLocated(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
*/
}
