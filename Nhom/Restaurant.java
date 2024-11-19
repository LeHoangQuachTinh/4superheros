/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Restaurant extends Account implements IDish {
    private String chuNhaHang;
    private double doanhThu;
    public List<Dish> menu;


    public Restaurant( String password, String SDT, String diachi, String idNhaHang,String tenNhaHang) {
        super(idNhaHang, tenNhaHang, password, SDT, diachi);
        this.menu = new ArrayList<>();
        this.doanhThu = 0.0;
    }

    public double getDoanhThu() {
        return doanhThu;
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
    public void congDoanhThu(double doanhThu){
        this.doanhThu+=doanhThu;
    }
    @Override
    public void lockAccount(){
        this.isLocked=true;
    }
}