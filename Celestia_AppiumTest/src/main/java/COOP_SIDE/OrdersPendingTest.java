package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class OrdersPendingTest {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void test() throws Exception {
        // login
        Coop coop = new Coop();
        driver = coop.coop_login();

        // Element IDs
        String ORDERS_PAGE = "android:id/ordersPage";
        String PENDING_BUTTON = "android:id/PendingButton";
        String FIRST_ORDER_ON_LIST = "android:id/OrderItem_1";

        String REJECT_BUTTON = "android:id/RejectButton";
        String RejectOrderDialog_CANCEL_BUTTON = "android:id/PendingOrderDismissButton";
        String RejectOrderDialog_REJECT_BUTTON = "android:id/PendingOrderConfirmButton";

        String ACCEPT_BUTTON = "android:id/AcceptButton";
        String AcceptOrderDialog_CANCEL_BUTTON = "android:id/PendingOrderDismissButton";
        String AcceptOrderDialog_ACCEPT_BUTTON = "android:id/PendingOrderConfirmButton";

        // Navigate to Orders Page
        driver.findElement(AppiumBy.id(ORDERS_PAGE)).click();

        // Click on Pending Button
        driver.findElement(AppiumBy.id(PENDING_BUTTON)).click();

        // Check if there are any orders in the list
        List<WebElement> orders = driver.findElements(AppiumBy.id(FIRST_ORDER_ON_LIST));
        if (orders.isEmpty()) {
            // No orders found, proceed to logout
            System.out.println("No orders found. Proceeding to logout...");
            coop.coop_logout();
        } else {
            // Iterate over each order in the list
            for (WebElement order : orders) {
                // Click on the first order in the list
                order.click();

                // Reject order - Cancel the reject
                driver.findElement(AppiumBy.id(REJECT_BUTTON)).click();
                driver.findElement(AppiumBy.id(RejectOrderDialog_CANCEL_BUTTON)).click();

                // Reject order - Confirm the reject
                driver.findElement(AppiumBy.id(REJECT_BUTTON)).click();
                driver.findElement(AppiumBy.id(RejectOrderDialog_REJECT_BUTTON)).click();

                // After rejection, check if there are still orders in the list
                orders = driver.findElements(AppiumBy.id(FIRST_ORDER_ON_LIST));
                if (orders.isEmpty()) {
                    System.out.println("No more orders available after rejection. Proceeding to logout...");
                    break;
                }

                // Click on the first order in the list again
                orders.get(0).click();

                // Accept order - Cancel the acceptance
                driver.findElement(AppiumBy.id(ACCEPT_BUTTON)).click();
                driver.findElement(AppiumBy.id(AcceptOrderDialog_CANCEL_BUTTON)).click();

                // Accept order - Confirm the acceptance
                driver.findElement(AppiumBy.id(ACCEPT_BUTTON)).click();
                driver.findElement(AppiumBy.id(AcceptOrderDialog_ACCEPT_BUTTON)).click();

                // Check again if there are more orders
                orders = driver.findElements(AppiumBy.id(FIRST_ORDER_ON_LIST));
                if (orders.isEmpty()) {
                    System.out.println("No more orders available after acceptance. Proceeding to logout...");
                    break;
                }
            }

            // Proceed to logout after processing all orders
//            coop.coop_logout();
        }
    }
}