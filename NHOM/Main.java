package NHOM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin AD=new Admin();
        Scanner sc = new Scanner(System.in);
        ListRestaurant newRestaurant = new ListRestaurant();
        Restaurant nhaHangHienTai = null; //Lưu trữ nhà hàng đang đăng nhập
        int choice;
        while (true) {
            System.out.println("Nhà Hàng 4 Anh Em Siêu Nhân.Xin Chào!");
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
                    do{
                        System.out.println("===== Quản Lý Nhà Hàng =====");
                        System.out.println("""
                                1. Đăng kí nhà hàng
                                2. Đăng nhập nhà hàng
                                3. Quên mật khẩu
                                4. Thoát
                                """);
            
                        System.out.println("Chọn chức năng: ");
                        choice = sc.nextInt();
                        sc.nextLine();
            
                        switch(choice){
                            case 1://Đăng kí nhà hàng
                                newRestaurant.registerAccount();
                            break;
                            case 2: //Đăng nhập nhà hàng
                                int dem = 0;
                                System.out.println("Nhập mã nhà hàng (ID): ");
                                String id = sc.nextLine();
                                System.out.println("Nhập mật khẩu: ");
                                String password = sc.nextLine();
                                nhaHangHienTai = newRestaurant.search(id);
                            
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
                                                        nhaHangHienTai.addDish();
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
                    }while(choice != 4);
                }
                break;
                case 3:
                {

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
