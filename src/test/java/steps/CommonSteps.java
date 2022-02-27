package steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.environment.Environment;

import static utils.CheckVariable.checkVariable;

public class CommonSteps {
    @Given("user executes java script script {string}")
    public void user_executes_java_script_script(String script) {
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        js.executeScript((String) checkVariable(script));
    }

    @Given("user gets text from window editor and equal with {string}")
    public void i_get_text_from_window_editor_and_equal_with(String er) {
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        String valueOfEditor = (String) js.executeScript("return window.editor.getValue()");
        Assert.assertEquals(er, valueOfEditor);
    }

    @Given("user waits alert and it contains text {string} and {string} it")
    public void i_accept_the_alert(String text, String action) {
        WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(), 15);
        wait.until(ExpectedConditions.alertIsPresent());

        String alertText = Environment.getDriverService().getDriver().switchTo().alert().getText();
        if (alertText.contains(text)) {
            if (action.trim().equals("accept")) {
                Environment.getDriverService().getDriver().switchTo().alert().accept();
            } else if (action.trim().equals("dismiss")) {
                Environment.getDriverService().getDriver().switchTo().alert().dismiss();
            }
        }
    }
}
