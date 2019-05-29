package com.demo.nopcommerce.resources.testdata;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "inputs")
    public Object [][] getData(){
        return new Object[][]{
                {"test1111@gmail.com", "123test123"},
                {"test2222@gmai1.com", "123test234"},
                {"test3333@gmail.com", "123test345"}
        };
    }
}