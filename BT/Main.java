package BT;


import java.util.Scanner;
import BT.NganHang.DSTaiKhoang;
import BT.NganHang.TaiKhoan;
public class Main {
    public static void main(String[] args) {
        Admin AD=new Admin();
        AD.docFileMonAn("monan.txt");
        Scanner sc = new Scanner(System.in);
        DSTaiKhoang ds=new DSTaiKhoang();
        int choice;
        while (true) {
            System.out.println("\nNhà Hàng 4 Anh Em Siêu Nhân.Xin Chào!");
            System.out.println("1.Quản Trị Viên");
            System.out.println("2.Nhà Hàng");
            System.out.println("3.Người dùng");
            System.out.println("0.Thoát!");

            System.out.printf("Mời bạn nhập lựa chọn:");
            choice=sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã quản trị viên để đăng nhập:");
                    String maQuanTri=sc.nextLine();
                    if(AD.getMaQuanTri().equals(maQuanTri))
                    {
                        int c;
                        do{
                            System.out.println("---------------ADMIN---------------");
                            System.out.println("1.Quản lí tài khoản Nhà Hàng");
                            System.out.println("2.Quản lí tài khoản Khách Hàng");
                            System.out.println("3.Đổi mã quản trị viên");
                            System.out.println("0.Thoát");
                            System.out.print("Nhập lựa chọn:");
                            c=sc.nextInt();
                            sc.nextLine();

                            switch (c) {
                                case 1:
                                   do{
                                        System.out.println("1.Thêm tài khoản nhà hàng");
                                        System.out.println("2.Xoá tài khoản nhà hàng");
                                        System.out.println("3.Chỉnh sửa tài khoản nhà hàng");
                                        System.out.println("4.Khoá tài khoản nhà hàng chỉ định");
                                        System.out.println("0.Thoát");
                                        System.out.print("Nhập lựa chọn:");
                                        choice=sc.nextInt();
                                        sc.nextLine();

                                        switch (choice) {
                                            case 1:
                                                AD.listRestaurant.registerAccount();
                                                break;
                                            case 2:
                                                AD.listRestaurant.deleteAccount();
                                            break;
                                            case 3:
                                                AD.listRestaurant.editAccount();
                                            break;
                                            case 4:
                                                System.out.print("Nhập mã tài khoản ngân hàng cần khoá:");
                                                String matk=sc.nextLine();
                                                AD.listRestaurant.lockAccount(matk);
                                                break;
                                            default:
                                                break;
                                        }
                                   }
                                   while (choice!=0);
                                    

                                 
                                    break;
                                case 2:
                                        do{
                                            System.out.println("1.Thêm tài khoản Khách hàng");
                                            System.out.println("2.Xoá tài khoản Khách Hàng");
                                            System.out.println("3.Chỉnh sửa tài khoản Khách Hàng");
                                            System.out.println("4.Khoá tài khoản khách hàng chỉ định");
                                            System.out.println("0.Thoát");
                                            System.out.print("Nhập lựa chọn:");
                                            choice=sc.nextInt();
                                            sc.nextLine();

                                            switch (choice) {
                                                case 1:
                                                    AD.listCustomer.registerAccount();
                                                    break;
                                                case 2:
                                                    AD.listCustomer.deleteAccount();
                                                break;
                                                case 3:
                                                    AD.listCustomer.editAccount();
                                                break;
                                                case 4:
                                                    System.out.print("Nhập mã tài khoản khách hàng cần khoá:");
                                                    String matk=sc.nextLine();
                                                    AD.listCustomer.lockAccount(matk);
                                                    break;
                                                default:
                                                    break;
                                            }
                                    }
                                    while (choice!=0);
                                        
                                break;
                                case 3:
                                    System.out.println("Nhập mã quản trị cũ:");
                                    String maQT=sc.nextLine();
                                    if(AD.getMaQuanTri().equals(maQT))
                                        AD.setMaQuanTri(maQT);
                                    else
                                        System.out.println("Mã quản trị không đúng");
                                break;
                                case 0:
                                    break;
                                default:
                                    break;
                            }
                        }
                        while(c!=0); 
                    }
                    else
                        System.out.println("Mã quản trị sai.Thoát");
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
                                0. Thoát
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
                                            System.out.println("\nĐăng nhập thành công!");
                                            int chon;
                                            do {
                                                // Hiển thị menu chức năng
                                                System.out.println("======================================================");
                                                System.out.println("|              BẠN MUỐN LÀM GÌ ?                     |");
                                                System.out.println("======================================================");
                                                System.out.println("|  1. Tạo Menu (Thêm món)                            |");
                                                System.out.println("|  2. Chỉnh sửa Menu                                 |");
                                                System.out.println("|  3. Xem Menu                                       |");
                                                System.out.println("|  4. Xem Doanh Thu                                  |");
                                                System.out.println("|  5. Đổi Mật Khẩu                                   |");
                                                System.out.println("|  6. Cập Nhật Thông Tin Nhà Hàng                    |");
                                                System.out.println("|  7. Thoát                                          |");
                                                System.out.println("======================================================");
                                                System.out.println("Chọn chức năng: ");
                                                chon = sc.nextInt();
                                                sc.nextLine();
                        
                                                // Xử lý các chức năng người dùng chọn
                                                switch (chon) {
                                                    case 1: // Thêm món
                                                        String idDish;
                                                        String nameDish;
                                                        double price = 0;;
                                                        int quality = 0;
                                                        String idNhap;
                                                        boolean kt = false;
                                                        //Nhập id món ăn
                                                        do{
                                                            System.out.println("Nhập mã món: ");
                                                            idDish = sc.nextLine().trim(); //trim() loại bỏ khoảng trắng hai đầu

                                                            //Kiểm tra chứa kí tự đặc biệt
                                                            if(idDish.matches(".*[!@#$%^&*].*")){
                                                                System.out.println("Mã món không được chứa kí tự đặc biệt. Vui lòng nhập lại!");
                                                                continue;
                                                            }

                                                            //Kiểm tra trùng mã món
                                                            if(nhaHangHienTai.getMenu().containsKey(idDish)){
                                                                System.out.println("Mã món ăn đã tồn tại. Vui lòng nhập mã món khác!");
                                                                continue;
                                                            }
                                                            kt = true;
                                                        }while(!kt);

                                                        kt=false;
                                                        //Nhập tên món ăn
                                                        do{
                                                            System.out.println("Nhập tên món ăn: ");
                                                            nameDish = sc.nextLine();
                                                            if(nhaHangHienTai.getMenu().containsKey(nameDish))
                                                            {
                                                                System.out.println("Tên món ăn bị trùng lặp với các món ăn trước. Vui lòng nhập tên khác!");
                                                                continue;
                                                            }
                                                            kt=true;
                                                        }while(!kt);
                                                        
                                                        kt=false;
                                                        do {
                                                            try {
                                                                System.out.println("Nhập giá món ăn: ");
                                                                price = sc.nextDouble();
                                                                sc.nextLine();
                                                                if(price <= 0){
                                                                    System.out.println("Giá món phải lớn hơn 0. Vui lòng nhập lại.");
                                                                }else{
                                                                    kt = true;
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("Định dạng giá không hợp lệ. Vui lòng nhập lại!");
                                                                sc.nextLine(); //Xóa bộ nhớ đệm khi nhập sai
                                                            }
                                                        } while (!kt);

                                                        kt = false;
                                                        do {
                                                            try {
                                                                System.out.println("Nhập số lượng hiện có: ");
                                                                quality = sc.nextInt();
                                                                sc.nextLine();
                                                                if(quality<0){
                                                                    System.out.println("Số lượng nhập vào phải lớn hơn 0. Vui lòng nhập lại!");
                                                                }else{
                                                                    kt = true;
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("Định dạng số lượng không hợp lệ. Vui lòng nhập lại (ví dụ: 100).");
                                                                sc.nextLine();
                                                            }
                                                        } while (!kt);
                                                        Dish dish = new Dish(idDish, nameDish, price, quality);
                                                        nhaHangHienTai.addDish(dish);
                                                        System.out.println("Bạn vừa mới thêm món "+dish.getNameDish()+" vao Menu!");
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
                                                    nhaHangHienTai.quenMatKhau();;
                                                } else {
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
                        System.out.println("\n--------Tài khoản khách hàng----------");
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
                                System.out.print("Nhập mã khách hàng: ");
                                String id = sc.nextLine();
                                Customer tkCustomer = AD.listCustomer.search(id); 
                                if (tkCustomer != null) {
                                    while (dem < 5) {
                                        System.out.print("Nhập mật khẩu: ");
                                        String password = sc.nextLine();
                                        // Kiểm tra đăng nhập
                                        if (tkCustomer.login(id, password)) {
                                            System.out.println("\nĐăng nhập thành công!");
                                            dangNhap = true;
                                            int choice1;
                                            do {
                                                // Hiển thị menu chức năng sau khi đăng nhập
                                                System.out.println("1.Chọn món");
                                                System.out.println("2.Giỏ hàng");
                                                System.out.println("3.Xem trạng thái đơn hàng");
                                                System.out.println("4.Xem lịch đơn hàng");
                                                System.out.println("5.Liên kết ngân hàng!");
                                              
                                                System.out.println("0.Thoát");

                                                System.out.print("Nhập lựa chọn:");
                                                choice1 = sc.nextInt();
                                                sc.nextLine();
                                                switch (choice1) {
                                                    case 1:
                                                        String chon;
                                                            System.out.println("--------Menu--------");
                                                            AD.listRestaurant.getListNhaHang().values().forEach(item->{
                                                                item.inMenu();
                                                            });
                                                        do
                                                        {
                                                            int soLuong=0;
                                                            System.out.println("\n0.Thoát");
                                                            
                                                            System.out.print("Chọn món theo mã món:");
                                                            chon=sc.nextLine();
                                                            if(!chon.equalsIgnoreCase("0"))
                                                            {
                                                                System.out.print("Nhập số lượng :");
                                                                soLuong=sc.nextInt();
                                                                sc.nextLine();
                                                            }
                                                            else
                                                                break;

                                                            Restaurant nhaHangRestaurant=AD.listRestaurant.searchRestaurantByDishId(chon);
                                                            if(nhaHangRestaurant!=null){
                                                                Dish monDish=nhaHangRestaurant.searchDish(chon);
                                                                // tkCustomer.muaHangTrucTiep(nhaHangRestaurant.getMenu(), nhaHangRestaurant.searchDish(chon).getNameDish(), soLuong);
                                                                nhaHangRestaurant.giamSoLuong(monDish, soLuong);
                                                                if(!chon.equalsIgnoreCase("0"))
                                                                    {
                                                                        Dish newDish=AD.listRestaurant.searchDish(chon);
                                                                        if(newDish!=null)
                                                                            {
                                                                                newDish.setQuality(soLuong);
                                                                                tkCustomer.addDish(newDish);
                                                                            }
                                                                        else
                                                                            System.out.println("Không tìm thấy món!");
                                                                    }
                                                            }
                                                            else
                                                                System.out.println("\nMón không tìm thấy!\n");  
                                                        }
                                                        while (!chon.equalsIgnoreCase("0")) ;
                                                            
                                                        break;
                                                    case 2:
                                                        int chon1;
                                                        do
                                                        {
                                                            tkCustomer.inMenu();
                                                            tkCustomer.tinhTongTienGioHang();
                                                            System.out.println("1.Xem tổng tiền các đơn hơn trong giỏ hàng");
                                                            System.out.println("2.Giảm số lượng món ăn trong giỏ hàng");
                                                            System.out.println("3.Xóa món ăn ra khỏi giỏ hàng");
                                                            System.out.println("4.Mua hàng từ giỏ hàng!");
                                                            System.out.println("0.Thoats!");

                                                            System.out.print("Nhập lựa chọn:");
                                                            chon1=sc.nextInt();
                                                            sc.nextLine();

                                                            switch (chon1) {
                                                                case 1:
                                                                    tkCustomer.tinhTongTienGioHang();
                                                                    break;
                                                                case 2:
                                                                    System.out.print("Nhập mã món ăn cần giảm: ");
                                                                    String tenMon1 = sc.nextLine();
                                                                    System.out.print("Nhập số lượng cần giảm: ");
                                                                    int soLuong1 = sc.nextInt();
                                                                    sc.nextLine(); 
                                                                    tkCustomer.editDish(tenMon1, soLuong1);
                                                                break;
                                                                case 3:
                                                                    System.out.print("Nhập mã món cần xóa: ");
                                                                    String maMon = sc.nextLine();
                                                                    tkCustomer.deleteDish(maMon);
                                                                break;
                                                                case 4:
                                                                    tkCustomer.muaHangGioHang();

                                                                    break;
                                                                case 0:
                                                                break;
                                                                default:
                                                                    break;
                                                            }
                                                        } while (chon1!=0);

                                                        break;
                                                    case 3:
                                                        tkCustomer.viewOrderStatus();
                                                        break;
                                                    case 4:
                                                        tkCustomer.inLichSuGiaoDich();
                                                        break;
                                                    case 5:
                                                    System.out.print("Nhập số tài khoản ngân hàng cần liên kết:");
                                                    String stk=sc.nextLine();
                                                    
                                                  
                                                    

                                                    TaiKhoan taikhoan =ds.searchAcount(stk);
                                                    if(taikhoan!=null)
                                                    {
                                                        tkCustomer.themLienKet(stk, taikhoan);
                                                    }
                                                    else
                                                        System.out.println("Không tìm thấy tài khoản ngân hàng!\n");
                                                    
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
