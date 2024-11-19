package NHOM;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Customer extends Account implements IDish {
    private List<OrDer> orders;
    private List<Dish> gioHang;
//    private List<Dish> menu;

    public Customer() {
    }



    public Customer(boolean status, String idUser, String username, String password, String SDT, String diachi) {
        super(idUser, username, password, SDT, diachi);
        orders =new ArrayList<>();
        gioHang=new ArrayList<>();
//        menu=new ArrayList<>();
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
    @Override
    public void addDish(String tenMon, int soLuong,List<Dish> menu){
        for (Dish mon : menu) {
            if (mon.getNameDish().equalsIgnoreCase(tenMon)) {
                boolean daCo = false;
                for (Dish monGioHang : gioHang) {
                    if (monGioHang.getNameDish().equalsIgnoreCase(tenMon)) {
                        monGioHang.setQuality(monGioHang.getQuality() + soLuong);
                        System.out.println("Đã thêm! Món:"+tenMon  +" ||Số lượng:" +soLuong + " " +  " vào giỏ hàng.");
                        daCo = true;
                        break;
                    }
                }
                if (!daCo) {  
                    Dish monMoi = new Dish(mon.getIdDish(), mon.getNameDish(), mon.getPrice(), soLuong);  
                    gioHang.add(monMoi);  
                    System.out.println("Đã thêm " + soLuong + " " + tenMon + " vào giỏ hàng.");
            }
                return;
            }
        }
        System.out.println("Món ăn " + tenMon + " không có trong menu.");
    }

    // tính tổng tiền trong giỏ hàng 
    public double tinhTongTienGioHang(){
        if (gioHang.isEmpty()) 
            System.out.println("Giỏ hàng của bạn đang trống!");
            
        else {
            System.out.println("Giỏ hàng của bạn:");
            double tongTien = 0;
            for (Dish mon : gioHang) {
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
        for (Dish mon : gioHang) {
            OrDer newOrder = new OrDer(orderId, mon.getNameDish(), mon.getQuality());
            orders.add(newOrder);
        }
        gioHang.clear(); 
        System.out.println("Đặt hàng từ giỏ hàng thành công! Mã đơn hàng: " + orderId);
    }
    
    // Đặt hàng mua trực tiếp
    public void muaHangTrucTiep(List<Dish> menu) {
        Scanner scanner = new Scanner(System.in);
        
        // Hiển thị danh sách menu
        System.out.println("Danh sách món ăn trong menu:");
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Tên món", "Giá", "Số lượng");
        for (Dish mon : menu) {
            System.out.printf("%-10s %-20s %-10.2f %-10d%n", mon.getIdDish(), mon.getNameDish(), mon.getPrice(), mon.getQuality());
        }
        
        System.out.print("Nhập tên món ăn: ");
        String tenMonString = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        boolean monAnTonTai = false;
        for (Dish mon : menu) {
            if (mon.getNameDish().equalsIgnoreCase(tenMonString)) {
                monAnTonTai = true;
                String orderId = random(8);
                OrDer themMon = new OrDer(orderId, tenMonString, soLuong);
                orders.add(themMon);
                System.out.println("Đặt hàng thành công! Mã đơn hàng: " + orderId);
                break;
            }
        }
        if (!monAnTonTai) {
            System.out.println("Món ăn không tồn tại trong menu.");
        }
    }
    
    //Xem trạng thái đặt hàng
    public void viewOrderStatus() {
        if (orders.isEmpty()) {
            System.out.println("Bạn chưa có đơn hàng nào.");
        } 
        else {
            for (OrDer order : orders) {
                System.out.println(order);
            }
        }
    }

    //Giảm số lượng món ăn  trong gio hang
    @Override
    public void editDish(String tenMon, int soLuong){
        for (Dish monGioHang : gioHang) {
            if (monGioHang.getNameDish().equalsIgnoreCase(tenMon)){
                monGioHang.setQuality(monGioHang.getQuality()-soLuong);
                System.out.println("Đã tGiảm số lượng! Món:"+tenMon  +" ||số lượng:" +soLuong + " " +  " trong giỏ hàng.");
                return;
            }
        }
        System.out.println("Món ăn " + tenMon + " không có trong gio hang.");
    }

    //xóa món ăn
    @Override
    public void deleteDish(String tenMon){
        for (int i = 0; i < gioHang.size(); i++) {
            Dish mon = gioHang.get(i);
            if (mon.getNameDish().equalsIgnoreCase(tenMon)) {
                gioHang.remove(i);
                System.out.println("Đã xóa món: " + tenMon + " khỏi giỏ hàng.");
                return; 
            }
        }
        System.out.println("Món ăn " + tenMon + " không có trong giỏ hàng.");
    }
    
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
    
    //Ràng buộc mật khẩu
    public boolean kiemTraMatKhauManh(String matkhau) {
        if (matkhau.length() >= 5 
            &&matkhau.matches(".*[A-Z].*") 
            &&  matkhau.matches(".*[a-z].*")
            &&matkhau.matches(".*\\d.*") 
            && matkhau.matches(".*[!@#$%^&*()].*")) 
            return true;  
        return false;
    }
    
    
    //đăng kí khách hàng
    @Override
    public void registerAccount(ListCustomer dstk) {
        Scanner scanner =new Scanner(System.in);
        do{
            System.out.print("Nhập IdUser:");
            this.idUser=scanner.nextLine();
            if(dstk.kiemTraTonTai(idUser)!=null){
                System.out.println("Mã code đã tồn tại trong hệ thống!Nhập lại!");
            }
        }
        while(dstk.kiemTraTonTai(idUser)!=null);
        System.out.print("Nhập username:");
        this.username=scanner.nextLine();
        System.out.print("Nhập số điện thoại đăng kí:");
        this.SDT=scanner.nextLine();
        String soOTP=random(6);
        System.out.println("Mã otp của bạn là:"+soOTP);
        String otp ;
        do{
            System.out.print("Nhập mã otp:");
            otp=scanner.nextLine();
            if(!otp.equals(soOTP))
                System.out.println("Số otp không khớp!Vui lòng nhập lại!");
        }
        while(!otp.equals(soOTP));
        do{
            System.out.print("Tạo mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự):");
            this.password=scanner.nextLine();
            if(!kiemTraMatKhauManh(this.password))
                System.out.println("Mật khẩu không hợp lệ!");
        }
        while(!kiemTraMatKhauManh(this.password));
        System.out.print("Nhập địa chỉ:");
        this.diachi=scanner.nextLine();
    }

    //chỉnh sửa tài khoản
//    @Override
//    public void editAccount() {
//        
//    }

    //quên mật khẩu
    @Override
    public void forgotPassWord() {
        System.out.println("Nhập số điện thoại đã đăng kí với tài khoản của bạn: ");
        String sdtNhap = sc.nextLine();
        if(!sdtNhap.equals(SDT)){
            System.out.println("Không tìm thấy số điện thoại!");
            return;
        }

        //Tạo mã OTP
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(999999);
        System.out.println("Mã OTP của bạn là: "+otp);

        //Nhập OTP xác nhận
        System.out.println("Vui lòng nhập mã OTP để xác nhận");
        int otpNhap = sc.nextInt();

        if(otpNhap==otp){
            System.out.println("Mã OTP chính xác!");
            sc.nextLine();

            //Đổi mật khẩu
            System.out.println("Nhập mật khẩu mới: ");
            String newPassword = sc.nextLine();
            this.password = newPassword;
            System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
        }
        else
            System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");
    }

    //khóa tài khoản
    @Override
    public void lockAccount() {
         this.isLocked=true;
        System.out.println("Tài khoản đã được khóa!");
    }

    //mở tài khoản
    @Override
    public void openAccount() {
        this.isLocked=false;
        System.out.println("Tài khoản đã được mở");
    }

    @Override
    public void editAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Đăng nhập
    @Override
    public boolean login(String idUser, String password) {
        return this.idUser.equals(idUser) && this.password.equals(password);
    }
    
    

}