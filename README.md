# Selenium Demo

A demonstration project for UI test automation using **Selenium WebDriver**, **TestNG**, and **ExtentReports**. The project follows the Page Object Model pattern and uses YAML files for configuration.

## 🔧 Technologies Used

- Java 21
- Maven
- Selenium 4.30.0
- TestNG 7.10.2
- WebDriverManager 5.9.2
- ExtentReports 5.1.2
- Log4j 2.24.3
- Lombok 1.18.36
- SnakeYAML 2.2

## 🚀 Running Tests

1. Clone the repository:

   ```bash
   git clone https://github.com/GoralTomaszGorski/selenium-demo.git
   cd selenium-demo
   ```

2. Run tests using Maven:

   ```bash
   mvn clean test
   ```

Tests will run according to the configuration defined in `testng.xml`.

## 📊 Reporting (ExtentReports)

After tests are executed, an HTML report is generated using **ExtentReports**.

### 📁 Report Location:
```
test-output/ExtentReports/ExtentReport.html
```

### 🖥️ Preview:

Open the report in your browser:

```bash
start test-output/ExtentReports/ExtentReport.html
```
(Use the appropriate command for your OS)

The report includes:
- Test status (pass/fail/skip)
- Detailed steps for each test
- Screenshots on failure
- Log output (log4j)

## 📁 Project Structure

```
selenium-demo/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── goral/
│   │           ├── config/       # YAML configuration
│   │           ├── drivers/      # WebDriver initialization
│   │           ├── pages/        # Page Object classes
│   │           ├── reports/      # Report generation logic
│   │           └── utils/        # Helpers, logging
│   └── test/
│       └── java/
│           └── goral/
│               └── tests/        # TestNG test classes
│               └── resources/    # testng.xml, config.yaml
├── test-output/                  # ExtentReports output
└── pom.xml
```

## ⚙️ Configuration

Test configuration is defined in the `config.yaml` file.

Example:
```yaml
url: "https://example.com"
browser: "chrome"
```

## 📌 Future Improvements

- Add Allure Reports
- Integrate CI/CD (GitHub Actions, Jenkins)
- Add API testing (RestAssured or OkHttp)

---

## 👨‍💻 Author

**Tomasz Górski**

[GitHub](https://github.com/GoralTomaszGorski) | [LinkedIn](https://linkedin.com)