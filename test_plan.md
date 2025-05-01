# 📋 BookCart QA – Test Plan

**Project Name:** BookCart QA Automation Assignment  
**Tester:** Ilma Hodžić  
**Test Type:** Functional Testing, Smoke Testing, UI Testing, Exploratory Testing  
**Tools:** Java, Selenium WebDriver, TestNG, Chrome  
**Test Environment:**
- URL: https://bookcart.azurewebsites.net
- Browser: Chrome v136
- OS: Windows 11

---

## 1. Objective

To validate the main e-commerce flows of the BookCart web application including registration, login, browsing, wishlist, shopping cart, and ordering. 

---

## 2. Scope

### ✅ In Scope
- Registration and username validation
- Login with JWT token handling
- Book search, view similar books, category filtering
- Add/remove books from wishlist
- Add to cart, modify cart, delete from cart
- Checkout and order placement
- Token-based protected API calls
- Observing frontend-backend sync via DevTools

### ❌ Out of Scope:
- Payment gateway simulation (not implemented)
- Database verification
- Mobile device testing
- Load/performance testing

---

## 3. Risks and Assumptions

- App uses live API endpoints — test data persists
- No backend or admin access
- Token/session expiry behavior is unknown
- There is no UI feedback for some actions 

---

## 4. Test Strategy

### Manual Testing:
- Simulate user actions and document test cases
- Use DevTools to monitor API calls, tokens, and cookies

### Automation:
- Automate core smoke tests using **Java + Selenium + TestNG**

### Bug Reporting:
- Log bugs in a Markdown file (`bug_report.md`) with reproduction steps and severity

---

## 5. Key REST API Insights

| Action | Endpoint                                         | Method | Notes |
|--------|--------------------------------------------------|--------|-------|
| Username validation | `/api/User/validateUserName/{username}`          | GET | On typing in registration |
| Login | `/api/Login`                                     | POST | Returns JWT Token |
| Get all books | `/api/Book/`                                     | GET | Home page books |
| Get categories | `/api/Book/GetCategoriesList`                    | GET | Triggered on category browse |
| Get similar books | `/api/Book/GetSimilarBooks/{bookId}`             | GET | When viewing book detail |
| Add to cart | `/api/shoppingcart/addToCart/{userId}/{bookId}`  | POST | Works also for quantity increment |
| View cart | `/api/shoppingcart/{userId}`                     | GET | Requires JWT |
| Delete from cart | `/api/shoppingcart/{userId}/{bookId}`            | DELETE | Used to remove book |
| Toggle wishlist | `/api/Wishlist/ToggleWishlist/{userId}/{bookId}` | POST | Add/remove uses same call |
| View order history | `/api/Order/{userId}`                            | GET | Accessed after placing order |

---

## 6. Authentication Observations

- Login response provides a **JWT token** used in all `Authorization` headers
- Token is valid for the session and required for wishlist, order calls
- Cookies `ARRAffinity` and `ARRAffinitySameSite` manage Azure load balancing

---

## 7. Observed Functional Behaviors

| Observation | Value |
|-------------|-------|
| Category filtering inconsistently refreshes API calls (e.g., “Biography” refreshes data, “Romance” does not) |
| Cart quantity increased via repeat `POST /addToCart` calls |
| Checkout does not ask for payment – order is created with backend order ID |
| Orders are persisted – can be viewed at `/myorders` |
| JWT token is attached in `Authorization` header on protected API calls |

---

## 8. Suggested Test Flows

These flows will be developed in **Task 2 (test cases)** and partially automated in **Task 4**:
- [x] Register new user (valid and invalid)
- [x] Login/logout
- [x] Search and view book details
- [x] Add/remove wishlist
- [x] Add, update, and remove cart items
- [x] Proceed to checkout and view order
- [x] Switch categories and verify product updates
