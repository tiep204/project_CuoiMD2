package ra.presentation;

import ra.bussiness.entity.Book;
import ra.bussiness.entity.Catalog;
import ra.bussiness.impl.BookImpl;
import ra.config.ShopMessage;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.config.ShopValidate.checkValidate;

public class BookManagement {
    public static BookImpl bookimp = new BookImpl();

    public static void BookManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("*------------------------------------------------------*");
            System.out.println("|        **************QUẢN LÝ SÁCH*****************   |");
            System.out.println("|             1. Danh sách sách                        |");
            System.out.println("|             2. Tạo mới sách                          |");
            System.out.println("|             3. Cập nhật thông tim sách               |");
            System.out.println("|             4. Xóa sách                              |");
            System.out.println("|             5. Tìm kiếm                              |");
            System.out.println("|             6. Thoát                                 |");
            System.out.println("*------------------------------------------------------*");
            System.out.println("   Sự lựa chọm của bạn:  ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    bookimp.displayData();
                    break;
                case 2:
                    Book boc = new Book();
                    boc = bookimp.inputData(sc);
                    boolean check = bookimp.create(boc);
                    if (check) {
                        System.out.println(ShopMessage.NOTIFY_BOOKMANAGEMENT_CHOICE1);
                    } else {
                        System.out.println(ShopMessage.NOTIFY_BOOKMANAGEMENT_CHOICE2);
                    }
                    break;
                case 3:
                    bookimp.UpdateBook(sc);
                    break;
                case 4:
                    bookimp.Delete(sc);
                    break;
                case 5:
                    bookimp.searchBook(sc);
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTIFY_BOOKMANAGEMENT_CHOICE);
            }
        } while (exit);
    }
}


