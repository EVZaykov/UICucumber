Feature: Вывести все строки таблицы и убедиться, что запись имеет определенное значение.

  @all
  Scenario: ContactName равной ‘Giovanni Rovelli’ имеет Address = ‘Via Ludovico il Moro 22’
    * user is on the page "SQL page"
    * user executes java script script "window.editor.setValue('SELECT * FROM [Customers]')"
    * user clicks the button "Run SQL"
    * user saves data of table into variable "Customers"
    * user gets row from "Customers" where "ContactName" equals "Giovanni Rovelli" and checks next date
      | Address | Via Ludovico il Moro 22 |





