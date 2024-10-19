package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.sql.SQLOutput;
import java.time.Duration;

public class CoopNavigationTest {

    AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }


    @Test
    public void coopNavigationTest() throws Exception {
        Coop coop = new Coop();
        driver = coop.coop_login();

        String dashboardPage = "android:id/dashboardPage";
        String ordersPage = "android:id/ordersPage";
        String itemsPage = "android:id/itemsPage";
        String profilePage = "android:id/profilePage";

        // === From Dashboard ===
        System.out.println("Dashboard to other Pages");
        navigateAndBackWithDelay(ordersPage, "Orders", dashboardPage, "Dashboard"); // Dashboard -> Orders -> Back
        navigateAndBackWithDelay(itemsPage, "Items", dashboardPage, "Dashboard");   // Dashboard -> Items -> Back
        navigateAndBackWithDelay(profilePage, "Profile", dashboardPage, "Dashboard"); // Dashboard -> Profile -> Back

        // === From Orders ===
        System.out.println("Orders page to other pages");
        navigateToPageWithDelay(ordersPage, "Orders");
        navigateAndBackWithDelay(dashboardPage, "Dashboard", ordersPage, "Orders");  // Orders -> Dashboard -> Back
        navigateAndBackWithDelay(itemsPage, "Items", ordersPage, "Orders");          // Orders -> Items -> Back
        navigateAndBackWithDelay(profilePage, "Profile", ordersPage, "Orders");      // Orders -> Profile -> Back

        // === From Items ===
        System.out.println("Items page to other pages");
        navigateToPageWithDelay(itemsPage, "Items");
        navigateAndBackWithDelay(dashboardPage, "Dashboard", "android:id/itemsPage", "Items");    // Items -> Dashboard -> Back
        navigateAndBackWithDelay(ordersPage, "Orders", "android:id/itemsPage", "Items");          // Items -> Orders -> Back
        navigateAndBackWithDelay(profilePage, "Profile", "android:id/itemsPage", "Items");        // Items -> Profile -> Back

        // === End Test by Staying on Profile ===
//        navigateToPageWithDelay(profilePage, "Profile");  // Ensure we end on Profile page and stay there
        Thread.sleep(5000);

        //logout
//        driver = coop.farmer_logout();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id(elementId)));
    }

    @AfterTest
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
