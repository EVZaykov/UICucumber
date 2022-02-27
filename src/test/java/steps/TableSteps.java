package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.utils.Wait;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static utils.RunContext.RUN_CONTEXT;

public class TableSteps {
    @Given("user gets {string} table and check row count, ER = {string}")
    public void i_get_table_and_check_row_count_ER(String varName, String expectedResult) {
        List<LinkedHashMap<String, String>> dataTable = RUN_CONTEXT.get(varName, List.class);
        int size = dataTable.size();
        int er = Integer.parseInt(expectedResult);
        Assert.assertEquals(size, er);
    }

    @Given("user gets row from {string} where {string} equals {string} and saves value{string} into variable {string}")
    public void i_get_row_from_where_equals_and_save_value_into_variable(String varName, String cell, String value, String cellName, String newVarName) {
        List<LinkedHashMap<String, String>> dataTableFromFront = RUN_CONTEXT.get(varName, List.class);
        //dataTableFromFront.get()
        for (int i = 0; i < dataTableFromFront.size(); i++) {
            if (dataTableFromFront.get(i).get(cell).equals(value)) {
                RUN_CONTEXT.put(newVarName, dataTableFromFront.get(i).get(cellName));
                //Assert.assertEquals(dataTable.cell(i, 1),dataTableFromFront.get(0).get(dataTable.cell(i, 0)));
                Allure.step(dataTableFromFront.get(i).get(cellName) + " was saved into " + newVarName);

            } else if (i + 1 == dataTableFromFront.size()) {
                //Assert.fail("column: " + string2 + " with value: " + string3 + " doesn't exists");
            }
        }
    }

    @Given("user saves data of table into variable {string}")
    public void i_save_data_of_table_into_variable(String varName) {
        // Let's get header first
        String headerLoc = "//table[@class='ws-table-all notranslate']//tr//th";
        Wait.visibility(headerLoc);
        List<WebElement> allHeadersEle = Environment.getDriverService().getDriver().findElements(By.xpath(headerLoc));
        List<String> allHeaderNames = new ArrayList<String>();
        for (WebElement header : allHeadersEle) {
            String headerName = header.getText();
            allHeaderNames.add(headerName);
        }

        // Each row will be a key value pair. So we will use LinkedHashMap so that order
        // can be retained.
        // All map will be added to a list.
        List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();

        // Get total rows count
        String rowLoc = "//table[@class='ws-table-all notranslate']//tr";
        List<WebElement> allRowsEle = Environment.getDriverService().getDriver().findElements(By.xpath(rowLoc));
        // Starting from 2 as first row is header. Remember xpath index starts from 1
        for (int i = 2; i <= allRowsEle.size(); i++) {
            // Getting specific row with each iteration
            String specificRowLoc = "//table[@class='ws-table-all notranslate']//tr[" + i + "]";
            // Locating only cells of specific row.
            List<WebElement> allColumnsEle = Environment.getDriverService().getDriver().findElement(By.xpath(specificRowLoc))
                    .findElements(By.tagName("td"));
            // Creating a map to store key-value pair data. It will be created for each
            // iteration of row
            LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
            // Iterating each cell
            for (int j = 0; j < allColumnsEle.size(); j++) {
                // Getting cell value
                String cellValue = allColumnsEle.get(j).getText();
                // We will put in to map with header name and value with iteration
                // Get jth index value from allHeaderNames and jth cell value of row
                eachRowData.put(allHeaderNames.get(j), cellValue);
            }
            // After iterating row completely, add in to list.
            allTableData.add(eachRowData);
        }
        RUN_CONTEXT.put(varName, allTableData);
    }

    @Given("user gets row from {string} where {string} equals {string} and checks next date")
    public void i_get_row_from_where_equals_and_check_next_date(String varName, String column, String value, DataTable dataTable) {
        List<LinkedHashMap<String, String>> dataTableFromFront = RUN_CONTEXT.get(varName, List.class);
        for (int i = 0; i < dataTableFromFront.size(); i++) {
            if (dataTableFromFront.get(i).get(column).equals(value)) {
                for (int j = 0; j < dataTable.height(); j++) {
                    Assert.assertEquals(dataTable.cell(j, 1), dataTableFromFront.get(i).get(dataTable.cell(j, 0)));
                }
                break;
            } else if (i + 1 == dataTableFromFront.size()) {
                Assert.fail("column: " + column + " with value: " + value + " doesn't exists");
            }
        }
    }
}
