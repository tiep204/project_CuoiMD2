package ra.bussiness.impl;

import ra.bussiness.design.ICatalog;
import ra.bussiness.entity.Catalog;
import ra.config.ShopMessage;
import ra.config.ShopValidate;
import ra.data.DataURL;

import java.io.*;
import java.util.*;

public class CatalogImpl implements ICatalog<Catalog, String> {
    public static CatalogImpl cat = new CatalogImpl();


    @Override
    public List<Catalog> sorlbyName() {
        List<Catalog> listcatalog = readFormFile();
        if (listcatalog == null) {
            listcatalog = new ArrayList<>();
        }
        Collections.sort(listcatalog, new Comparator<Catalog>() {
            @Override
            public int compare(Catalog o1, Catalog o2) {
                return o1.getCatalogName().compareTo(o2.getCatalogName());
            }
        });
        return listcatalog;
    }

    @Override
    public boolean create(Catalog catalog) {
        List<Catalog> listCatalog = readFormFile();
        if (listCatalog == null) {
            listCatalog = new ArrayList<>();
        }
        listCatalog.add(catalog);
        boolean result = writetoFile(listCatalog);
        return result;
    }

    @Override
    public boolean update(Catalog catalog) {
        List<Catalog> listcatalog = readFormFile();
        if (listcatalog == null) {
            return false;
        } else {
            boolean checkcat = false;
            for (int i = 0; i < listcatalog.size(); i++) {
                if (listcatalog.get(i).getCatalogId() == catalog.getCatalogId()) {
                    listcatalog.set(i, catalog);
                    checkcat = true;
                    break;
                }
            }
            boolean kQ = writetoFile(listcatalog);
            if (checkcat && kQ) {
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean delete(String name) {
        List<Catalog> listcatalof = readFormFile();
        boolean check = false;
        for (Catalog catalog : listcatalof) {
            if (catalog.getCatalogName().equals(name)) {
                catalog.setCatalogStatus(!catalog.isCatalogStatus());
                check = true;
                break;
            }
        }
        boolean result = writetoFile(listcatalof);
        if (result && check) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Catalog> findbyName(String name) {
        List<Catalog> listcatalog = readFormFile();
        List<Catalog> list = new ArrayList<>();
        for (Catalog cat : listcatalog) {
            if(cat.getCatalogName().contains(name)){
                list.add(cat);
            }

        }
        return list;

    }
    public boolean checkcatalogName(String name) {
        List<Catalog> catalogList = readFormFile();
        boolean check = false;
        for (Catalog cat : catalogList) {
            if (cat.getCatalogName().equals(name)) {
                check = true;
                break;
            }
        }
        return check;
    }


    @Override
    public void displayData() {
        List<Catalog> listcatalog = sorlbyName();
        String status = "Hoạt động";
        if (listcatalog == null) {
            System.out.println(ShopMessage.NOTIFY_CATALOGIMPL_DISPLAYDATA_NULL);
        } else {
            System.out.println("*---------------------------------------------------------------------------------------------------------------*");
            System.out.printf("%-15s%-15s%-15s\n","Id","Tên", "Trạng thái người dùng");

            for (Catalog catalog : listcatalog) {
                if (catalog.isCatalogStatus()) {
                    status = " hoạt động";
                } else {
                    status = " khong hoat dong";
                }
                System.out.printf("%-15s%-15s%-15s\n",catalog.getCatalogId(),catalog.getCatalogName(),status);
            }
            System.out.println("*---------------------------------------------------------------------------------------------------------------*");

        }

    }

    @Override
    public Catalog inputData(Scanner sc) {
        List<Catalog> listcatalog = readFormFile();
        if (listcatalog == null) {
            listcatalog = new ArrayList<>();
        }
        Catalog catalog = new Catalog();
        catalog.setCatalogId(listcatalog.size() + 1);
        do {
            System.out.println("*---------------------------------------------------*");
            System.out.println("|           Mời bạn nhập vào tên(6-50 ký tự)        |");
            System.out.println("*---------------------------------------------------*");
            catalog.setCatalogName(ShopValidate.checkValidate(sc, ShopMessage.NOTIFY_CATALOGIMPL_INPUTDATA_CHECKVALI));
            boolean check = false;
            for (Catalog catalo : listcatalog) {
                if (catalo.getCatalogName().equals(catalog.getCatalogName())) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("");
                System.err.println(ShopMessage.NOTIFY_CATALOGIMPL_INPUTDATA_NOT_CHECKVALI);
            } else {
                break;
            }
        } while (true);
        System.out.println("*------------------------------------------------------------*");
        System.out.println("|                Vui lòng nhập trạng thái vào đây            |");
        System.out.println("|                1. Hoạt động                                |");
        System.out.println("|                2. Không hoạt động                          |");
        System.out.println("*------------------------------------------------------------*");

        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            catalog.setCatalogStatus(true);
        }
        return catalog;
    }

    @Override
    public List<Catalog> readFormFile() {
        List<Catalog> listCatalog = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(DataURL.URL_CATALOG_FILE);
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                listCatalog = (List<Catalog>) ois.readObject();
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

        return listCatalog;
    }

    @Override
    public boolean writetoFile(List<Catalog> list) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean returnData = true;
        try {
            file = new File(DataURL.URL_CATALOG_FILE);
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
    public void UpdateCatalog(Scanner sc) {
        Catalog cat1 = new Catalog();
        System.out.println("Hãy nhập theo Id");
        cat1.setCatalogId(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập vào tên");
        cat1.setCatalogName(sc.nextLine());
        System.out.println("*----------------------------------------------------*");
        System.out.println("|             1. hoạt động                           |");
        System.out.println("|             2. khong hoạt động                     |");
        System.out.println("*----------------------------------------------------*");
        System.out.println("su lua chon cua ban ");
        int chose = Integer.parseInt(sc.nextLine());
        if (chose == 1) {
            cat1.setCatalogStatus(true);
        } else if (chose == 2) {
            cat1.setCatalogStatus(false);
        } else {
            System.err.println("nhap lai 1 hoac 2");
        }
        boolean check = cat.update(cat1);
        if (check) {
            System.out.println("thanh cong");
        } else {
            System.out.println("ko thanh cong");
        }
    }

    public void delete(Scanner sc) {
        System.out.println("vui lòng nhập tên danh mục muốn xóa: ");
        String catalogName = sc.nextLine();
        boolean checkexist = cat.checkcatalogName(catalogName);
        if (checkexist) {
            boolean cattt = cat.delete(catalogName);
            if (cattt) {
                System.out.println("xoa thành công");
            } else {
                System.out.println("thất bại");
            }
        } else {
            System.out.println("Tên danh mục của bạn không tồn tại: ");
        }

    }
    public void search(Scanner sc) {
        System.out.println("Nhập vào tên danh mục muốn tìm kiếm: ");
        String str = sc.nextLine();
        List<Catalog> catalogList = cat.findbyName(str);
        if (catalogList.size() == 0) {
            System.out.println("khong co ket qua");
        } else {
            String status;

            System.out.println("*---------------------------------------------------------------------------------------------------------------*");
            System.out.printf("%-15s%-15s%-15s\n","Id","Tên", "Trạng thái người dùng");
            System.out.println("*---------------------------------------------------------------------------------------------------------------*");
            for (Catalog catalog : catalogList) {
                status = catalog.isCatalogStatus() ? "Hoạt động" : "Không hoạt động"; // if(catalog.iscatalogstatus){status = "hoat dong"} else{status = "khong hoat dong"}
                System.out.printf("%-15s%-15s%-15s\n",catalog.getCatalogId(),catalog.getCatalogName(),status);

            }
            System.out.println("*---------------------------------------------------------------------------------------------------------------*");

        }


    }



}
