package com.aqacourses.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SymbolSearchTest {

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
     * Open https://unicode-table.com/ru/ page, find symbols Q, & and A and print them to console
     */
    @Test
    public void testSymbolSearchTest() {

        // Open page
        driver.get("https://unicode-table.com/ru/");

        // Find and print symbol Q to console
        System.out.println(driver.findElement(By.xpath("//li[@title='U+0051 | Dec: 81']")).getText());

        // Find and print symbol & to console
        System.out.println(driver.findElement(By.xpath("//li[@title='U+0026 | Dec: 38']")).getText());

        // Find and print symbol A to console
        System.out.println(driver.findElement(By.xpath("//li[@title='U+0041 | Dec: 65']")).getText());

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
