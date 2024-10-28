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
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void farmerNavigationTest() throws Exception {
        Farmer farmerConstants = new Farmer();
        driver = farmerConstants.farmer_login();

        // Dashboard to other pages and back
        navigateAndBack("android:id/ordersPage", "Orders");
        navigateAndBack("android:id/itemsPage", "Items");
        navigateAndBack("android:id/profilePage", "Profile");

        // Orders to other pages and back
        navigateToPage("android:id/ordersPage", "Orders");
        navigateAndBack("android:id/dashboardPage", "Dashboard");
        navigateAndBack("android:id/itemsPage", "Items");
        navigateAndBack("android:id/profilePage", "Profile");

        // Items to other pages and back
        navigateToPage("android:id/itemsPage", "Items");
        navigateAndBack("android:id/dashboardPage", "Dashboard");
        navigateAndBack("android:id/ordersPage", "Orders");
        navigateAndBack("android:id/profilePage", "Profile");

        // Profile to other pages and back
        navigateToPage("android:id/profilePage", "Profile");
        navigateAndBack("android:id/dashboardPage", "Dashboard");
        navigateAndBack("android:id/ordersPage", "Orders");
        navigateAndBack("android:id/itemsPage", "Items");

        // Stay on Profile page
        navigateToPage("android:id/profilePage", "Profile");
        Thread.sleep(5000);

        // Logout
        farmerConstants.farmer_logout();
    }

    // Helper method to navigate to a page and go back to the previous page
    private void navigateAndBack(String elementId, String pageName) {
        if (navigateToPage(elementId, pageName)) {
            driver.navigate().back();
            System.out.println("Navigated back to the previous page from " + pageName + " page.");
        }
    }

    // Helper method to navigate to a page and confirm it is displayed
    private boolean navigateToPage(String elementId, String pageName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id(elementId))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id(elementId)));
            System.out.println("User is on the " + pageName + " page.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to navigate to the " + pageName + " page.");
            return false;
        }
    }

    @AfterTest
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}