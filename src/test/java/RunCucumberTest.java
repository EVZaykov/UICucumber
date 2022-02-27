import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.pagefactory.Tag;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"ru.sbtqa.tag.stepdefs.en", "steps"},
        plugin = {"pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/cucumber-html-reports/cucumber.json", "json:target/cucumber.json"}, features = "src/test/resources", tags = "@all")
public class RunCucumberTest extends Tag {

}
