package BT;

import java.util.HashMap;
import java.util.Random;

import java.util.stream.Collectors;

import BT.NganHang.TaiKhoan;

public class ListCustomer implements IListAccount {
    private HashMap<String, Customer> listCustomer;

    ListCustomer() {
        this.listCustomer = new HashMap<>();
    }

    public HashMap<String, Customer> getListCustomer() {
        return listCustomer;
    }

    @Override
    public void forgotPassWord() {
        System.out.println("Nhập mã khách hàng đã đăng kí:");
        String maKH = sc.nextLine();

        Customer customer = listCustomer.get(maKH);
        if (customer != null) {
            // Tạo mã OTP
            Random rand = new Random();
            int otp = 100000 + rand.nextInt(999999);
            System.out.println("Mã OTP của bạn là: " + otp);

            // Nhập OTP xác nhận
            System.out.println("Vui lòng nhập mã OTP để xác nhận");
            int otpNhap = sc.nextInt();

            if (otpNhap == otp) {
                System.out.println("Mã OTP chính xác!");
                sc.nextLine();

                // Đổi mật khẩu
                System.out.println("Nhập mật khẩu mới: ");
                String newPassword = sc.nextLine();
                // this.password = newPassword;
                customer.setPassword(newPassword);
                System.out.println("Mật khẩu của bạn đã được thay đổi thành công!");
            } else
                System.out.println("Mã OTP không chính xác! Vui lòng thử lại.");
        } else
            System.out.println("Không tìm thấy tài khoản!\n");
    }

    @Override
    public boolean login(String id, String password) {
        Customer khachHang = listCustomer.get(id);

        if (khachHang != null && khachHang.kTPassword(password))
            return true;
        return false;
    }

    @Override
    public void registerAccount() {
        String idUser;
        int dem = 1;
        do {
            System.out.print("Nhập IdUser( ):");
            idUser = sc.nextLine();
            if (listCustomer.containsKey(idUser)) {
                System.out.println("Mã code đã tồn tại trong hệ thống!Nhập lại!");
            }
        } 
        while (listCustomer.containsKey(idUser));
        System.out.print("Nhập username:");
        String username = sc.nextLine();
        String SDT;
        do{
            System.out.print("Nhập số điện thoại đăng kí(10||11 số):");
             SDT= sc.nextLine();
             if(!kiemTraSDT(SDT))
                 System.out.println("Số điện thoại không hợp lệ!Nhập lại!");
        }
        while(!kiemTraSDT(SDT));

        System.out.print("Nhập địa chỉ:");
        String diachi = sc.nextLine();

        Random random = new Random();
        String soOTP = random.ints(6, 0, 9)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        
        System.out.println("Mã otp của bạn là:" + soOTP);
        String otp;
        do {
            System.out.print("Nhập mã otp:");
            otp = sc.nextLine();
            if (!otp.equals(soOTP))
                System.out.println("Số otp không khớp!Vui lòng nhập lại!");
        } while (!otp.equals(soOTP));
        String password;
        do {
            System.out.printf("Tạo mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự) lần %d/5:", dem);
            password = sc.nextLine();
            dem++;
        } 
        while (!kiemTraMatKhauManh(password) && dem <= 5);
        if (kiemTraMatKhauManh(password)) {
            Customer tkCustomer = new Customer(idUser, username, password, SDT, diachi);
            listCustomer.put(idUser, tkCustomer);
            System.out.printf("Đã đăng kí tài khoản khách hàng Customer(%s,%s,%s) thành công!\n", idUser, username,
                    password);
        } else
            System.out.println("Đăng kí không thành công!\n");

    }

    public Customer search(String maCustomer) {
        return listCustomer.get(maCustomer);
    }

    // Ràng buộc mật khẩu
    public boolean kiemTraMatKhauManh(String matkhau) {
        if (matkhau.length() >= 5
                && matkhau.matches(".*[A-Z].*")
                && matkhau.matches(".*[a-z].*")
                && matkhau.matches(".*\\d.*")
                && matkhau.matches(".*[!@#$%^&*()].*"))
            return true;
        return false;
    }
    
    //ràng buộc số điện thoại
    public boolean kiemTraSDT(String sdt){
        if((sdt.length()==10||sdt.length()==11)&&sdt.matches("\\d+"))
            return true;
        return false;
    }
    

    @Override
    public void deleteAccount() {
        System.out.print("Nhập mã tài khoản người dùng cần xoá:");
        String maTK = sc.nextLine();
        if (this.listCustomer.containsKey(maTK)) {
            listCustomer.remove(maTK);
            System.out.println("\nXoá thành công !\n");
        } else
            System.out.println("\nTài khoản ngừoi dùng không tồn tại.Không thể xoá\n");

    }

    public void lienKetNganHang(Customer nguoiDung) {
        if (nguoiDung.STK != null) {
            System.out.printf("\nBạn đã liên kết tài khoản ngân hàng trước đó.Số tài khoản của bạn là:%s\n",
                    nguoiDung.STK);
            System.out.print("Bạn có muốn đổi số tài khoản khác không YES(1) NO(0):");
            String lc = sc.nextLine();

            if (lc.equalsIgnoreCase("1")) {
                System.out.print("Nhập số tài khoản mới:");
                String stkMoi = sc.nextLine();
                TaiKhoan tk = DS.searchAcount(stkMoi);
                if (tk != null) {
                    System.out.print("Nhập mật khẩu ngân hàng để liên kết:");
                    String matkhau = sc.nextLine();

                    if (tk.kiemtraMatKhau(matkhau)) {
                        nguoiDung.STK = stkMoi;
                        System.out.printf("Liên kết tài khoản (%s - %s) thành công!", tk.getStk(), tk.getChutk());
                    } else
                        System.out.println("\nMật khẩu không chính xác.Thử lại sau!");
                } else
                    System.out.println("\nTài khoản ngân hàng không tồn tại.Thử lại sau!");
            } else
                return;
        } else {
            System.out.print("Nhập số tài khoản muốn liên kết:");
            String stkMoi = sc.nextLine();
            TaiKhoan tk = DS.searchAcount(stkMoi);
            if (tk != null) {
                System.out.print("Nhập mật khẩu ngân hàng để liên kết:");
                String matkhau = sc.nextLine();

                if (tk.kiemtraMatKhau(matkhau)) {
                    nguoiDung.STK = stkMoi;
                    System.out.printf("Liê kết tài khoản (%s - %s) thành công!", tk.getStk(), tk.getChutk());
                } else
                    System.out.println("\nMật khẩu không chính xác.Thử lại sau!");
            } else
                System.out.println("\nTài khoản ngân hàng không tồn tại.Thử lại sau!");
        }
    }
}
