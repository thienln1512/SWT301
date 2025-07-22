package tests;

import org.junit.jupiter.api.*;
import pages.SignupPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Signup Feature Tests")
public class SignupTest {
    static SignupPage signupPage;
    static final String testPassword = "12345678";
    static final String existingEmail = "sonkksondepzai@gmail.com"; // giả sử đã tồn tại

    @BeforeAll
    static void initPage() {
        var driver = DriverFactory.getDriver();
        signupPage = new SignupPage(driver);
    }

    @BeforeEach
    void goToSignup() {
        signupPage.navigateTo("http://localhost:8080/signup");
    }

    @Test
    @Order(1)
    @DisplayName("✅ Valid Signup redirects to Login")
    void testValidSignup() {
        String testEmail = "user" + System.currentTimeMillis() + "@example.com";

        signupPage.enterEmail(testEmail);
        signupPage.enterPassword(testPassword);
        signupPage.enterConfirmPassword(testPassword);
        signupPage.clickSignupButton();

        waitShort();

        assertTrue(signupPage.isRedirectedToLogin(), "❌ Signup thành công nhưng không chuyển đến trang login");
    }

    @Test
    @Order(2)
    @DisplayName("❌ Empty email")
    void testEmptyEmail() {
        signupPage.enterEmail("");
        signupPage.enterPassword(testPassword);
        signupPage.enterConfirmPassword(testPassword);
        signupPage.clickSignupButton();

        waitShort();

        assertTrue(signupPage.isSignupFailed(), "❌ Signup không thành công khi thiếu email");
    }

    @Test
    @Order(3)
    @DisplayName("❌ Empty password")
    void testEmptyPassword() {
        signupPage.enterEmail("newuser@example.com");
        signupPage.enterPassword("");
        signupPage.enterConfirmPassword(testPassword);
        signupPage.clickSignupButton();

        waitShort();

        assertTrue(signupPage.isSignupFailed(), "❌ Signup không thành công khi thiếu mật khẩu");
    }

    @Test
    @Order(4)
    @DisplayName("❌ Empty confirm password")
    void testEmptyConfirmPassword() {
        signupPage.enterEmail("newuser@example.com");
        signupPage.enterPassword(testPassword);
        signupPage.enterConfirmPassword("");
        signupPage.clickSignupButton();

        waitShort();

        assertTrue(signupPage.isSignupFailed(), "❌ Signup không thành công khi thiếu xác nhận mật khẩu");
    }

    @Test
    @Order(5)
    @DisplayName("❌ Invalid email format")
    void testInvalidEmailFormat() {
        signupPage.enterEmail("invalid-email");
        signupPage.enterPassword(testPassword);
        signupPage.enterConfirmPassword(testPassword);
        signupPage.clickSignupButton();

        waitShort();

        assertTrue(signupPage.isSignupFailed(), "❌ Signup không thành công với định dạng email sai");
    }

    @AfterAll
    static void teardown() {
        DriverFactory.quitDriver();
    }

    private void waitShort() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
