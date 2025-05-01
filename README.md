# bookcart-qa
---
Automated UI tests for the [BookCart](https://bookcart.azurewebsites.net/) demo e-commerce application using **Java**, **Selenium WebDriver**, and **TestNG**.

---

## Project Overview

This project was created as part of a Junior QA Engineer assignment. It focuses on validating core user flows through smoke tests and reporting functional and security bugs found in the application.

---

## Technologies Used

- **Java 17**
- **Selenium WebDriver 4.6.0**
- **TestNG 7.6.1**
- **ChromeDriver 136**
- **IntelliJ IDEA**

---

## Smoke Test Scenarios Covered

| Test Case        | Description                                           |
|------------------|-------------------------------------------------------|
| `LoginTest`      | Verifies login with valid credentials                 |
| `SearchTest`     | Searches and selects a book from search results       |
| `CartTest`       | Logs in and adds a book to the cart                   |
| `CheckoutTest`   | Logs in, adds a book to cart, and completes checkout  |

---

## How to Run Tests

1. Make sure Chrome v136 and ChromeDriver 136 are installed.
2. Open the project in IntelliJ.
4. Navigate to any test class and right-click → **Run '...Test'**
5. You can run all tests using the TestNG test runner.

Note: The provided code snippet includes a hardcoded path to the ChromeDriver in BaseTest (C:\Users\Ilma Hodžić\Desktop\chromedriver-win64\chromedriver.exe). This path will need to be updated to the correct location of your ChromeDriver executable.

---

## Bugs Found

See [`bug_report.md`](./bug_report.md) for a list of 18+ real issues discovered during testing (security, UI, session management).

---

## Author

**Ilma Hodžić**  
Junior QA Engineer Candidate  
Sarajevo  

