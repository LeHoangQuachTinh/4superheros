package BT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

class Restaurant extends Account implements IDish {
    private String chuNhaHang;
    private double tongDoanhThu;
    private HashMap<String, Dish> menu;
    private HashMap<String,Dish>chiTietDoanhThu;

    public Restaurant(String password, String SDT, String diachi, String idNhaHang, String tenNhaHang,
            String chuNhaHang, String STK) {
        super(idNhaHang, tenNhaHang, password, SDT, diachi, STK);
        this.chuNhaHang = chuNhaHang;
        this.menu = new HashMap<>();
        this.tongDoanhThu = 0.0;
        this.chiTietDoanhThu = new HashMap<>();
    }

    public double getDoanhThu() {
        return tongDoanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.tongDoanhThu = doanhThu;
    }

    @Override
    public void addDish(Dish mon) {
        this.menu.put(mon.getIdDish(), mon);
    }

    public HashMap<String, Dish> getMenu() {
        return menu;
    }

    @Override
    public void editDish(String tenMon, int soLuong) {
        System.out.println("Nhập mã món ăn: ");
        String maMonAn = sc.nextLine();
        Dish dish = menu.get(maMonAn);

        if (dish != null) {
            System.out.println("Đang chỉnh sửa thông tin món: " + dish.getNameDish());
            System.out.println("Tên món ăn hiện tại: " + dish.getNameDish());
            System.out.println("Gía hiện tại: " + dish.getPrice());
            System.out.println("Số lượng hiện tại:" + dish.getQuality());

            System.out.println("Nhập thông tin mới cho món ăn (Nếu không muốn thay đổi vui lòng nhấn Enter): ");

            System.out.println("Nhập tên mới: ");
            String newName = sc.nextLine();
            if (!newName.isEmpty())
                dish.setNameDish(newName);

            System.out.println("Nhập giá mới: ");
            String newPriceStr = sc.nextLine();
            if (!newPriceStr.isEmpty()) {
                try {
                    double newPrice = Double.parseDouble(newPriceStr);
                    dish.setPrice(newPrice);
                } catch (NumberFormatException e) {
                    System.out.println("Định dạng không hợp lệ, giữ nguyên giá hiện tại!");
                }
            }

            System.out.println("Món ăn đã được cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy món ăn có mã là: " + maMonAn);
        }
    }

    @Override
    public void deleteDish(String tenMon) {
        System.out.print("Nhập mã món cần xóa: ");
        String maMon = sc.nextLine();

        Dish dish = menu.get(maMon);
        if (dish != null) {
            System.out.print("Xác nhận xóa món: " + dish.getNameDish() + " (Nhập 'y' để xác nhận): ");
            String xacNhan = sc.nextLine();
            if ("y".equals(xacNhan)) {
                menu.remove(maMon);
                System.out.println("Xóa món ăn thành công!");
            } else {
                System.out.println("Xóa món ăn bị hủy!");
            }
        } else {
            System.out.println("Không tìm thấy mã món ăn trong menu.");
        }
    }

