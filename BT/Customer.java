// package BT;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Customer extends Account implements IDish {
    private List<Order> Orders;
    private HashMap<String,Dish> gioHang;

    public HashMap<String, Dish> getGioHang() {
        return gioHang;
    }

    public Customer(boolean status, String idUser, String username, String password, String SDT, String diachi) {
        super(idUser, username, password, SDT, diachi);
        Orders =new ArrayList<>();
        gioHang=new HashMap<>();
    }
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

    // // mở tài khoản
    // @Override
    // public void openAccount() {
    //     this.isLocked=false;
    //     System.out.println("Tài khoản đã được mở");
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
    public void inMenu() {
    if (gioHang.isEmpty()) {
        System.out.println("Menu hiện tại không có món ăn nào!");
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
   
    
    

}