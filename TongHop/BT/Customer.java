package BT;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BT.NganHang.TaiKhoan;


class Customer extends Account implements IDish {
    private List<Order> Orders;
    private HashMap<String,Dish> gioHang;

    public HashMap<String, Dish> getGioHang() {
        return gioHang;
    }

    public Customer( String idUser, String username, String password, String SDT, String diachi) {
        super(idUser, username, password, SDT, diachi);
        Orders =new ArrayList<>();
        gioHang=new HashMap<>();
    }
    public Customer( String idUser, String username, String password, String SDT, String diachi,String STK) {
        super(idUser, username, password, SDT, diachi);
        this.STK=STK;
        Orders =new ArrayList<>();
        gioHang=new HashMap<>();

    }
    public double tinhTongTienGioHang(){
        if (gioHang.isEmpty()) 
            System.out.println("Giỏ hàng của bạn đang trống!");
            
        else {
            double tongTien = 0;
            for (Dish mon : gioHang.values()) {
                double price=mon.getPrice() * mon.getQuality(); 
                tongTien += price;
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
    public void muaHangTrucTiep(HashMap<String, Dish> menu, String tenMon, int soLuong) {
        Dish monTimThay = null;
        for (Dish dish : menu.values()) {
            if (dish.getNameDish().equalsIgnoreCase(tenMon)) {
                monTimThay = dish;
                break;
            }
        }

        if (monTimThay != null) {
            // Tạo một danh sách món ăn mới
            List<Dish> danhSachMonAn = new ArrayList<>();

            // Thêm món ăn đã tìm thấy vào danh sách với số lượng người dùng yêu cầu
            Dish monDatHang = new Dish(monTimThay.getIdDish(), monTimThay.getNameDish(), monTimThay.getPrice(), soLuong);
            danhSachMonAn.add(monDatHang);

            // Tạo một đơn hàng mới
            String orderId = random(8); // Random mã đơn hàng
            Order donHangMoi = new Order(orderId, danhSachMonAn);

            // Thêm đơn hàng vào danh sách đơn hàng của khách hàng
            Orders.add(donHangMoi);

            // In thông báo
            System.out.println("Đặt hàng thành công! Mã đơn hàng: " + orderId);
            donHangMoi.chiTietDonHang();
        }
        else {
            System.out.println("Không tìm thấy món ăn: " + tenMon);
        }
    }
    
    
    
    //Xem trạng thái đặt hàng
    public void viewOrderStatus() {
        if (Orders.isEmpty()) {
            System.out.println("\nBạn chưa có đơn hàng nào.\n");
        } 
        else {
            for (Order Order : Orders) {
                System.out.println(Order);
            }
        }
    }

    
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

    // // mở tài khoản
    // @Override
    // public void openAccount() {
    //     this.isLocked=false;
    //     System.out.println("Tài khoản đã được mở");
    // }
    
    // Đăng nhập
    @Override
    public boolean login(String idUser, String password) {
        return this.idUser.equals(idUser) && this.kTPassword(password);
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
    public void deleteDish(String maMon) {
        for (Dish mon : gioHang.values()) {
            if (mon.getIdDish().equalsIgnoreCase(maMon)) {
                gioHang.remove(maMon);
                System.out.println("Đã xóa món: " + mon.getNameDish() + " khỏi giỏ hàng.");
                return;
            }
        }
        System.out.println("Món ăn có mã " + maMon + " không có trong giỏ hàng.");
}


    @Override
    public void editDish(String maMon, int soLuong) {
        for (Dish monGioHang : gioHang.values()) {
            if (monGioHang.getIdDish().equalsIgnoreCase(maMon)) {
                int newQuality = monGioHang.getQuality() - soLuong;
                if (newQuality <= 0) {
                    gioHang.remove(monGioHang.getIdDish());
                    System.out.println("Món " + monGioHang.getNameDish() + " đã được xóa khỏi giỏ hàng.");
                } else {
                    monGioHang.setQuality(newQuality);
                    // System.out.println("Đã giảm số lượng món: " + monGioHang.getNameDish() + " còn lại: " + newQuality);
                }
                return;
            }
        }
        System.out.println("Món ăn có mã món " + maMon + " không có trong giỏ hàng.");

    }
    public void inMenu() {
    if (gioHang.isEmpty()) {
        System.out.println("\nMenu hiện tại không có món ăn nào!\n");
    } else {
        System.out.println("\n==== MENU NHÀ HÀNG: " + getUsername() + " ====\n");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-40s | %-20s | %-15s |\n", "Mã món", "Tên món", "Giá (VND)", "Số lượng");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (Map.Entry<String, Dish> entry : gioHang.entrySet()) {
            Dish dish = entry.getValue();
            System.out.printf("| %-10s | %-40s | %-20.0f | %-15d |\n", 
                dish.getIdDish(), dish.getNameDish(), dish.getPrice(), dish.getQuality());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
    }
     //thêm mã giao dịch
    // public String maGiaoDich(){
    //     return "GD"+(lichSuMuaHang.size()+1);
    // }
    
    // thêm lưu lịch sử giao dịch

    
    // in lịch sử giao dịch
    public void inLichSuGiaoDich(){
        System.out.println("Lịch sử mua hàng");
        for(Order od: this.Orders){
           od.chiTietDonHang();
        }
    }

    

}