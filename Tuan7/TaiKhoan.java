package vidutuan7;

import java.util.ArrayList;
import java.util.Scanner;

public class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;
    private int slSai;  // Số lần nhập sai mật khẩu
    private boolean biKhoa;  // Tài khoản bị khóa
    private ArrayList<String> lichSuGD;  // Lịch sử giao dịch
    
    // Constructor
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) 
    {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
        this.slSai = 0;
        this.biKhoa = false;
        this.lichSuGD = new ArrayList<>();
    }
    
    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            lichSuGD.add("Gui tien: +" + soTien + " VND");
            System.out.println("Gui tien thanh cong. So du moi la: " + soDu);
        } else {
            System.out.println("So tien gui khong hop le.");
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            lichSuGD.add("Rut tien: -" + soTien + " VND");
            System.out.println("Rut tien thanh cong. So du moi la: " + soDu);
        } else {
            System.out.println("So tien rut khong hop le hoac vuot qua so du.");
        }
    }
  
    public void kiemTraSoDu() {
        System.out.println("So du hien tai la: " + soDu + " VND");
    }
  
    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (biKhoa) {
            System.out.println("Tai khoan bi khoa do nhap sai mat khau qua nhieu lan.");
            return;
        }
        
        if (this.matKhau.equals(matKhauCu)) {
            if (matKhauMoi.length() < 8) {
                System.out.println("Mat khau moi phai co it nhat 8 ky tu .");
            } else {
                this.matKhau = matKhauMoi;
                slSai = 0; // Đặt lại số lần sai
                System.out.println("Doi mat khau thanh cong!");
            }
        } else {
            slSai++;
            if (slSai >= 3) {
                biKhoa = true;
                System.out.println("Tai khoan bi khoa do nhap sai mat khau qua 3 lan.");
            } else {
                System.out.println("Mat khau cu khong dung! Con " + (3 - slSai) + " lan thu.");
            }
        }
    }

    public void xemLichSuGiaoDich() {
        if (lichSuGD.isEmpty()) {
            System.out.println("Khong co giao dich nao.");
        } else {
            System.out.println("Lich su giao dich:");
            for (String giaoDich : lichSuGD) {
                System.out.println(giaoDich);
            }
        }
    }

    public void tinhLai(double laiSuat) {
                double lai = soDu * (laiSuat / 100);
        soDu += lai;
        lichSuGD.add("Tinh lai: +" + lai + " VND (Lai suat: " + laiSuat + "%)");
        System.out.println("Lai da duoc tinh. So su moi la: " + soDu);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaiKhoan taiKhoan = new TaiKhoan("123456", "Nguyen Ho Minh Quan", 5000000, "12345678");

        int luaChon;
        do {
            System.out.println("--------- MENU ---------");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("4. Doi mat khau");
            System.out.println("5. Xem lich su giao dich");
            System.out.println("6. Tinh lai");
            System.out.println("7. Thoat");
            System.out.print("Moi chon chuc nang: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap so tien can gui: ");
                    double soTienGui = scanner.nextDouble();
                    taiKhoan.guiTien(soTienGui);
                    break;
                case 2:
                    System.out.print("Nhap so tien can rut: ");
                    double soTienRut = scanner.nextDouble();
                    taiKhoan.rutTien(soTienRut);
                    break;
                case 3:
                    taiKhoan.kiemTraSoDu();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Nhap mat khau cu: ");
                    String matKhauCu = scanner.nextLine();
                    System.out.print("Nhap mat khau moi: ");
                    String matKhauMoi = scanner.nextLine();
                    taiKhoan.doiMatKhau(matKhauCu, matKhauMoi);
                    break;
                case 5:
                    taiKhoan.xemLichSuGiaoDich();
                    break;
                case 6:
                    System.out.print("Nhap lai suat (%): ");
                    double laiSuat = scanner.nextDouble();
                    taiKhoan.tinhLai(laiSuat);
                    break;
                case 7:
                    System.out.println("Ket thuc!.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai!");
                    break;
            }
            System.out.println();
        } while (luaChon != 7);

        scanner.close();
    }
}

