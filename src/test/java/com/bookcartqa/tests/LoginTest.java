package com.bookcartqa.tests;

import com.bookcartqa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testCheckoutFlow() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' Login ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("ilmexx");
        driver.findElement(By.id("mat-input-1")).sendKeys("Ilma1234");
        driver.findElement(By.xpath("//form//span[text()='Login']")).click();
        Thread.sleep(2000);
        boolean isWishlistVisible = driver.findElement(By.xpath("//mat-icon[text()='favorite']")).isDisplayed();
        Assert.assertTrue(isWishlistVisible, "Login failed – Wishlist icon not visible.");
    }
}
