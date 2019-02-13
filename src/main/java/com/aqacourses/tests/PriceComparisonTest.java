package com.aqacourses.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PriceComparisonTest {

    // Instance of WebDriver
    private WebDriver driver;

    /**
     * Set up method
     */
    @Before
    public void setUp() {

        // Disable infobars
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 5 seconds for implicitly wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();
    }

    /**
     * Open https://supsystic.com/example/comparison-example/ page, find current price and price without discount, calculate difference
     * and print current price, price without discount and difference to console
     */
    @Test
    public void testPriceComparisonTest() {

        // Open page
        driver.get("https://supsystic.com/example/comparison-example/");

        // Get and print price to console for Samsung Galaxy S6
        String price = driver.findElement(By.xpath("//span[contains(text(),'$959.00')]")).getAttribute("innerHTML");
        System.out.println("Price for Samsung Galaxy S6 = " + price);

        // Get and print price without discount to console for Samsung Galaxy S6
        String priceWithoutDiscount = driver.findElement(By.xpath("//span[contains(text(),'$2699')]")).getAttribute("innerHTML");
        System.out.println("Price without discount for Samsung Galaxy S6 = " + priceWithoutDiscount);

        // Calculate and print difference between prices to console for Samsung Galaxy S6
        float difference = Float.valueOf(price.substring(1)) - Float.valueOf(priceWithoutDiscount.substring(1));
        System.out.println("Difference between prices = " + difference);

    }

    /**
     * After method, quit driver
     */
    @After
    public void tearDown() {

        // Quit from Driver - close all window an driver
        driver.quit();
    }

}
