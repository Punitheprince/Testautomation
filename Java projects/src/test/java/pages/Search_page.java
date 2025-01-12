package pages;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import tests.BaseClass;

public class Search_page extends BaseClass
{
	@Test
    public void pagesetup() throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement dontAllowButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("com.android.permissioncontroller:id/permission_deny_button")));
    	
        dontAllowButton.click();
 
        WebElement skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.flipkart.android:id/custom_back_icon']"));
        skipBtn.click();
        
 
    }
	
    @Test
    public void search_items() throws InterruptedException, IOException {
      
   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	

    	WebElement search_field_1 = wait.until(
    	        ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"tv\"]")));
    	search_field_1.click();
    	super.attachscreenshot();
    	
    	WebElement search_field_2 = wait.until(
    	        ExpectedConditions.presenceOfElementLocated(By.className("android.widget.EditText")));
    	search_field_2.sendKeys("Tshirts");
    	super.attachscreenshot();
    	
    	
    	WebElement recomended_product = wait.until(
    	        ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"tshirts for boys\"]")));
    	recomended_product.click();
    	super.attachscreenshot();
    	
    	
    }
}
