package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "SQL page")
public class SqlPage extends BasePage {

    @ElementTitle(value = "Run SQL")
    @FindBy(xpath = "//button[text()='Run SQL »']")
    public WebElement runSQLButton;

    @ElementTitle(value = "Restore the database")
    @FindBy(xpath = "//button[contains(@title,'Restore the database')]")
    public WebElement restoreTheDatabaseButton;

    @ElementTitle(value = "Show Customers table")
    @FindBy(xpath = "//td[contains(@title,'Customers')]")
    public WebElement customersButton;

    @ElementTitle(value = "Show Categories table")
    @FindBy(xpath = "//td[contains(@title,'Categories')]")
    public WebElement categoriesButton;

    @ElementTitle(value = "Show Employees table")
    @FindBy(xpath = "//td[contains(@title,'Employees')]")
    public WebElement employeesButton;

    @ElementTitle(value = "Show OrderDetails table")
    @FindBy(xpath = "//td[contains(@title,'OrderDetails')]")
    public WebElement orderDetailsButton;

    @ElementTitle(value = "Show Orders table")
    @FindBy(xpath = "//td[contains(@title,'Orders')]")
    public WebElement ordersButton;

    @ElementTitle(value = "Show Products table")
    @FindBy(xpath = "//td[contains(@title,'Products')]")
    public WebElement productsButton;

    @ElementTitle(value = "Show Shippers table")
    @FindBy(xpath = "//td[contains(@title,'Shippers')]")
    public WebElement shippersButton;

    @ElementTitle(value = "Show Suppliers table")
    @FindBy(xpath = "//td[contains(@title,'Suppliers')]")
    public WebElement suppliersButton;
}
