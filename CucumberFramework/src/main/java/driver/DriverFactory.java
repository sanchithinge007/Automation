package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {


private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


public static void initDriver(String browser) {
if (browser.equalsIgnoreCase("chrome")) {
	ChromeOptions options = new ChromeOptions();
	options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
WebDriverManager.chromedriver().setup();
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
