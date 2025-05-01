package com.bookcartqa.tests;

import com.bookcartqa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutFlow() throws InterruptedException {
        login("ilmexx", "Ilma1234");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[text()='shopping_cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' CheckOut ']")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Ilma");
        driver.findElement(By.cssSelector("input[placeholder='Address Line 1']")).sendKeys("Test 123");
        driver.findElement(By.cssSelector("input[placeholder='Address Line 2']")).sendKeys("Near Markale");
        driver.findElement(By.cssSelector("input[placeholder='Pincode']")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[placeholder='State']")).sendKeys("Sarajevo");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()=' Place Order ']")).click();

        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/myorders"), "Failed to reach My Orders page after placing order.");
    }
}
