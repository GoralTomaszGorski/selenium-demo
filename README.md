# Selenium Demo Project

## Description

The **Selenium Demo** project is a simple example of using Selenium WebDriver to automate web application testing. It is an educational demo project aimed at learning the basics of UI test automation, including interacting with page elements such as forms, buttons, and other components.

The project is based on Selenium WebDriver and aims to provide simple, understandable test examples that can be used as a starting point for more advanced testing scenarios.

## Technologies

- **Selenium WebDriver** – tool for automating web application tests
- **Programming Language**: Java
- **Test Framework**: TestNG
- **Maven** – dependency management tool
- **ChromeDriver** – for handling Google Chrome in tests

## Installation

1. **Clone the repository**:

   Clone the repository to your local machine:

   ```bash
   git clone https://github.com/GoralTomaszGorski/selenium-demo.git
   
2. **Install dependencies:**:

    If you are using Maven:

   ```bash
    cd selenium-demo
    mvn install

3. **Set up WebDriver:**


    Make sure you have the correct WebDriver installed (e.g., ChromeDriver for Google Chrome). Remember to update the WebDriver path in the code if needed.

4. **Run the tests:**

   To run the tests, use Maven:
    ```bash
    mvn test
    ```

## Example Usage

The project includes basic tests that perform interactions with a sample web page. Here's an example of a simple login test:

   ```bash
@Test
public void testLogin() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://example.com/login");

    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("testuser");

    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("password123");

    WebElement submitButton = driver.findElement(By.id("submit"));
    submitButton.click();

    Assert.assertTrue(driver.findElement(By.id("welcome-message")).isDisplayed());

    driver.quit();
}
   ```
The login test opens the page, enters login credentials, and verifies if the welcome message appears after logging in.

## Contribution
Although the project is mainly for demo purposes, if you have suggestions, fixes, or want to add new tests, feel free to open a pull request or create an issue.
