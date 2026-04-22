package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            // ✅ Auto-manage correct driver version
            WebDriverManager.chromedriver().clearDriverCache().setup();

            ChromeOptions options = new ChromeOptions();

            // ✅ Run headless only in CI (Jenkins)
            String headless = System.getProperty("headless");

            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            // ✅ Stability options
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");

            driver.set(new ChromeDriver(options));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}