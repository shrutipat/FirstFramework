package com.demo.nopcommerce.webpages;

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pageobject.HomePage;
import com.demo.nopcommerce.pageobject.LoginPage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingExcel extends TestBase {
    public static final String File_Path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\demo\\nopcommerce\\resources\\testdata\\ExcelData.xlsx";

    @BeforeClass
    public void setExcel(){
        // Tell the code about the location of Excel file
        try {
            ExcelUtility.setExcelFile(File_Path, "LoginTests");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider="loginData")
    public void testUsingExcel(String email, String password)  {

        new HomePage().clickOnLoginLink();
        new LoginPage().loginToApplication(email, password);
    }
}