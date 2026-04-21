package stepdefinitions;

import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {


LoginPage loginPage = new LoginPage();


@Given("user is on login page")
public void openLoginPage() {
loginPage.openUrl();
}


@When("user enters username and password")
public void enterCredentials() {
loginPage.enterUsername("admin");
loginPage.enterPassword("admin123");
loginPage.clickLogin();
}


@Then("user should see dashboard")
public void verifyDashboard() {
Assert.assertTrue(DriverFactory.getDriver().getTitle().contains("a"));
}
}
