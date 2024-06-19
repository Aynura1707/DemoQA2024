package com.demoqa.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomeWorkTest  {
//    String name = "Aynura";
//    String email = "ainurakojokmatova@gmail.com";
//    String address = "Salieva 229/3";
//    String street = "Sverdlovskiy rayon";

//    @Test
//    @Description("Регистрация пользователя")
//    void registrationTest() throws InterruptedException {
//        WebElement searchInput = driver.findElement(By.xpath("//*[@placeholder='Full Name']"));
//        WebElement emailInputField = driver.findElement(By.xpath("//*[@placeholder='name@example.com']"));
//        WebElement currAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
//        WebElement permAddress = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
//        WebElement submitBtn = driver.findElement(By.xpath("//*[@id='submit']"));
//
//        searchInput.sendKeys(name);
//        emailInputField.sendKeys(email);
//        currAddress.sendKeys(address);
//        permAddress.sendKeys(street);
//        scrollToElement(submitBtn);
//        submitBtn.click();
//
//        WebElement borderName = driver.findElement(By.xpath("//*[@id='name']"));
//        WebElement borderEmail = driver.findElement(By.xpath("//*[@id='email']"));
//        WebElement borderCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
//        WebElement borderPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
//
//        scrollToElement(borderPermanentAddress);
//        sleep(5000);
//
//
//        Assert.assertTrue(borderName.getText().contains(name));
//        Assert.assertTrue(borderEmail.getText().contains(email));
//        System.out.println(borderCurrentAddress.getText());
//        Assert.assertTrue(borderCurrentAddress.getText().contains(address));
//        Assert.assertTrue(borderPermanentAddress.getText().contains(street));
//    }
//
//    public WebElement scrollToElement(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        return element;
//    }
}