    public void updateMenu() {
        int choice;
        do {
            System.out.println("---------- Chỉnh Sửa Menu -----------");
            System.out.println("""
                    1. Thêm món mới
                    2. Xóa món
                    3. Chỉnh sửa món đã có trong Menu
                    4. Giảm số lượng món
                    5. Tăng số lượng món
                    6. Thêm ưu đãi món ăn
                    7. Hủy ưu đãi món ăn
                    0. Thoát""");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:// Thêm món mới
                    Dish d = new Dish(diachi, SDT, choice, choice);
                    addDish(d);
                    break;
                case 2:// Xóa món
                    deleteDish("");
                    break;
                case 3:
                    editDish("", 1);
                    break;
                case 4: {
                    boolean tim = false;
                    String maMon;

                    do {
                        System.out.println("Nhập mã món cần giảm số lượng: ");
                        maMon = sc.nextLine();

                        Dish dish = menu.get(maMon);
                        if (dish != null) {
                            System.out.println("Món cần giảm số lượng: " + dish.getNameDish());
                            System.out.println("Số lượng hiện tại: " + dish.getQuality());
                            System.out.print("Nhập số lượng cần giảm: ");
                            int soLuongGiam = sc.nextInt();
                            sc.nextLine();

                            if (soLuongGiam <= 0) {
                                System.out.println("Số lượng giảm phải lớn hơn 0.");
                            } else if (soLuongGiam > dish.getQuality()) {
                                System.out.println("Số lượng giảm không thể lớn hơn số lượng hiện tại ("
                                        + dish.getQuality() + ").");
                            } else {
                                dish.giamSoLuong(soLuongGiam);
                                // System.out.println("Đã giảm số lượng món '" + dish.getNameDish() + "' thành
                                // công!");
                                tim = true;
                            }
                        } else {
                            System.out.println("Không tìm thấy món ăn có mã là: " + maMon);

                        }

                    } while (!tim);
                }
                    break;
                case 5: {
                    boolean tim = false;
                    String maMon;

                    // Dùng vòng lặp để yêu cầu nhập mã món cho đến khi đúng
                    do {
                        System.out.println("Nhập mã món cần tăng số lượng: ");
                        maMon = sc.nextLine();

                        Dish dish = menu.get(maMon);
                        if (dish != null) {
                            System.out.println("Món cần tăng số lượng: " + dish.getNameDish());
                            System.out.println("Số lượng hiện tại: " + dish.getQuality());

                            System.out.print("Nhập số lượng cần tăng: ");
                            int soLuongTang = sc.nextInt();
                            sc.nextLine();

                            if (soLuongTang <= 0) {
                                System.out.println("Số lượng tăng phải lớn hơn 0.");
                            } else {
                                dish.tangSoLuong(soLuongTang);
                                System.out.println("Đã tăng số lượng món '" + dish.getNameDish() + "' thành công!");
                                tim = true;
                            }
                        } else {
                            System.out.println("Không tìm thấy món ăn có mã là: " + maMon);
                        }

                    } while (!tim);
                }
                    break;
                case 6:
                    themMonAnUuDai();
                    break;
                case 7:
                    removeDiscount();
                    break;
                case 8:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 8);
    }

