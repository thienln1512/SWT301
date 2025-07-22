package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
    @DisplayName("Blank First and Last Name")
    void testBlankName() {
        registrationPage.navigate();
        registrationPage.fillForm("", "", "john.doe@example.com", "0912345678");
        registrationPage.submitForm();
        assertFalse(registrationPage.isRegistrationSuccess(), "❌ Không nên thành công khi tên trống");
    }

    @Test
    @Order(2)
    @DisplayName("Blank Phone Number")
    void testBlankPhone() {
        registrationPage.navigate();
        registrationPage.fillForm("John", "Doe", "john.doe@example.com", "");
        registrationPage.submitForm();
        assertFalse(registrationPage.isRegistrationSuccess(), "❌ Không nên thành công khi số điện thoại trống");
    }

    @Test
    @Order(3)
    @DisplayName("Invalid Email Format")
    void testInvalidEmail() {
        registrationPage.navigate();
        registrationPage.fillForm("John", "Doe", "invalid-email", "0912345678");
        registrationPage.submitForm();
        assertFalse(registrationPage.isRegistrationSuccess(), "❌ Không nên thành công khi email sai định dạng");
    }

    @Test
    @Order(4)
    @DisplayName("Non-numeric Phone Number")
    void testInvalidPhone() {
        registrationPage.navigate();
        registrationPage.fillForm("John", "Doe", "john.doe@example.com", "abcde12345");
        registrationPage.submitForm();
        assertFalse(registrationPage.isRegistrationSuccess(), "❌ Không nên thành công khi số điện thoại sai định dạng");
    }

    @Test
    @Order(5)
    @DisplayName("Blank Gender")
    void testBlankGender() {
        registrationPage.navigate();
        registrationPage.type(By.id("firstName"), "John");
        registrationPage.type(By.id("lastName"), "Doe");
        registrationPage.type(By.id("userEmail"), "john.doe@example.com");
        registrationPage.type(By.id("userNumber"), "0912345678");
        registrationPage.submitForm();
        assertFalse(registrationPage.isRegistrationSuccess(), "❌ Không nên thành công khi chưa chọn giới tính");
    }

    @Test
    @Order(6)
    @DisplayName("Successful Full Registration")
    void testFullRegistration() {
        registrationPage.navigate();
        registrationPage.fillForm("John", "Doe", "john.doe@example.com", "0912345678");
        registrationPage.fillAdditionalFields("01 Jan 2000", "Maths", true, "Hanoi", true, "D:\\thienln1512\\New folder\\1.png", true);
        registrationPage.submitForm();
        assertTrue(registrationPage.isRegistrationSuccess(), "✅ Nên đăng ký thành công khi điền đủ và đúng");
    }
}