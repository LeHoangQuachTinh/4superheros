package order_online;

import java.util.Hashtable;
import java.util.Scanner;

public class ListRestaurant {
    private Hashtable<String, Restaurant> listNhaHang = new Hashtable<>();

    //Phương thức đăng kí nhà hàng (giữ nguyên)
    public void dangKiNhaHang(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập mã nhà hàng");
        String idNhaHang = sc.nextLine();

        if(listNhaHang.contains(idNhaHang)){
            System.out.println("Mã nhà hàng đã được đăng kí. Xin vui lòng nhập lại!");
            return;
        }
        System.out.println("Nhập tên nhà hàng: ");
        String tenNhahang = sc.nextLine();

        System.out.println("Nhập chủ nhà hàng ");
        String chuNhaHang = sc.nextLine();

        System.out.println("Thiết lập mật khẩu: ");
        String password = sc.nextLine();

        System.out.println("Nhập số điện thoại nhà hàng: ");
        String sdt = sc.nextLine();

        System.out.println("Nhập địa chỉ nhà hàng: ");
        String diaChi = sc.nextLine();

        Restaurant newRestaurant = new Restaurant(idNhaHang, chuNhaHang, password, sdt, diaChi, idNhaHang, tenNhahang);
        listNhaHang.put(idNhaHang, newRestaurant);
        System.out.println("Tao tai khoan nha hang thanh cong!");
    }
    
    public Restaurant search(String id){
        return listNhaHang.get(id);
    }
}
