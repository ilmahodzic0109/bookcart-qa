| TC ID  | Title                        | Steps                                                   | Expected Result                          | Type      | Smoke |
|--------|------------------------------|----------------------------------------------------------|-------------------------------------------|-----------|--------|
| TC001  | Register New User            | Navigate to Register → Fill valid data → Submit         | User registered successfully              | Positive  | No     |
| TC002  | Login with Valid Credentials | Navigate to Login → Enter correct credentials → Submit  | User redirected to homepage               | Positive  | Yes    |
| TC003  | Login with Invalid Password  | Navigate to Login → Enter wrong password → Submit       | Error message shown                        | Negative  | No     |
| TC004  | Search for Existing Book     | Use search bar to search 'Harry Potter and the Chamber of Secrets'                         | Books related to 'Java' displayed         | Positive  | Yes    |
| TC005  | Search for Non-Existing Book | Search gibberish like 'zzz'                             | 'No results found' message shown          | Negative  | No     |
| TC006  | Add Book to Cart             | Login → Click 'Add to cart' on a book                   | Item appears in cart                      | Positive  | Yes    |
| TC007  | Increase Quantity in Cart    | Go to cart → Click '+' to increase item quantity        | Item quantity increases                   | Positive  | No     |
| TC008  | Remove Book from Cart        | Go to cart → Click 'Remove' icon                        | Item is removed from cart                 | Positive  | Yes    |
| TC009  | Toggle Wishlist              | Click heart icon on a book                              | Heart fills/unfills, wishlist updated     | Positive  | No     |
| TC010  | Checkout Flow                | Login → Add item → Go to cart → Click Checkout          | Order is placed and shown in My Orders    | Positive  | Yes    |
