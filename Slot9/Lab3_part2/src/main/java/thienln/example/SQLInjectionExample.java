package thienln.example;

import java.util.logging.*;

public class SQLInjectionExample {
    // Tạo một logger instance
    private static final Logger logger = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR '1'='1";
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        // Sử dụng logger thay vì System.out.println()
        logger.info("Executing query: " + query);
    }
}
