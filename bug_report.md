# Bug Report – BookCart QA

## Bug #1 – Cart items added while logged out are lost after login

**Description:**  
When a user adds books to the cart while **not logged in**, those items appear in the cart and the user is prompted to log in during checkout. After logging in, the cart unexpectedly loads the **previous logged-in cart state**, and all items added while logged out are **lost**.

**Steps to Reproduce:**
1. Open the site **without logging in**
2. Add 3–4 different books to the cart
3. Click on the cart or try to checkout
4. You are prompted to log in
5. After login, observe the cart contents

**Expected Result:**
- Items added before login should persist and transfer to the authenticated cart session
- The user should not lose items they just selected, even if they were not logged in initially

**Actual Result:**
- Cart is reset to whatever was last saved while logged in (or empty)
- Items added while logged out are lost and cannot be recovered

**Severity:**  
**High** (Critical UX & session management bug – leads to user frustration and potential cart abandonment)

---

## Bug #2 – Missing feedback when search has no results
**Description:** Searching for gibberish (e.g. "Java") refreshes book/category API but does not display any "No results found" message.  
**Steps to Reproduce:**
1. Navigate to homepage
2. Enter 'Java' in search bar
3. Observe the result
   **Expected Result:** A visible message like "No books found" appears.  
   **Actual Result:** No feedback or UI change is shown.  
   **Severity:** Low

---

## Bug #3 – Fake/test data visible in live environment (Book ID: 90)

**Description:**
The book at `/books/details/90` appears to contain placeholder or test data:
- Author name: `qwert`
- Price: `₹123.00`
- Uses a generic "No image available" cover

**Expected Result:**
All visible products should have real titles, authors, prices, and covers — even if they are demo items.

**Actual Result:**
Fake/test values are visible to users and reduce credibility of the application.

**Severity:** Medium (content issue in production)

---

## Bug #4 – Gemini API error for plot summary generation
**Description:** Clicking “Generate Book Plot Summary using Gemini” returns 400 Bad Request due to invalid/missing API key.  
**Steps to Reproduce:**
1. Open a book
2. Click “Generate Book Plot Summary using Gemini”
3. Check DevTools Console/Network tab  
   **Expected Result:** Plot summary is generated  
   **Actual Result:** Console shows API_KEY_INVALID error  
   **Severity:** High

---

## Bug #5 – Refreshing book detail page causes “No books found” error
**Description:** Pressing Refresh (F5) on a book detail page causes app to lose context and show “No books found.” and "Back to Home" button.  
**Steps to Reproduce:**
1. Click on a book to open detail page
2. Press F5 or browser refresh button  
   **Expected Result:** Book content reloads properly  
   **Actual Result:** Message appears with "Go to Home" button  
   **Severity:** High

---
## Bug #6 – Lack of Responsive Design
**Description:**  
The application does not adapt to different screen sizes, leading to layout issues on mobile devices.
**Steps to Reproduce:**
1. Open the application on a mobile device or use browser developer tools to simulate a smaller screen.
2. Navigate through various pages (e.g., homepage, book list, cart, book detail).

**Expected Result:** The layout adjusts appropriately for different screen sizes, ensuring usability on all devices.

**Actual Result:** Elements overlap or are misaligned, making the application difficult to use on smaller screens.

**Severity:** Medium (Affects usability on mobile devices)

---

## Bug #7 – Password help text overlaps Confirm Password field on Registration
**Description:**  
On the registration page, when a user begins typing in the **Password** field, a helper message appears (e.g., "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number"). However, this message visually overlaps with the **Confirm Password** field below it, making the form look broken and harder to use.

**Steps to Reproduce:**
1. Go to https://bookcart.azurewebsites.net/register
2. Start typing a password in the Password field
3. Observe the helper text appearing
4. Notice that it overlaps or pushes into the Confirm Password input field

**Expected Result:** The helper text should be clearly visible without overlapping any other input fields.

**Actual Result:** The helper message overlaps the Confirm Password field, reducing usability and form clarity.

**Severity:** Low to Medium (Visual/UI bug affecting user experience and clarity)

---

## Bug #8 – Cart item count resets to 0 

