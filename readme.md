
# MIRO UI Automation

>This framework has been designed to automate functional flows of WebApplication and, ensure coverage and quality

### Libraries Used :
- **Selenium** - Web Automation
- **TestNG** - Unit Testing Library
- **Extent Reports** - Reporting Library to generate beautiful html reports
- **WebDriverManager** - Executables management
- **Owner Library** - To manage configurations from properties file
- **Zero Cell** - To manage test data from Excel

### Capabilities:
> - Web Tests can be run on chrome or edge browsers.
> - Configuration can be changed from config.properties inside src/test/resources
> - Utility methods available for Web Interactions (SeleniumUtils.java)

### Running Tests:
**[Prerequisites]()**: **Java 8+**

    1. Running Tests Individually
     
     Go to src/test/java and Open any Java class that ends with '.*Test'. Right click to select the class/test and run as TestNG test and test will execute locally as follows:
![img.png](images/img_2.png)
 
    2. Running Tests in Parallel

     Open testng.xml file located in the root directory and right click to select the xml file and run as TestNG tests. The tests will start running in parallel based on thread-count value defined in testng.xml

### Report Generation:

Once test execution is complete, the framework will generate report at the root of project directory as `index.html`. This reports hold all the information about the tests on Pass, Fail and Skip. Also for failed tests it will attach screenshot of the page where tests got failed. 
Following is a sample of report generated:

![img.png](images/img.png)
![img_1.png](images/img_1.png)
