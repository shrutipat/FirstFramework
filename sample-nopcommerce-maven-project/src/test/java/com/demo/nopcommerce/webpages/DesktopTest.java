package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.pageobject.BuildYourOwnPage;
import com.demo.nopcommerce.pageobject.ComputerPage;
import com.demo.nopcommerce.pageobject.DesktopPage;
import com.demo.nopcommerce.pageobject.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DesktopTest extends TestBase {

    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnPage buildYourOwnPage = new BuildYourOwnPage();


    @Test
    public void userShouldNavigateToBuildYourOwnPageSuccessfully() {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(600);
        desktopPage.clickOnAddToCartBtn();
        String actualText = buildYourOwnPage.getBuildYourOwnText();
        String expectedText = "Build your own computer";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void desktopShouldAddToBasketSuccessfully() throws InterruptedException {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(600);
        desktopPage.clickOnAddToCartBtn();
        Thread.sleep(2000);
        buildYourOwnPage.scrollUpDown(500);
        Thread.sleep(3000);
        buildYourOwnPage.clickOnHdd320GB();
        buildYourOwnPage.scrollUpDown(200);
        buildYourOwnPage.clickOnAddtoCart();
        Thread.sleep(2000);
        Assert.assertTrue(buildYourOwnPage.checkIfItemIsAddedSuccessfully());
    }

    @Test
    public void sortByZtoAShouldWorkSuccessfullyOnDesktopPage() throws InterruptedException {
        homePage.clickOnComputers();
        computerPage.clickOnDesktopImage();
        desktopPage.scrollUpDown(500);
        Thread.sleep(3000);
        //fetch and store list of items in array list
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='item-grid']/descendant::h2[@class='product-title']"));

        // Assign titles to String Array List
        ArrayList<String> sortedNames = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            sortedNames.add(list.get(i).getText());
        }

        // Re-arrange the original String Array in descending order
        Collections.sort(sortedNames, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.valueOf(s2.compareTo(s1));
            }
        });

        desktopPage.clickOnSortByDropDown();
        desktopPage.select_ZToA();
        desktopPage.scrollUpDown(500);
        Thread.sleep(1000);
        List<WebElement> listZToA = driver.findElements(By.xpath("//div[@class='item-grid']/descendant::h2[@class='product-title']"));
        Thread.sleep(1000);

        //verify that is sorted names is matching actual names after clicking Z to A
        for (int i = 0; i < listZToA.size(); i++) {
            Assert.assertEquals(sortedNames.get(i), listZToA.get(i).getText());
        }
    }
}