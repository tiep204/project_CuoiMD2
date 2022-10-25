package ra.presentation;

import ra.config.ShopMessage;

import java.util.Scanner;

public class LibraryBookCardManagement {
    public static void LibraryBookCardManagement(Scanner sc) {
        boolean exit = true;

        do {
            System.out.println("*-------------------------------------------------------------*");
            System.out.println("|       ************PHIẾU MƯỢN TRẢ SÁCH**************         |");
            System.out.println("|         1. Danh sách các phiếu mượn trả                     |");
            System.out.println("|         2. Tạo phiếu mượn                                   |");
            System.out.println("|         3. Tạo phiếu trả                                    |");
            System.out.println("|         4. Cập nhật trạng thái người đọc                    |");
            System.out.println("|         5. Thoát                                            |");
            System.out.println("*-------------------------------------------------------------*");
            System.out.println("   sự lựa chọn của bạn:  ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTFY_LIBRARYBOOKCARDMANAGEMENT_CHOICE);

            }
        } while (exit);

    }
}
