package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @Order(1)
    @DisplayName("Login with valid credentials")
    void testSuccessfulLogin() {
        loginPage.navigateToLoginPage();
        loginPage.enterEmail("user@example.com");
        loginPage.enterPassword("123456");
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginSuccessful(), "❌ Login failed or did not navigate to /home");
    }

    @AfterAll
    static void teardown() {
        DriverFactory.quitDriver();
    }
}
