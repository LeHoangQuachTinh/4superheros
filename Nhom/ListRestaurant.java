/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.Hashtable;
import java.util.Scanner;

public class ListRestaurant implements IListAccount {
    private Hashtable<String, Restaurant> listNhaHang = new Hashtable<>();

    public void registerAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhà hàng: ");
        String idNhaHang = sc.nextLine();

        if (listNhaHang.containsKey(idNhaHang)) {
            System.out.println("Mã nhà hàng đã được đăng kí.");
            return;
        }
        System.out.println("Nhập tên nhà hàng: ");
        String tenNhaHang = sc.nextLine();
        System.out.println("Nhập chủ nhà hàng: ");
        String chuNhaHang = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        System.out.println("Nhập số điện thoại nhà hàng: ");
        String sdt = sc.nextLine();
        System.out.println("Nhập địa chỉ nhà hàng: ");
        String diachi = sc.nextLine();

        Restaurant newRestaurant = new Restaurant(password, sdt, diachi, idNhaHang, tenNhaHang);
        listNhaHang.put(idNhaHang, newRestaurant);
        System.out.println("Tạo tài khoản nhà hàng thành công!");
    }
    

    @Override
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhà hàng (ID): ");
        String id = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();

        Restaurant restaurant = listNhaHang.get(id);
        if (restaurant != null && restaurant.getPassword().equals(password)) {
            System.out.println("Đăng nhập thành công!");
            return true;
        } else {
            System.out.println("Mã nhà hàng hoặc mật khẩu không đúng.");
            return false;
        }
    }

    @Override
    public void editAccount() {
        // Chỉnh sửa tài khoản nhà hàng
    }

    @Override
    public void forgotPassWord() {
        // Quên mật khẩu nhà hàng
    }

    @Override
    public void lockAccount() {
        // Khóa tài khoản nhà hàng
    }

    public Restaurant search(String id) {
        return listNhaHang.get(id);
    }
}
