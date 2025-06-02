package thienln.example;

import java.util.regex.Pattern;

public class AccountService {

    private static final int MIN_PASSWORD_LENGTH = 7; // lớn hơn 6 ký tự
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"
    );

    /**
     * Đăng ký tài khoản
     * @param username
     * @param password
     * @param email
     * @return true nếu hợp lệ, false nếu không hợp lệ
     */
    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        if (!isValidEmail(email)) {
            return false;
        }
        // Giả sử đăng ký thành công nếu hợp lệ (không check tồn tại username,...)
        return true;
    }

    /**
     * Kiểm tra email hợp lệ
     * @param email
     * @return true nếu hợp lệ, false nếu không
     */
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
