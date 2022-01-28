package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static support.TestContext.getDriver;
import static support.TestContext.setDriverOnScenarioStart;

public final class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
        TestContext.initialize();
        setDriverOnScenarioStart(() -> getDriver().manage().deleteAllCookies());
    }

    @After(order = 0)
    public void scenarioEnd(final Scenario scenario) {
        if (scenario.isFailed()) {
            final TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            final byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "result.png");
        }
        TestContext.teardown();
    }
}
