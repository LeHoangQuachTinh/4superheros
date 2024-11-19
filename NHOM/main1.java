/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NHOM;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class main1 {
    public static void nguoiDung(){
        System.out.println("1.Đăng kí tài khoản!");
        System.out.println("2.Đăng nhập tài khoản!");
        System.out.println("3.Quên mật khẩu!");
        System.out.println("0.Thoát!");
    }
    
    public static void chucNang_nguoiDung(){
        System.out.println("1.Đặt hàng mua trực tiếp");
        System.out.println("2.Thêm món ăn vào giỏ hàng");
        System.out.println("3.Xem tổng tiền các đơn hơn trong giỏ hàng");
        System.out.println("4.Giảm số lượng món ăn trong giỏ hàng");
        System.out.println("5.Xóa món ăn ra khỏi giỏ hàng");
        System.out.println("6.Xem trạng thái đơn hàng");
        System.out.println("7.Mua hàng từ giỏ hàng!");
        System.out.println("0.Thoát");
    }
    
    public static void main(String[] args) {
        ListCustomer dstk = null;
        Restaurant nhaHangRestaurant=new Restaurant();
       //hiển thị menu
        Scanner sc =new Scanner(System.in);
        int lc=sc.nextInt();
        loop1 :
        while(true){
            switch(lc){
                case 1:
                    Account tkAccount=new Customer();
                    tkAccount.registerAccount(dstk);
                    break;
                case 2:
                    int dem = 0;
                    boolean dangNhap = false;
                    System.out.println("Nhập IdUser: ");
                    String id = sc.nextLine();
                    Customer tkCustomer = dstk.kiemTraTonTai(id); 
                    if (tkCustomer != null) {
                        while (dem < 5) {
                            System.out.println("Nhập mật khẩu: ");
                            String password = sc.nextLine();
                            // Kiểm tra đăng nhập
                            if (tkCustomer.login(id, password)) {
                                System.out.println("Đăng nhập thành công!");
                                dangNhap = true;
                                // các chức năng sau khi đăng nhập
                                int lc1;
                                do {
                                    // Hiển thị menu chức năng sau khi đăng nhập
                                    chucNang_nguoiDung();
                                    lc1 = sc.nextInt();
                                    sc.nextLine();
                                    switch (lc1) {
                                        case 1:
                                            tkCustomer.muaHangTrucTiep(nhaHangRestaurant.getMenu());
                                            break;
                                        case 2:
                                            System.out.print("Nhập tên món ăn cần thêm vào giỏ hàng: ");
                                            String tenMon = sc.nextLine();
                                            System.out.print("Nhập số lượng: ");
                                            int soLuong = sc.nextInt();
                                            sc.nextLine(); 
                                            tkCustomer.addDish(tenMon, soLuong, nhaHangRestaurant.getMenu());
                                            break;
                                        case 3:
                                            tkCustomer.tinhTongTienGioHang();
                                            break;
                                        case 4:
                                            System.out.print("Nhập tên món ăn cần giảm: ");
                                            String tenMon1 = sc.nextLine();
                                            System.out.print("Nhập số lượng cần giảm: ");
                                            int soLuong1 = sc.nextInt();
                                            sc.nextLine(); 
                                            tkCustomer.editDish(tenMon1, soLuong1);
                                            break;
                                        case 5:
                                            System.out.print("Nhập tên món cần xóa: ");
                                            String tenMonDel = sc.nextLine();
                                            tkCustomer.deleteDish(tenMonDel);
                                            break;
                                        case 6:
                                            tkCustomer.viewOrderStatus();
                                            break;
                                        case 7:
                                            tkCustomer.muaHangGioHang();
                                            break;
                                        case 0:
                                            System.out.println("Đã thoát chức năng người dùng.");
                                            break;
                                        default:
                                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                                            break;
                                    }
                                } 
                                while (lc1 != 0);
                                break;
                            } 
                            else {
                                dem++;
                                System.out.println("Sai mật khẩu! Bạn còn " + (5 - dem) + " lần thử.");
                            }
                        }
                        // Nếu quá 5 lần nhập sai
                        if (!dangNhap) 
                            System.out.println("Bạn đã nhập sai quá 5 lần. Tài khoản bị khóa hoặc thoát.");
                    }
                    else 
                        System.out.println("Tài khoản không tồn tại.");
                case 3:
                    Account tkAccount1=new Customer();
                    tkAccount1.forgotPassWord();
                    break;
                case 0:
                    break loop1;
            }
        }
    }
}
