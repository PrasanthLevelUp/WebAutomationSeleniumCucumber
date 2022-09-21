package helper;


import static helper.Utils.getTimeStamp;

public class Constants {

    private final static String ConfiFile = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    private final static String EXTENT_CONFIG = System.getProperty("user.dir") + "/Reports";

    private final static long explicitWait = 100;
    private final static long impliciteWait = 100;

    public static String getConfig() { return ConfiFile; }

    public static String getExtentConfig() { return EXTENT_CONFIG; }

    public static String getUsername() {
        return PropertyHelper.getProperty("Username");
    }

    public static String getPassword() {
        return PropertyHelper.getProperty("password");
    }

    public static String getUrl() {
        return PropertyHelper.getProperty("QAurl");
    }

    public static long getExplicitwait() {
        return explicitWait;
    }

    public static long getImplicitewait() {
        return impliciteWait;
    }


}
