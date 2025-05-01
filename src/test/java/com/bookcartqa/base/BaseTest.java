package com.bookcartqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected final String baseUrl = "https://bookcart.azurewebsites.net/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ilma Hodžić\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void login(String username, String password) throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' Login ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.id("mat-input-1")).sendKeys(password);
        driver.findElement(By.xpath("//form//span[text()='Login']")).click();
        Thread.sleep(2000);
    }
}
