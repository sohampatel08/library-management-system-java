package in.ac.adit.pwj.miniproject.library;

public abstract class User {
    private String userName;
    private int userId;

    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public abstract void borrowBook(String bookName);

    public abstract void returnBook(String bookName);
}
