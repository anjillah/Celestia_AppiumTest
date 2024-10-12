package FARMER_SIDE;

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

public class FarmerNavigationTest {
    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void farmerNavigationTest() throws Exception {
        // Login
        Farmer farmerConstants = new Farmer();
        driver = farmerConstants.farmer_login();

        // === From Dashboard ===
        navigateAndBackWithDelay("android:id/ordersPage", "Orders", "android:id/dashboardPage", "Dashboard"); // Dashboard -> Orders -> Back
        navigateAndBackWithDelay("android:id/itemsPage", "Items", "android:id/dashboardPage", "Dashboard");   // Dashboard -> Items -> Back
        navigateAndBackWithDelay("android:id/profilePage", "Profile", "android:id/dashboardPage", "Dashboard"); // Dashboard -> Profile -> Back

        // === From Orders ===
        navigateToPageWithDelay("android:id/ordersPage", "Orders");
        navigateAndBackWithDelay("android:id/dashboardPage", "Dashboard", "android:id/ordersPage", "Orders");  // Orders -> Dashboard -> Back
        navigateAndBackWithDelay("android:id/itemsPage", "Items", "android:id/ordersPage", "Orders");          // Orders -> Items -> Back
        navigateAndBackWithDelay("android:id/profilePage", "Profile", "android:id/ordersPage", "Orders");      // Orders -> Profile -> Back

        // === From Items ===
        navigateToPageWithDelay("android:id/itemsPage", "Items");
        navigateAndBackWithDelay("android:id/dashboardPage", "Dashboard", "android:id/itemsPage", "Items");    // Items -> Dashboard -> Back
        navigateAndBackWithDelay("android:id/ordersPage", "Orders", "android:id/itemsPage", "Items");          // Items -> Orders -> Back
        navigateAndBackWithDelay("android:id/profilePage", "Profile", "android:id/itemsPage", "Items");        // Items -> Profile -> Back

        // === End Test by Staying on Profile ===
        navigateToPageWithDelay("android:id/profilePage", "Profile");  // Ensure we end on Profile page and stay there
        Thread.sleep(5000);
    }

    // Helper method to confirm the current page and wait for 2-3 seconds before navigating back
    private void confirmPageDisplayedWithDelay(String elementId, String pageName) throws InterruptedException {
        waitForElementVisible(elementId);  // Wait until the element is visible
        boolean isOnPage = driver.findElement(AppiumBy.id(elementId)).isDisplayed();
        if (isOnPage) {
            System.out.println("User is on the " + pageName + " page.");
            Thread.sleep(1000);  // Delay for ? seconds on the page to ensure it's visible
        } else {
            System.out.println("User is NOT on the " + pageName + " page.");
        }
    }

    // Helper method for navigation and confirmation of page with delay
    private void navigateToPageWithDelay(String elementId, String pageName) throws InterruptedException {
        driver.findElement(AppiumBy.id(elementId)).click();
        confirmPageDisplayedWithDelay(elementId, pageName);
    }

    // Helper method to navigate to a page, wait, and then use the back button to return
    private void navigateAndBackWithDelay(String navigateToId, String pageName, String backToId, String backPageName) throws InterruptedException {
        // Navigate to the page and wait
        navigateToPageWithDelay(navigateToId, pageName);

        // Use back button to return to the previous page and wait
        driver.navigate().back();
        confirmPageDisplayedWithDelay(backToId, backPageName);
    }

    // Wait for element to be visible
    private void waitForElementVisible(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id(elementId)));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
