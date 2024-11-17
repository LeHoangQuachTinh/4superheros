/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListRestaurant newRestaurant = new ListRestaurant();
        ListCustomer listCustomer = new ListCustomer();
        Restaurant nhaHangHienTai = null; // Lưu trữ nhà hàng đang đăng nhập
        Customer currentCustomer = null; // Lưu trữ khách hàng đang đăng nhập
        int choice;

        while (true) {
            System.out.println("Nhà Hàng 4 Anh Em Siêu Nhân.Xin Chào!");
            System.out.println("1. Quản Trị Viên");
            System.out.println("2. Nhà Hàng");
            System.out.println("3. Người dùng");
            System.out.println("0. Thoát!");

            System.out.printf("Mời bạn nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Quản trị viên chưa triển khai, có thể thêm vào sau.
                    break;

                case 2:
                    // Nhà hàng: Đăng ký, đăng nhập, quản lý nhà hàng
                    do {
                        System.out.println("===== Quản Lý Nhà Hàng =====");
                        System.out.println("""
                                1. Đăng ký nhà hàng
                                2. Đăng nhập nhà hàng
                                3. Quên mật khẩu
                                4. Thoát
                                """);

                        System.out.printf("Chọn chức năng: ");
                        choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {
                            case 1: // Đăng ký nhà hàng
                                newRestaurant.registerAccount();
                                break;

                            case 2: // Đăng nhập nhà hàng
                                System.out.printf("Nhập mã nhà hàng (ID): ");
                                String id = sc.nextLine();
                                System.out.printf("Nhập mật khẩu: ");
                                String password = sc.nextLine();
                                nhaHangHienTai = newRestaurant.search(id);

                                if (nhaHangHienTai != null) {
                                    if (nhaHangHienTai.getPassword().equals(password)) {
                                        System.out.println("Đăng nhập thành công!");
                                        int chon;
                                        do {
                                            System.out.println("Bạn muốn làm gì?");
                                            System.out.println("""
                                                    1. Tạo Menu (Thêm món)
                                                    2. Chỉnh sửa Menu
                                                    3. Xem menu
                                                    4. Xem doanh thu
                                                    5. Đổi mật khẩu
                                                    6. Cập nhật thông tin nhà hàng
                                                    7. Thoát
                                                    """);
                                            System.out.printf("Chọn chức năng: ");
                                            chon = sc.nextInt();
                                            sc.nextLine();

                                            switch (chon) {
                                                case 1:
                                                    nhaHangHienTai.addDish();
                                                    break;
                                                case 2:
                                                    nhaHangHienTai.updateMenu();
                                                    break;
                                                case 3:
                                                    nhaHangHienTai.inMenu();
                                                    break;
                                                case 4:
                                                    nhaHangHienTai.xemDoanhThu();
                                                    break;
                                                case 5:
                                                    nhaHangHienTai.resetPassword();
                                                    break;
                                                case 6:
                                                    nhaHangHienTai.updateThongTinNhaHang();
                                                    break;
                                                case 7:
                                                    System.out.println("Thoát chương trình");
                                                    break;
                                                default:
                                                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                                                    break;
                                            }
                                        } while (chon != 7);
                                    } else {
                                        System.out.println("Mật khẩu không đúng");
                                    }
                                } else {
                                    System.out.println("Mã nhà hàng không tồn tại!");
                                }
                                break;

                            case 3: // Quên mật khẩu
                                if (nhaHangHienTai != null) {
                                    nhaHangHienTai.quenMatKhau();
                                } else {
                                    System.out.println("Chưa có nhà hàng nào đăng nhập.");
                                }
                                break;

                            case 4:
                                System.out.println("Thoát chương trình!");
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                                break;
                        }
                    } while (choice != 4);
                    break;

                case 3:
                    // Người dùng: Đăng ký, đăng nhập, quản lý giỏ hàng và đặt món
                    do {
                        System.out.println("===== Quản Lý Người Dùng =====");
                        System.out.println("""
                                1. Đăng ký người dùng
                                2. Đăng nhập người dùng
                                3. Thoát
                                """);

                        System.out.printf("Chọn chức năng: ");
                        choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {
                            case 1: // Đăng ký người dùng
                                listCustomer.registerAccount();
                                break;

                            case 2: // Đăng nhập người dùng
                                System.out.printf("Nhập tên người dùng: ");
                                String username = sc.nextLine();
                                System.out.printf("Nhập mật khẩu: ");
                                String userPassword = sc.nextLine();

                                currentCustomer = listCustomer.login(username, userPassword);

                                if (currentCustomer != null) {
                                    System.out.println("Đăng nhập thành công!");
                                    int chon;
                                    do {
                                        System.out.println("Bạn muốn làm gì?");
                                        System.out.println("""
                                                1. Xem menu
                                                2. Thêm món vào giỏ hàng
                                                3. Xem giỏ hàng
                                                4. Đặt món
                                                5. Xem trạng thái đơn hàng
                                                6. Thoát
                                                """);
                                        System.out.printf("Chọn chức năng: ");
                                        chon = sc.nextInt();
                                        sc.nextLine();

                                        switch (chon) {
                                            case 1:
                                                currentCustomer.hienThiMonAn();
                                                break;
                                            case 2:
                                                System.out.printf("Nhập tên món ăn: ");
                                                String dishName = sc.nextLine();
                                                System.out.printf("Nhập số lượng: ");
                                                int quantity = sc.nextInt();
                                                sc.nextLine();
                                                currentCustomer.themMonAnVaoGioHang(dishName, quantity);
                                                break;
                                            case 3:
                                                currentCustomer.tinhTongTienGioHang();
                                                break;
                                            case 4:
                                                currentCustomer.placeOrder();
                                                break;
                                            case 5:
                                                currentCustomer.viewOrderStatus();
                                                break;
                                            case 6:
                                                System.out.println("Thoát chương trình");
                                                break;
                                            default:
                                                System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                                                break;
                                        }
                                    } while (chon != 6);
                                } else {
                                    System.out.println("Đăng nhập không thành công.");
                                }
                                break;

                            case 3:
                                System.out.println("Thoát chương trình!");
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                                break;
                        }
                    } while (choice != 3);
                    break;

                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn sai. Vui lòng nhập lại!");
                    break;
            }
        }
    }
}
