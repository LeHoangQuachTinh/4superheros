package NHOM;

import java.security.SecureRandom;
import java.util.Scanner;

public abstract class Account implements IAccount {
    protected String code;
    protected String username;
    protected String password;
    protected String SDT;
    protected String diachi;

    public Account() {
    }

    public Account(String code,String username, String password, String SDT,String diachi) {
        this.username = username;
        this.password = password;
        this.SDT = SDT;
        this.diachi=diachi;
    }
    
    //tạo hàm random số otp
    public String random(int so){
        SecureRandom random=new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for(int i=0;i<so;i++){
            int soOTP = random.nextInt(10);
            otp.append(soOTP);
        }
        return otp.toString();
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

    //Nhập thông tin người đăng kí
    @Override
    public void register(Scanner scanner, DSTaiKhoan dstk){
        do{
            System.out.print("Nhập code:");
            this.code=scanner.nextLine();
            if(dstk.kiemTraTonTai(code)!=null){
                System.out.println("Mã code đã tồn tại trong hệ thống!Nhập lại!");
            }
        }
        while(dstk.kiemTraTonTai(code)!=null);
        System.out.print("Nhập username:");
        this.username=scanner.nextLine();
        System.out.print("Nhập số điện thoại đăng kí:");
        this.SDT=scanner.nextLine();
        String soOTP=random(6);
        System.out.println("Mã otp của bạn là:"+soOTP);
        String otp ;
        do{
            System.out.print("Nhập mã otp:");
            otp=scanner.nextLine();
            if(!otp.equals(soOTP))
                System.out.println("Số otp không khớp!Vui lòng nhập lại!");
        }
        while(!otp.equals(soOTP));
        do{
            System.out.print("Tạo mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự):");
            this.password=scanner.nextLine();
            if(!kiemTraMatKhauManh(this.password))
                System.out.println("Mật khẩu không hợp lệ!");
        }
        while(!kiemTraMatKhauManh(this.password));
        System.out.print("Nhập địa chỉ:");
        this.diachi=scanner.nextLine();
    }
    
    //in thông tin người dùng
    public void in(){
        System.out.println("Mã code:"+this.code);
        System.out.println("User name:"+this.username);
        System.out.println("Password"+this.password);
        System.out.println("Số điện thoại:"+this.SDT);
        System.out.println("Địa chỉ:"+this.diachi);
    }

    //Đăng nhập tài khoản
    @Override
    public boolean login(Scanner scanner ,DSTaiKhoan dstk) {
        System.out.print("Nhập mã code:");
        String codeString=scanner.nextLine();
        System.out.print("Nhập mật khẩu:");
        String matKhau =scanner.nextLine();
        Account tk=dstk.kiemTraTonTai(codeString);
        if(tk!=null&&tk.password.equals(matKhau)&&tk.code.equals(code)){
            System.out.println("Đăng nhập thành công!");
            return true;
        }     
        return false;
    }

    //Đặt lại mật khẩu
    @Override
    public void resetPassword(Scanner scanner) {
        System.out.println("Resetting password for " + username);
        System.out.print("Nhập số điện thoại của bạn: ");
        String sdtNhap = scanner.nextLine();
        if (!sdtNhap.equals(this.SDT)) {
            System.out.println("Số điện thoại không khớp với tài khoản! Không thể đặt lại mật khẩu.");
            return;
        }
        String otp = random(6);
        System.out.println("Mã OTP để đặt lại mật khẩu là: " + otp);
        String OtpstrString;
        do {
            System.out.print("Nhập mã OTP: ");
            OtpstrString = scanner.nextLine();
            if (!OtpstrString.equals(otp)) 
                System.out.println("Mã OTP không đúng! Vui lòng thử lại.");
        } 
        while (!OtpstrString.equals(otp));
        String pasString;
        do {
            System.out.print("Nhập mật khẩu mới: ");
            pasString = scanner.nextLine();
            if (!kiemTraMatKhauManh(pasString))
                System.out.println("Mật khẩu không hợp lệ! Phải bao gồm [A-Z], [a-z], [0-9] và ký tự đặc biệt.");
        } 
        while (!kiemTraMatKhauManh(pasString));
        this.password = pasString;
        System.out.println("Mật khẩu đã được đặt lại thành công!");
    }
    
    
}

