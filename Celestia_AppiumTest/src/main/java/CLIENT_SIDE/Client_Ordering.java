package CLIENT_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class Client_Ordering {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void clientCategoryProductSelectionTest() throws Exception {
        Client client = new Client();
        driver = client.client_login();

        // Navigate to "Meat" category
        selectCategory("android:id/Category_Meat", "Meat");

        // Choose "Kiniing" product under "Meat"
        selectProduct("android:id/ProductCard_Kiniing", "Kiniing");

        // Adjust quantity to 12 kg
        adjustQuantity(12);

        // Confirm the order
        confirmOrder();
    }

    private void selectCategory(String categoryTestTag, String categoryName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            // Wait for the element to be visible and clickable
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id(categoryTestTag)));
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id(categoryTestTag))).click();
            System.out.println("Selected the " + categoryName + " category.");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + categoryTestTag);
            driver.navigate().back();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id(categoryTestTag))).click();
            System.out.println("Retried and selected the " + categoryName + " category.");
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for " + categoryName + " category to be clickable.");
        }
    }

    private void selectProduct(String productTestTag, String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Wait for the product element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id(productTestTag))).click();
            System.out.println("Selected the " + productName + " product.");
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for " + productName + " product to be clickable.");
        }
    }

    private void adjustQuantity(int targetQuantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the quantity input field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/QuantityInputField")));

        // Set the quantity by finding the input field and adjusting it
        driver.findElement(AppiumBy.id("android:id/QuantityInputField")).clear();
        driver.findElement(AppiumBy.id("android:id/QuantityInputField")).sendKeys(String.valueOf(targetQuantity));

        System.out.println("Adjusted quantity to " + targetQuantity + " kg.");
    }

    private void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Click on the Confirm Order button
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/ConfirmOrderButton"))).click();
        System.out.println("Clicked Confirm Order button.");

        // Wait for the order confirmation to succeed
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/OrderStateSuccess")));
        System.out.println("Order confirmed successfully.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
