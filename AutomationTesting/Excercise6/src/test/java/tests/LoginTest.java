package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Login Functionality Tests")
public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    static void setup() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @BeforeEach
    void goToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @Test
    @Order(1)
    @DisplayName("✅ Login with valid credentials")
    void testSuccessfulLogin() {
        loginPage.enterEmail("sonkksondepzai@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginSuccessful(), "❌ Login failed or did not navigate to /home");
    }

    @Test
    @Order(2)
    @DisplayName("❌ Empty email")
    void testEmptyEmail() {
        loginPage.enterEmail("");
        loginPage.enterPassword("123");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginFailed(), "❌ Login should fail when email is empty");
    }

    @Test
    @Order(3)
    @DisplayName("❌ Empty password")
    void testEmptyPassword() {
        loginPage.enterEmail("sonkksondepzai@gmail.com");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginFailed(), "❌ Login should fail when password is empty");
    }

    @Test
    @Order(4)
    @DisplayName("❌ Invalid email format")
    void testInvalidEmailFormat() {
        loginPage.enterEmail("invalid-email");
        loginPage.enterPassword("123");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginFailed(), "❌ Login should fail with invalid email format");
    }

    @Test
    @Order(5)
    @DisplayName("❌ Wrong password")
    void testWrongPassword() {
        loginPage.enterEmail("sonkksondepzai@gmail.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginFailed(), "❌ Login should fail with wrong password");
    }

    @Test
    @Order(6)
    @DisplayName("❌ Non-existing account")
    void testNonExistingAccount() {
        loginPage.enterEmail("nonexist@example.com");
        loginPage.enterPassword("123");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginFailed(), "❌ Login should fail for non-existing account");
    }

    @AfterAll
    static void teardown() {
        DriverFactory.quitDriver();
    }
}
