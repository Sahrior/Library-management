# Library-management

This Java code implements a basic library management system using Swing for the graphical user interface (GUI). Here’s a list of functionalities it provides:

Add Books: Users can add new books to the library by providing details such as title, author, genre, section, floor, and available copies.

View Books: Users can view a list of all books in the library displayed in a table format, including details like title, author, genre, section, floor, and available copies.

Search Books: Users can search for a specific book by title. If found, it displays the book's details; otherwise, it informs the user that the book is not available.

Borrowing Books: Users can borrow a book, which decreases the available copies if the book is available.

Returning Books: Users can return a borrowed book, which increases the available copies.

Data Persistence: The system saves and loads the list of books to and from a file (Books.dot), ensuring that the data is retained between sessions.

Basic UI: The application features a user-friendly interface with buttons for each function, along with dialogs for input and output messages.

Error Handling: It provides feedback to users for various actions, like searching for non-existent books or trying to borrow a book when no copies are available.

Overall, it allows for a straightforward management of a library's inventory, focusing on adding, viewing, searching, borrowing, and returning books.