**Description:**  
When unlogged user adds items to the cart, the cart icon correctly displays the number of items (e.g., “3”). However, after refreshing homepage, book detail page, login page and registration page the cart count resets to “0” even though the items are still present in the cart.

The correct number only reappears when:
- The user adds another item to the cart
- The user navigates directly to the cart page

**Steps to Reproduce:**
1. Logout and add 2–3 books to the cart
2. Observe the cart icon showing the correct count (e.g., “3”)
3. Refresh the current page (F5 or Ctrl+R)
4. Observe the cart count resets to “0”
5. Click to visit the Cart or add another book
6. The correct number then reappears

**Expected Result:**
- The cart icon should always reflect the current cart state, even after a page refresh.

**Actual Result:**
- Cart count is lost on page reload and only restored by cart interaction.

**Severity:**  
Medium (Functional + UX issue that can mislead the user into thinking the cart is empty)

---

## Bug #9 – No feedback on unsuccessful login attempts

**Description:**  
If a user enters an incorrect username or password, the application does not display any error message indicating that the login has failed. This can confuse the user, as there is no way to know what went wrong.

**Steps to Reproduce:**
1. Go to the login page
2. Enter an incorrect username or password
3. Click the login button

**Expected Result:**  
A clear error message like "Incorrect username or password" should be displayed.

**Actual Result:**  
Nothing happens on the UI — user receives no feedback.

**Severity:**  
Medium (Critical usability issue – users can’t recover from failure easily)

---

## Bug #10 – No validation feedback when gender is not selected during registration

**Description:**  
The registration form includes a gender selection field, but no feedback is provided if the user skips this field. The form fails silently and doesn't explain why the registration didn't proceed.

**Steps to Reproduce:**
1. Go to the registration page
2. Fill all required fields **except** gender
3. Click Register

**Expected Result:**  
A message like “Please select a gender” or a validation error below the field

**Actual Result:**  
No error is shown — form appears unresponsive

**Severity:**  
Medium (Blocks registration and confuses the user)

---

## Bug #11 – Pagination not working correctly on My Orders page

**Description:**  
When viewing the My Orders page with more than 5 orders placed, the pagination does not function as expected. All 7 orders are displayed on the first page even after selecting “5 items per page,” and clicking the pagination arrow does nothing.

**Steps to Reproduce:**
1. Place 7 or more orders while logged in
2. Navigate to https://bookcart.azurewebsites.net/myorders
3. Select “5 items per page” from the pagination dropdown
4. Try clicking the arrow to go to the second page

**Expected Result:**
- Only 5 orders should be displayed on the first page
- The second page should contain the remaining orders
- Pagination arrow should switch pages when clicked

**Actual Result:**
- All 7 orders are shown on the first page
- Arrow does not trigger any pagination behavior

**Severity:**  
Medium (Functional issue – breaks navigation and visibility of historical orders)

---

## Bug #12 – Search functionality on My Orders page does not work

**Description:**  
The search field on the My Orders page does not filter or return results based on user input. No matter what is typed into the search bar, no filtering is applied.

**Steps to Reproduce:**
1. Navigate to https://bookcart.azurewebsites.net/myorders
2. Use the search field to enter a known value (e.g., part of an order ID or date)
3. Observe that no filtering is applied

**Expected Result:**  
The list of orders should be filtered based on the search input

**Actual Result:**  
No filtering occurs — the search box appears non-functional

**Severity:**  
Medium (Broken feature – users cannot search or filter their order history)

---

## Bug #13 – Poorly designed Price Filter UI and limited functionality

**Description:**  
The Price Filter component on the homepage appears visually unrefined and lacks expected functionality for modern e-commerce filtering.

**Issues Observed:**
- Bright pink header and deep blue slider clash visually
- No input boxes to allow manual entry of min/max prices
- No immediate feedback when filter is adjusted — unclear if the book list updates
- Price values (₹111.00 to ₹8,264.00) are cramped and not styled well

**Expected Result:**
- A clean, dual-ended slider with matching color scheme
- Option to manually input price values
- Clear, subtle UI confirmation when filters are applied (e.g., toast, shimmer)
- Clear indication that filter was applied (e.g., product list refreshes)

**Actual Result:**
- Limited one-ended slider with harsh visuals, no UI feedback

