package COOP_SIDE;

import Constant.DriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrdersPreparingTest {
    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverConfig.getDriver();

        //login
        Coop coop = new Coop();
        driver = coop.coop_login();
    }

    @Test
    public void test(){
        //navigations
        String ORDERS_PAGE = "android:id/ordersPage";
        String PREPARING_BUTTON = "android:id/PreparingButton";
        String DELIVERY_BUTTON = "android:id/DeliveringButton";

        //Card Details
        String CARD = "android:id/OrderItem_1";
        String OrderID = "android:id/OrderID_1";
        String OrderDetails = "android:id/OrderDetailsText_1";
        String ClientName = "android:id/ClientName_1";
        String OrderStatus = "android:id/OrderStatus_1";
        String OrderAddress = "android:id/OrderAddress_1";
        String DateOrdered = "android:id/OrderDate_1";

        //SHIPPING STATUS
        String ShipOrderText = "android:id/ShipOrderText";
        String SHIP_ORDER_ACTION = "android:id/ShipOrderButton";
        //Dialog when ship order has been clicked
        String CancelUpdateStatus = "android:id/UpdateStatusDismissButton";
        String SaveUpdateStatus = "android:id/UpdateStatusConfirmButton";

        //DELIVERY STATUS
        String DeliveringStatusText = "android:id/OrderDeliveryText";


        // Navigate to Orders screen
        driver.findElement(AppiumBy.id(ORDERS_PAGE)).click();

        // Navigate to Preparing tab
        driver.findElement(AppiumBy.id(PREPARING_BUTTON)).click();

        // Retrieve and store the details from the Preparing tab
        String cardText = driver.findElement(AppiumBy.id(CARD)).getText();
        String orderIDText = driver.findElement(AppiumBy.id(OrderID)).getText();
        String orderDetailsText = driver.findElement(AppiumBy.id(OrderDetails)).getText();
        String clientNameText = driver.findElement(AppiumBy.id(ClientName)).getText();
        String orderStatusText = driver.findElement(AppiumBy.id(OrderStatus)).getText(); // should be equal to "Preparing"
        String orderAddressText = driver.findElement(AppiumBy.id(OrderAddress)).getText();
        String dateOrderedText = driver.findElement(AppiumBy.id(DateOrdered)).getText();
        String shipOrderText = driver.findElement(AppiumBy.id(ShipOrderText)).getText();

        // Check that the order status should be Preparing
        Assert.assertEquals(orderStatusText, "Preparing", "Order status should be 'Preparing' but is: " + orderStatusText);

        // Print retrieved details
        System.out.println("==========   PREPARING TAB   ==========");
        System.out.println("Card: " + cardText);
        System.out.println("Order ID: " + orderIDText);
        System.out.println("Order Details: " + orderDetailsText);
        System.out.println("Client Name: " + clientNameText);
        System.out.println("Order Status: " + orderStatusText);
        System.out.println("Order Address: " + orderAddressText);
        System.out.println("Date Ordered: " + dateOrderedText);
        System.out.println("Ship Order: " + shipOrderText);

        // Update status of order
        driver.findElement(AppiumBy.id(SHIP_ORDER_ACTION)).click();

        // Test if cancel update status is working
        driver.findElement(AppiumBy.id(CancelUpdateStatus)).click();

        // Test if save update status is working
        driver.findElement(AppiumBy.id(SHIP_ORDER_ACTION)).click();
        driver.findElement(AppiumBy.id(SaveUpdateStatus)).click();

        // After saving status update, click on Delivering tab
        driver.findElement(AppiumBy.id(DELIVERY_BUTTON)).click();

        // Retrieve the details from the Delivering tab using the same IDs
        String DEL_cardText = driver.findElement(AppiumBy.id(CARD)).getText();
        String DEL_orderIDText = driver.findElement(AppiumBy.id(OrderID)).getText();
        String DEL_orderDetailsText = driver.findElement(AppiumBy.id(OrderDetails)).getText();
        String DEL_clientNameText = driver.findElement(AppiumBy.id(ClientName)).getText();
        String DEL_orderStatusText = driver.findElement(AppiumBy.id(OrderStatus)).getText(); // should be equal to "Delivering"
        String DEL_orderAddressText = driver.findElement(AppiumBy.id(OrderAddress)).getText();
        String DEL_dateOrderedText = driver.findElement(AppiumBy.id(DateOrdered)).getText();
        String DEL_DeliveringStatus = driver.findElement(AppiumBy.id(DeliveringStatusText)).getText();

        // Check that the order status should be Delivering
        Assert.assertEquals(DEL_orderStatusText, "Delivering", "Order status should be 'Delivering' but is: " + DEL_orderStatusText);

        // Compare all other details to ensure they are the same
        Assert.assertEquals(DEL_cardText, cardText, "Card text should match");
        Assert.assertEquals(DEL_orderIDText, orderIDText, "Order ID should match");
        Assert.assertEquals(DEL_orderDetailsText, orderDetailsText, "Order details should match");
        Assert.assertEquals(DEL_clientNameText, clientNameText, "Client name should match");
        Assert.assertEquals(DEL_orderAddressText, orderAddressText, "Order address should match");
        Assert.assertEquals(DEL_dateOrderedText, dateOrderedText, "Date ordered should match");

        // Print retrieved details from Delivering tab
        System.out.println("==========   DELIVERING TAB   ==========");
        System.out.println("Card: " + DEL_cardText);
        System.out.println("Order ID: " + DEL_orderIDText);
        System.out.println("Order Details: " + DEL_orderDetailsText);
        System.out.println("Client Name: " + DEL_clientNameText);
        System.out.println("Order Status: " + DEL_orderStatusText);
        System.out.println("Order Address: " + DEL_orderAddressText);
        System.out.println("Date Ordered: " + DEL_dateOrderedText);
        System.out.println("Deliver Status: " + DEL_DeliveringStatus);
    }
}
