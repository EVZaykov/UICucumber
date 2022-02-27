import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.sbtqa.tag.pagefactory.environment.Environment;

import java.io.ByteArrayInputStream;


public class Hooks {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot of falling step", new ByteArrayInputStream(((TakesScreenshot) Environment.getDriverService().getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}

