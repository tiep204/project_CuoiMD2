package ra.presentation;

import ra.bussiness.entity.User;
import ra.bussiness.impl.UserImpl;
import ra.config.ShopMessage;

import java.util.Scanner;

public class loginManagement {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*--------------------------------------------------------*");
            System.out.println("|    **************Thu Vien Chuong My B***************   |");
            System.out.println("|                     1. Đăng nhập                       |");
            System.out.println("|                     2. Đăng ký                         |");
            System.out.println("|                     3. thoát                           |");
            System.out.println("*--------------------------------------------------------*");
            System.out.println("         sự lựa chọn của bạn: ");
            System.out.println("*---------------------------------------------------------*");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    UserImpl.locin(sc);
                    break;
                case 2:
                    UserImpl.Dangki();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println(ShopMessage.NOTIFY_LOGINMANAGEMENT_CHOICE);
            }
        } while (true);
    }
}




