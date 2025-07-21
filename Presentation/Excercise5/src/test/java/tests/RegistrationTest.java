package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Registration Form Tests")
public class RegistrationTest extends BaseTest {
    static RegistrationPage registrationPage;

    @BeforeAll
    static void initPage() {
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Should register successfully with valid data")
    void testRegistrationSuccess() {
        registrationPage.navigate();
        registrationPage.fillForm("John", "Doe", "john.doe@example.com", "0912345678");
        registrationPage.submitForm();
        assertTrue(registrationPage.isRegistrationSuccess(), "❌ Modal đăng ký không xuất hiện");
    }

}
