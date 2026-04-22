package runners;
import org.testng.annotations.Listeners;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:CucumberFramework/target/cucumber-report.html",
        "json:CucumberFramework/target/cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true,
    publish = false
    // tags = "@smoke or @regression"   // ✅ control execution
)
@Listeners({AllureTestNg.class})
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}