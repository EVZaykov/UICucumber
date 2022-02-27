Feature: Обновить все поля (кроме CustomerID) в любой записи таблицы Customers и проверить, что изменения записались в базу.

  @all
  Scenario Outline: Создание Customer -> Обновленией -> Валидация
    * user is on the page "SQL page"
    * user executes java script script "window.editor.setValue('INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country) VALUES (\\'<CustomerName>\\', \\'<ContactName>\\', \\'<Address>\\', \\'<City>\\', \\'<PostalCode>\\', \\'<Country>\\')')"
    * user clicks the button "Run SQL"
    * user executes java script script "window.editor.setValue('SELECT * FROM Customers WHERE CustomerName=\\'<CustomerName>\\' AND ContactName=\\'<ContactName>\\' AND Address=\\'<Address>\\' AND City=\\'<City>\\' AND PostalCode=\\'<PostalCode>\\' AND Country=\\'<Country>\\'')"
    * user clicks the button "Run SQL"
    * user saves data of table into variable "newCustomer"
    * user gets "newCustomer" table and check row count, ER = "1"
    * user gets row from "newCustomer" where "CustomerName" equals "<CustomerName>" and checks next date
      | ContactName | <ContactName> |
      | Address     | <Address>     |
      | City        | <City>        |
      | PostalCode  | <PostalCode>  |
      | Country     | <Country>     |
    * user gets row from "newCustomer" where "CustomerName" equals "<CustomerName>" and saves value"CustomerID" into variable "CustomerID"
    * user executes java script script "window.editor.setValue('UPDATE Customers SET CustomerName=\\'Alfred Schmidt\\', ContactName=\\'Alfred Schmidt\\', Address=\\'Street 10\\', City=\\'Frankfurt\\', PostalCode=\\'10\\', Country=\\'Germany\\' WHERE CustomerID=${CustomerID}')"
    * user clicks the button "Run SQL"
    * user executes java script script "window.editor.setValue('SELECT * FROM [Customers] WHERE CustomerID=${CustomerID}')"
    * user clicks the button "Run SQL"
    * user saves data of table into variable "CustomerAfterUpdate"
    * user gets row from "CustomerAfterUpdate" where "CustomerName" equals "Alfred Schmidt" and checks next date
      | ContactName | Alfred Schmidt |
      | Address     | Street 10      |
      | City        | Frankfurt      |
      | PostalCode  | 10             |
      | Country     | Germany        |

    Examples: Success
      | CustomerName | ContactName | Address  | City   | PostalCode | Country |
      | Jim          | Jimmy       | city 10  | Berlin | 0070       | Germany |
      | Tim          | Timmy       | city 012 | Berlin | 0001       | Germany |




