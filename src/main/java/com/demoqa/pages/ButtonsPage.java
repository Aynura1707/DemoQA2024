package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ButtonsPage extends BasePage{


    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(id = "doubleClickMessage")
    public WebElement getDoubleClickMessage;

    @FindBy(id = "00Na9")
    public WebElement doubleClickMe;

//  public final String doubleClickMessage = DriverManager.getDriver().findElement(By.id("doubleClickMessage")).getText();
}
