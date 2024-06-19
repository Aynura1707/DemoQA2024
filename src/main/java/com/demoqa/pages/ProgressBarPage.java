package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class ProgressBarPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'progress-bar')]")
    public WebElement progressBarValue;

    @FindBy(xpath = "//*[contains(@class,'btn-primary')]")
    public WebElement progressBarStart;

    public void startAndStopProgressBar() throws InterruptedException {
        webElementActions.click(progressBarStart);
        webElementActions.waitElementToBeVisible(progressBarValue);
        while (!(Integer.parseInt(progressBarValue.getText().replace("%", "")) >= 52)) {
            Thread.sleep(100);
        }
        webElementActions.click(progressBarStart);
        int actualProgressBarValue = Integer.parseInt(progressBarValue.getText().replace("%", ""));
        assertTrue(actualProgressBarValue >= 50 && actualProgressBarValue < 55);
    }
}