**Severity:**  
Low to Medium (UI/UX polish + functional limitation)

---

## Bug #14 – Inconsistent search behavior when querying by author name

**Description:**  
When typing an author's name in the homepage search field (e.g., “JKR”), the dropdown autosuggest displays books by that author. However, **pressing Enter** does **not** return the same results — books are not listed based on the author's name, only based on the title match.

**Steps to Reproduce:**
1. Go to https://bookcart.azurewebsites.net
2. Type an author name (e.g., "JKR") in the search bar
3. Observe dropdown autosuggest shows relevant books
4. Press Enter 
5. Observe that the main book list does **not** show results by that author

**Expected Result:**
- Search behavior should be consistent between dropdown preview and main result list
- Entering an author name should return all books by that author when confirmed

**Actual Result:**
- Autosuggest dropdown shows matching books by author
- Final search result (after Enter) returns no results or unrelated titles

**Severity:**  
Medium (Functional inconsistency – search experience is confusing and broken across input methods)
---

## Bug #15 – Protected API endpoint accessible without authentication

**Description:**  
The endpoint `/api/shoppingcart/{userId}` is accessible without any JWT token by directly visiting the URL in the browser, even after logout. This exposes user-specific data publicly.

**Steps to Reproduce:**
1. Log out of the app
2. Navigate to:
   ```
   https://bookcart.azurewebsites.net/api/shoppingcart/99778
   ```
3. Observe that the cart data is shown

**Expected Result:**
- API should return `401 Unauthorized` for any unauthenticated request to a user’s data

**Actual Result:**
- API returns JSON with cart data without any authentication

**Severity:**  
High (Critical security issue – exposes user data)
---

## Bug #16 – JWT token remains valid after logout (session not invalidated)

**Description:**  
After logging out of the application, the previously issued JWT token can still be used to access protected endpoints such as the shopping cart. This indicates that the session/token is not properly invalidated server-side, which is a security risk.

**Steps to Reproduce:**
1. Log in and capture the JWT token from DevTools Network tab
2. Log out
3. Use `fetch()` or Postman to access a protected endpoint:
   ```
   GET https://bookcart.azurewebsites.net/api/shoppingcart/{userId}
   Authorization: Bearer [your old token]
   ```
4. Observe the response

**Expected Result:**
- API returns `401 Unauthorized` or `403 Forbidden` after logout

**Actual Result:**
- API returns `200 OK` and full cart data even after logout

**Severity:**  
High (Security issue – token reuse after logout)

---
## Bug #17 – New userId is silently created on logout and used for next login session

**Description:**  
After logging out of the application, a new `userId` appears in localStorage before the user logs back in. When the user logs in again, that newly assigned userId is automatically used as the identity for the next session. This behavior suggests that the app is silently generating a new user record (possibly a guest user) during logout and then binding it to the next login session.

**Steps to Reproduce:**
1. Log in and inspect the `userId` in localStorage (e.g., `99787`)
2. Log out
3. Observe that a new `userId` (e.g., `99765`) immediately appears in localStorage
4. Log back in with your account
5. Notice that the session continues under `userId: 99765` instead of the original `99787`

**Expected Result:**
- Logging out should clear `userId`
- Logging in should assign only the authenticated user’s correct ID from the backend

**Actual Result:**
- A new userId is created at logout and becomes the identity for the next session, regardless of login credentials

**Severity:**  
High (Critical data integrity/security issue) – may result in users acting under incorrect or unintended accounts, with potential for data leaks, impersonation, or corruption.

---

## Bug #18 – Expired JWT Token Still Accepted (Token Expiry Not Enforced)

**Description:**  
Using a JWT token with a past `exp` (expiration) timestamp still returns a valid response from the API (`200 OK`). The server does not reject expired tokens, which creates a serious security flaw.

**Steps to Reproduce:**
1. Capture a valid JWT token from a session
2. Wait until it expires (check `exp` claim in JWT, it is 24h)
3. Use `fetch()` or Postman to send a request to a protected endpoint
4. Observe the response

**Expected Result:**
Server should respond with `401 Unauthorized` or an error like `Token expired`

**Actual Result:**
Server responds with `200 OK`, even with expired token

**Severity:**  
**High** – Violates fundamental security rules for session/token management

