package ra.bussiness.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class LibraryBookCard implements Serializable {
    private int libraryCardld;
    private String libraryCardName;
    private User user;
    private Date brrowDate;
    private Date returnDate;
    private Date actuaReturnDate;
    private ArrayList<Book> listBook;
    private String libraryCardStatus;

    public LibraryBookCard() {
    }

    public LibraryBookCard(int libraryCardld, String libraryCardName, User user, Date brrowDate, Date returnDate, Date actuaReturnDate, ArrayList<Book> listBook, String libraryCardStatus) {
        this.libraryCardld = libraryCardld;
        this.libraryCardName = libraryCardName;
        this.user = user;
        this.brrowDate = brrowDate;
        this.returnDate = returnDate;
        this.actuaReturnDate = actuaReturnDate;
        this.listBook = listBook;
        this.libraryCardStatus = libraryCardStatus;
    }

    public int getLibraryCardld() {
        return libraryCardld;
    }

    public void setLibraryCardld(int libraryCardld) {
        this.libraryCardld = libraryCardld;
    }

    public String getLibraryCardName() {
        return libraryCardName;
    }

    public void setLibraryCardName(String libraryCardName) {
        this.libraryCardName = libraryCardName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBrrowDate() {
        return brrowDate;
    }

    public void setBrrowDate(Date brrowDate) {
        this.brrowDate = brrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getActuaReturnDate() {
        return actuaReturnDate;
    }

    public void setActuaReturnDate(Date actuaReturnDate) {
        this.actuaReturnDate = actuaReturnDate;
    }

    public ArrayList<Book> getListBook() {
        return listBook;
    }

    public void setListBook(ArrayList<Book> listBook) {
        this.listBook = listBook;
    }

    public String getLibraryCardStatus() {
        return libraryCardStatus;
    }

    public void setLibraryCardStatus(String libraryCardStatus) {
        this.libraryCardStatus = libraryCardStatus;
    }



}
