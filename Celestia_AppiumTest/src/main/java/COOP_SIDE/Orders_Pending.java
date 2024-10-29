package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Orders_Pending {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = DriverConfig.getDriver();
    }

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //login
        Coop coop = new Coop();
        driver = coop.coop_login();


        String ORDERS_PAGE = "android:id/ordersPage";
        String PENDING_BUTTON = "android:id/PendingButton";
        String FIRST_ORDER_ON_LIST = "android:id/OrderItem_1";

        String REJECT_BUTTON = "android:id/RejectButton";
        String RejectOrderDialog_CANCEL_BUTTON = "android:id/PendingOrderDismissButton";
        String RejectOrderDialog_REJECT_BUTTON = "android:id/PendingOrderConfirmButton";

        String ACCEPT_BUTTON = "android:id/AcceptButton";
        String AcceptOrderDialog_CANCEL_BUTTON = "android:id/PendingOrderDismissButton";
        String AcceptOrderDialog_ACCEPT_BUTTON = "android:id/PendingOrderConfirmButton";

        //navigate to Orders Page
        driver.findElement(AppiumBy.id(ORDERS_PAGE)).click();

        //click on Pending Button
        driver.findElement(AppiumBy.id(PENDING_BUTTON)).click();

        //click on X icon then cancel order
        driver.findElement(AppiumBy.id(FIRST_ORDER_ON_LIST)).click();
        driver.findElement(AppiumBy.id(REJECT_BUTTON)).click();
        driver.findElement(AppiumBy.id(RejectOrderDialog_CANCEL_BUTTON)).click();

        //click on Reject then Reject order
        driver.findElement(AppiumBy.id(FIRST_ORDER_ON_LIST)).click();
        driver.findElement(AppiumBy.id(REJECT_BUTTON)).click();
        driver.findElement(AppiumBy.id(RejectOrderDialog_REJECT_BUTTON)).click();

        //click on Check icon then cancel order
        driver.findElement(AppiumBy.id(FIRST_ORDER_ON_LIST)).click();
        driver.findElement(AppiumBy.id(ACCEPT_BUTTON)).click();
        driver.findElement(AppiumBy.id(AcceptOrderDialog_CANCEL_BUTTON)).click();

        //click on Check icon then accept order
        driver.findElement(AppiumBy.id(FIRST_ORDER_ON_LIST)).click();
        driver.findElement(AppiumBy.id(ACCEPT_BUTTON)).click();
        driver.findElement(AppiumBy.id(AcceptOrderDialog_ACCEPT_BUTTON)).click();
    }
}
