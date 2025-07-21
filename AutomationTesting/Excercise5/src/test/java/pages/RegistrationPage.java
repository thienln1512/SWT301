package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderRadio = By.xpath("//label[text()='Male']");
    private By mobileField = By.id("userNumber");
    private By uploadInput = By.id("uploadPicture");
    private By submitButton = By.id("submit");
    private By successModal = By.id("example-modal-sizes-title-lg");

    public void navigate() {
        navigateTo("https://demoqa.com/automation-practice-form");

        // Xóa quảng cáo hoặc footer bị che
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('fixedban')?.remove()");
            js.executeScript("document.querySelector('footer')?.remove()");
        } catch (Exception e) {
            System.out.println("⚠️ Failed to remove ads/footer: " + e.getMessage());
        }
    }

    public void fillForm(String firstName, String lastName, String email, String mobile) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        click(genderRadio);
        type(mobileField, mobile);
    }

    public void uploadPicture(String filePath) {
        WebElement input = waitForVisibility(uploadInput);
        input.sendKeys(filePath);
    }

    public void submitForm() {
        WebElement button = waitForVisibility(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
        System.out.println("✅ Submitted form");
    }

    public boolean isRegistrationSuccess() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successModal));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
