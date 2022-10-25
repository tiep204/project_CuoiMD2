package ra.presentation;

import ra.bussiness.entity.User;
import ra.bussiness.impl.UserImpl;
import ra.config.ShopMessage;

import java.util.List;
import java.util.Scanner;

public class UserManagement {
    public static UserImpl useripm = new UserImpl();
    public static void UserManagement(Scanner sc){
        boolean exit = true;
        do {
            System.out.println("*---------------------------------------------------------------------*");
            System.out.println("|      ************QUẢN LÝ THÔNG TIN NGƯỜI ĐỌC************            |");
            System.out.println("|             1. Danh sách người đọc                                  |");
            System.out.println("|             2. Tạo mới người đọc                                    |");
            System.out.println("|             3. Cập nhật thông tin                                   |");
            System.out.println("|             4. Xóa người đọc                                        |");
            System.out.println("|             5. Tìm kiếm người đọc                                   |");
            System.out.println("|             6. Thoát                                                |");
            System.out.println("*---------------------------------------------------------------------*");
            System.out.println(" Sự lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    useripm.displayData();
                    break;
                case 2:
                    User user = new User();
                    user = useripm.inputData(sc);
                    boolean check = useripm.create(user);
                    if(check){
                        System.out.println("Thêm mới người đọc thành công");
                    }else{
                        System.out.println("thêm mới không thành công");
                    }
                    break;
                case 3:
                    //Nhap vao userID can cap nhat thong tin
                    System.out.println("Nhap vao ma nguoi dung can cap nhat thong tin: ");
                    int userId = Integer.parseInt(sc.nextLine());
                    //Cho phap cap nhat thong tin
                    User userUpdate = UserImpl.updateUserInfor(userId,sc);
                    //Cap nhat user
                    if (userUpdate!=null){
                        useripm.update(userUpdate);
                    }else{
                        System.err.println("Khong ton tai user");
                    }
                    break;
                case 4:
                    useripm.deleteee(sc);
                    break;
                case 5:
                    useripm.search(sc);
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTIFY_USERMANAGEMENT_CHOICE);
            }
        }while (exit);
    }


}
