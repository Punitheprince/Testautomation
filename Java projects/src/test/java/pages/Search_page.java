package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import tests.BaseClass;

public class Search_page extends BaseClass {

    @Test
    public void pagesetup() throws InterruptedException {
        // Initialize logging for this test
        Logger_start("Search Test", "Test for searching items");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dontAllowButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("com.android.permissioncontroller:id/permission_deny_button")));
        dontAllowButton.click();

        WebElement skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.flipkart.android:id/custom_back_icon']"));
        skipBtn.click();
    }

    @Test
    public void search_items() throws InterruptedException, IOException {
    	
        test.log(Status.INFO, "Search item test started");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement search_field_1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"tv\"]")));
        search_field_1.click();
        attachscreenshot(); 

        WebElement search_field_2 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("android.widget.EditText")));
        search_field_2.sendKeys("Tshirts");
        attachscreenshot(); // Attach screenshot after entering text

        WebElement recommended_product = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"tshirts for boys\"]")));
        recommended_product.click();
        attachscreenshot(); // Attach screenshot after clicking recommended product

        test.log(Status.PASS, "Search test passed successfully");
    }
}
