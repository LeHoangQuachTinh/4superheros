package nganhang;

import java.util.ArrayList;
import java.util.Scanner;
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
            System.out.println("3. Xoa tai khoan");
            System.out.println("4. Chuyen tien");
            System.out.println("5. Xem lich su giao dich");
            System.out.println("6. Thoat");
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
                    xoaTaiKhoan(scanner);
                    break;
                case 4:
                    chuyenTien(scanner);
                    break;
                case 5:
                    xemLichSuGiaoDich();
                    break;
                case 6:
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
        try {
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
        } catch (Exception e) 
        {
            System.out.println("Loi khi tao tai khoan: " + e.getMessage());
        }
    }

    private static void dangNhap(Scanner scanner) 
    {
        try {
            System.out.println("Nhap so tai khoan:");
            String soTaiKhoan = scanner.next();
            System.out.println("Nhap mat khau:");
            String matKhau = scanner.next();

            for (TaiKhoan taiKhoan : danhSachTaiKhoan) 
            {
                if (taiKhoan.getSoTaiKhoan().equals(soTaiKhoan) && taiKhoan.getMatKhau().equals(matKhau)) {
                    System.out.println("Dang nhap thanh cong.");
                    chucNangTaiKhoan(scanner, taiKhoan);
                    return;
                }
            }
            System.out.println("So tai khoan hoac mat khau khong dung.");
        } catch (Exception e) 
        {
            System.out.println("Loi khi dang nhap: " + e.getMessage());
        }
    }

    private static void chucNangTaiKhoan(Scanner scanner, TaiKhoan taiKhoan) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("Chon chuc nang:");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Kiem tra so du");
            System.out.println("4. Doi mat khau");
            System.out.println("5. Xem lich su giao dich");
            System.out.println("6. Thoat");

            int choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Nhap so tien gui:");
                    double soTienGui = scanner.nextDouble();
                    taiKhoan.guiTien(soTienGui);
                    break;
                case 2:
                    System.out.println("Nhap so tien rut:");
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
                    taiKhoan.xemLichSuGiaoDich();
                    break;
                case 6:
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    private static void xoaTaiKhoan(Scanner scanner) 
    {
        System.out.println("Nhap so tai khoan can xoa:");
        String soTaiKhoan = scanner.next();
        danhSachTaiKhoan.removeIf(taiKhoan -> taiKhoan.getSoTaiKhoan().equals(soTaiKhoan));
        System.out.println("Xoa tai khoan thanh cong.");
    }

    private static void chuyenTien(Scanner scanner) 
    {
        System.out.println("Nhap so tai khoan gui:");
        String soTaiKhoanGui = scanner.next();
        System.out.println("Nhap so tai khoan nhan:");
        String soTaiKhoanNhan = scanner.next();
        System.out.println("Nhap so tien chuyen:");
        double soTienChuyen = scanner.nextDouble();

        TaiKhoan taiKhoanGui = null, taiKhoanNhan = null;
        for (TaiKhoan taiKhoan : danhSachTaiKhoan) 
        {
            if (taiKhoan.getSoTaiKhoan().equals(soTaiKhoanGui)) taiKhoanGui = taiKhoan;
            if (taiKhoan.getSoTaiKhoan().equals(soTaiKhoanNhan)) taiKhoanNhan = taiKhoan;
        }

        if (taiKhoanGui != null && taiKhoanNhan != null) 
        {
            taiKhoanGui.rutTien(soTienChuyen);
            taiKhoanNhan.guiTien(soTienChuyen);
            System.out.println("Chuyen tien thanh cong.");
        } 
        else 
            System.out.println("So tai khoan gui hoac nhan khong dung.");
    }

    private static void xemLichSuGiaoDich() 
    {
        for (TaiKhoan taiKhoan : danhSachTaiKhoan)
        {
            System.out.println("Lich su giao dich cua tai khoan: " + taiKhoan.getSoTaiKhoan());
            taiKhoan.xemLichSuGiaoDich();
        }
    }
}