# Test Automation
Tech Stack: Java, Selenium, Maven, Junit, Cucumber, Allure.

Installation (pre-requisites)
-----------------------------
1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. IDE (Eclipse, IntelliJ, etc)
4. Plugin - Cucumber for java

Setup Instructions
--------------
Clone the repo from below command or download zip and set it up in your local workspace.
```
https://github.com/EVZaykov/UICucumber.git
```

Running Test PowerShell/Zsh
------------
Go to your project directory from terminal and hit following commands
```
docker-compose up -d selenium-hub ; docker-compose scale chrome=1 ; mvn clean test "-Dcucumber.options=-t @all"; mvn allure:serve

```
Optional arguments for maven command
------------------------------------
| Argument          | Description                                           | Default value                         |Example                      |
| ------------------| -------------                                         |---------------------------------------|-----------------------------|
| cucumber.options  | all cucumber options                                  |-                                      | "-Dcucumber.options=-t @all"|
| allure:serve      | Generates report and opens it in the default browser  |-                                      | allure:serve

You can watch a browser in container 
------------
1. Open http://localhost:4444/ui/index.html#/ 
2. Go to session tab 
3. Password ``` secret ```

Automation scripts did not launch on Linux platform!
------------







