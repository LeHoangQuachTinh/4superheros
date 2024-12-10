
package BT;
import java.util.Scanner;

import BT.NganHang.TaiKhoan;
import BT.NganHang.TaiKhoanThanhToan;
import static BT.IListAccount.DS;

abstract class Account {
    protected String idUser;
    protected String username;
    private String password;
    protected String SDT;
    protected String diachi;
    protected String STK;
    protected boolean isLocked;

    Scanner sc = new Scanner(System.in);

    public Account(String idUser, String username, String password, String SDT, String diachi, String STK) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.SDT = SDT;
        this.STK = STK;
        this.diachi = diachi;
        this.isLocked = false;
    }

    public Account(String idUser, String username, String password, String SDT, String diachi) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.SDT = SDT;
        this.diachi = diachi;
        this.isLocked = false;
    }

    public boolean isIsLocked() {
        return isLocked;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean kTPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }

    public boolean login(String idUser, String password) {
        return this.idUser.equals(idUser) && this.password.equals(password);
    }

    public void changePassword() {
        int dem = 0;
        while (dem < 5) {
            System.out.println("Nhập mật khẩu hiện tại: ");
            String oldPass = sc.nextLine();
            if (this.password.equals(oldPass)) {
                System.out.println("Mật khẩu cũ chính xác");
                // Xác nhận mật khẩu mới

                while (true) {
                    System.out.println("Nhập mật khẩu mới: ");
                    String newPass = sc.nextLine();

                    if (newPass.length() < 5 || kiemTraMatKhauManh(newPass)) { // phải có ký tự đặc biệt
                        System.out.println(
                                "Mật khẩu không hợp lệ. Mật khẩu mới phải chứa ít nhất 5 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt. Vui lòng nhập lại.");
                        continue;
                    }
                    while (true) {
                        System.out.println("Xác nhận lại mật khẩu mới: ");
                        String confirmPass = sc.nextLine();

                        if (newPass.equals(confirmPass)) {
                            this.password = newPass;
                            System.out.println("Đổi mật khẩu thành công");
                            return;
                        } else
                            System.out.println(
                                    "Mật khẩu xác nhận không trùng khớp với mật khẩu vừa thiết lập. Đổi mật khẩu thất bại");
                    }
                }

            } else {
                dem++;
                System.out.println("Mật khẩu cũ không chính xác. Số lần thử còn lại: " + (5 - dem));
                if (dem > 5) {
                    System.out.println("Bạn đã nhập sai mật khẩu cũ quá nhiều lần. Đổi mật khẩu cũ không thành công");
                    return;
                }
            }
        }
    }

    public void in() {
        System.out.println("---------------------------------------------");
        System.out.println("Thông tin tài khoản:");
        System.out.println("ID người dùng: " + idUser);
        System.out.println("Tên người dùng: " + username);
        System.out.println("Số điện thoại: " + SDT);
        System.out.println("Địa chỉ: " + diachi);
        System.out.println("---------------------------------------------");
    }

    public String toFileFormat() {
        String info = "";
        info += "\nMã tài khoản:" + idUser + "\nTên tài khoản:" + username + "\nMật khẩu:" + password + "\nSĐT:" + SDT;
        return info;
    }

    public TaiKhoanThanhToan getTaiKhoanThanhToan() {
        TaiKhoan tk = DS.searchAcount(STK);
        TaiKhoanThanhToan tktt = (TaiKhoanThanhToan) (tk);
        return tktt;
    }

    public void lockAccount() {
        this.isLocked = true;
        System.out.println("Tài khoản đã được khóa!");
    }

    public void openAccount() {
        this.isLocked = false;
        System.out.println("Tài khoản đã được mở khoá.Có thể dùng bình thường trở lại!");
    }

    public boolean kiemTraMatKhauManh(String password) {
        return password.length() >= 5 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    
    
    abstract void updateProfile();

    abstract void showInfo();

}
