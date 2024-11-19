package NHOM;

import java.util.Random;
import java.util.Scanner;

abstract class Account {
    protected String idUser;
    protected String username;
    protected String password;
    protected String SDT;
    protected String diachi;
    protected boolean isLocked;


    Scanner sc = new Scanner(System.in);
    public Account(String idUser,String username, String password, String SDT,String diachi) {
        this.idUser=idUser;
        this.username = username;
        this.password = password;
        this.SDT = SDT;
        this.diachi=diachi;
        this.isLocked=false;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public String getSDT() {
        return SDT;
    }


    public void setSDT(String sDT) {
        SDT = sDT;
    }


    public String getDiachi() {
        return diachi;
    }


    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean login(String idUser, String password){
        return this.idUser.equals(idUser) && this.password.equals(password);
    }

    public void changePassword() {
        int dem = 0;
        while(dem < 5){
            System.out.println("Nhập mật khẩu hiện tại: ");
            String oldPass = sc.nextLine();
            if(this.password.equals(oldPass)){
                System.out.println("Mật khẩu cũ chính xác");
                //Xác nhận mật khẩu mới
                System.out.println("Nhập mật khẩu mới: ");
                String newPass = sc.nextLine();
                while(true){
                    System.out.println("Xác nhận lại mật khẩu mới: ");
                    String confirmPass = sc.nextLine();
    
                    if(newPass.equals(confirmPass)){
                        this.password=newPass;
                        System.out.println("Đổi mật khẩu thành công");
                        return;
                    }
                    else
                        System.out.println("Mật khẩu xác nhận không trùng khớp với mật khẩu vừa thiết lập. Đổi mật khẩu thất ba");
                }
            }
            else{
                dem++;
                System.out.println("Mật khẩu cũ không chính xác. Số lần thử còn lại: "+(5-dem));
                if(dem > 5){
                    System.out.println("Bạn đã nhập sai mật khẩu cũ quá nhiều lần. Đổi mật khẩu cũ không thành công");
                    return;
                }  
            }
        }
    }

    public void quenMatKhau(){
        System.out.println("Nhập số điện thoại đã đăng kí với tài khoản của bạn: ");
        String sdtNhap = sc.nextLine();
        if(!sdtNhap.equals(SDT)){
            System.out.println("Không tìm thấy số điện thoại!");
            return;
        }

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
            this.password = newPassword;
            System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
        }
        else
            System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");
    }
    abstract void lockAccount();

    public void in() {
        System.out.println("---------------------------------------------");
        System.out.println("Thông tin tài khoản:");
        System.out.println("ID người dùng: " + idUser);
        System.out.println("Tên người dùng: " + username);
        System.out.println("Số điện thoại: " + SDT);
        System.out.println("Địa chỉ: " + diachi);
        System.out.println("---------------------------------------------");
    }
}

