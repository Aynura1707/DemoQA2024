package com.demoqa.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class HW_23MayTest{

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ainur\\IdeaProjects\\HTML\\src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
//        sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }



    @Test
    public void openLinks() throws InterruptedException {
        WebElement mainmenu = driver.findElement(By.xpath("//*[@id='tab-01']/div/p/a/img"));
        mainmenu.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://dostavka312.kg/category/11");
        findByRestaurantName("KFC Московская");
        Assert.assertTrue(driver.getTitle().contains("KFC Московская в Бишкеке - заказ и доставка"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://dostavka312.kg/garnirygpt/kfc-moskovskaja"));
        ListOfKombo();
}

    public void findByRestaurantName(String name){
        List<WebElement> allRestaurants = driver.findElements(By.xpath("//div[@class='panel-heading']"));
        for (WebElement restaurant:allRestaurants) {
            System.out.println(restaurant.getText());
        }
        for (WebElement restaurant:allRestaurants) {
            if (restaurant.getText().contains(name)) {
                WebElement link = restaurant.findElement(By.xpath("./following-sibling::div/div/a[contains(@onclick,'ViewContent')]"));
                link.click();
                break;
            };

            }
        }
    public void ListOfKombo(){
        List<WebElement> kombo = driver.findElements(By.xpath("//div[@class='food-title']"));
        for (WebElement komboFood : kombo){
            System.out.println(komboFood.getText());
    }


    }
}