    public void inMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu hiện tại không có món ăn nào!");
        } else {
            System.out.println("                            ==== MENU nhà hàng "+getUsername()+" ====");
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-25s | %-10s | %-12s | %-12s | %-25s | \n", 
                              "Mã món", "Tên món","Số lượng" ,"Giá (VND)", "Giá sau giảm", "Chú thích");
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Dish dish : menu.values()) {
                String ghiChu = dish.isUuDai() ? String.format("Giảm %.0f%%", dish.getGiamGia()) : "Không áp dụng ưu đãi";
                double giaSauGiam = dish.giaSauKhiGiam();  // Giá sau giảm (dùng luôn cả khi không có ưu đãi)
                System.out.printf("| %-10s | %-25s | %-10s | %-12.0f | %-12.0f | %-25s |\n", 
                                  dish.getIdDish(), dish.getNameDish(),dish.getQuality() ,dish.getPrice(), 
                                  giaSauGiam, ghiChu);
                System.out.println("------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    
    public void themDoanhThu(Dish mon) {
        // Lấy thời gian hiện tại và định dạng
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedDate = now.format(formatter);

        // Thêm vào HashMap
        chiTietDoanhThu.put(formattedDate, mon);
        this.tongDoanhThu += mon.giaSauKhiGiam(); // Cập nhật tổng doanh thu
    }
    
    public void xemDoanhThu() {
        double tong=0;
        System.out.println("===========================================================");
        System.out.printf(" %-10s | %-15s | %-15s | %-20s\n", "Tên món", "Số lượng", "Số tiền", "Thời gian");
        System.out.println("-----------------------------------------------------------");
        for (var entry : chiTietDoanhThu.entrySet()) {
            Dish mon=entry.getValue();
            System.out.printf(" %-10s | %-15s | %-10.0f VNĐ  | %-20s\n", 
                mon.getNameDish(),
                mon.getQuality(),
                mon.giaSauKhiGiam(),
                entry.getKey().formatted(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"))
            );
            tong+=mon.giaSauKhiGiam()*mon.getQuality();
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Tổng doanh thu:         %.0f VND\n", tong);
        System.out.println("===========================================================");
    }
    

    @Override
    public void lockAccount() {
        this.isLocked = true;
    }

    public void giamSoLuong(Dish dish, int soLuong) {
        dish.giamSoLuong(soLuong);
        if (dish.getQuality() == 0)
            menu.remove(dish.getIdDish());
    }

    public Dish searchDish(String id) {
        return menu.get(id);
    }

    public void themMonAnUuDai() {
        System.out.print("Nhập mã món ăn cần đánh dấu ưu đãi: ");
        String maMonUuDai = sc.nextLine();
    
        // Tìm kiếm món ăn trong menu
        Dish monUuDai = menu.get(maMonUuDai);
        if (monUuDai != null) { // Sửa điều kiện kiểm tra (trước đó kiểm tra `maMonUuDai` thay vì `monUuDai`)
            System.out.print("Bạn đã chọn: " + monUuDai.getNameDish());
            double phanTramGiam = 0;
            boolean validInput = false;
    
            // Nhập phần trăm giảm giá
            do {
                try {
                    System.out.print("Nhập phần trăm giảm giá (0-100): ");
                    phanTramGiam = sc.nextDouble();
                    sc.nextLine(); // Đọc bỏ dòng thừa
    
                    if (phanTramGiam < 0 || phanTramGiam > 100) {
                        System.out.print("Phần trăm giảm giá không hợp lệ! Vui lòng nhập lại.");
                    } else {
                        validInput = true;
                    }
                } catch (Exception e) {
                    System.out.print("Định dạng không hợp lệ. Vui lòng nhập lại (ví dụ: 10% thì nhập 10).");
                    sc.nextLine(); // Đọc bỏ dữ liệu không hợp lệ
                }
            } while (!validInput);
    
            // Nhập thời hạn ưu đãi
            System.out.println("Chọn cách kết thúc ưu đãi:");
            System.out.println("1. Tự động kết thúc sau thời gian cố định");
            System.out.println("2. Người dùng tự kết thúc");
            int luaChonKetThuc = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng thừa

            switch (luaChonKetThuc) {
                case 1:
                    System.out.print("Nhập số ngày ưu đãi (1 ngày = 30 giây): ");
                    int soNgay = sc.nextInt();
                    sc.nextLine(); // Đọc bỏ dòng thừa
                    long duration = soNgay * 30 * 1000L; // Quy đổi thời gian sang mili giây
                    monUuDai.setUuDai(true, phanTramGiam, 1, duration); // Tự động kết thúc
                    System.out.println("Món ăn: " + monUuDai.getNameDish() + " đã được đánh dấu ưu đãi với giảm giá " 
                            + phanTramGiam + "% trong " + soNgay + " ngày.");
                break;
                case 2:
                    monUuDai.setUuDai(true, phanTramGiam, 2, 0); // Người dùng tự kết thúc
                    System.out.println("Món ăn: " + monUuDai.getNameDish() + " đã được đánh dấu ưu đãi với giảm giá " 
                            + phanTramGiam + "%. Người dùng sẽ tự tắt ưu đãi.");
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Không thể thiết lập ưu đãi.");
                    break;
            }
        } else {
            System.out.println("Không tìm thấy món ăn với mã: " + maMonUuDai);
        }
    }

    public void removeDiscount() {
        System.out.println("Chọn phương thức hủy giảm giá:");
        System.out.println("1. Hủy giảm giá cho một món cụ thể");
        System.out.println("2. Hủy giảm giá cho tất cả món ăn");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1 -> { // Hủy giảm giá cho một món
                System.out.print("Nhập mã món cần hủy giảm giá: ");
                String maMon = sc.nextLine();

                Dish dish = menu.get(maMon);
                if (dish != null) {
                    if (dish.isUuDai()) {
                        dish.setUuDai(false, 0); // Hủy ưu đãi cho món
                        System.out.println("Đã hủy giảm giá cho món: " + dish.getNameDish());
                    } else {
                        System.out.println("Món ăn không có ưu đãi. Không cần hủy.");
                    }
                } else {
                    System.out.println("Không tìm thấy món ăn có mã: " + maMon);
                }
            }
            case 2 -> { // Hủy giảm giá cho tất cả món
                boolean hasDiscount = false;
                for (Dish dish : menu.values()) {
                    if (dish.isUuDai()) {
                        dish.setUuDai(false, 0); // Hủy ưu đãi cho món
                        hasDiscount = true;
                    }
                }
                if (hasDiscount) {
                    System.out.println("Đã hủy giảm giá cho tất cả món ăn trong menu.");
                } else {
                    System.out.println("Không có món ăn nào đang áp dụng ưu đãi.");
                }
            }
            default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    @Override
    public void updateProfile() {
        System.out.println("\nChọn thông tin cần chỉnh sửa:");
        System.out.println("1. Tên người dùng");
        System.out.println("2. Số điện thoại");
        System.out.println("3. Địa chỉ");
        System.out.println("4. Mật khẩu");
        System.out.println("0.Thoát!");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1:
                System.out.print("Nhập tên người dùng mới: ");
                this.username = sc.nextLine();
                System.out.println("Tên người dùng đã được cập nhật!");
                break;
            case 2:
                System.out.print("Nhập số điện thoại mới: ");
                this.SDT = sc.nextLine();
                System.out.println("Số điện thoại đã được cập nhật!");
                break;
            case 3:
                System.out.print("Nhập địa chỉ mới: ");
                this.diachi = sc.nextLine();
                System.out.println("Địa chỉ đã được cập nhật!");
                break;
            case 4:
                System.out.print("Nhập mật khẩu mới: ");
                String newPassword;
                do {
                    newPassword = sc.nextLine();
                    if (!kiemTraMatKhauManh(newPassword)) {
                        System.out.println("Mật khẩu không hợp lệ! Nhập lại: ");
                    }
                } while (!kiemTraMatKhauManh(newPassword));
                this.setPassword(newPassword);
                System.out.println("Mật khẩu đã được cập nhật!");
                break;
            case 0:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void markBestSeller() {
        System.out.println("Nhập mã món ăn cần đánh dấu bán chạy: ");
        String idDish = sc.nextLine();
        Dish dish = menu.get(idDish);
        if (dish != null) {
            dish.setBestSeller(true);
            System.out.println("Đã đánh dấu món " + dish.getNameDish() + " là <<BEST SELLER>>!");
        } else {
            System.out.println("Không tìm thấy món ăn với mã " + idDish);
        }
    }

    public void removeBestSeller() {
        System.out.println("Nhập mã món cần hủy đánh dấu Best Seller: ");
        String idDish = sc.nextLine();
        Dish dish = menu.get(idDish);
        if (dish != null) {
            dish.setBestSeller(false);
            System.out.println("Món " + dish.getNameDish() + " đã bị gỡ <<Best Seller>>");
        } else {
            System.out.println("Không tìm thấy món ăn với mã " + idDish);
        }
    }
    @Override
    public void showInfo() {
        super.in();
        System.out.println("Chủ nhà hàng:" + this.chuNhaHang);
        System.out.println("Doanh thu nhà hàng:" + this.tongDoanhThu);
    }

}