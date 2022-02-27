Feature: Проверка фильтрации - WHERE

  @all
  Scenario: Вывести только те строки таблицы Customers, где city=‘London’. Проверить, что в таблице ровно 6 записей.
    * user is on the page "SQL page"
    * user executes java script script "window.editor.setValue('SELECT * FROM Customers WHERE city=\\'London\\'')"
    * user clicks the button "Run SQL"
    * user saves data of table into variable "Customers"
    * user gets "Customers" table and check row count, ER = "6"
