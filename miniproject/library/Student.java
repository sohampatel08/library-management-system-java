package in.ac.adit.pwj.miniproject.library;

public class Student extends User {
    public Student(String userName, int userId) {
        super(userName, userId);
    }

    @Override
    public void borrowBook(String bookName) {
        System.out.println("Student " + getUserName() + " borrowed the book: " + bookName);
    }

    @Override
    public void returnBook(String bookName) {
        System.out.println("Student " + getUserName() + " returned the book: " + bookName);
    }
}
