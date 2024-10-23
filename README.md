📚 Library Management System A simple and efficient console-based Library Management System built in Java that allows users to borrow, return, and manage books. This project demonstrates core OOP principles like inheritance, inner classes, exception handling, multithreading, and file handling for persistent storage.

🏆 Objective The objective of this project is to create a system that manages book transactions (borrowing, returning) while ensuring concurrency, data integrity, and persistence.

🛠️ Technology Stack Language: Java ☕ Collection API: ArrayList, HashMap Multithreading: Simultaneous user transactions File Handling: Persistent storage for book data Exception Handling: Robust error handling for invalid operations Package: in.ac.adit.pwj.miniproject.library

🌟 Features 🧑‍🏫 User Types: Student and Faculty users, each with unique borrowing privileges. 📚 Book Management: Add, borrow, and return books seamlessly. 🔄 Concurrent Transactions: Multiple users can borrow books simultaneously with proper thread synchronization. 💾 Persistent Storage: Book data is saved and retrieved from a file, so it's available across sessions. ⚠️ Error Handling: Handles invalid operations like trying to borrow a non-available book or returning a non-borrowed one.

📐 System Architecture 📦 Classes and Inheritance User (Base Class) Student and Faculty inherit from User and override borrowing behavior. Library Contains an inner class BookInventory to manage the book inventory. 🔄 Concurrency Multithreading is used to handle multiple users borrowing books at the same time. synchronized blocks ensure that book data remains consistent. 💾 File Handling Book data is stored in a file (BookData.txt) and reloaded each time the program runs.

🛠️ How to Run the Project 🚀 Installation Instructions

Clone the repository: git clone https://github.com/Dev-Narola/library-management-system-java.git

Navigate to the project directory: cd library-management-system

Compile the project: javac -d . src/in/ac/adit/pwj/miniproject/library/*.java

Run the application: java in.ac.adit.pwj.miniproject.library.LibraryManagementSystem

🎮 Usage Instructions

When the program starts, a menu is displayed with options to: Add a book 📚 Borrow a book 🤝 Return a book 🔄 Display all books 📖 Exit 🚪
Follow the on-screen instructions to interact with the library system.
⚠️ Exception Handling Borrowing a non-existent book: "throw new BookNotAvailableException("This book is not available.");" Returning a book that was never borrowed: "throw new BookNotBorrowedException("You did not borrow this book.");"

🌟 Future Enhancements 🎨 GUI: Develop a graphical user interface for better usability. 🔍 Search Functionality: Add a search feature to find books by title or author. 🗄️ Database Integration: Switch from file-based storage to a relational database like MySQL for scalability.

About
No description, website, or topics provided.
Resources
 Readme
 Activity
Stars
 0 stars
Watchers
 1 watching
Forks
 0 forks
Report repository
Releases
No releases published
Packages
No packages published
Languages
Java
100.0%
Footer
