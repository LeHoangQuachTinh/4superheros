/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Customer extends Account implements IDish {
    private List<Order> Orders;
    private HashMap<String,Dish> gioHang;

    public Customer(boolean status, String idUser, String username, String password, String SDT, String diachi) {
        super(idUser, username, password, SDT, diachi);
        Orders =new ArrayList<>();
        gioHang=new HashMap<>();
    }

    //thêm món ăn vào danh sách menu
//    public void menu_MonAn() {
//        menu.add(new Dish("MA0001","Phở bò", 50000, 5));
//        menu.add(new Dish("MA0002","Bánh mì thịt", 25000, 6));
//        menu.add(new Dish("MA0003","Gà rán", 60000, 7));
//        menu.add(new Dish("MA0004","Bún chả", 45000, 8));
//        menu.add(new Dish("MA0005","Nem rán", 30000, 9));
//        menu.add(new Dish("MA0006","Cơm tấm sườn bì chả", 40000, 5));
//        menu.add(new Dish("MA0007","Lẩu thái", 150000, 4));
//        menu.add(new Dish("MA0008","Bún bò Huế", 50000, 3));
//        menu.add(new Dish("MA0009","Hủ tiếu Nam Vang", 45000, 2));
//        menu.add(new Dish("MA0010","Mì Quảng", 40000, 1));
//        menu.add(new Dish("MA0011","Chả cá Lã Vọng", 120000, 10));
//        menu.add(new Dish("MA0012","Xôi gà", 30000, 9));
//        menu.add(new Dish("MA0013","Canh chua cá lóc", 80000, 8));
//        menu.add(new Dish("MA0014","Sườn xào chua ngọt", 90000, 7));
//        menu.add(new Dish("MA0015","Bánh xèo", 35000, 6));
//    }

    //hiển thị menu món ăn
    
//    public void hienThiMonAn(){
//        System.out.println("Danh sách món ăn!");
//        for (int i = 0; i < menu.size(); i++) {
//            Dish mon = menu.get(i);
//            System.out.println((i + 1) + ". " + mon.getNameDish() + " - " + mon.getPrice() + " VND");
//        }
//    }
    
    // Thêm món ăn vào giỏ hàng
    //thêm danh sách món ăn
    // @Override
    // public void addDish(String tenMon, int soLuong,List<Dish> menu){
    //     for (Dish mon : menu) {
    //         if (mon.getNameDish().equalsIgnoreCase(tenMon)) {
    //             boolean daCo = false;
    //             for (Dish monGioHang : gioHang) {
    //                 if (monGioHang.getNameDish().equalsIgnoreCase(tenMon)) {
    //                     monGioHang.setQuality(monGioHang.getQuality() + soLuong);
    //                     System.out.println("Đã thêm! Món:"+tenMon  +" ||Số lượng:" +soLuong + " " +  " vào giỏ hàng.");
    //                     daCo = true;
    //                     break;
    //                 }
    //             }
    //             if (!daCo) {  
    //                 Dish monMoi = new Dish(mon.getIdDish(), mon.getNameDish(), mon.getPrice(), soLuong);  
    //                 gioHang.add(monMoi);  
    //                 System.out.println("Đã thêm " + soLuong + " " + tenMon + " vào giỏ hàng.");
    //         }
    //             return;
    //         }
    //     }
    //     System.out.println("Món ăn " + tenMon + " không có trong menu.");
    // }
    public double tinhTongTienGioHang(){
        if (gioHang.isEmpty()) 
            System.out.println("Giỏ hàng của bạn đang trống!");
            
        else {
            System.out.println("Giỏ hàng của bạn:");
            double tongTien = 0;
            for (Dish mon : gioHang.values()) {
                System.out.println(mon);
                tongTien += mon.getPrice() * mon.getQuality(); 
            }
            System.out.println("Tổng tiền: " + tongTien + " VND");
            return tongTien;
        }
        return 0;
    }
  
    // Đặt hàng từ giỏ hàng
    public void muaHangGioHang() {
        if (gioHang.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống. Không thể đặt hàng.");
            return;
        }
        String orderId = random(8);
        Order newOrder = new Order(orderId, new ArrayList<>(gioHang.values()));
        Orders.add(newOrder);
        gioHang.clear(); 
        System.out.println("Đặt hàng từ giỏ hàng thành công! Mã đơn hàng: " + orderId);
    }
    
    
    // Đặt hàng mua trực tiếp
    // public void muaHangTrucTiep(List<Dish> menu) {
    //     Scanner scanner = new Scanner(System.in);
        
    //     // Hiển thị danh sách menu
    //     System.out.println("Danh sách món ăn trong menu:");
    //     System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Tên món", "Giá", "Số lượng");
    //     for (Dish mon : menu) {
    //         System.out.printf("%-10s %-20s %-10.2f %-10d%n", mon.getIdDish(), mon.getNameDish(), mon.getPrice(), mon.getQuality());
    //     }
        
    //     System.out.print("Nhập tên món ăn: ");
    //     String tenMonString = scanner.nextLine();
    //     System.out.print("Nhập số lượng: ");
    //     int soLuong = scanner.nextInt();
    //     scanner.nextLine();

    //     boolean monAnTonTai = false;
    //     for (Dish mon : menu) {
    //         if (mon.getNameDish().equalsIgnoreCase(tenMonString)) {
    //             monAnTonTai = true;
    //             String OrderId = random(8);
    //             Order themMon = new Order(OrderId, tenMonString, soLuong);
    //             Orders.add(themMon);
    //             System.out.println("Đặt hàng thành công! Mã đơn hàng: " + OrderId);
    //             break;
    //         }
    //     }
    //     if (!monAnTonTai) {
    //         System.out.println("Món ăn không tồn tại trong menu.");
    //     }
    // }
    
    //Xem trạng thái đặt hàng
    public void viewOrderStatus() {
        if (Orders.isEmpty()) {
            System.out.println("Bạn chưa có đơn hàng nào.");
        } 
        else {
            for (Order Order : Orders) {
                System.out.println(Order);
            }
        }
    }

    //Giảm số lượng món ăn  trong gio hang
    // @Override
    // public void editDish(String tenMon, int soLuong){
    //     for (Dish monGioHang : gioHang.values()) {
    //         if (monGioHang.getNameDish().equalsIgnoreCase(tenMon)){
    //             monGioHang.setQuality(monGioHang.getQuality()-soLuong);
    //             System.out.println("Đã tGiảm số lượng! Món:"+tenMon  +" ||số lượng:" +soLuong + " " +  " trong giỏ hàng.");
    //             return;
    //         }
    //     }
    //     System.out.println("Món ăn " + tenMon + " không có trong gio hang.");
    // }


    
    //tạo hàm random số otp
    public String random(int so){
        SecureRandom random=new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for(int i=0;i<so;i++){
            int soOTP = random.nextInt(10);
            otp.append(soOTP);
        }
        return otp.toString();
    }

    //khóa tài khoản
    @Override
    public void lockAccount() {
         this.isLocked=true;
        System.out.println("Tài khoản đã được khóa!");
    }

    //mở tài khoản
    // @Override
    // public void openAccount() {
    //     this.isLocked=false;
    //     System.out.println("Tài khoản đã được mở");
    // }

    // @Override
    // public void editAccount() {
    //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    // }
    
    // Đăng nhập
    @Override
    public boolean login(String idUser, String password) {
        return this.idUser.equals(idUser) && this.password.equals(password);
    }

    @Override
    public void addDish(Dish mon) {
        if (gioHang.containsKey(mon.getIdDish())) {
            Dish existingDish = gioHang.get(mon.getIdDish());
            existingDish.setQuality(existingDish.getQuality() + mon.getQuality());
            System.out.println("Cập nhật số lượng món: " + mon.getNameDish());
        } else {
            gioHang.put(mon.getIdDish(), mon);
            System.out.println("Đã thêm món: " + mon.getNameDish() + " vào giỏ hàng.");
        }
    }
    

    @Override
    public void deleteDish(String tenMon) {
        for (Dish mon : gioHang.values()) {
            if (mon.getNameDish().equalsIgnoreCase(tenMon)) {
                gioHang.remove(mon.getIdDish());
                System.out.println("Đã xóa món: " + tenMon + " khỏi giỏ hàng.");
                return;
            }
        }
        System.out.println("Món ăn " + tenMon + " không có trong giỏ hàng.");
}


    @Override
    public void editDish(String tenMon, int soLuong) {
        for (Dish monGioHang : gioHang.values()) {
            if (monGioHang.getNameDish().equalsIgnoreCase(tenMon)) {
                int newQuality = monGioHang.getQuality() - soLuong;
                if (newQuality <= 0) {
                    gioHang.remove(monGioHang.getIdDish());
                    System.out.println("Món " + tenMon + " đã được xóa khỏi giỏ hàng.");
                } else {
                    monGioHang.setQuality(newQuality);
                    System.out.println("Đã giảm số lượng món: " + tenMon + " còn lại: " + newQuality);
                }
                return;
            }
        }
        System.out.println("Món ăn " + tenMon + " không có trong giỏ hàng.");
    }

   
    
    

}