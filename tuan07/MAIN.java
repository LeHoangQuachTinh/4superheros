package NGANHANG;

import java.util.Scanner;

public class MAIN {
      public static void main(String[] args) {
        DANHSACHTAIKHOAN listTK = new DANHSACHTAIKHOAN();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Nhap lua chon cua ban: ");
            System.out.println("""
                               1. Them tai khoan
                               2. Gui tien
                               3. Rut tien
                               4. Kiem tra so du
                               5. Doi mat khau
                               6. In danh sach tai khoan""");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Ban da chon phuong thuc them tai khoan.");
                    TAIKHOAN tk = new TAIKHOAN();
                    System.out.println("Nhap thong tin tai khoan!");
                    tk.nhapTK();
                    listTK.themTK(tk);
                    break;
                case 2:
                    System.out.println("Ban da chon phuong thuc gui tien!");
                    System.out.println("Nhap so tai khoan: ");
                    String soTaiKhoan = sc.nextLine();
                    TAIKHOAN tkGuiTien = listTK.timTaiKhoan(soTaiKhoan);
                    if(tkGuiTien != null)
                    {
                        System.out.println("Tai khoan: "+tkGuiTien.getChuTaiKhoan());
                        tkGuiTien.guiTien();
                    }
                    else
                        System.out.println("Khong tim thay so tai khoan!");
                    break;
                case 3:
                    System.out.println("Ban da chon phuong thuc rut tien!");
                    System.out.println("Nhap so tai khoan: ");
                    String soTK = sc.nextLine();
                    TAIKHOAN tkRutTien = listTK.timTaiKhoan(soTK);
                    if(tkRutTien != null)
                    {
                        System.out.println("Tai khoan: "+tkRutTien.getChuTaiKhoan());
                        tkRutTien.rutTien();
                    }
                    else
                        System.out.println("Khong tim thay so tai khoan");
                    break;
                case 4:
                    System.out.println("Ban da chon phuong thuc kiem tra so du!");
                    System.out.println("Nhap so tai khoan: ");
                    String soTaiKhoanKiemTra = sc.nextLine();
                    TAIKHOAN tkKiemTra = listTK.timTaiKhoan(soTaiKhoanKiemTra);
                    if(tkKiemTra != null)
                    {
                        System.out.println("Tai khoan: "+tkKiemTra.getChuTaiKhoan());
                        tkKiemTra.kiemTra();
                    }
                    else
                        System.out.println("Khong tim thay so tai khoan");
                    break;  
                case 5:
                    System.out.println("Ban da chon phuong thuc doi mat khau!");
                    System.out.println("Nhap so tai khoan: ");
                    String soTaiKhoanDoiMK = sc.nextLine();
                    TAIKHOAN tkDoiMK = listTK.timTaiKhoan(soTaiKhoanDoiMK);
                    if(tkDoiMK != null)
                    {
                        System.out.println("Tai khoan: "+tkDoiMK.getChuTaiKhoan());
                        tkDoiMK.doiMatKhau();
                    }
                    else{
                        System.out.println("Khong tim thay so tai khoan");
                    }
                    break;  
                case 6:
                    System.out.println("In danh sach tai khoan:");
                    listTK.inDanhSach();
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        }while(choice != 0);
    }
}
