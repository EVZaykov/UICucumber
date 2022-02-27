Feature: Подсчет стран

  @all
  Scenario: Подсчет уникальных и не уникальных стран
    * user is on the page "SQL page"
    * user executes java script script "window.editor.setValue('SELECT COUNT(Country) AS \\'All Countries\\', COUNT(DISTINCT Country) AS \\'Unique countries\\', (COUNT(Country) - COUNT(DISTINCT Country)) AS NotUnique FROM Customers')"
    * user clicks the button "Run SQL"
    * user saves data of table into variable "Countries"
    * user gets "Countries" table and check row count, ER = "1"
    * user gets row from "Countries" where "Unique countries" equals "21" and checks next date
      | NotUnique | 70 |






