package BT;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BT.NganHang.DSTaiKhoang;
import BT.NganHang.TaiKhoan;
import BT.NganHang.TaiKhoanThanhToan;

class Customer extends Account implements IDish {

    private List<Order> Orders;
    private HashMap<String, Dish> gioHang;
    private HashMap<String, Dish> gioMuaTrucTiep;

    public Customer(String idUser, String username, String password, String SDT, String diachi) {
        super(idUser, username, password, SDT, diachi);
        Orders = new ArrayList<>();
        gioHang = new HashMap<>();
        gioMuaTrucTiep = new HashMap<>();
    }

    public Customer(String idUser, String username, String password, String SDT, String diachi, String STK) {
        super(idUser, username, password, SDT, diachi, STK);
        this.STK = STK;
        Orders = new ArrayList<>();
        gioHang = new HashMap<>();
        gioMuaTrucTiep = new HashMap<>();
    }

    public List<Order> getOrders() {
        return Orders;
    }

    public HashMap<String, Dish> getGioHang() {
        return gioHang;
    }
    public HashMap<String, Dish> getGioMuaTrucTiep() {
        return gioMuaTrucTiep;
    }
    public double tinhTongTienGioHang() {
        if (gioHang.isEmpty())
            System.out.println("Giỏ hàng của bạn đang trống!");

        else {
            double tongTien = 0;
            for (Dish mon : gioHang.values()) {
                double price = mon.giaSauKhiGiam() * mon.getQuality();
                tongTien += price;
            }
            System.out.println("Tổng tiền: " + tongTien + " VND");
            return tongTien;
        }
        return 0;
    }

    public double tinhTongTienGioHangTrucTiep() {
        if (gioMuaTrucTiep.isEmpty())
            // System.out.println("Bạn chưa mua món gì cả!");
            System.out.println("");

        else {
            double tongTien = 0;
            for (Dish mon : gioMuaTrucTiep.values()) {
                double price = mon.giaSauKhiGiam() * mon.getQuality();
                tongTien += price;
            }
            System.out.println("Tổng tiền: " + tongTien + " VND");
            return tongTien;
        }
        return 0;
    }

    // Xem trạng thái đặt hàng
    public void viewOrderStatus() {
        if (Orders.isEmpty()) {
            System.out.println("\nBạn chưa có đơn hàng nào.\n");
        } else {
            for (Order Order : Orders) {
                System.out.println(Order);
            }
        }
    }

