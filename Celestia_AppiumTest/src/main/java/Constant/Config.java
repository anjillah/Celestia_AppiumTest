package Constant;

/**
 * Class to hold constants
 */
public class Config {
    public static final String PLATFORM_NAME = "Android";
    public static final String AUTOMATION_NAME = "uiautomator2";
    public static String APP_PATH = System.getProperty("user.dir") + "\\apps\\app-debug.apk";

    public static String appiumServerURL = "http://127.0.0.1:4723";


    //LOGIN PATHS
    //NOTE to self: contentDesc cant be used because it's not clickable
    public static final String EmailField_AppiumId = "android:id/emailField";

    public static final String PasswordField_AppiumId = "android:id/passwordField";

    public static final String LoginButton_AppiumId = "android:id/loginButton";


    //LOGOUT PATHS
    public static final String LogoutButton_AppiumId = "android:id/logoutButton";

    public static final String CancelLogoutButton_Appium_xpath = "//android.view.ViewGroup/android.view.View/android.view.View/" +
            "android.view.View/android.view.View/android.view.View[1]";

    public static final String ConfirmLogoutButton_Appium_xpath = "//android.view.ViewGroup/android.view.View/android.view.View/" +
            "android.view.View/android.view.View/android.view.View[2]";
}