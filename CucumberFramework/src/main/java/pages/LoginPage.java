package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import utils.ConfigReader;

public class LoginPage {


WebDriver driver = DriverFactory.getDriver();


By username = By.id("username");
By password = By.name("password");
By loginBtn = By.id("submit");


public void openUrl() {
driver.get(ConfigReader.get("url"));
}


public void enterUsername(String user) {
driver.findElement(username).sendKeys(user);
}


public void enterPassword(String pass) {
driver.findElement(password).sendKeys(pass);
}


public void clickLogin() {
driver.findElement(loginBtn).click();
}
}
