/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nganhangtruutuong.dahinh;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author 123
 */
public class QuanLyTaiKhoan 
{
    private static ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) 
        {
            System.out.println("Chon chuc nang:");
            System.out.println("1. Tao tai khoan");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    taoTaiKhoan(scanner);
                    break;
                case 2:
                    dangNhap(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
        scanner.close();
    }

    private static void taoTaiKhoan(Scanner scanner) 
    {
        System.out.println("Nhap loai tai khoan (1: Tiet Kiem, 2: Thanh Toan):");
        int loaiTaiKhoan = scanner.nextInt();
        System.out.println("Nhap so tai khoan:");
        String soTaiKhoan = scanner.next();
        System.out.println("Nhap chu tai khoan:");
        String chuTaiKhoan = scanner.next();
        System.out.println("Nhap so du:");
        double soDu = scanner.nextDouble();
        System.out.println("Nhap mat khau:");
        String matKhau = scanner.next();

        TaiKhoan taiKhoan;
        if (loaiTaiKhoan == 1) 
        {
            System.out.println("Nhap lai suat:");
            double laiSuat = scanner.nextDouble();
            taiKhoan = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, soDu, matKhau, laiSuat);
        } 
        else 
        {
            System.out.println("Nhap han muc thau chi:");
            double hanMucThauChi = scanner.nextDouble();
            taiKhoan = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, soDu, matKhau, hanMucThauChi);
        }

        danhSachTaiKhoan.add(taiKhoan);
        System.out.println("Tao tai khoan thanh cong.");
    }

    private static void dangNhap(Scanner scanner) 
    {
        System.out.println("Nhap so tai khoan:");
        String soTaiKhoan = scanner.next();
        System.out.println("Nhap mat khau:");
        String matKhau = scanner.next();

        for (TaiKhoan taiKhoan : danhSachTaiKhoan) 
        {
            if (taiKhoan.getSoTaiKhoan().equals(soTaiKhoan) && taiKhoan.getMatKhau().equals(matKhau)) 
            {
                System.out.println("Dang nhap thanh cong.");
                chucNangTaiKhoan(scanner, taiKhoan);
                return;
            }
        }
        System.out.println("So tai khoan hoac mat khau khong dung.");
    }

    private static void chucNangTaiKhoan(Scanner scanner, TaiKhoan taiKhoan) 
    {
        boolean loggedIn = true;

        while (loggedIn) 
        {
            System.out.println("Chon chuc nang:");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("4. Doi mat khau");
            if (taiKhoan instanceof TaiKhoanTietKiem) 
            {
                System.out.println("5. Tinh lai");
            } 
            else 
                if (taiKhoan instanceof TaiKhoanThanhToan) 
                {
                System.out.println("5. Thanh toan hoa don");
                }
            System.out.println("6. Dang xuat");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Nhap so tien can gui:");
                    double soTienGui = scanner.nextDouble();
                    taiKhoan.guiTien(soTienGui);
                    break;
                case 2:
                    System.out.println("Nhap so tien can rut:");
                    double soTienRut = scanner.nextDouble();
                    taiKhoan.rutTien(soTienRut);
                    break;
                case 3:
                    taiKhoan.kiemTraSoDu();
                    break;
                case 4:
                    System.out.println("Nhap mat khau cu:");
                    String matKhauCu = scanner.next();
                    System.out.println("Nhap mat khau moi:");
                    String matKhauMoi = scanner.next();
                    taiKhoan.doiMatKhau(matKhauCu, matKhauMoi);
                    break;
                case 5:
                    if (taiKhoan instanceof TaiKhoanTietKiem) 
                    {
                        ((TaiKhoanTietKiem) taiKhoan).tinhLai();
                    } 
                    else 
                        if (taiKhoan instanceof TaiKhoanThanhToan) 
                        {
                                System.out.println("Nhap so tien can thanh toan:");
                        double soTienThanhToan = scanner.nextDouble();
                        ((TaiKhoanThanhToan) taiKhoan).thanhToanHoaDon(soTienThanhToan);
                    }
                    break;
                case 6:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}

                    
