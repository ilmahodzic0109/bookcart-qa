package com.bookcartqa.tests;

import com.bookcartqa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void testSearch() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search books or authors']")).sendKeys("Harry Potter and the Chamber of Secrets");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Harry Potter and the Chamber of Secrets')]")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("Harry Potter and the Chamber of Secrets"), "Book detail page not loaded correctly.");
    }
}
