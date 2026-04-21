package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {


@Before
public void setUp() {
DriverFactory.initDriver(ConfigReader.get("browser"));
}


@After
public void tearDown() {
DriverFactory.quitDriver();
}
}
