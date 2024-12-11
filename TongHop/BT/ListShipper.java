
package BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import BT.NganHang.TaiKhoanThanhToan;

public class ListShipper implements IListAccount {

    private HashMap<String, Shipper> listShipper;

    public ListShipper() {
        this.listShipper = new HashMap<>();
    }

    public HashMap<String, Shipper> getListShipper() {
        return listShipper;
    }

    // Thêm shipper vào danh sách
    public void addShipper(Shipper shipper) {
        listShipper.put(shipper.idUser, shipper);
        System.out.println("Shipper " + shipper.getUsername() + " đã được thêm vào danh sách.");
    }

    // Xóa shipper khỏi danh sách
    @Override
    public void deleteAccount() {
        System.out.print("Nhập mã tài khoản shipper cần xoá:");
        String maTK = sc.nextLine();
        if (this.listShipper.get(maTK) != null) {
            listShipper.remove(maTK);
            System.out.println("\nXoá thành công !\n");
        } else
            System.out.println("\nTài khoản nhà hàng không tồn tại.Không thể xoá\n");
    }

    // Đăng nhập shipper
    @Override
    public boolean login(String id, String password) {
        Shipper shipper = listShipper.get(id);

        if (shipper != null && shipper.kTPassword(password))
            return true;
        return false;
    }

    // Đăng ký tài khoản shipper
    @Override
    public void registerAccount() {
        String idUser;
        int dem = 1;

        do {
            System.out.print("Nhập IdShipper: ");
            idUser = sc.nextLine();
            if (listShipper.containsKey(idUser)) {
                System.out.println("Mã code đã tồn tại trong hệ thống! Nhập lại!");
            }
        } while (listShipper.containsKey(idUser));

        System.out.print("Nhập username: ");
        String username = sc.nextLine();

        String password ;
        do {
            System.out.printf("Tạo mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự) lần %d/5:", dem);
            password = sc.nextLine();
            dem++;
        } 
        while (!kiemTraMatKhauManh(password) && dem <= 5);
        
         String SDT;
        do{
            System.out.print("Nhập số điện thoại đăng kí(10||11 số): ");
             SDT = sc.nextLine();
             if(!kiemTraSDT(SDT))
                 System.out.println("Số điện thoại không hợp lệ!");
        }
        while(!kiemTraSDT(SDT));

        System.out.print("Nhập địa chỉ: ");
        String diachi = sc.nextLine();

        System.out.print("Nhập loại xe: ");
        String loaiXe = sc.nextLine();

        System.out.print("Nhập Số tài khoản ngân hàng: ");
        String STK = sc.nextLine();

        Random random = new Random();
        String soOTP = random.ints(6, 0, 9)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("Mã OTP của bạn là: " + soOTP);

        String otp;
        do {
            System.out.print("Nhập mã OTP: ");
            otp = sc.nextLine();
            if (!otp.equals(soOTP)) {
                System.out.println("Số OTP không khớp! Vui lòng nhập lại!");
            }
        } while (!otp.equals(soOTP));

        Shipper tkShipper = new Shipper(idUser, username, password, SDT, diachi, loaiXe, STK);
        listShipper.put(idUser, tkShipper);
        System.out.printf("Đã đăng kí tài khoản Shipper (%s, %s, %s) thành công!\n", idUser, username, password);
    }

