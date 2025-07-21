package tests;

import org.junit.jupiter.api.*;
import pages.SignupPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Signup Feature Tests")
public class SignupTest extends BaseTest {
    static SignupPage signupPage;

    @BeforeAll
    static void initPage() {
        signupPage = new SignupPage(driver);
    }

    @BeforeEach
    void goToSignup() {
        driver.get("http://localhost:8080/signup");
    }

    @Test
    @Order(1)
    @DisplayName("Valid Signup")
    void testValidSignup() {
        signupPage.enterUsername("newuser");
        signupPage.enterEmail("newuser@example.com");
        signupPage.enterPassword("123456");
        signupPage.enterConfirmPassword("123456");
        signupPage.clickSignupButton();

        assertTrue(driver.getCurrentUrl().contains("login"), "❌ Signup should redirect to login");
    }

    @Test
    @Order(2)
    @DisplayName("Signup Password Mismatch")
    void testPasswordMismatch() {
        signupPage.enterUsername("user2");
        signupPage.enterEmail("user2@example.com");
        signupPage.enterPassword("123456");
        signupPage.enterConfirmPassword("654321");
        signupPage.clickSignupButton();

        assertTrue(driver.getCurrentUrl().contains("signup"), "❌ Should remain on signup page due to mismatch");
    }
}