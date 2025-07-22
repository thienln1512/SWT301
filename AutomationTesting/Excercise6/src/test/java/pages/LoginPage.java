package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.name("email"); // ✅ dùng name thay vì id
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']"); // submit nút login

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("http://localhost:8080/login");
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("/home") || driver.getCurrentUrl().contains("/admin");
    }

    public boolean isLoginFailed() {
        // Điều kiện này có thể thay đổi tùy theo giao diện trang
        return driver.getPageSource().contains("Invalid") || driver.getCurrentUrl().contains("/login");
    }

}