    @Override
    public void forgotPassWord() {
        System.out.print("Nhập mã tài khoản shipper của bạn: ");
        String matk = sc.nextLine();
        // Restaurant nhaHang=listNhaHang.get(matk);
        Shipper shipper = listShipper.get(matk);
        if (shipper == null) {
            System.out.println("Không tìm thấy tài khoản!");
            return;
        }

        System.out.printf("Mã OTP sẽ được gửi về số điện thoại:%s\n", shipper.SDT);
        // Tạo mã OTP
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(999999);
        System.out.println("Mã OTP của bạn là: " + otp);

        // Nhập OTP xác nhận
        System.out.print("Vui lòng nhập mã OTP để xác nhận:");
        int otpNhap = sc.nextInt();

        if (otpNhap == otp) {
            System.out.println("Mã OTP chính xác!");
            sc.nextLine();

            // Đổi mật khẩu
            while (true) {
                System.out.print("Nhập mật khẩu mới: ");
                String newPassword = sc.nextLine();

                if (!kiemTraMatKhauManh(newPassword)) { // phải có ký tự đặc biệt
                    System.out.println(
                            "Mật khẩu không hợp lệ. Mật khẩu mới phải chứa ít nhất 5 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt. Vui lòng nhập lại.");
                    continue;
                }
                shipper.setPassword(newPassword);
                System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
                return;
            }
        } else
            System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");

    }
    // Hiển thị tất cả shipper
    public void showAllShippers() {
        if (listShipper.isEmpty()) {
            System.out.println("Không có shipper nào.");
        } else {
            for (Shipper shipper : listShipper.values()) {
                System.out.println("ID: " + shipper.idUser + ", Tên: " + shipper.getUsername() + ", Loại xe: "
                        + shipper.getLoaiXe());
            }
        }
    }

    public Shipper findShipper(String shipperId) {
        if (listShipper.containsKey(shipperId)) {
            return listShipper.get(shipperId);
        } else {
            return null;
        }
    }

    //ràng buộc mật khẩu
    public boolean kiemTraMatKhauManh(String password) {
        return password.length() >= 5 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
    
    //ràng buộc số điện thoại
    public boolean kiemTraSDT(String sdt){
        if((sdt.length()==10||sdt.length()==11)&&sdt.matches("\\d+"))
            return true;
        return false;
    }

    public Shipper randomShipper(double tien) {
        List<String> keys = new ArrayList<>();

        System.out.println(listShipper.toString());
        Random random = new Random();
        int attempts = 0; // Đếm số lần thử
        System.out.println(keys.toString());
        while (!keys.isEmpty()) {
            // Random một key
            String randomKey = keys.get(random.nextInt(keys.size()));
            Shipper shipper = listShipper.get(randomKey);

            // Lấy tài khoản thanh toán
            TaiKhoanThanhToan tktt;
            try {
                tktt = (TaiKhoanThanhToan) (DS.searchAcount(shipper.STK));
            } catch (ClassCastException e) {
                System.err.println("Lỗi ép kiểu tài khoản thanh toán!");
                return null;
            }

            // Kiểm tra điều kiện shipper
            if (shipper.isTrangThai() && tktt.getSodu() >= tien) {
                System.out.println("Tìm thấy shipper sau " + attempts + " lần thử.");
                return shipper;
            }

            // Loại bỏ key khỏi danh sách và tiếp tục
            keys.remove(randomKey);
            attempts++;
        }

        System.out.println("Không tìm được shipper phù hợp sau khi thử " + attempts + " lần.");
        return null;
    }
    public Shipper findShipperToOrder(String maDH) {
        for (Shipper shipper : listShipper.values()) {
            // Kiểm tra xem shipper có nhận đơn hàng này không
            Order order = shipper.timOrders(maDH);
            if (order != null && order.getOrderID().equalsIgnoreCase(maDH)) {
                return shipper;
            }
        }
        return null; // Nếu không tìm thấy shipper nhận đơn
    }
     public Shipper ShipperNgauNhien() {
        if (listShipper.isEmpty()) {
            // return null; // Không có shipper nào trong danh sách
            System.out.println("danh sacsh rong");
            return null;
        }

        Set<String> keys = listShipper.keySet(); // Lấy tất cả các khóa
        String[] keyArray = keys.toArray(new String[0]); // Chuyển thành mảng
        Random random = new Random();

        // Lặp qua danh sách để tìm một Shipper thỏa mãn
        for (int i = 0; i < keyArray.length; i++) {
            String randomKey = keyArray[random.nextInt(keyArray.length)];
            Shipper shipper = listShipper.get(randomKey);

            if (shipper != null && shipper.isTrangThai()) {
                return shipper; // Trả về shipper hợp lệ
            }
        }
        return null;
    }

}