    public String random(int so) {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < so; i++) {
            int soOTP = random.nextInt(10);
            otp.append(soOTP);
        }
        return otp.toString();
    }


    public void addDish(Dish mon,String gioHangTrucTiep) {
        if (gioMuaTrucTiep.containsKey(mon.getIdDish()) && gioMuaTrucTiep != null) {
            Dish existingDish = gioMuaTrucTiep.get(mon.getIdDish());
            existingDish.setQuality(existingDish.getQuality() + mon.getQuality());

        } else {
            gioMuaTrucTiep.put(mon.getIdDish(), mon);
            System.out.println("Đã thêm món: " + mon.getNameDish() + " vào danh sách mua.");
        }
    }
    @Override
    public void addDish(Dish mon) {
        if (gioHang.containsKey(mon.getIdDish())) {
            Dish existingDish = gioHang.get(mon.getIdDish());
            existingDish.setQuality(existingDish.getQuality() + mon.getQuality());

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
                    // System.out.println("Đã giảm số lượng món: " + monGioHang.getNameDish() + "
                    // còn lại: " + newQuality);
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
            // System.out.println("\n==== MENU NHÀ HÀNG: " + getUsername() + " ====\n");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-40s | %-20s | %-15s |\n", "Mã món", "Tên món", "Giá (VND)", "Số lượng");
            System.out.println("-----------------------------------------------------------------------------------------------");

            for (Map.Entry<String, Dish> entry : gioHang.entrySet()) {
                Dish dish = entry.getValue();
                System.out.printf("| %-10s | %-40s | %-20.0f | %-15d |\n",
                        dish.getIdDish(), dish.getNameDish(), dish.giaSauKhiGiam(), dish.getQuality());
            }
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    // in lịch sử giao dịch
    public void inLichSuGiaoDich() {
        System.out.println("Lịch sử mua hàng");
        if (Orders.isEmpty())
            System.out.println("\nBạn chưa đặt đơn hàng nào!\n");
        else
            for (Order od : this.Orders) {
                od.chiTietDonHang();
            }
    }

    public void showMonDaChon() {
        if (gioMuaTrucTiep != null) {
            for (Dish dish : gioMuaTrucTiep.values()) {
                System.out.printf("\n- %s.%s.Số lượng:%d", dish.getIdDish(), dish.getNameDish(), dish.getQuality());
            }
        }
    }

    public double thanhToan(int lc, DSTaiKhoang ds, double tien, String hinhThuc, Shipper shipper, Order donHangMoi) {
        if (tien <= 0)
            return 0;
        else {
            switch (lc) {
                case 1:
                    TaiKhoan tk = ds.searchAcount(this.STK);
                    TaiKhoanThanhToan tktt = (TaiKhoanThanhToan) (tk);
                    if (tktt.getSodu() >= tien) {
                        tktt.rutTien(tien);
                        List<Dish> danhSachMonAn = new ArrayList<>();
                        HashMap<String, Dish> list;
                        if (hinhThuc.equalsIgnoreCase("Mua trực tiếp"))
                            list = gioMuaTrucTiep;
                        else
                            list = gioHang;

                      
                        for (Dish dish : list.values())
                            danhSachMonAn.add(dish);

                        if (shipper != null) {
                            Orders.add(donHangMoi);
                            shipper.getDonGiao().add(donHangMoi);
                            // In thông báo
                            System.out.println("Đặt hàng thành công! Mã đơn hàng: " + donHangMoi.getOrderID());
                            donHangMoi.chiTietDonHang();
                            if (hinhThuc.equalsIgnoreCase("Mua trực tiếp"))
                                gioMuaTrucTiep.clear();
                            else
                                gioHang.clear();
                            return tien;
                        }

                    } else {
                        System.out.println("Số dư không đủ.Không thể thanh toán");
                        return 0;
                    }

                case 2:
                    System.out.println("\nMua thành công!");
                    System.out.println("Vui lòng thanh toán khi đã nhận được hàng");
                    List<Dish> danhSachMonAn = new ArrayList<>();
                    HashMap<String, Dish> list;
                    if (hinhThuc.equalsIgnoreCase("Mua trực tiếp"))
                        list = gioMuaTrucTiep;
                    else
                        list = gioHang;

                    for (Dish dish : list.values())
                        danhSachMonAn.add(dish);

                    if (shipper != null) {
                        
                        Orders.add(donHangMoi);
                        shipper.getDonGiao().add(donHangMoi);
                        shipper.addOrder(donHangMoi);
                        // In thông báo
                        System.out.println("Đặt hàng thành công! Mã đơn hàng: " + donHangMoi.getOrderID());
                        donHangMoi.chiTietDonHang();
                        if (hinhThuc.equalsIgnoreCase("Mua trực tiếp"))
                            gioMuaTrucTiep.clear();
                        else
                            gioHang.clear();
                    }

                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                    // return 0;
                }

            }
        }
        return 0;
    }

    public Order donHangMoidat() {
        if (this.Orders.size() == 0)
            return null;
        else
            return Orders.get(Orders.size() - 1);
    }

    @Override
    public void updateProfile() {

        System.out.println("Chọn thông tin cần chỉnh sửa:");
        System.out.println("1. Tên người dùng");
        System.out.println("2. Số điện thoại");
        System.out.println("3. Địa chỉ");
        System.out.println("4. Mật khẩu");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1:
                System.out.print("Nhập tên người dùng mới: ");
                this.username = sc.nextLine();
                System.out.println("Tên người dùng đã được cập nhật!");
                break;
            case 2:
                System.out.print("Nhập số điện thoại mới: ");
                this.SDT = sc.nextLine();
                System.out.println("Số điện thoại đã được cập nhật!");
                break;
            case 3:
                System.out.print("Nhập địa chỉ mới: ");
                this.diachi = sc.nextLine();
                System.out.println("Địa chỉ đã được cập nhật!");
                break;
            case 4:
                System.out.print("Nhập mật khẩu mới: ");
                String newPassword;
                do {
                    newPassword = sc.nextLine();
                    if (!kiemTraMatKhauManh(newPassword)) {
                        System.out.println("Mật khẩu không hợp lệ! Nhập lại: ");
                    }
                } while (!kiemTraMatKhauManh(newPassword));
                this.setPassword(newPassword);
                System.out.println("Mật khẩu đã được cập nhật!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    @Override
    public void showInfo() {
        super.in();
    }


}