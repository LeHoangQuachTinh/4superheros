/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends Account implements IDish {
    private List<OrDer> orders; // Danh sách các đơn hàng đã đặt
    private List<Dish> gioHang; // Giỏ hàng của khách hàng
    private List<Dish> menu; // Menu món ăn của nhà hàng

    // Constructor
    public Customer(String code, String username, String password, String SDT, String diachi) {
        super(code, username, password, SDT, diachi);
        orders = new ArrayList<>();
        gioHang = new ArrayList<>();
        menu = new ArrayList<>();
    }

    // In thông tin người dùng
    @Override
    public void in() {
        System.out.println("In thông tin người dùng!");
        super.in(); // Gọi phương thức in từ lớp Account
    }

    // Thêm món ăn vào danh sách menu (giả lập)
    public void menu_MonAn() {
        menu.add(new Dish("MA0001", "Phở bò", 50000, 5));
        menu.add(new Dish("MA0002", "Bánh mì thịt", 25000, 6));
        menu.add(new Dish("MA0003", "Gà rán", 60000, 7));
        menu.add(new Dish("MA0004", "Bún chả", 45000, 8));
        menu.add(new Dish("MA0005", "Nem rán", 30000, 9));
        menu.add(new Dish("MA0006", "Cơm tấm sườn bì chả", 40000, 5));
        menu.add(new Dish("MA0007", "Lẩu thái", 150000, 4));
        menu.add(new Dish("MA0008", "Bún bò Huế", 50000, 3));
        menu.add(new Dish("MA0009", "Hủ tiếu Nam Vang", 45000, 2));
        menu.add(new Dish("MA0010", "Mì Quảng", 40000, 1));
        menu.add(new Dish("MA0011", "Chả cá Lã Vọng", 120000, 10));
        menu.add(new Dish("MA0012", "Xôi gà", 30000, 9));
        menu.add(new Dish("MA0013", "Canh chua cá lóc", 80000, 8));
        menu.add(new Dish("MA0014", "Sườn xào chua ngọt", 90000, 7));
        menu.add(new Dish("MA0015", "Bánh xèo", 35000, 6));
    }

    // Hiển thị menu món ăn
    public void hienThiMonAn() {
        System.out.println("Danh sách món ăn:");
        for (int i = 0; i < menu.size(); i++) {
            Dish mon = menu.get(i);
            System.out.println((i + 1) + ". " + mon.getNameDish() + " - " + mon.getPrice() + " VND");
        }
    }

    // Thêm món ăn vào giỏ hàng
    public void themMonAnVaoGioHang(String tenMon, int soLuong) {
        for (Dish mon : menu) {
            if (mon.getNameDish().equalsIgnoreCase(tenMon)) {
                boolean daCo = false;
                for (Dish monGioHang : gioHang) {
                    if (monGioHang.getNameDish().equalsIgnoreCase(tenMon)) {
                        monGioHang.setQuality(monGioHang.getQuality() + soLuong); // Cập nhật số lượng món ăn trong giỏ
                        System.out.println("Đã thêm " + soLuong + " " + tenMon + " vào giỏ hàng.");
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

    // Tính tổng tiền trong giỏ hàng
    public double tinhTongTienGioHang() {
        if (gioHang.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống!");
        } else {
            System.out.println("Giỏ hàng của bạn:");
            double tongTien = 0;
            for (Dish mon : gioHang) {
                System.out.println(mon);
                tongTien += mon.getPrice() * mon.getQuality(); // Tính tổng tiền
            }
            System.out.println("Tổng tiền: " + tongTien + " VND");
            return tongTien;
        }
        return 0.0;
    }

    // Đặt hàng
    @Override
    public void placeOrder() {
        if (!gioHang.isEmpty()) {
            String orderId = "ORDER" + System.currentTimeMillis(); // Tạo ID đơn hàng ngẫu nhiên
            OrDer newOrder = new OrDer(orderId, gioHang); // Tạo đơn hàng
            orders.add(newOrder); // Thêm vào danh sách đơn hàng của khách hàng
            System.out.println("Đơn hàng đã được tạo thành công!");
            System.out.println(newOrder);
            gioHang.clear(); // Xóa giỏ hàng sau khi đặt hàng thành công
        } else {
            System.out.println("Giỏ hàng trống. Không thể đặt hàng.");
        }
    }

    // Xem trạng thái đơn hàng
    @Override
    public void viewOrderStatus() {
        if (orders.isEmpty()) {
            System.out.println("Bạn chưa có đơn hàng nào.");
        } else {
            for (OrDer order : orders) {
                System.out.println(order);
            }
        }
    }

    // Các phương thức của IDish, mặc dù không thực hiện trong Customer nhưng yêu cầu có mặt.
    @Override
    public void addDish() {
        // Implement method if necessary
    }

    @Override
    public void editDish() {
        // Implement method if necessary
    }

    @Override
    public void deleteDish() {
        // Implement method if necessary
    }
}
