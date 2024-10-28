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
import java.time.Duration;

public class CoopNavigationTest {

    private AndroidDriver driver;

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

        // Dashboard to other pages and back
        navigateAndBack(dashboardPage, ordersPage, "Orders");
        navigateAndBack(dashboardPage, itemsPage, "Items");
        navigateAndBack(dashboardPage, profilePage, "Profile");

        // Orders to other pages and back
        navigateToPage(ordersPage, "Orders");
        navigateAndBack(ordersPage, dashboardPage, "Dashboard");
        navigateAndBack(ordersPage, itemsPage, "Items");
        navigateAndBack(ordersPage, profilePage, "Profile");

        // Items to other pages and back
        navigateToPage(itemsPage, "Items");
        navigateAndBack(itemsPage, dashboardPage, "Dashboard");
        navigateAndBack(itemsPage, ordersPage, "Orders");
        navigateAndBack(itemsPage, profilePage, "Profile");

        // Profile to other pages and back, then stay on Profile
        navigateToPage(profilePage, "Profile");
        navigateAndBack(profilePage, dashboardPage, "Dashboard");
        navigateAndBack(profilePage, ordersPage, "Orders");
        navigateAndBack(profilePage, itemsPage, "Items");
        navigateToPage(profilePage, "Profile"); // Stay on Profile page

        // Logout
        coop.coop_logout();
    }

    // Helper method to navigate to a page and then back to the original page
    private void navigateAndBack(String fromPageId, String toPageId, String pageName) {
        if (navigateToPage(toPageId, pageName)) {
            driver.navigate().back();
            System.out.println("Navigated back to the previous page from " + pageName + " page.");
        }
    }

    // Helper method to navigate to a page and confirm it is displayed
    private boolean navigateToPage(String elementId, String pageName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
        if (driver != null) {
            driver.quit();
        }
    }
}
