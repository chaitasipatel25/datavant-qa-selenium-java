# datavant-qa-selenium-java
## Java Selenium framework for UI testing

## ❓ What is this Repository about?
This framework is an example of Datavant Automation Take-Home Assessment

### WebDriver Setup
This project uses Selenium WebDriver to interact with the Chrome web browser.
In order for the tests to work, [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
must be installed on the test machine and accessible from the system PATH.
Make sure to download chromedriver compatible with chrome browser

The source code may easily be changed to work with any other web browser by installing the required web drivers.

**How to run Test**

    1. From IDE, run test as TestNG test
    2. From command line, run 'mvn clean test' from root folder

**How can we make this framework better suitable for enterprise product?**

    1. Better Parameterization: For now I am using TestNg DataProvider functionality to run same test with different data. We can make more reliable and maintainable parameterization solution to handle data from CSV or JSON files or using Dynamic values created during runtime.
    2. Configuration Management: Currently config data has been passed via config.properties file. We should introduce environment variable to handle such config as we will be running this tests via different platforms (CI/CD, local machines etc..)
    3. Ability to run test in parallel and on multiple servers
    4. Test Analysis, metrics and report Generation
    5. Screenshots of tests
    6. Setup monitoring for Server where tests are running

Automation framework's specific implementations can vary greatly based on the unique characteristics of product and the needs of customer base.
