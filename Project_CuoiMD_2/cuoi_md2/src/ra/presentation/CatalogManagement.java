package ra.presentation;

import ra.bussiness.entity.Catalog;
import ra.bussiness.impl.CatalogImpl;
import ra.config.ShopMessage;

import java.util.List;
import java.util.Scanner;

public class CatalogManagement {
    public static CatalogImpl cat = new CatalogImpl();

    public static void catalogManagement(Scanner sc) {
        boolean exit = true;
        do {
            System.out.println("*---------------------------------------------------------*");
            System.out.println("|             ********QUẢN TRỊ CÁC DANH MỤC********       |");
            System.out.println("|                1. Danh sách danh mục sách               |");
            System.out.println("|                2. Tạo mới danh mục sách                 |");
            System.out.println("|                3. Cập nhật danh mục sách                |");
            System.out.println("|                4. Xóa danh mục sách                     |");
            System.out.println("|                5. Tìm kiếm danh mục sách                |");
            System.out.println("|                6. Thoát                                 |");
            System.out.println("*---------------------------------------------------------*");
            System.out.println("    Sự lựa chọn của bạn:        ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    cat.displayData();
                    break;
                case 2:
                    Catalog catalog = new Catalog();
                    catalog = cat.inputData(sc);
                    boolean check = cat.create(catalog);
                    if (check) {
                        System.out.println("them moi thanh cong");
                    } else
                        System.out.println("co loi trong qua trinh xu li");
                    break;
                case 3:
                    cat.UpdateCatalog(sc);
//                    catalog.UpdateCatalog(sc);
                    break;
                case 4:
                    cat.delete(sc);
                    break;
                case 5:
                    cat.search(sc);
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTIFY_CATALOGMANAGEMENT_CHOICE);
            }

        } while (exit);
    }

//    public static void UpdateCatalog(Scanner sc) {
//        Catalog cat1 = new Catalog();
//        System.out.println("Hãy nhập theo Id");
//        cat1.setCatalogId(Integer.parseInt(sc.nextLine()));
//        System.out.println("Nhập vào tên");
//        cat1.setCatalogName(sc.nextLine());
//        System.out.println("*----------------------------------------------------*");
//        System.out.println("|             1. hoạt động                           |");
//        System.out.println("|             2. khong hoạt động                     |");
//        System.out.println("*----------------------------------------------------*");
//        System.out.println("su lua chon cua ban ");
//        int chose = Integer.parseInt(sc.nextLine());
//        if (chose == 1) {
//            cat1.setCatalogStatus(true);
//        } else if (chose == 2) {
//            cat1.setCatalogStatus(false);
//        } else {
//            System.err.println("nhap lai 1 hoac 2");
//        }
//        boolean check = cat.update(cat1);
//        if (check) {
//            System.out.println("thanh cong");
//        } else {
//            System.out.println("ko thanh cong");
//        }
//    }

//    public static void delete(Scanner sc) {
//        System.out.println("vui lòng nhập tên danh mục muốn xóa: ");
//        String catalogName = sc.nextLine();
//        boolean checkexist = cat.checkcatalogName(catalogName);
//        if (checkexist) {
//            boolean cattt = cat.delete(catalogName);
//            if (cattt) {
//                System.out.println("xoa thành công");
//            } else {
//                System.out.println("thất bại");
//            }
//        } else {
//            System.out.println("Tên danh mục của bạn không tồn tại: ");
//        }
//
//    }

//    public static void search(Scanner sc) {
//        System.out.println("Nhập vào tên danh mục muốn tìm kiếm: ");
//        String str = sc.nextLine();
//        List<Catalog> catalogList = cat.findbyName(str);
//        if (catalogList.size() == 0) {
//            System.out.println("khong co ket qua");
//        } else {
//            String status;
//
//            for (Catalog catalog : catalogList) {
//                status = catalog.isCatalogStatus() ? "Hoạt động" : "Không hoạt động"; // if(catalog.iscatalogstatus){status = "hoat dong"} else{status = "khong hoat dong"}
//                System.out.println("id: " + catalog.getCatalogId() + " Tên: " + catalog.getCatalogName() + " trạng thái: " + status);
//
//            }
//        }
//
//
//    }


}
