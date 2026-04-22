package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {


@Before
public void setUp() {
DriverFactory.initDriver(ConfigReader.get("browser"));
}

@After
public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Failed Screenshot");
    }

    DriverFactory.getDriver().quit();
}
}
