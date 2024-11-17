/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.Scanner;

class Admin {
    ListRestaurant listRestaurant;
    ListCustomer listCustomer;

    Admin() {
        this.listCustomer = new ListCustomer();
        this.listRestaurant = new ListRestaurant();
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("===== QUẢN TRỊ VIÊN =====");
            System.out.println("1. Quản lý nhà hàng");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("0. Thoát");
            System.out.printf("Mời bạn nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manageRestaurants();
                    break;
                case 2:
                    manageCustomers();
                    break;
                case 0:
                    System.out.println("Thoát khỏi chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }

    private void manageRestaurants() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== QUẢN LÝ NHÀ HÀNG =====");
            System.out.println("1. Đăng kí nhà hàng");
            System.out.println("2. Đăng nhập nhà hàng");
            System.out.println("3. Quản lý nhà hàng");
            System.out.println("0. Quay lại");
            System.out.printf("Mời bạn nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    listRestaurant.registerAccount();
                    break;
                case 2:
                    listRestaurant.login();
                    break;
                case 3:
                    // Có thể thêm các chức năng quản lý khác nếu cần
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (true);
    }

    private void manageCustomers() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== QUẢN LÝ KHÁCH HÀNG =====");
            System.out.println("1. Đăng kí khách hàng");
            System.out.println("2. Đăng nhập khách hàng");
            System.out.println("3. Quản lý tài khoản khách hàng");
            System.out.println("0. Quay lại");
            System.out.printf("Mời bạn nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    listCustomer.registerAccount();
                    break;
                case 2:
                    listCustomer.login();
                    break;
                case 3:
                    // Có thể thêm các chức năng quản lý khác nếu cần
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (true);
    }
}
