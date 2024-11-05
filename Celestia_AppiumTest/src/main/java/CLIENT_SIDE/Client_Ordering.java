package CLIENT_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
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
        selectProduct("android:id/ProductTypeCard_Kiniing", "Kiniing");

        // Adjust quantity to 12 kg
        adjustQuantity(12);

        // Set the target date to November 30
        selectTargetDate("November 30");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Wait for the quantity input field to be visible
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/QuantityInputField"))); // Adjusted ID

            // Interact with the quantity input field
            WebElement quantityInputField = driver.findElement(AppiumBy.id("android:id/QuantityInputField"));
            quantityInputField.clear();
            quantityInputField.sendKeys(String.valueOf(targetQuantity));
            System.out.println("Adjusted quantity to " + targetQuantity + " kg.");
        } catch (TimeoutException e) {
            System.err.println("Quantity input field not found within timeout: " + e.getMessage());
        } catch (WebDriverException e) {
            System.err.println("An error occurred while interacting with the quantity input: " + e.getMessage());
        }
    }

    private void selectTargetDate(String targetDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Open the date picker
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/DateIconButton"))).click();

        // Wait for the date options to be displayed and click on the specific date
        // Assuming you need to find the button for November 30
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[contains(@text,'30')]"))).click();

        System.out.println("Selected target date: " + targetDate);
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
