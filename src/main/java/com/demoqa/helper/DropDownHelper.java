package com.demoqa.helper;

import com.demoqa.entities.Employee;
import com.demoqa.pages.PracticeFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {

    public WebDriver driver;
    public DropDownHelper(WebDriver driver){
        this.driver = driver;
    }

    public DropDownHelper selectByVisibleText(WebElement element, String value){

        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }
}
