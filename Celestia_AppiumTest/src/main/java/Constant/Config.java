package Constant;

/**
 * Class to hold constants
 */
public class Config {
    public static final String PLATFORM_NAME = "Android";
    public static final String AUTOMATION_NAME = "uiautomator2";
    public static String APP_PATH = "C:\\Users\\Asus\\IdeaProjects\\Celestia_AppiumTest\\apps\\CocoByCelestia.apk";
    public static String appiumServerURL = "http://127.0.0.1:4723";


    //LOGIN PATHS
    public static final String EmailField_Appium_xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View/android.widget.EditText[1]";

    public static final String PasswordField_Appium_xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View/android.widget.EditText[2]";

    public static final String LoginButton_Appium_xpath = "//android.widget.Button";


    //LOGOUT PATHS
    public static final String LogoutButton_Appium_xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View/android.view.View[2]";

    public static final String CancelLogoutButton_Appium_xpath = "//android.view.ViewGroup/android.view.View/android.view.View/" +
            "android.view.View/android.view.View/android.view.View[1]";

    public static final String ConfirmLogoutButton_Appium_xpath = "//android.view.ViewGroup/android.view.View/android.view.View/" +
            "android.view.View/android.view.View/android.view.View[2]";
}