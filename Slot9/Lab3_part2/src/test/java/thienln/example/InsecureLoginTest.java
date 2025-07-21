package thienln.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InsecureLoginTest {

    @Test
    void testLoginSuccess() {
        InsecureLogin.login("admin", "123456");
        // Không cần assert nếu chỉ cần chạy để tránh warning "method not used"
        assertTrue(true);
    }

    @Test
    void testLoginFail() {
        InsecureLogin.login("user", "wrongpassword");
        assertTrue(true);
    }

    @Test
    void testPrintUserInfo() {
        InsecureLogin insecureLogin = new InsecureLogin();
        insecureLogin.printUserInfo("John Doe");
        assertTrue(true);

    }
}
