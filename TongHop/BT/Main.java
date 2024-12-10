package BT;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import BT.NganHang.MainNH;
import BT.NganHang.TaiKhoanThanhToan;
import static BT.IListAccount.DS;

public class Main {

    public static int xuLyInt(String thongbao) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(thongbao);
                int input = sc.nextInt();
                // sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Bạn nhập lựa chọn phải một số nguyên!\n.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Admin AD = new Admin();

        AD.docFileMonAn("D:\\DAIHOC\\KY_3\\TH_LTHDT\\BAI_THUC_HANH\\src\\TongHop\\BT\\data.txt");
        Scanner sc = new Scanner(System.in);
        TaiKhoanThanhToan TKGoc = AD.getTkGoc();
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        Map<String, ScheduledFuture<?>> orderFutures = new ConcurrentHashMap<>();

        int choice;
        while (true) {
            System.out.println("\nỨng dụng đặt đồ ăn online.Xin Chào!");
            System.out.println("1.Quản Trị Viên");
            System.out.println("2.Nhà Hàng");
            System.out.println("3.Người dùng");
            System.out.println("4.Người giao hàng");
            // System.out.println("10.Chuyển qua ngân hàng(Không khuyến cáo)");

            System.out.println("0.Thoát!");

            choice = xuLyInt("Mời bạn nhập lựa chọn:");
            // sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã quản trị viên để đăng nhập:");
                    String maQuanTri = sc.nextLine();
                    if (AD.getMaQuanTri().equals(maQuanTri)) {
                        int c;
                        do {
                            System.out.println("---------------ADMIN---------------");
                            System.out.println("1.Quản lí tài khoản Nhà Hàng");
                            System.out.println("2.Quản lí tài khoản Khách Hàng");
                            System.out.println("3.Quản lí tài khoản Người Giao Hàng");
                            System.out.println("4.(Dừng/bật lại) hoạt động để bảo trì");
                            System.out.println("5.Xuất file danh sách tài khoản hiện có trong hệ thống");
                            System.out.println("6.Đổi mã quản trị viên");
                            System.out.println("0.Thoát");

                            c = xuLyInt("Nhập lựa chọn:");
                            // sc.nextLine();

                            switch (c) {
                                case 1:
                                    do {
                                        System.out.println(
                                                "\n--------------Chức năng quản lí tài khoản Nhà Hàng------------------");
                                        System.out.println("1.Thêm tài khoản nhà hàng");
                                        System.out.println("2.Xoá tài khoản nhà hàng");
                                        System.out.println("3.Chỉnh sửa tài khoản nhà hàng");
                                        System.out.println("4.Khoá tài khoản nhà hàng chỉ định");
                                        System.out.println("5.Mở khoá tài khoản nhà hàng chỉ định");
                                        System.out.println("0.Thoát");

                                        choice = xuLyInt("Nhập lựa chọn:");
                                        // sc.nextLine();

                                        switch (choice) {
                                            case 1:
                                                AD.listRestaurant.registerAccount();
                                                break;
                                            case 2:
                                                AD.listRestaurant.deleteAccount();
                                                break;
                                            case 3:
                                                System.out.print("Nhập mã tài khoản ngân hàng cần sửa:");
                                                String id = sc.nextLine();

                                                AD.listRestaurant.getListNhaHang().get(id).updateProfile();
                                                ;
                                                break;
                                            case 4:
                                                System.out.print("Nhập mã tài khoản ngân hàng cần khoá:");
                                                String matk = sc.nextLine();
                                                AD.listRestaurant.getListNhaHang().get(matk).lockAccount();
                                                ;
                                                break;
                                            case 5:
                                                System.out.print("Nhập mã tài khoản ngân hàng cần mở khoá:");
                                                matk = sc.nextLine();
                                                AD.listRestaurant.getListNhaHang().get(matk).openAccount();
                                                ;
                                            default:
                                                break;
                                        }
                                    } while (choice != 0);

                                    break;
                                case 2:
                                    do {
                                        System.out.println(
                                                "\n--------------Chức năng quản lí tài khoản Khách Hàng------------------");
                                        System.out.println("1.Thêm tài khoản Khách hàng");
                                        System.out.println("2.Xoá tài khoản Khách Hàng");
                                        System.out.println("3.Chỉnh sửa tài khoản Khách Hàng");
                                        System.out.println("4.Khoá tài khoản khách hàng chỉ định");
                                        System.out.println("5.Mở khoá tài khoản khách hàng chỉ định");
                                        System.out.println("6.Xem đánh giá của khách hàng");
                                        System.out.println("0.Thoát");
                                        choice = xuLyInt("Nhập lựa chọn:");
                                        // sc.nextLine();

                                        switch (choice) {
                                            case 1:
                                                AD.listCustomer.registerAccount();
                                                break;
                                            case 2:
                                                AD.listCustomer.deleteAccount();
                                                break;
                                            case 3:
                                                System.out.print("Nhập mã tài khoản khách hàng cần sửa:");
                                                String id = sc.nextLine();
                                                AD.listCustomer.getListCustomer().get(id).updateProfile();
                                                break;
                                            case 4:
                                                System.out.print("Nhập mã tài khoản khách hàng cần khoá:");
                                                String matk = sc.nextLine();
                                                AD.listCustomer.getListCustomer().get(matk).lockAccount();
                                                ;
                                                break;
                                            case 5:
                                                System.out.print("Nhập mã tài khoản khách hàng cần moở khoá:");
                                                matk = sc.nextLine();
                                                AD.listCustomer.getListCustomer().get(matk).openAccount();
                                                break;
                                            case 6:
                                                System.out.println("\n---------Đánh giá của khách hàng------------\n");
                                                AD.showDanhGia();
                                                break;
                                            case 0:
                                                choice = 0;
                                                break;
                                            default:
                                                break;
                                        }
                                    } while (choice != 0);

                                    break;
                                case 3:
                                    do {
                                        System.out.println(
                                                "\n--------------Chức năng quản lí tài khoản Người Giao Hàng------------------");
                                        System.out.println("1.Thêm tài khoản Shipper");
                                        System.out.println("2.Xoá tài khoản Shipper");
                                        System.out.println("3.Chỉnh sửa tài khoản Shipper");
                                        System.out.println("4.Khoá tài khoản Shipper chỉ định");
                                        System.out.println("5.Mở khoá tài khoản Shipper chỉ định");
                                        System.out.println("0.Thoát");

                                        choice = xuLyInt("Nhập lựa chọn:");
                                        // sc.nextLine();

                                        switch (choice) {
                                            case 1:
                                                AD.listShipper.registerAccount();
                                                break;
                                            case 2:
                                                AD.listShipper.deleteAccount();
                                                break;
                                            case 3:
                                                System.out.print("Nhập mã tài khoản shipper cần sửa:");
                                                String id = sc.nextLine();
                                                AD.listShipper.getListShipper().get(id).updateProfile();
                                                ;
                                                break;
                                            case 4:
                                                System.out.print("Nhập mã tài khoản shipper cần khoá:");
                                                String matk = sc.nextLine();
                                                AD.listShipper.getListShipper().get(matk).lockAccount();
                                                break;
                                            case 5:
                                                System.out.print("Nhập mã tài khoản shipper cần mở khoá:");
                                                matk = sc.nextLine();
                                                AD.listShipper.getListShipper().get(matk).openAccount();
                                                break;
                                            default:
                                                break;
                                        }
                                    } while (choice != 0);
                                    break;
                                case 4:
                                    AD.doiHoatDong();
                                    if (!AD.isHoatDong())
                                        System.out.println("\nĐã dừng hoạt động các hoạt động các tài khoản!\n");
                                    else
                                        System.out.println("\nHệ thống đã hoạt động lại.Có thể sử dụng bình thường!\n");
                                    break;
                                case 5:
                                    AD.GhiFile();
                                    break;
                                case 6:
                                    System.out.println("Nhập mã quản trị cũ:");
                                    String maQT = sc.nextLine();
                                    if (AD.getMaQuanTri().equals(maQT))
                                        AD.setMaQuanTri(maQT);
                                    else
                                        System.out.println("Mã quản trị không đúng");
                                    break;

                                case 0:
                                    break;
                                default:
                                    break;
                            }
                        } while (c != 0);
                    } else
                        System.out.println("Mã quản trị sai.Thoát");
                    break;
                case 2: {
                    if (AD.isHoatDong()) {
                        Restaurant nhaHangHienTai = null;
                        do {
                            System.out.println("\n===== Quản Lý Nhà Hàng =====");
                            System.out.println("""
                                    1. Đăng kí nhà hàng
                                    2. Đăng nhập nhà hàng
                                    3. Quên mật khẩu
                                    0. Thoát
                                    """);

                            choice = xuLyInt("Chọn chức năng: ");
                            // sc.nextLine();

                            switch (choice) {
                                case 1:// Đăng kí nhà hàng
                                    AD.listRestaurant.registerAccount();
                                    break;
                                case 2: // Đăng nhập nhà hàng
                                    int dem = 0;
                                    System.out.print("Nhập mã nhà hàng (ID): ");
                                    String id = sc.nextLine();
                                    System.out.print("Nhập mật khẩu: ");
                                    String password = sc.nextLine();
                                    nhaHangHienTai = AD.listRestaurant.search(id);

                                    while (dem < 5) {
                                        if (nhaHangHienTai != null) {
                                            if (nhaHangHienTai.kTPassword(password)) {
                                                System.out.println("\nĐăng nhập thành công!");
                                                System.out.printf("Xin chào chủ nhà hàng %s!\n",
                                                        nhaHangHienTai.username);
                                                int chon;
                                                do {
                                                    // Hiển thị menu chức năng
                                                    System.out.println(
                                                            "======================================================");
                                                    System.out.println(
                                                            "|              BẠN MUỐN LÀM GÌ ?                     |");
                                                    System.out.println(
                                                            "======================================================");
                                                    System.out.println(
                                                            "|  1. Tạo Menu (Thêm món)                            |");
                                                    System.out.println(
                                                            "|  2. Chỉnh sửa Menu                                 |");
                                                    System.out.println(
                                                            "|  3. Xem Menu                                       |");
                                                    System.out.println(
                                                            "|  4. Xem Doanh Thu                                  |");
                                                    System.out.println(
                                                            "|  5. Đổi Mật Khẩu                                   |");
                                                    System.out.println(
                                                            "|  6. Cập Nhật Thông Tin Nhà Hàng                    |");
                                                    System.out.println(
                                                            "|  0. Thoát                                          |");
                                                    System.out.println(
                                                            "======================================================");

                                                    chon = xuLyInt("Chọn chức năng: ");
                                                    // sc.nextLine();

                                                    // Xử lý các chức năng người dùng chọn
                                                    switch (chon) {
                                                        case 1: // Thêm món
                                                            String idDish;
                                                            String nameDish;
                                                            double price = 0;
                                                            ;
                                                            int quality = 0;
                                                            String idNhap;
                                                            boolean kt = false;
                                                            // Nhập id món ăn
                                                            do {
                                                                System.out.println("Nhập mã món: ");
                                                                idDish = sc.nextLine().trim(); // trim() loại bỏ khoảng
                                                                                               // trắng hai đầu

                                                                // Kiểm tra chứa kí tự đặc biệt
                                                                if (idDish.matches(".*[!@#$%^&*].*")) {
                                                                    System.out.println(
                                                                            "Mã món không được chứa kí tự đặc biệt. Vui lòng nhập lại!");
                                                                    continue;
                                                                }

                                                                // Kiểm tra trùng mã món
                                                                if (nhaHangHienTai.getMenu().containsKey(idDish)) {
                                                                    System.out.println(
                                                                            "Mã món ăn đã tồn tại. Vui lòng nhập mã món khác!");
                                                                    continue;
                                                                }
                                                                kt = true;
                                                            } while (!kt);

                                                            kt = false;
                                                            // Nhập tên món ăn
                                                            do {
                                                                System.out.println("Nhập tên món ăn: ");
                                                                nameDish = sc.nextLine().trim();
                                                                // Kiểm tra trùng tên món ăn
                                                                boolean isDuplicate = false;
                                                                for (Dish dish : nhaHangHienTai.getMenu().values()) { // Giả sử Dish là class chứa thông tin món ăn
                                                                                                                
                                                                    if (dish.getNameDish().equalsIgnoreCase(nameDish)) {
                                                                        isDuplicate = true;
                                                                        break;
                                                                    }
                                                                }

                                                                if (isDuplicate) {
                                                                    System.out.println(
                                                                            "Tên món ăn bị trùng lặp với các món ăn trước. Vui lòng nhập tên khác!");
                                                                    kt = false;
                                                                } else {
                                                                    kt = true;
                                                                }
                                                            } while (!kt);

                                                            kt = false;
                                                            do {
                                                                try {
                                                                    System.out.println("Nhập giá món ăn: ");
                                                                    price = sc.nextDouble();
                                                                    sc.nextLine();
                                                                    if (price <= 0) {
                                                                        System.out.println(
                                                                                "Giá món phải lớn hơn 0. Vui lòng nhập lại.");
                                                                    } else {
                                                                        kt = true;
                                                                    }
                                                                } catch (Exception e) {
                                                                    System.out.println(
                                                                            "Định dạng giá không hợp lệ. Vui lòng nhập lại!");
                                                                    sc.nextLine(); // Xóa bộ nhớ đệm khi nhập sai
                                                                }
                                                            } while (!kt);

                                                            kt = false;
                                                            do {
                                                                try {
                                                                    System.out.println();
                                                                    quality = xuLyInt("Nhập số lượng hiện có: ");
                                                                    // sc.nextLine();
                                                                    if (quality < 0) {
                                                                        System.out.println(
                                                                                "Số lượng nhập vào phải lớn hơn 0. Vui lòng nhập lại!");
                                                                    } else {
                                                                        kt = true;
                                                                    }
                                                                } catch (Exception e) {
                                                                    System.out.println(
                                                                            "Định dạng số lượng không hợp lệ. Vui lòng nhập lại (ví dụ: 100).");
                                                                    sc.nextLine();
                                                                }
                                                            } while (!kt);
                                                            Dish dish = new Dish(idDish, nameDish, price, quality);
                                                            nhaHangHienTai.addDish(dish);
                                                            System.out.println("Bạn vừa mới thêm món "
                                                                    + dish.getNameDish() + " vao Menu!");

                                                            // Hỏi người dùng có muốn thêm món ăn này làm món ăn ưu đãi không
                                      
                                                            System.out.println(
                                                                    "Bạn có muốn thêm món này vào danh sách món ưu đãi không? (Y/N): ");
                                                            String them = sc.nextLine();
                                                            if (them.equalsIgnoreCase("Y")) {
                                                                System.out.println(
                                                                        "Nhập phần trăm giảm giá cho món ăn (ví dụ: 20 phần trăm thì nhập 20): ");
                                                                double phanTramGiam = sc.nextDouble();
                                                                sc.nextLine();
                                                                System.out.println("Chọn thời hạn ưu đãi: ");
                                                                System.out.println("""
                                                                        1. 3 ngày (quy ước 10 giây)
                                                                        2. 2 tuần (quy ước 14 giây)
                                                                        3. 1 tháng (quy ước 20 giây)
                                                                        """);
                                                                int luaChon = xuLyInt("Nhập lựa chọn:");
                                                                

                                                                long thoiHan = 0;
                                                                switch (luaChon) {
                                                                    case 1:
                                                                        thoiHan = 10000; // 10 giây
                                                                        break;
                                                                    case 2:
                                                                        thoiHan = 14000; // 14 giây
                                                                        break;
                                                                    case 3:
                                                                        thoiHan = 60000; // 20 giây
                                                                        break;
                                                                    default:
                                                                        System.out.println(
                                                                                "Lựa chọn không hợp lệ. Thời gian ưu đãi mặc định là 3 ngày");
                                                                        thoiHan = 10000;
                                                                }
                                                                dish.setUuDai(true, phanTramGiam, thoiHan);
                                                                System.out.println("Món " + dish.getNameDish()
                                                                        + " đã được thêm vào danh sách món ăn ưu đãi với "
                                                                        + phanTramGiam + " % giảm giá.");
                                                            } else {
                                                                System.out.println(
                                                                        "Bạn đã không thêm món " + dish.getNameDish()
                                                                                + " không được thêm vào món ưu đãi.");
                                                            }
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
                                                            nhaHangHienTai.updateProfile();
                                                            break;
                                                        case 0: // Thoát
                                                            System.out.println("Thoát chương trình");
                                                            break;
                                                        default:
                                                            System.out.println(
                                                                    "Lựa chọn không hợp lệ! Vui lòng thử lại.");
                                                            break;
                                                    }
                                                } while (chon != 0);
                                                break;
                                            } else {
                                                dem++; // Tăng số lần nhập sai mật khẩu
                                                System.out.println("Mật khẩu không đúng. Số lần sai: " + dem);

                                                // Nếu đã nhập sai 5 lần
                                                if (dem == 5) {
                                                    choice = 0;
                                                }
                                            }
                                        } else {
                                            System.out.println("Mã nhà hàng không tồn tại!");
                                            break; // Kết thúc nếu mã nhà hàng không tồn tại
                                        }

                                        // Nếu đăng nhập chưa thành công, yêu cầu nhập lại mật khẩu
                                        if (dem < 5) {
                                            System.out.print("Nhập lại mật khẩu: ");
                                            password = sc.nextLine();
                                        }
                                    }
                                    break;
                                case 3:// Quên mật khẩu
                                    AD.listRestaurant.forgotPassWord();
                                    break;
                                case 4:
                                    System.out.println("Thoát chương trình!");
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                                    break;
                            }
                        } while (choice != 0);
                    } else
                        System.out.println("Hệ thống dang bảo trì.Vui lòng thử lại sai!");
                }
                    break;
                case 3: {
                    if (AD.isHoatDong()) {
                       
                        do {
                            System.out.println("\n--------Tài khoản khách hàng----------");
                            System.out.println("1.Đăng kí tài khoản!");
                            System.out.println("2.Đăng nhập tài khoản!");
                            System.out.println("3.Quên mật khẩu!");
                            System.out.println("0.Thoát!");
                            choice = xuLyInt("Nhập lựa chọn:");
                            // sc.nextLine();
                            switch (choice) {
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
                                                System.out.printf("Xin chào khách hàng %s!\n", tkCustomer.username);
                                                dangNhap = true;
                                                int choice1;
                                                do {
                                                    // Hiển thị menu chức năng sau khi đăng nhập
                                                    System.out.println(
                                                            "\n-------------Chức năng người dùng-------------");
                                                    System.out.println("1.Chọn món");
                                                    System.out.println("2.Giỏ hàng");
                                                    System.out.println("3.Xem trạng thái đơn hàng");
                                                    System.out.println("4.Báo cáo/Đánh giá");
                                                    System.out.println("5.Liên kết ngân hàng!");
                                                    System.out.println("6.Cập nhật thông tin khách hàng!");
                                                    System.out.println("7.Huỷ đơn hàng vừa mới đặt(Nếu có)");
                                                    System.out.println("8.Khóa tài khoản");
                                                    System.out.println("9.Mở tài khoản");
                                                    System.out.println("0.Thoát");

                                                    choice1 = xuLyInt("Nhập lựa chọn:");
                                                    // sc.nextLine();
                                                    switch (choice1) {
                                                        case 1:
                                                            if(!tkCustomer.isIsLocked()){
                                                                String chon;
                                                                System.out.println("--------Menu--------");
                                                                AD.listRestaurant.getListNhaHang().values()
                                                                        .forEach(item -> {
                                                                            item.inMenu();
                                                                        });

                                                                do {
                                                                    tkCustomer.showMonDaChon();
                                                                    if (!tkCustomer.getGioMuaTrucTiep().isEmpty()) {
                                                                        System.out.println("\nA.Mua các món đã chọn");
                                                                        System.out.println("B.Xoá món đã chọn");
                                                                    }
                                                                    System.out.println("0.Thoát");

                                                                    System.out.print("Chọn món theo mã món: ");
                                                                    chon = sc.nextLine();

                                                                    if (chon.equalsIgnoreCase("0"))
                                                                        break; // Nếu chọn thoát, thoát khỏi vòng lặp
                                                                    if (chon.equalsIgnoreCase("A")) {

                                                                        System.out.println("Chọn phương thức thanh toán");
                                                                        System.out.println("1.Thanh toán online");
                                                                        System.out.println("2.Thanh toán trực tiếp");

                                                                        int lc = xuLyInt("Nhập lựa chọn:");

                                                                        List<Dish> danhSachMonAn = new ArrayList<>();

                                                                        for (Dish dish : tkCustomer.getGioMuaTrucTiep()
                                                                                .values())
                                                                            danhSachMonAn.add(dish);
                                                                        String orderId = tkCustomer.random(8);
                                                                        Order donHangMoi = new Order(orderId, danhSachMonAn,
                                                                                true, tkCustomer, null);
                                                                        if (tkCustomer.getTaiKhoanThanhToan()
                                                                                .getSodu() >= donHangMoi.getTotalPrice()) {
                                                                            System.out.printf(
                                                                                    "\n Mã đơn hàng của bạn là:%s\n",
                                                                                    orderId);
                                                                            System.out.println(
                                                                                    "Đơn hàng đang chuẩn bị.Đang chờ shipper nhận hàng...........");
                                                                            AD.listDH.put(orderId, donHangMoi);
                                                                            LocalDateTime startTime = LocalDateTime.now();
                                                                            Runnable task = new Runnable() {

                                                                                @Override
                                                                                public void run() {
                                                                                    LocalDateTime now = LocalDateTime.now();

                                                                                    // Kiểm tra nếu không có shipper nhận đơn

                                                                                    if (!AD.listDH.get(orderId).nhan) {
                                                                                        // Kiểm tra đã qua 2 phút và chưa
                                                                                        // tới 5 phút
                                                                                        if (now.isAfter(
                                                                                                startTime.plusMinutes(2))
                                                                                                && now.isBefore(startTime
                                                                                                        .plusMinutes(5))) {


                                                                                            Shipper shipper = AD
                                                                                                    .ShipperNgauNhien();
                                                                                            donHangMoi.setShipper(shipper);
                                                                                            double tien = tkCustomer
                                                                                                    .thanhToan(lc, DS,
                                                                                                            tkCustomer
                                                                                                                    .tinhTongTienGioHangTrucTiep(),
                                                                                                            "Mua trực tiếp",
                                                                                                            shipper,
                                                                                                            donHangMoi);
                                                                                            TKGoc.congSoDu(tien);
                                                                                            AD.phanPhoiTienChoNhaHang(
                                                                                                    tkCustomer
                                                                                                            .donHangMoidat());
                                                                                            orderFutures.get(orderId)
                                                                                                    .cancel(true);
                                                                                        }
                                                                                        // Kiểm tra đã qua 5 phút
                                                                                        else if (now.isAfter(
                                                                                                startTime.plusMinutes(5))) {
                                                                                            // Điều kiện 2: đã qua 5 phút và
                                                                                            // chưa có shipper nhận
                                                                                            orderFutures.get(orderId)
                                                                                                    .cancel(true);
                                                                                            System.out.println(
                                                                                                    "Không có shipper nhận đơn hàng trong 5 phút. Hủy yêu cầu tạo đơn hàng.");
                                                                                        }
                                                                                    }
                                                                                    // Nếu đã có shipper nhận đơn
                                                                                    else {
                                                                                        double tien = tkCustomer.thanhToan(
                                                                                                lc, DS,
                                                                                                tkCustomer
                                                                                                        .tinhTongTienGioHangTrucTiep(),
                                                                                                "Mua trực tiếp",
                                                                                                AD.timShipper(orderId),
                                                                                                donHangMoi);
                                                                                        TKGoc.congSoDu(tien);
                                                                                        AD.phanPhoiTienChoNhaHang(
                                                                                                tkCustomer.donHangMoidat());
                                                                                        orderFutures.get(orderId)
                                                                                                .cancel(true);
                                                                                    }
                                                                                }
                                                                            };
                                                                            ScheduledFuture<?> future = scheduled
                                                                                    .scheduleAtFixedRate(task, 0, 1,
                                                                                            TimeUnit.SECONDS);
                                                                            orderFutures.put(orderId, future);

                                                                        } else
                                                                            System.out.println(
                                                                                    "\nSố tiền trong tài khoản không đủ thanh toán.Vui lòng nạp thêm");

                                                                        break;
                                                                    }
                                                                    if (chon.equalsIgnoreCase("B")) {
                                                                        System.out.print("Nhập mã món cần xoá:");
                                                                        String maMon = sc.nextLine();

                                                                        if (tkCustomer.getGioMuaTrucTiep()
                                                                                .containsKey(maMon)) {
                                                                            int soLuong = tkCustomer.getGioMuaTrucTiep()
                                                                                    .get(maMon).getQuality();
                                                                            AD.listRestaurant.searchDish(maMon)
                                                                                    .tangSoLuong(soLuong);
                                                                            tkCustomer.getGioMuaTrucTiep().remove(maMon);
                                                                            System.out.println("Xoá thành công!");
                                                                        } else
                                                                            System.out.println("Không tìm món cần xoá!");
                                                                        break;
                                                                    }
                                                                    int soLuong = xuLyInt("Nhập số lượng: ");
                                                                    // sc.nextLine(); // Đọc dòng tiếp theo để tránh việc bỏ
                                                                    // qua input

                                                                    Restaurant nhaHangRestaurant = AD.listRestaurant
                                                                            .searchRestaurantByDishId(chon);
                                                                    if (nhaHangRestaurant != null) {
                                                                        Dish monDish = nhaHangRestaurant.searchDish(chon);
                                                                        Dish monDishKH = new Dish(monDish.getIdDish(),
                                                                                monDish.getNameDish(), monDish.getPrice(),
                                                                                soLuong);
                                                                        if (monDish != null) {
                                                                            if (soLuong <= monDish.getQuality()
                                                                                    && soLuong > 0) {

                                                                                System.out.println("1.Mua trực tiếp");
                                                                                System.out.println("2.Thêm vào giỏ hàng");
                                                                                System.out.println("0.Thoát!");

                                                                                int choose = xuLyInt("Nhập lựa chọn");
                                                                                sc.nextLine();

                                                                                switch (choose) {
                                                                                    case 1:
                                                                                        monDishKH.setQuality(soLuong);
                                                                                        tkCustomer.themMon(monDishKH);
                                                                                        nhaHangRestaurant.giamSoLuong(
                                                                                                monDish, soLuong);
                                                                                        break;
                                                                                    case 2:
                                                                                        monDishKH.setQuality(soLuong);
                                                                                        tkCustomer.addDish(monDishKH);
                                                                                        nhaHangRestaurant.giamSoLuong(
                                                                                                monDish, soLuong);
                                                                                        break;

                                                                                    case 0:
                                                                                        break;
                                                                                    default:
                                                                                        break;
                                                                                }

                                                                            } else {
                                                                                System.out.println(
                                                                                        "\nSố lượng bạn mua lớn hơn số lượng món đang có hay số lượng nhập không hợp lệ. Không thể thêm!");
                                                                            }
                                                                        } else
                                                                            System.out.println("\nMón không tìm thấy!");

                                                                    } else
                                                                        System.out.println(
                                                                                "\nMón không tồn tại trong nhà hàng!");

                                                                } while (!chon.equalsIgnoreCase("0"));
                                                            }
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");

                                                            break;
                                                        case 2:
                                                            if(!tkCustomer.isIsLocked()){
                                                                int chon1;
                                                                do {
                                                                    tkCustomer.inMenu();
                                                                    tkCustomer.tinhTongTienGioHang();
                                                                    System.out.println(
                                                                            "1.Xem tổng tiền các đơn hơn trong giỏ hàng");
                                                                    System.out.println(
                                                                            "2.Giảm số lượng món ăn trong giỏ hàng");
                                                                    System.out.println("3.Xóa món ăn ra khỏi giỏ hàng");
                                                                    System.out.println("4.Mua hàng từ giỏ hàng!");


                                                                    System.out.println("0.Thoats!");

                                                                    chon1 = xuLyInt("Nhập lựa chọn");


                                                                    switch (chon1) {
                                                                        case 1:
                                                                            tkCustomer.tinhTongTienGioHang();
                                                                            break;
                                                                        case 2:
                                                                            System.out.print("Nhập mã món ăn cần giảm: ");
                                                                            String maMon1 = sc.nextLine();

                                                                            int soLuong1 = xuLyInt(
                                                                                    "Nhập số lượng cần giảm: ");

                                                                            tkCustomer.editDish(maMon1, soLuong1);
                                                                            Restaurant nhaHangRestaurant = AD.listRestaurant
                                                                                    .searchRestaurantByDishId(maMon1);
                                                                            Dish monDish = nhaHangRestaurant
                                                                                    .searchDish(maMon1);

                                                                            monDish.tangSoLuong(soLuong1);
                                                                            break;
                                                                        case 3:
                                                                            System.out.print("Nhập mã món cần xóa: ");
                                                                            String maMon = sc.nextLine();

                                                                            Restaurant nhaHangRestaurant1 = AD.listRestaurant
                                                                                    .searchRestaurantByDishId(maMon);
                                                                            Dish monDish1 = nhaHangRestaurant1
                                                                                    .searchDish(maMon);


                                                                            monDish1.tangSoLuong(monDish1.getQuality());
                                                                            tkCustomer.deleteDish(maMon);
                                                                            break;
                                                                        case 4:

                                                                            System.out
                                                                                    .println("Chọn phương thức thanh toán");
                                                                            System.out.println("1.Thanh toán online");
                                                                            System.out.println("2.Thanh toán trực tiếp");

                                                                            int lc = xuLyInt("Nhập lựa chọn:");

                                                                            List<Dish> danhSachMonAn = new ArrayList<>();

                                                                            for (Dish dish : tkCustomer.getGioHang()
                                                                                    .values())
                                                                                danhSachMonAn.add(dish);
                                                                            String orderId = tkCustomer.random(8);// Random  mã đơn hàng

                                                                            Order donHangMoi = new Order(orderId,
                                                                                    danhSachMonAn, true, tkCustomer, null);

                                                                            if (tkCustomer.getTaiKhoanThanhToan()
                                                                                    .getSodu() >= donHangMoi
                                                                                            .getTotalPrice()) {
                                                                                System.out.printf(
                                                                                        "\n Mã đơn hàng của bạn là:%s\n",
                                                                                        orderId);
                                                                                System.out.println(
                                                                                        "Đang chờ shipper nhận hàng.Đơn hàng đang chủng bị.Chờ shipper nhận hàng\n");
                                                                                AD.listDH.put(orderId, donHangMoi);
                                                                                LocalDateTime startTime = LocalDateTime
                                                                                        .now();
                                                                                Runnable task = new Runnable() {

                                                                                    @Override
                                                                                    public void run() {
                                                                                        LocalDateTime now = LocalDateTime
                                                                                                .now();

                                                                                        // Kiểm tra nếu không có shipper nhận đơn

                                                                                        if (!AD.listDH.get(orderId).nhan) {
                                                                                            // Kiểm tra đã qua 2 phút và chưa tới 5 phút

                                                                                            if (now.isAfter(startTime
                                                                                                    .plusMinutes(2))
                                                                                                    && now.isBefore(
                                                                                                            startTime
                                                                                                                    .plusMinutes(
                                                                                                                            5))) {


                                                                                                Shipper shipper = AD
                                                                                                        .ShipperNgauNhien();
                                                                                                donHangMoi.setShipper(
                                                                                                        shipper);
                                                                                                double tien = tkCustomer
                                                                                                        .thanhToan(lc, DS,
                                                                                                                tkCustomer
                                                                                                                        .tinhTongTienGioHang(),
                                                                                                                "Mua giỏ hàng",
                                                                                                                shipper,
                                                                                                                donHangMoi);
                                                                                                TKGoc.congSoDu(tien);
                                                                                                AD.phanPhoiTienChoNhaHang(
                                                                                                        tkCustomer
                                                                                                                .donHangMoidat());
                                                                                                orderFutures.get(orderId)
                                                                                                        .cancel(true);
                                                                                            }
                                                                                            // Kiểm tra đã qua 5 phút
                                                                                            else if (now.isAfter(startTime
                                                                                                    .plusMinutes(5))) {
                                                                                                // Điều kiện 2: đã qua 5 phút và chưa có shipper nhận

                                                                                                orderFutures.get(orderId)
                                                                                                        .cancel(true);
                                                                                                System.out.println(
                                                                                                        "Không có shipper nhận đơn hàng trong 5 phút. Hủy yêu cầu tạo đơn hàng.");
                                                                                            }
                                                                                        }
                                                                                        // Nếu đã có shipper nhận đơn
                                                                                        else {
                                                                                            double tien = tkCustomer
                                                                                                    .thanhToan(lc, DS,
                                                                                                            tkCustomer
                                                                                                                    .tinhTongTienGioHang(),
                                                                                                            "Mua trực tiếp",
                                                                                                            AD.timShipper(
                                                                                                                    orderId),
                                                                                                            donHangMoi);
                                                                                            TKGoc.congSoDu(tien);
                                                                                            AD.phanPhoiTienChoNhaHang(
                                                                                                    tkCustomer
                                                                                                            .donHangMoidat());
                                                                                            orderFutures.get(orderId)
                                                                                                    .cancel(true);
                                                                                        }
                                                                                    }
                                                                                };

                                                                                // Lưu trữ thời gian bắt đầu công việc
                                                                                ScheduledFuture<?> future = scheduled
                                                                                        .scheduleAtFixedRate(task, 0, 1,
                                                                                                TimeUnit.SECONDS);
                                                                                orderFutures.put(orderId, future);

                                                                            } else
                                                                                System.out.println(
                                                                                        "Số tiền tài khoản không đủ.Vui lòng nạp thêm để thanh toán online");
                                                                            break;
                                                                        case 0:
                                                                            break;
                                                                        default:
                                                                            break;
                                                                    }
                                                                } while (chon1 != 0);
                                                            }
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");

                                                            break;
                                                        case 3:
                                                            if(!tkCustomer.isIsLocked())
                                                                tkCustomer.inLichSuGiaoDich();
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");
                                                            break;
                                                        case 4:
                                                            if(!tkCustomer.isIsLocked()){
                                                                System.out.print("Nhập ý kiến của bạn:");
                                                                String danhGia = sc.nextLine();
                                                                AD.themDanhGia("\n KH" + tkCustomer.idUser + ":" + danhGia
                                                                        + "lúc " + LocalDate.now() + " \n");
                                                                System.out.println("\nCảm ơn quý khách đã đánh giá\n");
                                                            }
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");
                                                            break;
                                                        case 5:
                                                            if(!tkCustomer.isIsLocked())
                                                                AD.listCustomer.lienKetNganHang(tkCustomer);
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");
                                                            break;
                                                        case 6:
                                                            if(!tkCustomer.isIsLocked())
                                                                tkCustomer.updateProfile();
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");
                                                            break;
                                                        case 7:
                                                            if(!tkCustomer.isIsLocked()){
                                                               System.out.print("Nhập mã đơn cần huỷ:");
                                                                String maDon = sc.nextLine();
                                                                if (AD.listDH.containsKey(maDon)) {
                                                                    if (AD.timShipper(maDon) == null) {
                                                                        Order od = AD.listDH.get(maDon);
                                                                        if (od.isThanhToan())
                                                                            tkCustomer.getTaiKhoanThanhToan()
                                                                                    .congSoDu(od.getTotalPrice());
                                                                        orderFutures.get(maDon).cancel(true);
                                                                        AD.listDH.remove(maDon);
                                                                        System.out.println(
                                                                                "Huỷ thành công đơn hàng " + maDon);
                                                                    } else
                                                                        System.out.println(
                                                                                "\nĐã có shipper nhận đơn hàng và đang giao.Không thể huỷ");
                                                                } else
                                                                    System.out.println("Mã đơn hàng không tìm thấy!"); 
                                                            }
                                                            else
                                                                System.out.println("Tài khoản đã bị khóa trước đó không thể thực hiện,vui lòng mở tài khoản để thực hiện");
                                                            break;
                                                        case 8:
                                                            if(tkCustomer.isIsLocked()){
                                                                System.out.println("Tài khoản đã bị khóa trước đó");   
                                                            }
                                                            else
                                                                tkCustomer.lockAccount();
                                                            
                                                            break;
                                                        case 9:
                                                            if(!tkCustomer.isIsLocked())
                                                                System.out.println("Tài khoản đang được mở");
                                                                
                                                            else
                                                                tkCustomer.openAccount();
                                                            break;
                                                        case 0:
                                                            System.out.println("Đã thoát chức năng người dùng.");
                                                            break;
                                                        default:
                                                            System.out.println(
                                                                    "Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                                                            break;
                                                    }
                                                } while (choice1 != 0);
                                                break;
                                            } else {
                                                dem++;
                                                System.out.println("Sai mật khẩu! Bạn còn " + (5 - dem) + " lần thử.");
                                            }
                                        }
                                        // Nếu quá 5 lần nhập sai
                                        if (!dangNhap)
                                            System.out.println(
                                                    "Bạn đã nhập sai quá 5 lần. Tài khoản bị khóa hoặc thoát.");
                                    } else
                                        System.out.println("Tài khoản không tồn tại.");
                                    break;
                                case 3:
                                    AD.listCustomer.forgotPassWord();
                                    break;
                                case 0:
                                    break;
                            }
                        } while (choice != 0);
                    } else
                        System.out.println("Hệ thống đang bảo trì.Vui lòng thử lại sau!");
                }
                    break;
                case 4:

                    if (AD.isHoatDong()) {
                        do {
                            System.out.println("-----------Tài khoản người giao hàng------------");
                            Shipper shipperHienTai = null;
                            System.out.println("""
                                        1. Đăng kí shipper
                                        2. Đăng nhập shipper
                                        3. Quên mật khẩu
                                        0. Thoát
                                    """);

                            choice = xuLyInt("Chọn chức năng: ");
                            // sc.nextLine();

                            switch (choice) {
                                case 1:
                                    AD.listShipper.registerAccount();
                                    break;

                                case 2:
                                    // Đăng nhập shipper
                                    System.out.print("Nhập mã shipper (ID): ");
                                    String shipperId = sc.nextLine();
                                    System.out.print("Nhập mật khẩu: ");
                                    String shipperPassword = sc.nextLine();

                                    shipperHienTai = AD.listShipper.findShipper(shipperId);

                                    if (shipperHienTai != null && shipperHienTai.kTPassword(shipperPassword)) {
                                        System.out.println("Đăng nhập thành công!");
                                        int chon;
                                        do {
                                            System.out.println("==== Menu Shipper ====");
                                            System.out.println("1. Bật trạng thái shipper (Có sẵn)");
                                            System.out.println("2. Tắt trạng thái shipper (Không có sẵn)");
                                            System.out.println("3. Xem loại xe");
                                            System.out.println("4. Xem danh sách tất cả các đơn hàng hiện có");
                                            System.out.println("5. Xem danh sách đơn đang chưa giao xong");
                                            System.out.println("6. Hoàn thành đơn!");
                                            System.out.println("7. Chọn các đơn hàng đang có sẵn!");
                                            System.out.println("0. Thoát");
                                            System.out.print("Chọn chức năng: ");
                                            chon = xuLyInt("Chọn chức năng: ");
                                            // sc.nextLine();

                                            switch (chon) {
                                                case 1:
                                                    shipperHienTai.batTrangThai();
                                                    break;
                                                case 2:
                                                    shipperHienTai.tatTrangThai();
                                                    break;
                                                case 3:
                                                    System.out.println(
                                                            "Loại xe của shipper: " + shipperHienTai.getLoaiXe());
                                                    break;
                                                case 4:
                                                    shipperHienTai.showOrders();
                                                    break;
                                                case 5:
                                                    shipperHienTai.showDonChuaGiao();
                                                    break;
                                                case 6:
                                                    shipperHienTai.giaoHang();
                                                    break;
                                                case 7:
                                                    if (!AD.listDH.isEmpty()) {
                                                        for (Order od : AD.listDH.values()) {
                                                            od.chiTietDonHang();
                                                        }

                                                        System.out.println("Chọn đơn theo mã đơn:");
                                                        String maDon = sc.nextLine();

                                                        if (AD.listDH.containsKey(maDon)) {
                                                            // Tìm và thêm đơn hàng vào danh sách đơn hàng của shipper
                                                            Order mon = AD.listDH.get(maDon);
                                                            if (!mon.isThanhToan()) {
                                                                if (shipperHienTai.getTaiKhoanThanhToan()
                                                                        .getSodu() >= mon.getTotalPrice()) {
                                                                    mon.nhan = true;
                                                                    shipperHienTai.addOrder(mon);
                                                                    mon.setShipper(shipperHienTai);

                                                                    Thread delayThread = new Thread(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            try {

                                                                                Thread.sleep(4000);
                                                                                AD.listDH.remove(maDon);
                                                                                // Kiểm tra và hủy tác vụ nếu shipper đã
                                                                                // nhận đơn
                                                                                if (orderFutures.get(maDon) != null
                                                                                        && !orderFutures.get(maDon)
                                                                                                .isCancelled()) {
                                                                                    orderFutures.get(maDon)
                                                                                            .cancel(true); // Hủy công
                                                                                                           // việc định
                                                                                                           // kỳ kiểm
                                                                                                           // tra
                                                                                                           // shipper
                                                                                    System.out.println(
                                                                                            "Shipper đã nhận đơn hàng. Hủy tác vụ kiểm tra.");
                                                                                }

                                                                            } catch (InterruptedException e) {
                                                                                e.printStackTrace();
                                                                            }
                                                                        }
                                                                    });

                                                                    // Bắt đầu chạy thread
                                                                    delayThread.start();
                                                                } else
                                                                    System.out.println(
                                                                            "\nSố tiền trong tài khoản của bạn không đủ.Không thể nhận đơn");
                                                            } else {
                                                                mon.nhan = true;
                                                                shipperHienTai.addOrder(mon);
                                                                mon.setShipper(shipperHienTai);

                                                                Thread delayThread = new Thread(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        try {

                                                                            Thread.sleep(4000);
                                                                            AD.listDH.remove(maDon);
                                                                            // Kiểm tra và hủy tác vụ nếu shipper đã
                                                                            // nhận đơn
                                                                            if (orderFutures.get(maDon) != null
                                                                                    && !orderFutures.get(maDon)
                                                                                            .isCancelled()) {
                                                                                orderFutures.get(maDon).cancel(true); // Hủy công việc định kỳ kiểm tra shipper
                                                                                                                  
                                                                                System.out.println(
                                                                                        "Shipper đã nhận đơn hàng. Hủy tác vụ kiểm tra.");
                                                                            }

                                                                        } catch (InterruptedException e) {
                                                                            e.printStackTrace();
                                                                        }
                                                                    }
                                                                });
                                                                // Bắt đầu chạy thread
                                                                delayThread.start();
                                                            }

                                                        } else {
                                                            System.out.println(
                                                                    "\nMã đơn bạn nhập hiện không có. Thử lại sau");
                                                        }
                                                    } else {
                                                        System.out.println("\nKhông có đơn hàng nào hiện có!");
                                                    }
                                                    break;

                                                case 0:
                                                    break;
                                                default:
                                                    break;
                                            }
                                        } while (chon != 0);
                                    } else {
                                        System.out.println("Thông tin đăng nhập không đúng.");
                                    }
                                    break;
                                case 3:
                                    AD.listShipper.forgotPassWord();
                                    break;
                                case 0:
                                    break;

                                default:
                                    break;
                            }
                        } while (choice != 0);
                    } else
                        System.out.println("Hệ thống đang bảo trì.Vui lòng thử lại sau!");
                    break;
                case 10:
                    MainNH.main(new String[] {});
                    break;
                case 0:
                    System.out.println("😊❤️Xin cảm ơn!❤️😊");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn sai.Vui lòng nhập lại!");
                    break;
            }
        }
    }
}
