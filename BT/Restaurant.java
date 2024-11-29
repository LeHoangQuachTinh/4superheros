package BT;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

class Restaurant extends Account implements IDish {
    private String chuNhaHang;
    private double doanhThu;
    private HashMap<String,Dish> menu;
   
    public Restaurant( String password, String SDT, String diachi, String idNhaHang,String tenNhaHang,String chuNhaHang) {
        super(idNhaHang, tenNhaHang, password, SDT, diachi);
        this.chuNhaHang=chuNhaHang;
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
        System.out.println("Nhập mã món cần xóa: ");
        String maMon = sc.nextLine();

        Dish dish = menu.get(maMon);
        if (dish != null) {
            System.out.println("Xác nhận xóa món: " + dish.getNameDish() + " (Nhập 'y' để xác nhận): ");
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
                                1. Thêm món mới")
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

    public void updateThongTinNhaHang() {
        int choice;
        do {
            System.out.println("=====Cập nhật thông tin nhà hàng=====");
            System.out.println("""
                    1.Cập nhật tên nhà hàng
                    2.Cập nhật địa chỉ nhà hàng
                    3.Cập nhật số điện thoại nhà hàng
                    4.Thoát
                    """);
            
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice){
                case 1:
                //Đổi tên nhà hàng
                    System.out.println("Nhập tên nhà hàng mới: ");
                    String newRestaurant = sc.nextLine();
                    if(!newRestaurant.isEmpty()){
                        if(newRestaurant.equals(getUsername())){
                            System.out.println("Tên nhà hàng mới trùng với tên nhà hàng cũ!. Không có thay đổi nào được thực hiện!");
                        }
                        else{
                            this.setUsername(newRestaurant);
                        System.out.println("Tên nhà hàng đã được cập nhật: "+this.getUsername());
                        }
                    }
                    else
                        System.out.println("Tên nhà hàng chưa được cập nhật.");
                break;
                case 2:
                //Đổi địa chỉ nhà hàng
                    System.out.println("Nhập địa chỉ mới của nhà hàng: ");
                    String newAdress = sc.nextLine();
                    if(!newAdress.isEmpty()){
                        if(newAdress.equals(diachi)){
                            System.out.println("Địa nhà hàng mới trùng với địa chỉ nhà hàng cũ!. Không có thay đổi nào được thực hiện!");
                        }
                        else{
                            this.setDiachi(newAdress);
                            System.out.println("Địa chỉ đã cập nhật thành công: "+this.diachi);
                        }
                    }
                    else
                        System.out.println("Địa chỉ chưa được cập nhật");
                break;
                case 3:
                //Đổi số điện thoại
                    System.out.println("Nhập số điện thoại mới: ");
                    String newSdt = sc.nextLine();
                    if(!newSdt.isEmpty()){
                        if(newSdt.equals(getSDT())){
                            System.out.println("Số điện thoại mới trùng với số điện thoại cũ! Không có sự thay đổi nào được thực hiện!");
                        }
                        else{
                            this.setSDT(newSdt);
                            System.out.println("Số điện thoại đã được cập nhật: "+this.getSDT());
                        }
                    }
                    else
                        System.out.println("Số điện thoại chưa được cập nhật");
                break;
                case 4:
                //Thoát chương trình
                    System.out.println("Thoát cập nhật!");
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 4);
    }

    public void giamSoLuong(Dish dish, int soLuong){
        dish.giamSoLuong(soLuong);
    }
    public Dish searchDish(String id){
        return menu.get(id);
    }

}