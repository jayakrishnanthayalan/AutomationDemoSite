package utils;

import java.util.UUID;

public class TestDataGenerator {


    public static final String FIRST_NAME = "Jaya";
    public static final String LAST_NAME  = "Krishnan";
    public static final String USERNAME = "user_" + System.currentTimeMillis();
    public static final String EMAIL    = "user_" + System.currentTimeMillis() + "@mail.com";
    public static final String PASSWORD = "Password@123";

    private TestDataGenerator() {
        // Prevent instantiation
    }
}
