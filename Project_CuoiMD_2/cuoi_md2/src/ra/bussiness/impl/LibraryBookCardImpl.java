package ra.bussiness.impl;

import ra.bussiness.design.IlibraryBookCard;
import ra.bussiness.entity.Book;
import ra.bussiness.entity.LibraryBookCard;
import ra.data.DataURL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryBookCardImpl implements IlibraryBookCard<LibraryBookCard, String> {
    @Override
    public boolean create(LibraryBookCard libryBookCard) {
        List<LibraryBookCard> listlibraryBookCard = readFormFile();
        if (listlibraryBookCard == null) {
            listlibraryBookCard = new ArrayList<>();
        }
        listlibraryBookCard.add(libryBookCard);
        boolean kQ = writetoFile(listlibraryBookCard);
        return kQ;
    }

    @Override
    public boolean update(LibraryBookCard libryBookCard) {
        List<LibraryBookCard> libraryBookCardList = readFormFile();
        if (libraryBookCardList == null) {
            return false;
        } else {
            boolean check = false;
            for (int i = 0; i < libraryBookCardList.size(); i++) {
                if (libraryBookCardList.get(i).getLibraryCardld() == libryBookCard.getLibraryCardld()) {
                    libraryBookCardList.get(i).setListBook(libryBookCard.getListBook());
                    libraryBookCardList.get(i).setReturnDate(libryBookCard.getReturnDate());
                    check = true;
                    break;
                }
            }
            boolean result = writetoFile(libraryBookCardList);
            if (check && result) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean delete(String id) {
        int libraryCard = Integer.parseInt(id);
        List<LibraryBookCard> libraryBookCardList = readFormFile();
        BookImpl bookIpm = new BookImpl();
        List<Book> bookList = bookIpm.readFormFile();
        boolean check = false;
        for (LibraryBookCard librarycard : libraryBookCardList) {
            if (librarycard.getLibraryCardld() == libraryCard) {
                for (Book book : librarycard.getListBook()) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (book.getBookId().equals(bookList.get(i).getBookId())) {
                            bookList.get(i).setBookQuantity(bookList.get(i).getBookQuantity() + 1);
                            bookIpm.writetoFile(bookList);
                        }
                    }
                }
                Date date = new Date();
                librarycard.setActuaReturnDate(date);
                check = true;
                break;

            }
        }
        boolean result = writetoFile(libraryBookCardList);
        if (result && check) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<LibraryBookCard> findbyName(String name) {
        return null;
    }

    @Override
    public void displayData() {
        List<LibraryBookCard> listlibrarybookcard = readFormFile();
        for (LibraryBookCard li : listlibrarybookcard) {
            System.out.printf("Id Thẻ tv: ", li.getLibraryCardld(), " Tên thẻ tv: ", li.getLibraryCardName(), " Tên người dùng: ", li.getUser(), "Ngày mượn: ", li.getBrrowDate(), "Ngày trả: ", li.getReturnDate());

        }

    }

    @Override
    public LibraryBookCard inputData(Scanner sc) {
//        List<LibraryBookCard> listlibrarybookcardd = readFormFile();
//        if (listlibrarybookcardd == null) {
//            listlibrarybookcardd = new ArrayList<>();
//        }
//        LibraryBookCard librarycardd = new LibraryBookCard();
//        librarycardd.setLibraryCardld(listlibrarybookcardd.size() + 1);
//        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
//        Date date = new Date();
//        String stringName = format.format(date) + "   " + (int)(Math.random()*1000);
//        librarycardd.setLibraryCardName(stringName);
//        librarycardd.setBrrowDate(date);
//        System.out.println("Ngày trả sách");
//
//        librarycardd.setReturnDate();

        return null;
    }

    @Override
    public List<LibraryBookCard> readFormFile() {
        List<LibraryBookCard> listlibrarycard = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(DataURL.URL_LIBRARYCARD);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            listlibrarycard = (List<LibraryBookCard>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
        return listlibrarycard;
    }

    @Override
    public boolean writetoFile(List<LibraryBookCard> list) {
        return false;
    }

    @Override
    public LibraryBookCard searchByUserld(int Id) {
        List<LibraryBookCard> libraryBookCardList = readFormFile();
        if (libraryBookCardList == null) {
            libraryBookCardList = new ArrayList<>();
        }
        List<LibraryBookCard> listIdd = new ArrayList<>();
        for (LibraryBookCard listCard : libraryBookCardList) {
            if(listCard.getUser().getUserId() == Id){
                listIdd.add(listCard);
            }
        }
        return (LibraryBookCard) listIdd;
    }

}
