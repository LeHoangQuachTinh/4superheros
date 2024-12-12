package BT;

import java.util.ArrayList;
import java.util.List;
import BT.NganHang.TaiKhoanThanhToan;

public class Shipper extends Account {
    private boolean trangThai;
    private String loaiXe;
    private List<Order> orders;
    private List<Order> donGiao;

    public Shipper(String idUser, String username, String password, String SDT, String diachi, String loaiXe,String STK) {
        super(idUser, username, password, SDT, diachi, STK);
        this.trangThai = true;
        this.loaiXe = loaiXe;
        this.isLocked = false;
        this.orders = new ArrayList<>();
        this.donGiao = new ArrayList<>();
    }

    public List<Order> getDonGiao() {
        return donGiao;
    }
    public boolean isTrangThai() {
        return trangThai;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public List<Order> getOrders() {
        return orders;
    }
    
    public Order timOrders(String maDH) {
        for (Order od : orders) {
            if (od.getOrderID().equalsIgnoreCase(maDH))
                return od;
        }
        return null;
    }
    public void batTrangThai() {
        this.trangThai = true;
        System.out.println("Shipper " + getUsername() + " đã được bật trạng thái (có sẵn).");
    }

    public void tatTrangThai() {
        this.trangThai = false;
        System.out.println("Shipper " + getUsername() + " đã được tắt trạng thái (không có sẵn).");
    }
    // Phương thức thêm đơn hàng vào danh sách
    public void addOrder(Order order) {
        orders.add(order);
        
    }

    // Phương thức hiển thị tất cả đơn hàng của shipper
    public void showOrders() {
        System.out.println("Danh sách đơn hàng của shipper " + getUsername() + ":");
        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
        } else {
            for (Order order : orders) {
                System.out.println("Mã đơn hàng: " + order.getOrderID() + ", Trạng thái: " + order.getStatus());
            }
        }
    }

    public void InfoShipper() {
        System.out.println("\nThông tin cơ bản về shipper đang giao hàng cho bạn");
        System.out.println("Tên shipper:" + this.username);
        System.out.println("Tên xe:" + this.loaiXe);
        System.out.println("SĐT:" + this.SDT);

    }

    public void updateOrderStatus(String orderId, String newStatus) {
        for (Order order : orders) {
            if (order.getOrderID().equals(orderId)) {
                order.setStatus(newStatus);
                System.out.println("Trạng thái đơn hàng " + orderId + " đã được cập nhật thành: " + newStatus);
                if (newStatus.equals("Đã giao")) {
                    // notifyCustomer(orderId, newStatus);
                }
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng với mã: " + orderId);
    }
  
    @Override
    public void updateProfile() {
        System.out.println("-----------Cập nhật thông tin shipper------------");
        System.out.println("""
                1.Cập nhật số điện thoại
                2.Cập nhật loại xe đang duy chuyển
                3.Đổi mật khẩu mới
                0.Thoát
                """);
        System.out.print("Nhập lựa chọn của bạn:");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Nhập số điện thoại mới: ");
                String newSdt = sc.nextLine();
                if (!newSdt.isEmpty()) {
                    if (newSdt.equalsIgnoreCase(this.SDT)) {
                        System.out.println(
                                "Số điện thoại mới trùng với số điện thoại cũ! Không có sự thay đổi nào được thực hiện!");
                    } else {
                        this.setSDT(newSdt);
                        System.out.println("Số điện thoại đã được cập nhật: " + newSdt);
                    }
                } else
                    System.out.println("Số điện thoại chưa được cập nhật");
                break;
            case 2:
                // Đổi địa chỉ nhà hàng
                System.out.print("Nhập tên xe mới của bạn: ");
                String loaiXeMoi = sc.nextLine();
                if (!loaiXeMoi.isEmpty()) {
                    if (loaiXeMoi.equals(this.diachi)) {
                        System.out.println("Tên xe  mới trùng với tên xe cũ!. Không có thay đổi nào được thực hiện!");
                    } else {
                        this.setDiachi(loaiXeMoi);
                        System.out.println("Tên xe mới đã cập nhật thành công: " + loaiXeMoi);
                    }
                } else
                    System.out.println("Địa chỉ chưa được cập nhật");
                break;
            case 3:
                // listthis.get(idUser).changePassword();
                break;
            case 0:
                // Thoát chương trình
                System.out.println("Thoát cập nhật!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    @Override
    public void showInfo() {
        super.in();
        System.out.println("Loại xe:" + this.loaiXe);
    }

    public void showDonChuaGiao() {
        boolean kt = false;
        for (Order od : orders) {
            if (od.getStatus().equalsIgnoreCase("Đang giao")) {
                od.chiTietDonHang();
                kt = true;
            }
        }
        if (!kt)
            System.out.println("Bạn chưa có đơn hàng nào để giao");

    }

    public void giaoHang() {
        if (trangThai) { // Kiểm tra trạng thái shipper
            if (donGiao.isEmpty()) {
                System.out.println("Không có đơn hàng nào trong danh sách sẵn sàng đi giao.");
            } else {
                System.out.println("Danh sách đơn hàng sẵn sàng đi giao:");
                for (Order order : donGiao) {
                    System.out.println("Mã đơn hàng: " + order.getOrderID() + ", Trạng thái: " + order.getStatus());
                }

                System.out.println(
                        "Nhập các mã đơn hàng đã giao thành công hoặc thất bại (dạng: madon1:thành công, madon2:thất bại):");
                String maDonTrangThaString = sc.nextLine();
                String[] donTrangThaiStrings = maDonTrangThaString.split(","); // Tách các mã đơn hàng

                for (String donHangString : donTrangThaiStrings) {
                    String[] parts = donHangString.split(":"); // Tách mã đơn và trạng thái
                    if (parts.length == 2) {
                        String orderId = parts[0].trim(); // Mã đơn hàng
                        String trangThaString = parts[1].trim(); // Trạng thái

                        boolean thanhcong = false;
                        for (Order order : donGiao) {
                            if (order.getOrderID().equals(orderId)) {
                                order.setStatus(trangThaString); // Cập nhật trạng thái đơn hàng
                                System.out.println(
                                        "\nĐơn hàng " + orderId + " đã được cập nhật trạng thái: " + trangThaString);
                                thanhcong = true;
                                System.out.println("Nhận tiền của khách sau khi giao xong!");
                                System.out.println("Bạn đã được cộng 15K tiền hoa hồng!");
                                TaiKhoanThanhToan tk = this.getTaiKhoanThanhToan();
                                tk.congSoDu(15000);
                                break;
                            }
                        }

                        if (!thanhcong) {
                            System.out.println("Không tìm thấy đơn hàng có mã: " + orderId);
                        }
                    } else {
                        System.out.println("Định dạng nhập không hợp lệ cho: " + donHangString);
                    }
                }
            }
        } else {
            System.out.println("Trạng thái giao hàng của bạn chưa sẵn sàng!");
        }

    }

}
