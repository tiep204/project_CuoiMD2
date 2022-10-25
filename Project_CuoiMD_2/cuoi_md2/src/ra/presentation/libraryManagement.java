package ra.presentation;

import ra.bussiness.entity.User;
import ra.config.ShopMessage;

import java.util.Scanner;

public class libraryManagement {
    public static void libraryManagement(Scanner sc){
        boolean exit = true;

        do {
            System.out.println("*----------------------------------------------------*");
            System.out.println("|       ***********QUẢN LÝ THƯ VIỆN***********       |");
            System.out.println("|        1. Quản trị các danh mục                    |");
            System.out.println("|        2. Quản lý sách                             |");
            System.out.println("|        3. Quản lý thông tin người đọc              |");
            System.out.println("|        4. Phiếu mượn trả sách                      |");
            System.out.println("|        5. thoat                                    |");
            System.out.println("*----------------------------------------------------*");
            System.out.println("Đây là sự lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    CatalogManagement.catalogManagement(sc);
                    break;
                case 2:
                    BookManagement.BookManagement(sc);
                    break;
                case 3:
                    UserManagement.UserManagement(sc);
                    break;
                case 4:
                    LibraryBookCardManagement.LibraryBookCardManagement(sc);
                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTIFY_LIBRATYMANAGENMENT_CHOICE);
            }
        }while (exit);

    }

}
