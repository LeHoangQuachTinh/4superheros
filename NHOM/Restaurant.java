package order_online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Restaurant extends Account implements IRestaurant {

    private String idNhaHang;
    private String tenNhaHang;
    private String chuNhaHang;
    private String password;
    private String sdt;

    private List<Dish> menu;
    private double doanhThu;
    Scanner sc = new Scanner(System.in);

    public Restaurant(String idUser, String username, String password, String SDT, String diachi, String idNhaHang,
            String tenNhaHang) {
        super(idUser, username, password, SDT, diachi);
        this.idNhaHang = idNhaHang;
        this.tenNhaHang = tenNhaHang;
        this.menu = new ArrayList<>();
        this.doanhThu = 0.0;
    }

    public String getTenNhaHang() {
        return tenNhaHang;
    }

    public double getDoanhThu() {
        return doanhThu;
    }


    @Override
    public void register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public void addDish() {
       String maMon, tenMon;
       double price;
       int soluong;
       
       do {
            System.out.println("Nhập mã món: ");
            maMon=sc.nextLine();

            boolean ktMaMon = false;
            for(Dish dish : menu){
                if(dish.getIdDish().equals(maMon)){
                    System.out.println("Mã món đã tồn tại. Vui lòng nhập lại!");
                    ktMaMon = true;
                    break;
                }
            }

            if(!ktMaMon){
                //Nhập tên món
                System.out.println("Nhập tên món: ");
                tenMon=sc.nextLine();

                boolean ktTenMon = false;
                for(Dish dish : menu){
                    if(dish.getNameDish().equals(tenMon)){
                        System.out.println("Tên món đã tồn tại. Vui lòng nhập lại!");
                        ktTenMon=true;
                        break;
                    }
                }
                if(!ktTenMon){
                    while(true){
                        System.out.print("Nhập giá món: ");
                        price=sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Nhập số lượng hiện có:");
                        soluong=sc.nextInt();

                        if(soluong<=0)
                            System.out.println("Số lượng món phải lớn hơn 0. Vui lòng nhập lại!");
                        else if(price<0)
                            System.out.println("Giá món phải lớn hơn hoặc bằng 0.Vui lòng nhập lại");
                        else{
                            Dish newDish = new Dish(maMon, tenMon, price,soluong);
                            menu.add(newDish);
                            System.out.println("Đã thêm món: "+tenMon+" thành công!");
                            break;
                        }
                    }
                    break;
                }
            }
       } while (true);
    }

    @Override
    public void editDish() {
        System.out.println("Nhập mã món ăn: ");
        String maMonAn = sc.nextLine();
        boolean tim = false;
        for(Dish dish : menu){
            if(dish.getIdDish().equals(maMonAn)){
                tim = true;
                System.out.println("Đang chỉnh sửa thông tin món: "+dish.getNameDish());
                System.out.println("Tên món ăn hiện tại: "+dish.getNameDish());
                System.out.println("Gía hiện tại: "+dish.getPrice());
                System.out.println("Số lượng hiện tại:"+dish.getQuality());

                System.out.println("Nhập thông tin mới cho món ăn(Nếu không muốn thay đổi vui lòng nhấn Enter): ");

                System.out.println("Nhập tên mới: ");
                String newName = sc.nextLine();
                if(!newName.isEmpty())  
                    dish.setNameDish(newName);
                System.out.println("Nhập giá mới: ");
                String newPriceStr = sc.nextLine();
                if(!newPriceStr.isEmpty()){
                    try {
                        double newPrice = Double.parseDouble(newPriceStr);
                        dish.setPrice(newPrice);
                    } catch (NumberFormatException e) {
                        System.out.println("Định dạng không hợp lệ, giữ nguyên giá hiện tại!");
                    }
                }

                System.out.println("Món ăn đã được cập nhật thành công!");
                break;
            }
            if(!tim)
                System.out.println("Không tìm thấy món ăn có mã là: "+dish.getIdDish());
        }
    }

    @Override
    public void deleteDish() {
        System.out.println("Nhập mã món cần xóa: ");
        String maMon = sc.nextLine();
        boolean tim = false;
        for(Dish dish : menu){
            if(dish.getIdDish().equals(maMon)){
                System.out.println("Xác nhận xóa món: "+dish.getNameDish() + " (Nhập 'y' để xác nhận): ");
                String xacNhan = sc.nextLine();
                if("y".equals(xacNhan)){
                    menu.remove(dish);
                    System.out.println("Xóa món ăn thành công!");
                }
                else 
                    System.out.println("Xóa món ăn bị hủy!");
                tim = true;
                break;
            }
        }
        if(!tim)
            System.out.println("Không tìm thấy mã món ăn trong menu.");
    }

    @Override
    public void xemDoanhThu() {
        System.out.println("Doanh thu: "+doanhThu);
    }

    @Override
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
                        if(newRestaurant.equals(tenNhaHang)){
                            System.out.println("Tên nhà hàng mới trùng với tên nhà hàng cũ!. Không có thay đổi nào được thực hiện!");
                        }
                        else{
                            this.tenNhaHang=newRestaurant;
                        System.out.println("Tên nhà hàng đã được cập nhật: "+this.tenNhaHang);
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
                        if(newSdt.equals(sdt)){
                            System.out.println("Số điện thoại mới trùng với số điện thoại cũ! Không có sự thay đổi nào được thực hiện!");
                        }
                        else{
                            this.setSDT(newSdt);
                            System.out.println("Số điện thoại đã được cập nhật: "+this.SDT);
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

    @Override
    public void updateMenu() {
        int choice;
        do{
            System.out.println("===== Chỉnh Sửa Menu =====");
            System.out.println("""
                                1. Thêm món mới")
                                2. Xóa món
                                3. Chỉnh sửa món đã có trong Menu
                                4. Thoát""");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch(choice){
                case 1://Thêm món mới
                    addDish();
                break;
                case 2://Xóa món
                    deleteDish();
                break;
                case 3:
                    editDish();
                break;
                case 4:
                    System.out.println("Thoát");
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while(choice != 4);
    }

    public void inMenu(){
        if(menu.isEmpty()){
            System.out.println("Menu hiện tại không có món ăn nào!");
        }
        else{
            System.out.println("\n==== MENU NHÀ HÀNG: "+ tenNhaHang+" ====\n");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-40s | %-20s |\n","Mã món", "Tên món", "Giá (VND)");
            System.out.println("--------------------------------------------------------------------------------");

            for(Dish dish : menu){
                System.out.printf("| %-10s | %-40s | %-20.0f |\n", dish.getIdDish(), dish.getNameDish(), dish.getPrice());
            }
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

}