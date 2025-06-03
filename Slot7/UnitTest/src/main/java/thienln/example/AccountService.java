package thienln.example;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class AccountService {

    private static final Set<String> registerUsernames = new HashSet<>();

    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MAX_PASSWORD_LENGTH = 12;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"
    );


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
        if (registerUsernames.contains(username)) {
            return false;
        }
        registerUsernames.add(username);
        return true;
    }


    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        int len = password.length();
        if (len <  MIN_PASSWORD_LENGTH || len > MAX_PASSWORD_LENGTH) {
            return false;
        }
        return true;
    }
}
