/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.HashMap;
import java.util.Scanner;

public class ListCustomer implements IListAccount {
    private HashMap<String, Customer> listCustomer;  

    ListCustomer() {
        this.listCustomer = new HashMap<>();
    }

    // Phương thức đăng ký tài khoản khách hàng
    @Override
    public void registerAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID khách hàng: ");
        String id = sc.nextLine();

        // Kiểm tra nếu khách hàng đã tồn tại
        if (listCustomer.containsKey(id)) {
            System.out.println("Khách hàng đã tồn tại!");
            return;
        }

        // Nhập thông tin khách hàng
        System.out.println("Nhập tên khách hàng: ");
        String name = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();

        // Tạo đối tượng Customer và thêm vào danh sách
        Customer newCustomer = new Customer(id, name, password, phone, address);
        listCustomer.put(id, newCustomer);
        System.out.println("Đăng ký khách hàng thành công!");
    }

    // Phương thức đăng nhập khách hàng
    @Override
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID khách hàng: ");
        String id = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();

        // Kiểm tra thông tin đăng nhập
        if (listCustomer.containsKey(id)) {
            if (listCustomer.get(id).getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            } else {
                System.out.println("Mật khẩu sai!");
                return false;
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
        return false;
    }

    @Override
    public void editAccount() {
        // Thêm logic chỉnh sửa thông tin khách hàng ở đây (ví dụ: cập nhật tên, số điện thoại, địa chỉ)
    }

    @Override
    public void forgotPassWord() {
        // Thêm logic xử lý quên mật khẩu cho khách hàng (ví dụ: yêu cầu xác nhận email, số điện thoại, v.v.)
    }
    
    @Override
    public void lockAccount() {
        // Thêm logic xử lý khóa tài khoản khách hàng (ví dụ: đánh dấu trạng thái khóa tài khoản)
    }
}
