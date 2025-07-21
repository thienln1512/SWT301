package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    private By usernameInput = By.id("username");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By signupButton = By.id("signupButton");

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void enterConfirmPassword(String password) {
        type(confirmPasswordInput, password);
    }

    public void clickSignupButton() {
        click(signupButton);
    }
}