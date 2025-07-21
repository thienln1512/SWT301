package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // ❌ GỠ DÒNG CHẶN JAVASCRIPT NÀY (gây ra white screen)
        // Map<String, Object> prefs = new HashMap<>();
        // prefs.put("profile.managed_default_content_settings.javascript", 2);
        // options.setExperimentalOption("prefs", prefs);

        // ✅ Bạn có thể giữ hoặc gỡ "--incognito"
        // options.addArguments("--incognito");

        return new ChromeDriver(options);
    }
}
