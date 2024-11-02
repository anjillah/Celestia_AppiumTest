package Constant;

/**
 * Class to hold constants
 */
public class Config {
    public static final String PLATFORM_NAME = "Android";
    public static final String AUTOMATION_NAME = "uiautomator2";
    public static String APP_PATH = System.getProperty("user.dir") + "\\apps\\app-debug.apk";
    public static String APP_DEVICE_NAME = "Medium Phone API 35";

    public static String appiumServerURL = "http://127.0.0.1:4723";


    //LOGIN PATHS
    public static final String EMAIL_FIELD = "android:id/emailField";
    public static final String PASSWORD_FIELD = "android:id/passwordField";
    public static final String LOGIN_BUTTON = "android:id/loginButton";


    //LOGOUT PATHS
    public static final String LOGOUT_BUTTON = "android:id/logoutButton";
    public static final String CANCEL_LOGOUT = "android:id/cancelLogout";
    public static final String CONFIRM_LOGOUT = "android:id/confirmLogout";
}