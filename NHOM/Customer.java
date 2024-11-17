package NHOM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer extends Account implements ICustomer {
    private List<OrDer> orders;
    private List<MonAn> gioHang;
    private List<MonAn> menu=new ArrayList<>();
    
    public Customer(String code,String username, String password, String SDT,String diachi) {
        super(code,username, password, SDT,diachi);
        orders =new ArrayList<>();
        gioHang=new ArrayList<>();
    }

    //Nhập thông tin người đăng kí
    @Override
    public void register(Scanner scanner, DSTaiKhoan dstk) {
        System.out.println("Đăng kí thông tin người dùng!");
        super.register(scanner, dstk); 
    }
    
    //Đăng nhập tài khoản
    @Override
    public boolean login(Scanner scanner, DSTaiKhoan dstk) {
        return super.login(scanner, dstk); 
    }
    

    //in thông tin người dùng
    @Override
    public void in() {
        System.out.println("In thông tin người dùng!");
        super.in(); 
    }

    //Quên mật khẩu
    @Override
    public void resetPassword(Scanner scanner) {
        super.resetPassword(scanner); 
    }
    
    //thêm món ăn vào danh sách menu
    public void menu_MonAn() {
        menu.add(new MonAn("Phở bò", 50000, 0));
        menu.add(new MonAn("Bánh mì thịt", 25000, 0));
        menu.add(new MonAn("Gà rán", 60000, 0));
        menu.add(new MonAn("Bún chả", 45000, 0));
        menu.add(new MonAn("Nem rán", 30000, 0));
        menu.add(new MonAn("Cơm tấm sườn bì chả", 40000, 0));
        menu.add(new MonAn("Lẩu thái", 150000, 0));
        menu.add(new MonAn("Bún bò Huế", 50000, 0));
        menu.add(new MonAn("Hủ tiếu Nam Vang", 45000, 0));
        menu.add(new MonAn("Mì Quảng", 40000, 0));
        menu.add(new MonAn("Chả cá Lã Vọng", 120000, 0));
        menu.add(new MonAn("Xôi gà", 30000, 0));
        menu.add(new MonAn("Canh chua cá lóc", 80000, 0));
        menu.add(new MonAn("Sườn xào chua ngọt", 90000, 0));
        menu.add(new MonAn("Bánh xèo", 35000, 0));
    }

    //hiển thị menu món ăn
    public void hienThiMonAn(){
        System.out.println("Danh sách món ăn!");
        for (int i = 0; i < menu.size(); i++) {
            MonAn mon = menu.get(i);
            System.out.println((i + 1) + ". " + mon.getTenMon() + " - " + mon.getGia() + " VND");
        }
    }
    
    // Thêm món ăn vào giỏ hàng
    public void themMonAnVaoGioHang(String tenMon, int soLuong) {
        for (MonAn mon : menu) {
            if (mon.getTenMon().equalsIgnoreCase(tenMon)) {
                boolean daCo = false;
                for (MonAn monGioHang : gioHang) {
                    if (monGioHang.getTenMon().equalsIgnoreCase(tenMon)) {
                        monGioHang.soLuong += soLuong;
                        System.out.println("Đã thêm! Món:"+tenMon  +" ||số lượng:" +soLuong + " " +  " vào giỏ hàng.");
                        daCo = true;
                        break;
                    }
                }
                if (!daCo) {
                    MonAn monMoi = new MonAn(tenMon, mon.getGia(), soLuong);
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
            for (MonAn mon : gioHang) {
                System.out.println(mon);
                tongTien += mon.gia * mon.soLuong; 
            }
            System.out.println("Tổng tiền: " + tongTien + " VND");
            return tongTien;
        }
        return 0.0;
    }
    
    //Đặt hàng
    @Override
    public void placeOrder() {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("Nhập mã sản phẩm: ");
//        String productId = scanner.nextLine();
//        System.out.print("Nhập tên sản phẩm: ");
//        String productName = scanner.nextLine();
//        System.out.print("Nhập số lượng: ");
//        int quantity = scanner.nextInt();
//        scanner.nextLine();
//        String orderId = random(8); 
//        OrDer newOrder = new OrDer(orderId, productName, quantity);
//        orders.add(newOrder); 
//        System.out.println("Đơn hàng đã được tạo thành công!");
//        System.out.println(newOrder);
    }

    //Xem trạng thái đặt hàng
    @Override
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
    
    
    
}