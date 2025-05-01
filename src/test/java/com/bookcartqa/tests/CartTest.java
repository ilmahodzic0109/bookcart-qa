package com.bookcartqa.tests;

import com.bookcartqa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddBookToCart() throws InterruptedException {
        login("ilmexx", "Ilma1234");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-icon[text()='shopping_cart']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Cart"), "Cart page not displayed correctly.");
    }
}
