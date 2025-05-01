# BookCart QA Automation

Automated UI smoke tests for the [BookCart e-commerce demo](https://bookcart.azurewebsites.net) using **Java**, **Selenium WebDriver**, and **TestNG**.

---

## Project Overview

This project was created as part of a **Junior QA Engineer assignment**. It focuses on validating critical user flows through **automated smoke tests** and reporting **functional**, **UI**, and **security** bugs found during exploratory and structured testing.

---

##  Technologies Used

| Tool / Framework     | Version        |
|----------------------|----------------|
| Java                 | 17             |
| Selenium WebDriver   | 4.6.0          |
| TestNG               | 7.6.1          |
| Chrome / ChromeDriver| v136           |
| IntelliJ IDEA        | 2024.2         |

---

## Smoke Test Scenarios Covered

| Test Class       | Description                                      |
|------------------|--------------------------------------------------|
| `LoginTest`      | Verifies login with valid credentials            |
| `SearchTest`     | Searches for a book and verifies result          |
| `CartTest`       | Logs in, adds book to cart, verifies cart        |
| `CheckoutTest`   | Logs in, adds book, proceeds to checkout         |

Each test simulates a real user flow and uses **assertions** to validate success conditions.

---

## How to Run the Tests

### Prerequisites:
- Java 17 installed
- Chrome browser v136 installed
- Compatible `chromedriver.exe` (v136) placed and path updated in `BaseTest.java`

### Steps (in IntelliJ IDEA):
1. Clone the repo
2. Open in IntelliJ
3. Right-click on any test (e.g. `CartTest`) → **Run 'CartTest'**

---

>  **Note:**  
> The `BaseTest.java` class uses a hardcoded path for ChromeDriver:  
> `C:\Users\Ilma Hodžić\Desktop\chromedriver-win64\chromedriver.exe`  
> Make sure to update this path if running on a different machine.

---

##  Bug Reports

A detailed list of 18 discovered bugs (functional + security) is provided in [bug_report.md](bug_report.md), including:

-  Cart item loss after login
-  JWT token not expiring correctly
-  Token still valid after logout
-  No feedback on failed login
-  UI overlaps on registration form

---

##  Author

**Ilma Hodžić**  
Junior QA Engineer Candidate  
Sarajevo, Bosnia and Herzegovina  
