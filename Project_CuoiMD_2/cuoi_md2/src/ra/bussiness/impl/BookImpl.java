package ra.bussiness.impl;

import ra.bussiness.design.Ilibrany;
import ra.bussiness.entity.Book;
import ra.config.ShopMessage;
import ra.data.DataURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.config.ShopValidate.checkValidate;

public class BookImpl implements Ilibrany<Book, String> {
    public static BookImpl bookimp = new BookImpl();
    @Override
    public boolean create(Book book) {
        List<Book> listbook = readFormFile();
        if (listbook == null) {
            listbook = new ArrayList<>();
        }
        listbook.add(book);
        boolean ketqua = writetoFile(listbook);
        return ketqua;
    }

    @Override
    public boolean update(Book book) {
        List<Book> listbook = readFormFile();
        if (listbook == null) {
            return false;
        } else {
            boolean checkboc = false;
            for (int i = 0; i < listbook.size(); i++) {
                if (listbook.get(i).getBookId().equals(book.getBookId())) {
                    listbook.set(i, book);
                    checkboc = true;
                    break;
                }
            }
            boolean result = writetoFile(listbook);
            if (checkboc && result) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean delete(String name) {
        List<Book> listbook = readFormFile();
        boolean check = false;
        for (Book book : listbook) {
            if (book.getBookName().equals(name)) {
                book.setBookStatus(ShopMessage.NOTIFY_BOOKIMPL_DELETE);
                check = true;
                break;
            }
        }
        boolean result = writetoFile(listbook);
        if (result && check) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Book> findbyName(String name) {
        List<Book> listbook = readFormFile();
        List<Book> list = new ArrayList<>();
        for (Book book : listbook) {
            if (book.getBookName().contains(name)) {
                list.add(book);
            }
        }
        return list;
    }

    @Override
    public void displayData() {
        List<Book> listBook = readFormFile();
        System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("%-15s%-20s%-15s%-70s%-20s%-15s\n","Id" , "Tên sách" , "Số lượng", "Tác giả", "Độ mới", "Trạng thái");
        System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");

        for (Book b : listBook) {
            System.out.printf("%-15s%-20s%-15s%-70s%-20s%-15s\n",b.getBookId(),b.getBookName(),b.getBookQuantity(),b.getListAuthor(),b.getBookStates(),b.getBookStatus());
        }
        System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
    }


    @Override
    public Book inputData(Scanner sc) {
        List<Book> listbook = readFormFile();
        if (listbook == null) {
            listbook = new ArrayList<>();
        }
        Book book = new Book();
        do {
            System.out.println("*--------------------------------------------------------------------*");
            System.out.println("           Bạn hãy nhập Id sách gồm 5 ký tự bắt đầu bằng chữ 'B'      ");
            System.out.println("*--------------------------------------------------------------------*");
            book.setBookId(checkValidate(sc, ShopMessage.NOTIFY_BOOKIMPL_INPUTDATA_CHECKVALI));
            boolean check = false;
            for (Book book1 : listbook) {
                if (book1.getBookId().equals(book.getBookId())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("*-------------------------------------------------------------------------*");
                System.out.println("                         Id của bạn đã tồn tại                             ");
                System.out.println("*-------------------------------------------------------------------------*");

            } else {
                break;
            }
        } while (true);
        System.out.println("*--------------------------------------------------------------------------*");
        System.out.println("                Mời bạn nhập tên sách(6-50 ký tự)                          ");
        System.out.println("*--------------------------------------------------------------------------*");
        book.setBookName(checkValidate(sc, ShopMessage.NOTIFY_BOOKIMPL_INPUTDATA_CHECKVALI_NAME));
        System.out.println("*---------------------------------------------------------------------------*");
        System.out.println("|                    moi ban nhap so luong sach:                            |");
        System.out.println("*---------------------------------------------------------------------------|");
        String string = checkValidate(sc, ShopMessage.NOTIFY_BOOKIMPL_INPUTDATA_CHECKVALI_QUATYTI);
        book.setBookQuantity(Integer.parseInt(string));
        do {
            System.out.println("*---------------------------------------------------------------------------*");
            System.out.println("                     Mời bạn nhập Họ và tên tác giả vào đây                  ");
            System.out.println("*---------------------------------------------------------------------------*");
            String author = checkValidate(sc, ShopMessage.NOTIFY_BOOKIMPL_INPUTDATA_AUTHORCHEKVALI);
            if (book.getListAuthor().size() == 0) {
                book.getListAuthor().add(author);
            } else {
                boolean check = false;
                for (String checkName : book.getListAuthor()) {
                    if (checkName.equals(author)) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    System.out.println("*---------------------------------------------------------------------------|");
                    System.out.println("               Tác giả của bạn đã tồn tại, vui lòng nhập tên mới             ");
                    System.out.println("*---------------------------------------------------------------------------|");
                } else {
                    book.getListAuthor().add(author);
                }
            }
            System.out.println("*-----------------------------------------------------*");
            System.out.println("|       Bạn có muốn thêm tác giả khác không           |");
            System.out.println("|        1. có            2. không                    |");
            System.out.println("*-----------------------------------------------------*");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                break;
            }
        } while (true);
        System.out.println("*-----------------------------------------------------*");
        System.out.println("|              Tình trạng của sách là:                |");
        System.out.println("|              1. Mới                                 |");
        System.out.println("|              2. Thường                              |");
        System.out.println("|              3. Cũ.                                 |");
        System.out.println("*-----------------------------------------------------*");
        int choicee = Integer.parseInt(sc.nextLine());
        if (choicee == 1) {
            book.setBookStates("Mới");
        } else if (choicee == 2) {
            book.setBookStates(" Bình thường ");
        } else {
            book.setBookStates("Cũ");
        }

        System.out.println("*-----------------------------------------------------*");
        System.out.println("|              Trạng thái của sách                    |");
        System.out.println("|              1. Hoạt động                           |");
        System.out.println("|              2. Hết sách                            |");
        System.out.println("|              3. Không hoạt động                     |");
        System.out.println("*-----------------------------------------------------*");
//        int choiceee = ShopValidate.Number(sc, 1,3);
        int choiceee = Integer.parseInt(sc.nextLine());
        switch (choiceee) {
            case 1:
                book.setBookStatus("Hoạt động");
                break;
            case 2:
                book.setBookStatus("Hết sách");
                break;
            case 3:
                book.setBookStatus("không hoạt động");
                break;
            default:
                System.out.println("Vui long chon từ 1-3");
        }
        return book;

    }

    @Override
    public List<Book> readFormFile() {
        List<Book> listbook = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(DataURL.URL_BOOK_FILE);
            if (file.exists()) {

                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                listbook = (List<Book>) ois.readObject();
            }
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
        return listbook;
    }

    @Override
    public boolean writetoFile(List<Book> list) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returnbook = true;
        try {
            file = new File(DataURL.URL_BOOK_FILE);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception ex) {
            returnbook = false;
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
        return returnbook;
    }

    public boolean checkbookName(String name) {
        List<Book> bookList = readFormFile();
        boolean check = false;
        for (Book boc : bookList) {
            if(boc.getBookName().equals(name)){
                check = true;
                break;
            }
        }
        return check;
    }
    public void UpdateBook(Scanner sc) {
        BookImpl bookIpm = new BookImpl();
        List<Book> listBook = new ArrayList<>();
        listBook = bookIpm.readFormFile();
        System.out.println("Hãy nhập id mà bạn muốn cập nhật : ");
        String str = sc.nextLine();
        for (Book book : listBook) {
            if (book.getBookId().equals(str)) {
                System.out.println("Nhập vào tên sách mà bạn muốn cập nhật");
                String name = sc.nextLine();
                if (name.trim() != "" && name.length() != 0) {
                    book.setBookName(name);
                }
                System.out.println("*-----------------------------------------------------*");
                System.out.println("|              Tình trạng của sách là:                |");
                System.out.println("|              1. Mới                                 |");
                System.out.println("|              2. Thường                              |");
                System.out.println("|              3. Cũ.                                 |");
                System.out.println("*-----------------------------------------------------*");
                System.out.println("sự lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1) {
                    book.setBookStates("mới");
                } else if (choice == 2) {
                    book.setBookStates("Thường");
                } else if (choice == 3) {
                    book.setBookStates("cũ");
                } else {
                    System.err.println("vui lòng nhập từ 1-3");
                }
                do {
                    System.out.println("Mời bạn nhập tên tác giả vào đây: ");
                    String author = checkValidate(sc, "^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,4}$");
                    if (book.getListAuthor().size() == 0) {
                        book.getListAuthor().add(author);
                    } else {
                        boolean check = false;
                        for (String checkName : book.getListAuthor()) {
                            if (checkName.equals(author)) {
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Tác giả của bạn đã tồn tại. vui lòng nhập tên mới");
                        } else {
                            book.getListAuthor().add(author);
                        }
                    }
                    System.out.println("*-----------------------------------------------------*");
                    System.out.println("|       Bạn có muốn thêm tác giả khác không           |");
                    System.out.println("|        1. có            2. không                    |");
                    System.out.println("*-----------------------------------------------------*");
                    int choice1 = Integer.parseInt(sc.nextLine());
                    if (choice1 != 1) {
                        break;
                    }
                } while (true);
                System.out.println("Mời nhập trạng thái mà bạn muốn cập nhật: ");
                System.out.println("*-----------------------------------------------------*");
                System.out.println("|              Trạng thái của sách                    |");
                System.out.println("|              1. Hoạt động                           |");
                System.out.println("|              2. Hết sách                            |");
                System.out.println("|              3. Không hoạt động                     |");
                System.out.println("*-----------------------------------------------------*");

                int choicee = Integer.parseInt(sc.nextLine());
                if(choicee == 1){
                    book.setBookStatus("Hoạt động");
                } else if (choicee == 2) {
                    book.setBookStatus("Hết sách");
                } else if (choicee == 3) {
                    book.setBookStatus("Không hoạt động");
                }else {
                    System.err.println("Vui lòng nhập từ 1-3");
                }
            }

        }
        writetoFile(listBook);

    }
    public void Delete(Scanner sc) {
        System.out.println("vui lòng nhập tên sách mà bạn muốn xóa vào đây: ");
        String bookName = sc.nextLine();
        boolean checkexist = bookimp.checkbookName(bookName);
        if (checkexist) {
            boolean bookkk = bookimp.delete(bookName);
            if (bookkk) {
                System.out.println("bạn đã xoa thành công: ");
            } else {
                System.out.println("Tên sách của bạn không tồn tại trong này: ");
            }
        }

    }
    public void searchBook(Scanner sc) {
        System.out.println("Nhập vào tên sách muốn tìm kiếm: ");
        String str = sc.nextLine();
        List<Book> bookList = bookimp.findbyName(str);
        if (bookList.size() == 0) {
            System.out.println("không có kết quả hợp lệ: ");
        } else {
            System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
            System.out.printf("%-15s%-20s%-15s%-70s%-20s%-15s\n","Id" , "Tên sách" , "Số lượng", "Tác giả", "Độ mới", "Trạng thái");
            System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
            for (Book book : bookList) {
                System.out.printf("%-15s%-20s%-15s%-70s%-20s%-15s\n",book.getBookId(),book.getBookName(),book.getBookQuantity(),book.getListAuthor(),book.getBookStates(),book.getBookStatus());
            }
        }
        System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
    }




}
