package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TextBox {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ainur\\IdeaProjects\\HTML\\src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }

    }

    @Test
    void fillBlank() throws InterruptedException {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Aynura");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("aida.aseinovich@gmail.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Chokmorova street 58");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Svrdlovskyi rayon");
        WebElement submitButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        scrollToElement(submitButton).click();
//        Assert.assertEquals();

    }

    public WebElement scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    void textBoxFullName() throws InterruptedException {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Aynura");
    }

    @Test
    void textBoxEmail() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("ainurakojokmatova@gmail.com");

    }

    @Test
    void textBoxCurrentAddress() {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Salieva street 229/3");
    }

}

