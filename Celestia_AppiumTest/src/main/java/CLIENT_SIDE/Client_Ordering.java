package CLIENT_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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
        selectCategory("Category_Meat", "Meat");

        // Choose "Kiniing" product under "Meat"
        selectProduct("ProductCard_Kiniing", "Kiniing");

        // Adjust quantity to 12 kg
        adjustQuantity(12);

        // Confirm the order
        confirmOrder();
    }

    private void selectCategory(String categoryTestTag, String categoryName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(categoryTestTag))).click();
        System.out.println("Selected the " + categoryName + " category.");
    }

    private void selectProduct(String productTestTag, String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(productTestTag))).click();
        System.out.println("Selected the " + productName + " product.");
    }

    private void adjustQuantity(int targetQuantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        int currentQuantity = Integer.parseInt(wait.until(
                ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("QuantityInputField"))).getText());

        while (currentQuantity != targetQuantity) {
            if (currentQuantity < targetQuantity) {
                driver.findElement(AppiumBy.accessibilityId("IncrementButton")).click();
            } else {
                driver.findElement(AppiumBy.accessibilityId("DecrementButton")).click();
            }
            currentQuantity = Integer.parseInt(driver.findElement(AppiumBy.accessibilityId("QuantityInputField")).getText());
        }
        System.out.println("Adjusted quantity to " + targetQuantity + " kg.");
    }

    private void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("AddOrderButton"))).click();
        System.out.println("Clicked Add Order button.");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("TargetDateInput"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("ConfirmOrderButton"))).click();
        System.out.println("Confirmed target date for the order.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("OrderStateSuccess")));
        System.out.println("Order confirmed successfully.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
