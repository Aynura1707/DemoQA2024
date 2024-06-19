package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    public WebElementActions webElementActions = new WebElementActions();
    public WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
    Random random = new Random();
    }

