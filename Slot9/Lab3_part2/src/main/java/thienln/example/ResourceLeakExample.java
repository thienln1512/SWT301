package thienln.example;

import java.io.*;
import java.util.logging.*;

public class ResourceLeakExample {
    // Tạo một đối tượng logger
    private static final Logger logger = Logger.getLogger(ResourceLeakExample.class.getName());

    public static void main(String[] args) {
        // Sử dụng try-with-resources để đảm bảo BufferedReader được đóng đúng cách
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Ghi log thay vì in ra console
                logger.info(line);
            }
        } catch (IOException e) {
            // Ghi log lỗi thay vì in stack trace
            logger.log(Level.SEVERE, "Đã xảy ra lỗi khi đọc file", e);
        }
    }
}
