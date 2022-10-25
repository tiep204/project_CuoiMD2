package ra.bussiness.entity;
import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private String bookId;
    private String bookName;
    private int bookQuantity;
    private ArrayList<String> ListAuthor = new ArrayList<>();
    private Catalog catalog;

    public void setListAuthor(ArrayList<String> listAuthor) {
        ListAuthor = listAuthor;
    }

    private String bookStates;
    private String bookStatus;

    public Book() {
    }

    public Book(String bookId, String bookName, int bookQuantity, ArrayList<String> listAuthor, Catalog catalog, String bookStates, String bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
        ListAuthor = listAuthor;
        this.catalog = catalog;
        this.bookStates = bookStates;
        this.bookStatus = bookStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public ArrayList<String> getListAuthor() {
        return ListAuthor;
    }


    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getBookStates() {
        return bookStates;
    }

    public void setBookStates(String bookStates) {
        this.bookStates = bookStates;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
