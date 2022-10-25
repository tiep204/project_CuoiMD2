package ra.bussiness.impl;

import ra.bussiness.design.IUser;
import ra.bussiness.entity.Book;
import ra.bussiness.entity.User;
import ra.config.ShopMessage;
import ra.config.ShopValidate;
import ra.data.DataURL;
import ra.presentation.libraryManagement;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserImpl implements IUser<User, String> {
    public static UserImpl userIpm = new UserImpl();

    @Override
    public boolean checkLogin(String name, String pass) {

        return false;
    }


    @Override
    public boolean create(User user) {
        List<User> userList = readFormFile();
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user);
        boolean kq = writetoFile(userList);
        return kq;
    }

    @Override
    public boolean update(User user) {
        //1. Doc file lay danh sach toan bo user
        List<User> userList = readFormFile();
        //2. Kiem tra user da ton tai trong danh sach chua
        if (userList == null) {
            return false;
        } else {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserId() == user.getUserId()) {
                    //3. Cap nhat thong tin user trong danh sach
                    userList.set(i, user);
                    break;
                }
            }
            //4. ghi danh sach user da duoc cap nhat vao file
            boolean kq = writetoFile(userList);
            return kq;
        }

    }

    public static User updateUserInfor(int userId, Scanner sc) {
        /*
         * 1. Doc file lay ra danh sach user --> listUser
         * 2. Lay ra user can cap nhat trong listUser theo userId
         * 3. Cho nhap thong tin cap nhat cua user
         * 4. return user
         * */
        UserImpl userImp = new UserImpl();
        //1.
        List<User> listUser = userImp.readFormFile();
        //2.
        for (User user : listUser) {
            if (user.getUserId() == userId) {
                //3.Cap nhat thong tin cho user
                System.out.println(ShopMessage.NOTIFY_USERIMPL_UPDATE);
                String userName = sc.nextLine();
                if (userName != null && userName.length() != 0) {
                    user.setUserName(userName);
                }
                System.out.println(ShopMessage.NOTIFY_USERIMPL_PHONE);
                String phone = sc.nextLine();
                if (phone != null && phone.length() != 0) {
                    user.setPhoneNuber(Integer.parseInt(phone));
                }
                //Nhap tiep thong tin
                System.out.println(ShopMessage.NOTIFY_USERIMPL_EMAIL);
                String email = sc.nextLine();
                if (email != null && email.length() != 0) {
                    user.setEmail(email);
                }
                System.out.println(ShopMessage.NOTIFY_USERIMPL_ADDRESS);
                String address = sc.nextLine();
                if (address != null && address.length() != 0) {
                    user.setAddress(address);
                }
                System.out.println("*------------------------------------------------------------*");
                System.out.println("|                Vui lòng nhập trạng thái vào đây            |");
                System.out.println("|                1. Hoạt động                                |");
                System.out.println("|                2. Không hoạt động                          |");
                System.out.println("*------------------------------------------------------------*");

                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    user.setUserStatus(true);
                }
                //4. return user
                return user;
            }
        }
        return null;
    }

    public void deleteee(Scanner sc) {
        System.out.println(ShopMessage.NOTIFY_USERIMPL_DELETEEE);
        String userIdd = sc.nextLine();
        boolean checkexist = userIpm.checkUserId(Integer.parseInt(userIdd));
        if (checkexist) {
            boolean check = userIpm.delete(userIdd);
            if (check) {
                System.out.println(ShopMessage.NOTIFY_USERIMPL_DELETEEE_DELETE);
            } else {
                System.err.println(ShopMessage.NOTIFY_USERIMPL_DELETEEE_NOT_DELETE);
            }
        }
    }


    public boolean checkUserId(Integer id) {
        List<User> userList = readFormFile();
        boolean check = false;
        for (User us : userList) {
            if (us.getUserId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public boolean delete(String id) {
        int idUser = Integer.parseInt(id);
        List<User> userList = readFormFile();
        boolean check = false;
        for (User user : userList) {
            if (user.getUserId() == idUser) {
                user.setUserStatus(false);
                return writetoFile(userList);
            }
        }
        return false;
    }

    @Override
    public List<User> findbyName(String name) {
        List<User> userList = readFormFile();
        List<User> userList1 = new ArrayList<>();
        for (User u : userList) {
            if (u.getUserName().contains(name)) {
                userList1.add(u);
            }
        }
        return userList1;
    }

    @Override
    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat(ShopMessage.NOTIFY_USERIMPL_DISPLAYDATA_DATE);
        List<User> listuser = readFormFile();
        String status = "Hoat dong";
        if (listuser == null) {
            System.out.println(ShopMessage.NOTIFY_USERIMPL_DISPLAYDATA);
        } else {
            System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
            System.out.printf("%-5s%-20s%-15s%-40s%-30s%-20s%-20s%-15s\n", "ID", "Ten nguoi dung", "So dien thoai", "Email", "Dia chi", "Ngay bat dau", "Ngay het han", "Trang thai      ");
            System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");

            for (User user : listuser) {
                status = (user.isUserStatus()) ? "Hoat dong" : "Khong hoat dong";
                System.out.printf("%-5s%-20s%-15s%-40s%-30s%-20s%-20s%-15s\n", user.getUserId(), user.getUserName(), user.getPhoneNuber(), user.getEmail(), user.getAddress(), sdf.format(user.getLibrarycardStartDay()), sdf.format(user.getLibrarycardEndday()), status);

            }
            System.out.println("*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*");

        }
    }

    @Override
    public User inputData(Scanner sc) {
        List<User> listuser = readFormFile();
        if (listuser == null) {
            listuser = new ArrayList<>();
        }
        User user = new User();
        user.setUserId(listuser.size() + 1);
        do {
            System.out.println("*--------------------------------------------------------------------*");
            System.out.println("              Mời bạn nhập tên người đọc (từ 6-50) ký tự              ");
            System.out.println("*--------------------------------------------------------------------*");

            String inputName = sc.nextLine();
            String name = ShopMessage.NOTIFY_USERIMPL_INPUTDATA_NAME;
            boolean checkName = inputName.matches(name);
            if (checkName) {
                user.setUserName(inputName);
                break;
            } else {
                System.out.println("*--------------------------------------------------------------------*");
                System.err.println("                    Vui lòng nhập từ 6-50 ký tự                       ");
                System.out.println("*--------------------------------------------------------------------*");
            }

            user.setUserName(sc.nextLine());
            boolean check = false;
            for (User userr : listuser) {
                if (userr.getUserName().equals(user.getUserName())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.err.println(ShopMessage.NOTIFY_USERIMPL_INPUTDATA_NOTNOTNAME);
            } else {
                break;
            }
        } while (true);
        do {
            System.out.println("*--------------------------------------------------------------------*");
            System.out.println("              Hãy nhập số điện thoại của bạn vào đây                  ");
            System.out.println("*--------------------------------------------------------------------*");
            String inputPhone = sc.nextLine();
            String phone = ShopMessage.NOTIFY_USERIMPL_INPUTDATA_CHECK_PHONE;
            boolean checkPhone = inputPhone.matches(phone);
            if (checkPhone) {
                user.setPhoneNuber(Integer.parseInt(inputPhone));
                break;
            } else {
                System.err.println(ShopMessage.NOTIFY_USERIMPL_INPUTDATA_CHECK_NOT_PHONE);
            }
        } while (true);
        do {
            System.out.println("*--------------------------------------------------------------------*");
            System.out.println("*                 Hãy nhập email của bạn vào đây:                    *");
            System.out.println("*--------------------------------------------------------------------*");
            String inputEmail = sc.nextLine();
            String email = ShopMessage.NOTIFY_USERIMPL_INPUTDATA_CHECK_EMAILL;
            boolean checkEmail = inputEmail.matches(email);
            if (checkEmail) {
                user.setEmail(inputEmail);
                break;
            } else {
                System.err.println(ShopMessage.NOTIFY_USERIMPL_INPUTDATA_CHECK_NOTEMAILL);
            }
        } while (true);

        System.out.println("*--------------------------------------------------------------------*");
        System.out.println("*                       Nhập địa chỉ của bạn vào đây:                *");
        System.out.println("*--------------------------------------------------------------------*");
        user.setAddress(sc.nextLine());
        System.out.println("*--------------------------------------------------------------------*");
        System.out.println("*         mời bạn nhập ngày mua thẻ thư viện vào đây(dd/MM/yyyy):    *");
        System.out.println("*--------------------------------------------------------------------*");
        user.setLibrarycardStartDay(ShopValidate.dayReturn(sc));
        do {
            System.out.println("*--------------------------------------------------------------------*");
            System.out.println("*              Mời bạn nhập ngày hết hạn(dd/MM/yyyy)                 *");
            System.out.println("*--------------------------------------------------------------------*");
            user.setLibrarycardEndday(ShopValidate.endDay(sc));
            int checkday = user.getLibrarycardStartDay().compareTo(user.getLibrarycardEndday());
            if (checkday < 0) {
                break;
            } else {
                System.err.println(ShopMessage.NOTIFY_USERIMPL_INPUTDATA_CHECK_LIBRARYDAY);
            }


        } while (true);
        System.out.println("*------------------------------------------------------------*");
        System.out.println("|                Vui lòng nhập trạng thái vào đây            |");
        System.out.println("|                1. Hoạt động                                |");
        System.out.println("|                2. Không hoạt động                          |");
        System.out.println("*------------------------------------------------------------*");

//        int choice = ShopValidate.Number(sc , 1 , 2);
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            user.setUserStatus(true);
        }


        return user;
    }

    @Override
    public List<User> readFormFile() {
        List<User> listUser = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(DataURL.URL_USER_FILE);
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                listUser = (List<User>) ois.readObject();
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
        return listUser;
    }

    @Override
    public boolean writetoFile(List<User> list) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returnData = true;
        try {
            file = new File(DataURL.URL_USER_FILE);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception ex) {
            returnData = false;
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
        return returnData;
    }

    public void search(Scanner sc) {
        SimpleDateFormat sdf = new SimpleDateFormat(ShopMessage.NOTIFY_USERIMPL_SEARCH_CHECK_DAY);
        System.out.println("*------------------------------------------------------------*");
        System.out.println("*      Nhập vào tên danh mục mà bạn muốn tìm kiếm vào đây    *");
        System.out.println("*------------------------------------------------------------*");

        String strUser = sc.nextLine();
        List<User> userList = userIpm.findbyName(strUser);
        if (userList.size() == 0) {
            System.err.println(ShopMessage.NOTIFY_USERIMPL_SEARCH_INPUTNOTNAME);
        } else {
            String statusUser;
            System.out.printf("%-5s%-20s%-15s%-40s%-30s%-20s%-20s%-15s\n", "ID", "Ten nguoi dung", "So dien thoai", "Email", "Dia chi", "Ngay bat dau", "Ngay het han", "Trang thai      ");

            for (User use : userList) {
                statusUser = use.isUserStatus() ? "Hoạt động " : "không hoạt động";
                System.out.printf("%-5s%-20s%-15s%-40s%-30s%-20s%-20s%-15s\n", use.getUserId(), use.getUserName(), use.getPhoneNuber(), use.getEmail(), use.getAddress(), sdf.format(use.getLibrarycardStartDay()), sdf.format(use.getLibrarycardEndday()), statusUser);

            }
        }
    }

    public static void locin(Scanner sc) {
        do {
            System.out.println("*------------------------------------------------------------*");
            System.out.println("*             Mời bạn nhập tên tài khoản vào đây             *");
            System.out.println("*------------------------------------------------------------*");
            String inputName = sc.nextLine();
            System.out.println("*------------------------------------------------------------*");
            System.out.println("*                 Nhập mật khẩu vào đây                      *");
            System.out.println("*------------------------------------------------------------*");
            String inputPass = sc.nextLine();
            String checkName = ShopMessage.ACCOUNT;
            String checkPass = ShopMessage.PASSWORD;
            boolean checkout1 = inputPass.matches(checkPass);
            boolean checkout = inputName.matches(checkName);
            if (checkout && checkout1) {
                System.out.println(ShopMessage.NOTIFY_USERIMPL_LOCIN);
                break;
            } else {
                System.err.println(ShopMessage.NOTIFY_USERIMPL_LOCIN_);
            }
        } while (true);
        libraryManagement.libraryManagement(sc);
    }
    public static void Dangki(){
        System.err.println(ShopMessage.NOTIFY_LOGINMANAGEMENT_CHOICEE);
    }
}



