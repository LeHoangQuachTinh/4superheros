package BT;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import BT.NganHang.TaiKhoanThanhToan;

public class ListRestaurant implements IListAccount {
    private Hashtable<String, Restaurant> listNhaHang = new Hashtable<>();

    //ràng buộc số điện thoại
    public boolean kiemTraSDT(String sdt){
        if((sdt.length()==10||sdt.length()==11)&&sdt.matches("\\d+"))
            return true;
        return false;
    }
    
    public void registerAccount() {
        int dem = 0;
        String chuNhaHang, idNhaHang, tenNhaHang, password, sdt, diachi;

        // Nhập mã nhà hàng
        System.out.print("Nhập mã nhà hàng: ");
        idNhaHang = sc.nextLine();
        if (listNhaHang.containsKey(idNhaHang)) {
            System.out.println("Mã nhà hàng đã được đăng ký. Xin vui lòng nhập lại!");
            return;
        }

        // Nhập các thông tin cơ bản
        System.out.print("Nhập tên nhà hàng: ");
        tenNhaHang = sc.nextLine();

        System.out.print("Nhập chủ nhà hàng: ");
        chuNhaHang = sc.nextLine();

        // Thiết lập mật khẩu
        while (true) {
            System.out.print(
                    "Thiết lập mật khẩu (Mật khẩu phải chứa ít nhất 5 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt): ");
            password = sc.nextLine();
            if (ktmk(password)) {
                break;
            } else {
                System.out.println("Mật khẩu không hợp lệ. Vui lòng nhập lại!");
            }
        }

        
        do{
            System.out.print("Nhập số điện thoại nhà hàng(10||11 số): ");
            sdt = sc.nextLine();
             if(!kiemTraSDT(sdt))
                 System.out.println("Số điện thoại không hợp lệ!");
        }
        while(!kiemTraSDT(sdt));

        System.out.print("Nhập địa chỉ nhà hàng: ");
        diachi = sc.nextLine();

        // Nhập số tài khoản ngân hàng
        while (true) {
            System.out.print("Nhập số tài khoản ngân hàng: ");
            String stk = sc.nextLine();

            if (DS.searchAcount(stk) != null) {
                Restaurant newRestaurant = new Restaurant(password, sdt, diachi, idNhaHang, tenNhaHang, chuNhaHang,
                        stk);
                listNhaHang.put(idNhaHang, newRestaurant);
                System.out.println("Tạo nhà hàng thành công!");
                break;
            } else {
                System.out.println("\nSố tài khoản không tồn tại!");
                dem++;
                if (dem >= 5) {
                    System.out.println("Bạn đã nhập sai quá 5 lần. Vui lòng thử lại sau!");
                    break;
                }
            }
        }
    }

    public Hashtable<String, Restaurant> getListNhaHang() {
        return listNhaHang;
    }

    public Restaurant search(String id) {
        return listNhaHang.get(id);
    }

    @Override
    public void forgotPassWord() {

        System.out.print("Nhập mã tài khoản của bạn: ");
        String matk = sc.nextLine();
        Restaurant nhaHang = listNhaHang.get(matk);
        if (nhaHang == null) {
            System.out.println("Không tìm thấy tài khoản!");
            return;
        }

        System.out.printf("Mã OTP sẽ được gửi về số điện thoại:%s\n", nhaHang.SDT);
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

                if (!ktmk(newPassword)) { // phải có ký tự đặc biệt
                    System.out.println(
                            "Mật khẩu không hợp lệ. Mật khẩu mới phải chứa ít nhất 5 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt. Vui lòng nhập lại.");
                    continue;
                }
                nhaHang.setPassword(newPassword);
                System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
                return;
            }
        } else
            System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");
    }

    @Override
    public boolean login(String id, String password) {
        int dem = 0;

        Account restaurant = null;
        while (restaurant == null) {
            System.out.println("Nhập mã nhà hàng: ");
            id = sc.nextLine();
            restaurant = listNhaHang.get(id);
            if (restaurant == null) {
                System.out.println("Mã nhà hàng không tồn tại. Vui lòng nhập lại!");
            }
        }

        // Kiểm tra mật khẩu
        while (dem < 5) {
            System.out.println("Nhập mật khẩu của tài khoản: ");
            password = sc.nextLine();

            // Kiểm tra mật khẩu
            if (restaurant.kTPassword(password)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            } else {
                dem++;
                System.out.println("Sai mật khẩu. Bạn còn " + (5 - dem) + " lần thử.");
            }
        }

        // Sau khi hết 5 lần thử hỏi người dùng có muốn thiết lập lại mật khẩu không
        System.out.println("Bạn đã nhập sai mật khẩu quá 5 lần.");
        System.out.println("Bạn có muốn quên mật khẩu? (y/n): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            forgotPassWord();

            // Sau khi đổi mật khẩu thành công, yêu cầu nhập lại mật khẩu vừa tạo để đăng
            // nhập
            System.out.println("Mật khẩu được đổi thành công!");
            System.out.println("Vui lòng nhập lại mật khẩu để đăng nhập: ");
            String newPass = sc.nextLine();

            // Kiểm tra mật khẩu mới
            if (restaurant.kTPassword(newPass)) {
                System.out.println("Đăng nhập thành công với mật khẩu mới!");
                return true;
            } else {
                System.out.println("Mật khẩu không đúng, đăng nhập không thành công");
            }
        } else {
            System.out.println("Đăng nhập không thành công!");
        }
        return false;
    }

    public Dish searchDish(String id) {
        for (Restaurant item : listNhaHang.values()) {
            Dish foundDish = item.getMenu().get(id);
            if (foundDish != null) {
                return foundDish;
            }
        }
        return null;
    }

    public Restaurant searchDishToRestaurant(String id) {
        for (Restaurant item : listNhaHang.values()) {
            if (item.getMenu().containsKey(id))
                return item;
        }
        return null;
    }

    @Override
    public void deleteAccount() {
        System.out.print("Nhập mã tài khoản nhà hàng cần xoá:");
        String maTK = sc.nextLine();
        if (this.listNhaHang.contains(maTK)) {
            listNhaHang.remove(maTK);
            System.out.println("\nXoá thành công !\n");
        } else
            System.out.println("\nTài khoản nhà hàng không tồn tại.Không thể xoá\n");
    }

    public boolean ktmk(String password) {
        return password.length() >= 5 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public Restaurant kiemTra(String maNhaHangString) {
        return listNhaHang.get(maNhaHangString);
    }

    public Restaurant searchRestaurantByDishId(String idDish) {
        for (Restaurant restaurant : listNhaHang.values()) {
            for (Dish dish : restaurant.getMenu().values()) {
                if (dish.getIdDish().equals(idDish)) {
                    return restaurant;
                }
            }
        }
        return null;
    }
       public void phanPhoiTienChoNhaHang(Order od) {
        if (od == null)
            return;
        for (Dish mon : od.getDishes()) {
            Restaurant nh = this.searchDishToRestaurant(mon.getIdDish());
            if (nh != null) {
                TaiKhoanThanhToan tktt = (TaiKhoanThanhToan) (DS.searchAcount(nh.STK));
                tktt.congSoDu(mon.getPrice() * mon.getQuality());
                nh.setDoanhThu(nh.getDoanhThu() + mon.getPrice() * mon.getQuality());
            }
        }
    }

}