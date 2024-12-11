package BT;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderID;
    private List<Dish> dishes;
    private String status;
    private boolean thanhToan;


    private LocalDateTime time;
    private boolean receive;
    private List<Account> info;

    public Order(String orderID, List<Dish> dishes, boolean thanhToan, Account infoKhachHang, Account infoShipper) {
        this.orderID = orderID;
        this.dishes = dishes;
        this.thanhToan = thanhToan;
        this.status = "Đang chờ xử lí";
        this.receive = false;
        this.time = LocalDateTime.now();
        this.info = new ArrayList<>();
        info.add(infoKhachHang);
        info.add(infoShipper);
    }

    public boolean isReceive() {
        return receive;
    }
    public void setThanhToan(boolean thanhToan) {
        this.thanhToan = thanhToan;
    }
    public void setReceive(boolean receive) {
        this.receive = receive;
    }
    public void setShipper(Account shipper) {
        info.set(1, shipper);
    }
    public String getStatus() {
        return status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isThanhToan() {
        return thanhToan;
    }

    // Tính tổng giá trị đơn hàng
    public double getTotalPrice() {
        double tongTien = 0.0;
        for (Dish dish : dishes) {
            tongTien += dish.getTotalPrice();
        }
        return tongTien;
    }
    
    public void chiTietDonHang() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        System.out.println("\n========================= CHI TIẾT ĐƠN HÀNG =========================");
        System.out.printf("Mã đơn hàng         : %s\n", this.orderID);
        System.out.printf("Trạng thái đơn hàng : %s\n", this.status);
        System.out.printf("Thời gian đặt hàng  : %s\n", this.time.format(formatter).toString());

        for (Account x : this.info) {
            if (x instanceof Customer) {
                Customer cus = (Customer) x;
                System.out.println("\n--- Thông tin khách hàng ---");
                System.out.printf("Tên khách hàng      : %s\n", cus.username);
                System.out.printf("SĐT khách hàng      : %s\n", cus.SDT);
                System.out.printf("Địa chỉ khách hàng  : %s\n", cus.diachi);
            } else if (x instanceof Shipper) {
                Shipper shi = (Shipper) x;
                System.out.println("\n--- Thông tin shipper ---");
                System.out.printf("Tên shipper         : %s\n", shi.username);
                System.out.printf("SĐT shipper         : %s\n", shi.SDT);
            }
        }

        System.out.println("\n---------------------------DANH SÁCH MÓN ĂN--------------------------------");
        System.out.printf("| %-27s | %-21s | %-21s |\n", "Món ăn", "Số lượng", "Giá (VND)");
        System.out.println("---------------------------------------------------------------------------");
        double tongTien = 0;
        for (Dish dish : dishes) {
            double tien = 0;
            tien += dish.getQuality() * dish.getPrice();
            tongTien += tien;
            System.out.printf("| %-27s | %-21d | %-21s |\n",
                    dish.getNameDish(),
                    dish.getQuality(),
                    Double.toString(tien));
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-27s | %-21s | %-21s |\n",
                "Tổng tiền",
                " ",
                Double.toString(tongTien)); // Gọi phương thức tính tổng tiền
        System.out.println(thanhToan ? "\nHình thức thanh toán: Đã thanh toán online"
                : "\nHình thức thanh toán: Thanh toán khi nhận hàng");
        System.out.println("===========================================================================");
    }

}
