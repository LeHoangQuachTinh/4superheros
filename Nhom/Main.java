/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin AD=new Admin();
        Scanner sc = new Scanner(System.in);
       //Lưu trữ nhà hàng đang đăng nhập
        int choice;
        while (true) {
            System.out.println("\nNhà Hàng 4 Anh Em Siêu Nhân.Xin Chào!");
            System.out.println("1.Quản Trị Viên");
            System.out.println("2.Nhà Hàng");
            System.out.println("3.Người dùng");
            System.out.println("0.Thoát!");

            System.out.printf("Mời bạn nhập lựa chọn:");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                {
                    Restaurant nhaHangHienTai = null;
                    do{
                        System.out.println("===== Quản Lý Nhà Hàng =====");
                        System.out.println("""
                                1. Đăng kí nhà hàng
                                2. Đăng nhập nhà hàng
                                3. Quên mật khẩu
                                4. Thoát
                                """);
            
                        System.out.print("Chọn chức năng: ");
                        choice = sc.nextInt();
                        sc.nextLine();
            
                        switch(choice){
                            case 1://Đăng kí nhà hàng
                                AD.listRestaurant.registerAccount();
                            break;
                            case 2: //Đăng nhập nhà hàng
                                int dem = 0;
                                System.out.println("Nhập mã nhà hàng (ID): ");
                                String id = sc.nextLine();
                                System.out.println("Nhập mật khẩu: ");
                                String password = sc.nextLine();
                                nhaHangHienTai = AD.listRestaurant.search(id);
                            
                                while (dem < 5) {
                                    if (nhaHangHienTai != null) {
                                        if (nhaHangHienTai.getPassword().equals(password)) {
                                            System.out.println("Đăng nhập thành công!");
                                            int chon;
                                            do {
                                                // Hiển thị menu chức năng
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
                                                System.out.println("Chọn chức năng: ");
                                                chon = sc.nextInt();
                                                sc.nextLine();
                        
                                                // Xử lý các chức năng người dùng chọn
                                                switch (chon) {
                                                    case 1: // Thêm món
                                                        Dish d=new Dish(id, password, choice, chon);
                                                        nhaHangHienTai.addDish(d);
                                                        break;
                                                    case 2: // Chỉnh sửa menu
                                                        nhaHangHienTai.updateMenu();
                                                        break;
                                                    case 3: // Xem menu
                                                        nhaHangHienTai.inMenu();
                                                        break;
                                                    case 4: // Xem doanh thu
                                                        nhaHangHienTai.xemDoanhThu();
                                                        break;
                                                    case 5: // Đổi mật khẩu
                                                        nhaHangHienTai.changePassword();
                                                        break;
                                                    case 6: // Cập nhật thông tin nhà hàng
                                                        nhaHangHienTai.updateThongTinNhaHang();
                                                        break;
                                                    case 7: // Thoát
                                                        System.out.println("Thoát chương trình");
                                                        break;
                                                    default:
                                                        System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                                                        break;
                                                }
                                            } while (chon != 7);
                                            break; 
                                        } else {
                                            dem++;  // Tăng số lần nhập sai mật khẩu
                                            System.out.println("Mật khẩu không đúng. Số lần sai: " + dem);
                                            
                                            // Nếu đã nhập sai 5 lần
                                            if (dem == 5) {
                                                System.out.println("Bạn đã nhập sai mật khẩu quá 5 lần.");
                                                System.out.println("Bạn có muốn đổi mật khẩu không? (Y/N)");
                                                String chon = sc.nextLine();
                                                
                                                if (chon.equalsIgnoreCase("Y")) {
                                                    // Thực hiện đổi mật khẩu
                                                    nhaHangHienTai.quenMatKhau();;
                                                } else {
                                                    // Hủy đăng nhập
                                                    System.out.println("Đăng nhập bị hủy.");
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Mã nhà hàng không tồn tại!");
                                        break;  // Kết thúc nếu mã nhà hàng không tồn tại
                                    }
                        
                                    // Nếu đăng nhập chưa thành công, yêu cầu nhập lại mật khẩu
                                    if (dem < 5) {
                                        System.out.println("Nhập lại mật khẩu: ");
                                        password = sc.nextLine();
                                    }
                                }
                            break;
                            case 3://Quên mật khẩu
                                nhaHangHienTai.quenMatKhau();
                            break;
                            case 4:
                                System.out.println("Thoát chương trình!");
                            break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                            break;
                        }
                    }while(choice != 0);
                }
                break;
                case 3:
                {   
                    // ListCustomer listCustomer=AD.listCustomer.getListCustomer();
                    do{
                        System.out.println("--------Tài khoản khách hàng----------");
                        System.out.println("1.Đăng kí tài khoản!");
                        System.out.println("2.Đăng nhập tài khoản!");
                        System.out.println("3.Quên mật khẩu!");
                        System.out.println("0.Thoát!");
                        System.out.print("Nhập lựa chọn:");
                        choice=sc.nextInt();
                        sc.nextLine();
                        switch(choice){
                            case 1:
                                AD.listCustomer.registerAccount();
                                break;
                            case 2:
                                int dem = 0;
                                boolean dangNhap = false;
                                System.out.println("Nhập IdUser: ");
                                String id = sc.nextLine();
                                Customer tkCustomer = AD.listCustomer.search(id); 
                                if (tkCustomer != null) {
                                    while (dem < 5) {
                                        System.out.println("Nhập mật khẩu: ");
                                        String password = sc.nextLine();
                                        // Kiểm tra đăng nhập
                                        if (tkCustomer.login(id, password)) {
                                            System.out.println("Đăng nhập thành công!");
                                            dangNhap = true;
                                            int choice1;
                                            do {
                                                // Hiển thị menu chức năng sau khi đăng nhập
                                                System.out.println("1.Chọn món");
                                                System.out.println("2.Giỏ hàng");
                                                System.out.println("3.Xem tổng tiền các đơn hơn trong giỏ hàng");
                                                System.out.println("4.Giảm số lượng món ăn trong giỏ hàng");
                                                System.out.println("5.Xóa món ăn ra khỏi giỏ hàng");
                                                System.out.println("6.Xem trạng thái đơn hàng");
                                                System.out.println("7.Mua hàng từ giỏ hàng!");
                                                System.out.println("0.Thoát");

                                                System.out.print("Nhập lựa chọn:");
                                                choice1 = sc.nextInt();
                                                sc.nextLine();
                                                switch (choice1) {
                                                    case 1:

                                                        // tkCustomer.muaHangTrucTiep(AD.listRestaurant.getListNhaHang().values().forEach(entry -> {
                                                        //    entry.getMenu();
                                                        // }));
                                                        System.out.println("--------Menu--------");
                                                        AD.listRestaurant.getListNhaHang().values().forEach(item->{
                                                            item.inMenu();
                                                        });
                                                        System.out.print("Nhập lựa chọn:");
                                                        String chon=sc.nextLine();
                                                        // Dish mon=AD.listRestaurant.getListNhaHang().
                                                        tkCustomer.addDish(null);
                                                        
                                                        break;
                                                    case 2:
                                                        // System.out.print("Nhập tên món ăn cần thêm vào giỏ hàng: ");
                                                        // String tenMon = sc.nextLine();
                                                        // System.out.print("Nhập số lượng: ");
                                                        // int soLuong = sc.nextInt();
                                                        // sc.nextLine(); 

                                                        // tkCustomer.addDish(tenMon, soLuong, AD.listRestaurant.getMenu());
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
                                            while (choice1 != 0);
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
                                AD.listCustomer.forgotPassWord();
                                break;
                            case 0:
                                break;
                        }
                    }
                    while (choice!=0) ;
                }
                break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn sai.Vui lòng nhập lại!");
                    break;
            }
        }
    }
}
