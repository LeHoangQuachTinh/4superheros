package NHOM;

import java.util.Hashtable;
import java.util.Scanner;

import java.util.Hashtable;

import java.util.Scanner;

import NHOM.IListAccount;



public class ListRestaurant implements  IListAccount{
    private Hashtable<String, Restaurant> listNhaHang = new Hashtable<>();

    //Phương thức đăng kí nhà hàng (giữ nguyên)
    public void registerAccount(){
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

        Restaurant newRestaurant = new Restaurant( password, sdt, diaChi, idNhaHang, tenNhahang);
        listNhaHang.put(idNhaHang, newRestaurant);
        System.out.println("Tao tai khoan nha hang thanh cong!");
    }
    
    public Restaurant search(String id){
        return listNhaHang.get(id);
    }

    @Override
    public void editAccount() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void forgotPassWord() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void lockAccount() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean login() {
        // TODO Auto-generated method stub
        return false;
    }
}
