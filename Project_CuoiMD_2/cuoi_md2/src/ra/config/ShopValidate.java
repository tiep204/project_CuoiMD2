package ra.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShopValidate {
    public static String checkValidate(Scanner sc, String str){
        String ra;
        do {
            ra = sc.nextLine();
            if(ra.trim().matches(str)){
                break;

            }else{
                System.err.println("|              Vui lòng nhập đúng định dạng             |");
                System.out.println("*-------------------------------------------------------*");
            }
        }while (true);
        return ra;
    }


//    public static int Number(Scanner sc, int a, int b){
//        int number;
//        do {
//            System.out.println("Sự lựa chọn của bạn: ");
//            try {
//                number = Integer.parseInt(sc.nextLine());
//                if(number >= a && number>= b){
//                    break;
//                }else{
//                    System.out.println("vui lòng chọn trong khoảng từ: "+a + " đến " +b+ ":");
//                }
//            }catch (Exception e){
//                System.out.println("bạn hay nhap dung dinh dang");
//            }
//        }while (true);
////        return number;
//    }
    public static Date dayReturn(Scanner sc){
        Date date =new Date();
        String strDay;
        do {
           strDay =sc.nextLine();
            String dayVali="^([0-9]{2})/([1-9]|10|11|12)/([0-9]{4})$";
            boolean check = strDay.matches(dayVali);
            if (check){
                break;
            }else {
                System.out.println("ngay thang sai dinh dang, nhap lai");
            }
        }while (true);
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse(strDay);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return date;
    }
    public static Date endDay(Scanner sc){
        Date date = new Date();
        String strEndDay;
        do {
            strEndDay =sc.nextLine();
            String dayValid="^([0-9]{2})/([1-9]|10|11|12)/([0-9]{4})$";
            boolean check = strEndDay.matches(dayValid);
            if (check){
                break;
            }else {
                System.out.println("ngay thang sai dinh dang, nhap lai");
            }
        }while (true);
        DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse(strEndDay);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return date;
    }


}
