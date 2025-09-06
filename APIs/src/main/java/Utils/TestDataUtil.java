package Utils;

public class TestDataUtil {

    // Generate a unique email for each test run
    public static String generateUniqueEmail() {
        return "user" + System.currentTimeMillis() + "@example.com";
    }
}
