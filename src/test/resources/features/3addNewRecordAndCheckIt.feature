Feature: Добавить новую запись в таблицу и проверить, что эта запись добавилась.

  @all
  Scenario Outline: Добавить новую запись в таблицу Customers и проверить, что эта запись добавилась
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

    Examples: Success
      | CustomerName | ContactName | Address   | City | PostalCode | Country |
      | Timo1        | Tom         | Google 10 | NY   | 007        | Germany |
      | Timo2        | 200         | firstname | Jim  | lastname   | Germany |




