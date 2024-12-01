package BT;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

class Restaurant extends Account implements IDish {
    private String chuNhaHang;
    private double doanhThu;
    private HashMap<String,Dish> menu;
   
    
    public Restaurant( String password, String SDT, String diachi, String idNhaHang,String tenNhaHang,String chuNhaHang,String STK) {
        super(idNhaHang, tenNhaHang, password, SDT, diachi);
        this.chuNhaHang=chuNhaHang;
        this.STK=STK;
        this.menu = new HashMap<>();
        this.doanhThu = 0.0;
    }

    public double getDoanhThu() {
        return doanhThu;
    }
    
    @Override
    public void addDish(Dish mon){
        this.menu.put(mon.getIdDish(), mon);
    }
    public HashMap<String,Dish> getMenu() {
        return menu;
    }


    @Override
    public void editDish(String tenMon,int soLuong) {
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
        do{
            System.out.println("===== Chỉnh Sửa Menu =====");
            System.out.println("""
                                1. Thêm món mới
                                2. Xóa món
                                3. Chỉnh sửa món đã có trong Menu
                                4. Giảm số lượng món
                                5. Tăng số lượng món
                                6. Thoát""");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch(choice){
                case 1://Thêm món mới
                    Dish d=new Dish(diachi, SDT, choice, choice);
                    addDish(d);
                break;
                case 2://Xóa món
                    deleteDish("");
                break;
                case 3:
                    editDish("",1);
                break;
                case 4:
                {
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
                                System.out.println("Số lượng giảm không thể lớn hơn số lượng hiện tại (" + dish.getQuality() + ").");
                            } else {
                                dish.giamSoLuong(soLuongGiam);
                                // System.out.println("Đã giảm số lượng món '" + dish.getNameDish() + "' thành công!");
                                tim=true;
                            }
                        } else {
                            System.out.println("Không tìm thấy món ăn có mã là: " + maMon);

                        }


                    } while (!tim);
                }
                break;
                case 5: 
                {
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
                                tim=true;
                            }
                        } else {
                            System.out.println("Không tìm thấy món ăn có mã là: " + maMon);
                        }


                    } while (!tim); 
                }
                break;
                case 6:
                    System.out.println("Thoát");
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while(choice != 6);
    }

    public void inMenu() {
    if (menu.isEmpty()) {
        System.out.println("\nMenu hiện tại không có món ăn nào!\n");
    } else {
        System.out.println("\n==== MENU NHÀ HÀNG: " + getUsername() + " ====\n");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-40s | %-20s | %-15s |\n", "Mã món", "Tên món", "Giá (VND)", "Số lượng");
        System.out.println("--------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, Dish> entry : menu.entrySet()) {
            Dish dish = entry.getValue();
            System.out.printf("| %-10s | %-40s | %-20.0f | %-15d |\n", 
                dish.getIdDish(), dish.getNameDish(), dish.getPrice(), dish.getQuality());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
}


    // public double tinhDoanhThu() {
    //     doanhThu = 0.0;

    //     // Duyệt qua tất cả các đơn hàng và cộng tổng tiền của mỗi đơn hàng
    //     for (Order order : allOrders) {
    //         doanhThu += order.getTotalPrice();
    //     }

    //     return doanhThu;
    // }

    public void xemDoanhThu() {
        System.out.println("Doanh thu của nhà hàng: "+doanhThu);
    }
    @Override
    public void lockAccount(){
        this.isLocked=true;
    }

   

    public void giamSoLuong(Dish dish, int soLuong){
        dish.giamSoLuong(soLuong);
    }
    public Dish searchDish(String id){
        return menu.get(id);
    }

    public void themMonAnUuDai(){
        System.out.println("Nhập mã món ăn cần đánh dấu ưu đãi: ");
        String maMonUuDai = sc.nextLine();

        //Tìm kiếm món ăn trong menu
        Dish monUuDai = menu.get(maMonUuDai);
        if(maMonUuDai != null){
            System.out.println("Bạn đã chọn: "+ monUuDai.getNameDish());
            double phanTramGiam = 0;
            boolean gt = false;
            do {
                try {
                    System.out.println("Nhập phần trăm giảm giá (0-100): ");
                    phanTramGiam=sc.nextDouble();
                    sc.nextLine();

                    if(phanTramGiam < 0 || phanTramGiam > 100){
                        System.out.println("Phần trăm giảm giá không hợp lệ! Vui lòng nhập lại");
                    }else{
                        gt = true;
                    }
                } catch (Exception e) {
                    System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại (ví dụ: 10% thì nhập 10).");
                    sc.nextLine();
                }
            } while (!gt);
            //Nhập thời hạn ưu đãi
            System.out.println("Chọn thời hạn ưu đãi: ");
            System.out.println("1. 3 ngày (10 giây)");
            System.out.println("2. 2 tuần (14 giây)");
            System.out.println("3. 1 tháng (20 giây)");
            int luaChon = sc.nextInt();
            sc.nextLine();
        
            long duration = 0;
            switch (luaChon) {
                case 1:
                    duration = 10000; // 10 giây
                    break;
                case 2:
                    duration = 14000; // 14 giây
                    break;
                case 3:
                    duration = 50000; // 20 giây
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Thời hạn ưu đãi mặc định là 3 ngày.");
                    duration = 10000;
            }
            //Cập nhật trạng thái ưu đãi cho món ăn
            monUuDai.setUuDai(true, phanTramGiam, duration);
            System.out.println("Món ăn: "+monUuDai.getNameDish()+" đã được đánh dấu ưu đãi với giảm giá"+ phanTramGiam+" %.");
        }else{
            System.out.println("Không tìm thấy món ăn với mã: "+maMonUuDai);
        }
    }

    public void removeDiscount(){
        System.out.println("Nhập mã món cần hủy giảm giá: ");
        String idDish = sc.nextLine();
        Dish dish = menu.get(idDish);
        if(dish!=null){
            dish.setGiamGia(0);
            System.out.println("Đã hủy chương trình ưu đãi cho món: "+dish.getNameDish());
        }else{
            System.out.println("Không tìm thấy món ăn với mã: "+idDish);
        }
    }

    public void markBestSeller(){
        System.out.println("Nhập mã món ăn cần đánh dấu bán chạy: ");
        String idDish = sc.nextLine();
        Dish dish = menu.get(idDish);
        if(dish != null){
            dish.setBestSeller(true);
            System.out.println("Đã đánh dấu món "+dish.getNameDish()+ " là <<BEST SELLER>>!");
        }else{
            System.out.println("Không tìm thấy món ăn với mã "+idDish);
        }
    }

    public void removeBestSeller(){
        System.out.println("Nhập mã món cần hủy đánh dấu Best Seller: ");
        String idDish = sc.nextLine();
        Dish dish = menu.get(idDish);
        if(dish!=null){
            dish.setBestSeller(false);
            System.out.println("Món "+dish.getNameDish()+" đã bị gỡ <<Best Seller>>");
        }else{
            System.out.println("Không tìm thấy món ăn với mã "+idDish);
        }
    }


}