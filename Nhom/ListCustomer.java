/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package order_online;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import java.util.stream.Collectors;
public class ListCustomer implements IListAccount{
    private HashMap<String,Customer> listCustomer;

    public HashMap<String, Customer> getListCustomer() {
        return listCustomer;
    }

    ListCustomer(){
        this.listCustomer=new HashMap<>();
    }

    /**
     *
     */

    @Override
    public void lockAccount(String matk) {
        if(listCustomer.get(matk)!=null)
            listCustomer.get(matk).isLocked=true;
        else
             System.out.println("Không tìm thấy tài khoản!\n");
    }

    @Override
    public void forgotPassWord() {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Nhập số điện thoại đã đăng kí với tài khoản của bạn: ");
        // String sdtNhap = sc.nextLine();
        System.out.println("Nhập mã khách hàng đã đăng kí:");
        String maKH=sc.nextLine();

        Customer customer=listCustomer.get(maKH);
        if(customer!=null){
            //Tạo mã OTP
            Random rand = new Random();
            int otp = 100000 + rand.nextInt(999999);
            System.out.println("Mã OTP của bạn là: "+otp);

            //Nhập OTP xác nhận
            System.out.println("Vui lòng nhập mã OTP để xác nhận");
            int otpNhap = sc.nextInt();

            if(otpNhap==otp){
                System.out.println("Mã OTP chính xác!");
                sc.nextLine();
                
                //Đổi mật khẩu
                System.out.println("Nhập mật khẩu mới: ");
                String newPassword = sc.nextLine();
                // this.password = newPassword;
                customer.password=newPassword;
                System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
            }
            else
                System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");
        }
        else
            System.out.println("Không tìm thấy tài khoản!\n");
    }

    @Override
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID khách hàng: ");
        String id = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();

        // Kiểm tra thông tin đăng nhập
        if (listCustomer.containsKey(id)) {
            if (listCustomer.get(id).getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            } else {
                System.out.println("Mật khẩu sai!");
                return false;
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
        return false;
    }

    @Override
    public void registerAccount() {
         Scanner scanner =new Scanner(System.in);
         String idUser;
        do{
            System.out.print("Nhập IdUser:");
            idUser=scanner.nextLine();
            if(listCustomer.containsKey(idUser)){
                System.out.println("Mã code đã tồn tại trong hệ thống!Nhập lại!");
            }
        }
        while(listCustomer.containsKey(idUser));
        System.out.print("Nhập username:");
        String username=scanner.nextLine();

        System.out.print("Nhập số điện thoại đăng kí:");
        String SDT=scanner.nextLine();

        System.out.print("Nhập địa chỉ:");
        String diachi=scanner.nextLine();
        Random random = new Random();
        String soOTP= random.ints(6, 0, 9)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining());;
        System.out.println("Mã otp của bạn là:"+soOTP);
        String otp ;
        do{
            System.out.print("Nhập mã otp:");
            otp=scanner.nextLine();
            if(!otp.equals(soOTP))
                System.out.println("Số otp không khớp!Vui lòng nhập lại!");
        }
        while(!otp.equals(soOTP));
        String password;
        do{
            System.out.print("Tạo mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự):");
            password=scanner.nextLine();
            if(!kiemTraMatKhauManh(password))
                System.out.println("Mật khẩu không hợp lệ!");
        }
        while(!kiemTraMatKhauManh(password));
        Customer tkCustomer=new Customer(true, idUser, username, password, SDT, diachi);
        listCustomer.put(idUser, tkCustomer);

    }

    
    public Customer search(String maCustomer){
        return listCustomer.get(maCustomer);
    }
    //Ràng buộc mật khẩu
    public boolean kiemTraMatKhauManh(String matkhau) {
        if (matkhau.length() >= 5 
            &&matkhau.matches(".*[A-Z].*") 
            &&  matkhau.matches(".*[a-z].*")
            &&matkhau.matches(".*\\d.*") 
            && matkhau.matches(".*[!@#$%^&*()].*")) 
            return true;  
        return false;
    }
    
    //Kiểm tra tồn tại IdUser trong danh sách
    public Account kiemTraTonTai(String idUser){
        return listCustomer.get(idUser);
    }
    
    @Override
    public void editAccount() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập ID khách hàng cần chỉnh sửa: ");
    String id = scanner.nextLine();

    Customer customer = listCustomer.get(id);
    if (customer == null) {
        System.out.println("Không tìm thấy khách hàng!");
        return;
    }

    System.out.println("Chọn thông tin cần chỉnh sửa:");
    System.out.println("1. Tên người dùng");
    System.out.println("2. Số điện thoại");
    System.out.println("3. Địa chỉ");
    System.out.println("4. Mật khẩu");
    System.out.print("Nhập lựa chọn của bạn: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Đọc bỏ dòng trống

    switch (choice) {
        case 1:
            System.out.print("Nhập tên người dùng mới: ");
            customer.username = scanner.nextLine();
            System.out.println("Tên người dùng đã được cập nhật!");
            break;
        case 2:
            System.out.print("Nhập số điện thoại mới: ");
            customer.SDT = scanner.nextLine();
            System.out.println("Số điện thoại đã được cập nhật!");
            break;
        case 3:
            System.out.print("Nhập địa chỉ mới: ");
            customer.diachi = scanner.nextLine();
            System.out.println("Địa chỉ đã được cập nhật!");
            break;
        case 4:
            System.out.print("Nhập mật khẩu mới: ");
            String newPassword;
            do {
                newPassword = scanner.nextLine();
                if (!kiemTraMatKhauManh(newPassword)) {
                    System.out.println("Mật khẩu không hợp lệ! Nhập lại: ");
                }
            } while (!kiemTraMatKhauManh(newPassword));
            customer.password = newPassword;
            System.out.println("Mật khẩu đã được cập nhật!");
            break;
        default:
            System.out.println("Lựa chọn không hợp lệ!");
    }
}

}
