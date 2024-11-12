package in.ac.adit.pwj.miniproject.library;

public class Faculty extends User {
    public Faculty(String userName, int userId) {
        super(userName, userId);
    }

    @Override
    public void borrowBook(String bookName) {
        System.out.println("Faculty " + getUserName() + " borrowed the book: " + bookName);
    }

    @Override
    public void returnBook(String bookName) {
        System.out.println("Faculty " + getUserName() + " returned the book: " + bookName);
    }
}
