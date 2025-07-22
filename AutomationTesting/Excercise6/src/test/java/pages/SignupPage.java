package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By confirmPasswordInput = By.name("newpass");
    private By signupButton = By.cssSelector("button[type='submit']");

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

    public boolean isRedirectedToLogin() {
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        return currentUrl.contains("/login") || title.equalsIgnoreCase("Login");
    }

    public boolean isSignupFailed() {
        return driver.getCurrentUrl().contains("/signup");
    }

}
