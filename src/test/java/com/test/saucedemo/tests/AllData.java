package com.test.saucedemo.tests;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name="negativeLogin")
    public Object[][] getUserInfo(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"standard","secret","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @DataProvider(name="TestProductLinks")
    public Object[][] getProductData(){
        return new Object[][]{
                {"Sauce Labs Backpack", "Sly Pack", "$29.99",new String[]{"Jay","Alex","60001"},"Thank you for your order!"},
                {"Sauce Labs Bike Light", "3 lighting modes", "$9.99",new String[]{"M","O","60016"},"Thank you for your order!"},
                {"Sauce Labs Bolt T-Shirt", "100% ringspun combed cotton", "$15.99",new String[]{"BO","Ne","60018"},"Thank you for your order!"},
                {"Sauce Labs Fleece Jacket", "fleece jacket", "$49.99",new String[]{"Muru","Ochi","60061"},"Thank you for your order!"},
                {"Sauce Labs Onesie", "Reinforced 3-snap bottom closure", "$7.99",new String[]{"Hello","Ho","60001"},"Thank you for your order!"},
                {"Test.allTheThings() T-Shirt (Red)", "Super-soft and comfy ringspun combed cotton", "$15.99",new String[]{"Jay","Alex","60001"},"Thank you for your order!"},
        };
    }
}
