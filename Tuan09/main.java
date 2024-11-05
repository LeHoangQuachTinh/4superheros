package nganhang;

import java.util.List;
import java.util.Scanner;

public class main {
    
    public static boolean kiemTraMatKhauHopLe(String matkhau) 
    {
        if (matkhau.length() < 5) 
            return false;
        if (!matkhau.matches(".*[A-Z].*")) 
            return false;
        if (!matkhau.matches(".*[a-z].*")) 
            return false;
        if (!matkhau.matches(".*\\d.*")) 
            return false;
        if (!matkhau.matches(".*[!@#$%^&*()].*")) 
            return false;
        return true;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        DSTaiKhoang DS = new DSTaiKhoang();
        
        String stk;
        String tentk;
        String matkhau;
        String maKhoiPhuc;
        int dem;
        while (true) 
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Ban chon lam gi");
            System.out.println("1.Dang ki tai khoan");
            System.out.println("2.Xuat danh sach thong tin tai khoan");
            System.out.println("3.Dang nhap tai khoan");
            System.out.println("4.Quen mat khau");
            System.out.println("0.Thoat chuong trinh");

            System.out.print("Nhap su lua chon: ");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) 
            {
                case 1:
                    System.out.println("Ban muon dang ki loai tai khoan nao?");
                    System.out.println("1. Tai khoan tiet kiem");
                    System.out.println("2. Tai khoan thanh toan");
                    System.out.print("Nhap su lua chon: ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    if (type == 1) 
                    {
                        System.out.println("Tao so tai khoan tiet kiem: ");
                        stk = sc.nextLine();
                        System.out.println("Nhap ten tai khoan: ");
                        tentk = sc.nextLine();
                        System.out.print("Tao mat khau cho tai khoan (Mat khau phai chua ki tu Hoa, Thuong, So va du 5 ki tu): ");
                        matkhau = sc.nextLine();

                        dem = 1;
                        if (!DS.kiemTraTrung(stk, tentk)) 
                        {
                            if (!kiemTraMatKhauHopLe(matkhau)) 
                            
                            {
                                while (dem <= 5 && !kiemTraMatKhauHopLe(matkhau)) 
                                {
                                    System.out.println("Mat khau cua ban khong thoa man yeu cau. Mat khau phai chua it nhat ki tu hoa, thuong va du 5 ki tu!");
                                    System.out.printf("Tao mat khau lan %d/5:", dem);
                                    matkhau = sc.nextLine();
                                    if (kiemTraMatKhauHopLe(matkhau)) 
                                    {
                                        System.out.print("Tao ma khoi phuc");
                                        maKhoiPhuc = sc.nextLine();
                                        System.out.print("Nhap lai suat: ");
                                        double laiSuat = sc.nextDouble();
                                        System.out.print("Nhap ki han (thang): ");
                                        int kiHan = sc.nextInt();
                                        //Tạo tài khoản tiết kiệm
                                        TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(stk, tentk, matkhau, maKhoiPhuc, laiSuat, kiHan);
                                        DS.addAcount(taiKhoanTietKiem);
                                        System.out.printf("Tai khoan vua moi them la: Account(stk: %s, tentk: %s, matkhau: %s, sodu: 50000₫, lai suat: %.2f%%)\\n", stk, tentk, matkhau, laiSuat);
                                        break;
                                    } 
                                    else
                                        dem++;
                                }
                                if (dem > 5)
                                    System.out.println("Ban da tao sai mat khau qua nhieu. Tao tai khoan khong thanh cong!");
                            } 
                            else 
                            {
                                System.out.print("Tao ma khoi phuc: ");
                                maKhoiPhuc = sc.nextLine();
                                System.out.print("Nhap lai suat (nhap duoi dang so phan tram, vi du: 5 cho 5%):");
                                double laiSuat = sc.nextDouble();
                                System.out.print("Nhap ky han: ");
                                int kiHan = sc.nextInt();
                                TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(stk, tentk, matkhau, maKhoiPhuc, laiSuat, kiHan);
                                DS.addAcount(taiKhoanTietKiem);
                                System.out.println("Dang ky tai khoan thanh cong!");
                                System.out.printf("Tai khoan vua moi them la: Account(stk: %s, tentk: %s, matkhau: %s, sodu: 50000₫)\n", stk, tentk, matkhau);
                            }
                        } 
                        else
                            System.out.println("So tai khoan hoac ten tai khoan da ton tai. Vui long nhap lai!");
                    }
                    // Đăng ký tài khoản thanh toán
                    else if (type == 2) 
                    {
                        System.out.println("Tao so tai khoan thanh toan: ");
                        stk = sc.nextLine();
                        System.out.println("Tao ten tai khoan thanh toan:");
                        tentk = sc.nextLine();
                        System.out.print("Tao mat khau cho tai khoan (Mat khau phai chua ki tu Hoa, Thuong, So va du 5 ki tu): ");
                        matkhau = sc.nextLine();

                        dem = 1;
                        if (!DS.kiemTraTrung(stk, tentk)) 
                        {
                            if (!kiemTraMatKhauHopLe(matkhau)) 
                            {
                                while (dem <= 5 && !kiemTraMatKhauHopLe(matkhau)) 
                                {
                                    System.out.println("Mat khau cua ban khong thoa man yeu cau. Mat khau phai chua it nhat ki tu hoa, thuong va du 5 ki tu!");
                                    System.out.printf("Tao lai mat khau lan thu %d/5: ", dem);
                                    matkhau = sc.nextLine();
                                    if (kiemTraMatKhauHopLe(matkhau)) 
                                    {
                                        System.out.print("Tao ma khoi phuc: ");
                                        maKhoiPhuc = sc.nextLine();
                                        System.out.print("Nhap phi duy tri: ");
                                        double phiDuyTri = sc.nextDouble();
                                        TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(stk, tentk, matkhau, maKhoiPhuc, phiDuyTri);
                                        DS.addAcount(taiKhoanThanhToan);
                                        System.out.println("Dang ki tai khoan thanh cong!");
                                        System.out.printf("Tai khoan vua moi them la: Account(stk: %s, tentk: %s, matkhau: %s, sodu: 50000₫)\n", stk, tentk, matkhau);
                                    }
                                }
                            }
                            else
                            {
                                System.out.print("Tao ma khoi phuc: ");
                                maKhoiPhuc = sc.nextLine();
                                System.out.print("Nhap phi duy tri: ");
                                double phiDuyTri = sc.nextDouble();
                                TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(stk, tentk, matkhau, maKhoiPhuc, phiDuyTri);
                                DS.addAcount(taiKhoanThanhToan);
                                System.out.println("Dang ki tai khoan thanh cong!");
                                System.out.printf("Tai khoan vua moi them la: Account(stk: %s, tentk: %s, matkhau: %s, sodu: 50000₫)\n", stk, tentk, matkhau);
                            }
                        }
                        else
                            System.out.println("So tai khoan hoac ten tai khoan da ton tai. Vui long nhap lai!");
                    }
                break;
                case 2: 
                {
                    int choice;
                    do {
                        System.out.println("Ban muon in danh sach tai khoan gi?");
                        System.out.println("""
                            1. In danh sach tai khoan tiet kiem
                            2. In danh sach tai khoan thanh toan
                            3. In tat ca danh sach tai khoan
                            0. Thoat chuong trinh""");
                        System.out.println("Nhap lua chon cua ban: ");
                        choice = sc.nextInt();
                        switch (choice) 
                        {
                            case 1:
                                System.out.println("In danh sach cac tai khoan tiet kiem");
                                System.out.println("======================================");
                                DS.showTietKiemAccounts();
                            break;
                            case 2:
                                System.out.println("In danh sach cac tai Khoan thanh toan");
                                System.out.println("======================================");
                                DS.showThanhToanAccounts();
                            break;
                            case 3:
                                System.out.println("Tat ca danh sach tai khoan");
                                System.out.println("=============");
                                System.out.println("Danh sach tai khoan tiet kiem:");
                                System.out.println("=============");
                                DS.showTietKiemAccounts();
                                System.out.println("===============================");
                                System.out.println("Danh sach tai khoan thanh toan");
                                System.out.println("============");
                                DS.showThanhToanAccounts();
                                System.out.println("===================================");
                            case 0:
                                System.out.println("Thoat chuong trinh!");
                            break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                            break;
                    }
                        
                    } while (choice != 0);
                }
                break;
                case 3: 
                {
                    System.out.println("Nhap tai khoan can dang nhap: ");
                    stk=sc.nextLine();

                    NganHang taikhoan = DS.searchAcount(stk);

                    if(taikhoan != null)
                    {
                        System.out.println("Nhap mat khau tai khoan can dang nhap: ");
                        matkhau = sc.nextLine();

                        int count = 1;
                        while(!taikhoan.kiemtraMatKhau(matkhau))
                        {
                            count++;
                            System.out.printf("Mat khau sai. Nhap lai mat khau tai khoan can dang nhap lan %d/5: ", count);
                            matkhau=sc.nextLine();
                            if(count > 5)
                                break;
                        }

                        if(taikhoan.kiemtraMatKhau(matkhau))
                        {
                            System.out.println("Tai khoan ban chon la: "+taikhoan.getStk());
                            System.out.println("Ten chu tai khoan la: "+taikhoan.chutk);
                            while (true)
                            {
                                System.out.println("\n1.Nap tien");
                                System.out.println("2.Rut tien");
                                System.out.println("3.Chuyen khoan");
                                System.out.println("4.Xem so du");
                                System.out.println("5.Doi mat khau");

                                //Thêm tùy chọn cho tài khoản tiết kiệm
                                if(taikhoan instanceof TaiKhoanTietKiem)
                                    System.out.println("""
                                        6. Tinh lai
                                        10. Tinh lai so tien gui tu tai khoan thanh toan""");
                                
                                //Thêm tùy chọn cho tài khoản thanh toán
                                if(taikhoan instanceof TaiKhoanThanhToan)
                                    System.out.println("""
                                        7. Xem han muc tin dung
                                        8. Rut tien tu tai khoan thanh toan
                                        9. Gui tien vao tai khoan tiet kiem""");
                                System.out.println("0. Thoat!");
                                System.out.println("Nhap lua chon: ");
                                int m = sc.nextInt();
                                sc.nextLine();

                                boolean exit = true;
                                switch (m)
                                {
                                    case 1: //Nạp tiền
                                    {
                                        System.out.println("Nhap so tien can nap: ");
                                        double tienNap = sc.nextDouble();
                                        taikhoan.napTiep(tienNap);
                                        System.out.println("So tien moi trong tai khoan la: "+taikhoan.getSodu());
                                    }
                                    break;
                                    case 2: //Rút tiền
                                    {
                                        System.out.println("Nhap so tien can rut: ");
                                        double tienRut = sc.nextDouble();
                                        int d = 1;
                                        boolean kt = true;
                                        do
                                        {
                                            System.out.printf("Nhap mat khau de rut lan %d/5", d);
                                            matkhau=sc.nextLine();
                                            if(taikhoan.kiemtraMatKhau(matkhau))
                                            {
                                                if(taikhoan.getSodu() >= tienRut)
                                                {
                                                    taikhoan.rutTien(tienRut);
                                                    System.out.println("So tien moi trong ta khoan la: "+taikhoan.getSodu());
                                                    kt=false;
                                                }
                                                else
                                                {
                                                    System.out.println("So du khong du de rut!");
                                                    kt=false;
                                                }
                                            }
                                            else
                                                d++;
                                        }while(kt && d <=5);
                                    }
                                    break;
                                    case 3: //Chuyển khoản
                                    {
                                        System.out.println("Nhap so tai khoan nhan: ");
                                        String stkNhan = sc.nextLine();

                                        NganHang tkNhan = DS.searchAcount(stkNhan);

                                        if(tkNhan != null)
                                        {
                                            System.out.printf("Tai khoan nhan: %s - %s\n", tkNhan.getStk(), tkNhan.chutk);
                                                System.out.println("Nhap so tien can chuyen: ");
                                                double tienChuyen = sc.nextDouble();
                                                taikhoan.chuyenTien(tkNhan, tienChuyen);
                                        }
                                        else
                                            System.out.println("Khong tim thay tai khoan can chuyen!");
                                    }
                                    break;
                                    case 4: //Xem số dư
                                        System.out.println("So du hien tai cua ban la: "+taikhoan.getSodu());
                                    break;
                                    case 5: //Đổi mật khẩu
                                    {
                                        boolean kt = false;
                                        dem = 1;
                                        do 
                                        {
                                            System.out.println("Nhap mat khau cu: ");
                                            matkhau=sc.nextLine();
                                            if(taikhoan.kiemtraMatKhau(matkhau))
                                            {
                                                System.out.println("Nhap mat khau moi (Mat khau phai chua it nhat 1 ki tu Hoa, thuong và 5 ki tu): ");
                                                String matKhauMoi = sc.nextLine();
                                                if(kiemTraMatKhauHopLe(matKhauMoi))
                                                {
                                                    System.out.println("Nhap lai mat khau moi de xac nhan: ");
                                                    String mkXN = sc.nextLine();
                                                    if(!mkXN.equals(matKhauMoi))
                                                    {
                                                        while(true)
                                                        {
                                                            System.out.println(" Vui long nhap lai mat khau xac nhan: ");
                                                            mkXN=sc.nextLine();
                                                            if(mkXN.equals(matKhauMoi))
                                                            {
                                                                taikhoan.doiMatKhau(matKhauMoi);
                                                                System.out.println("Doi mat khau thanh cong!");
                                                                kt=true;
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Mat khau xac nhan khong khop.");
                                                            }
                                                        }
                                                        
                                                    }
                                                }

                                            }
                                            else
                                            {
                                                dem++;
                                                System.out.println("Nhap sai mat khau cu. Xin moi nhap lai.");
                                            }
                                        } while (!kt && dem<=5);
                                        if(!kt)
                                            System.out.println("Da qua so lan thu doi mat khau!");
                                    }
                                    break;
                                    case 6:
                                        if(taikhoan instanceof TaiKhoanTietKiem)
                                        {
                                            TaiKhoanTietKiem tkTietKiem = (TaiKhoanTietKiem) taikhoan;
                                            tkTietKiem.nhap();
                                            System.out.println("Tinh lai gop hang thang cho tai khoan tiet kiem...");
                                            tkTietKiem.tinhLaiGopHangThang();
                                            tkTietKiem.laiDon();
                                            tkTietKiem.laiKep();
                                        }
                                        else
                                            System.out.println("Tai khoan khong phai la tai khoan tiet kiem.");
                                        break;
                                    case 7: 
                                    if(taikhoan instanceof TaiKhoanThanhToan)
                                    {
                                        TaiKhoanThanhToan tkThanhToan = (TaiKhoanThanhToan) taikhoan;
                                        System.out.printf("Han muc tin dung cua ban la: %.2f d\n", tkThanhToan.getHanMucTinDung());
                                    }
                                    else
                                        System.out.println("Tai khoan cua ban khong phai la tai khoan thanh toan!");
                                    break;
                                    case 8:
                                    {
                                        if(taikhoan instanceof TaiKhoanThanhToan)
                                        {
                                            TaiKhoanThanhToan tkThanhToan = (TaiKhoanThanhToan) taikhoan;

                                            System.out.println("Nhap so tien ban muon rut: ");
                                            double tienRut = sc.nextDouble();
                                            sc.nextLine();
                                            tkThanhToan.rutTien(tienRut);
                                            if(tkThanhToan.getSoNo()>0)
                                            {
                                                System.out.println("Ban hien co so no: "+tkThanhToan.getSoNo()+" d");
                                                System.out.println("Ban co muon nap tien vao so du de tra no khong? (1.Co/ 2.Khong)");
                                                int choice = sc.nextInt();
                                                sc.nextLine();
                                                if(choice == 1)
                                                {
                                                    System.out.println("Nhap so tien nap: ");
                                                    double tienNap = sc.nextDouble();
                                                    sc.nextLine();
                                                    tkThanhToan.napTien(tienNap);
                                                }
                                                else if(choice == 2)
                                                {
                                                    System.out.println("Ban da khong chon nap tien.");
                                                    System.out.println("So no cua ban van con!");
                                                }
                                            }
                                            else
                                                System.out.println("Ban khong co so no.");
                                        }    
                                        else
                                            System.out.println("Tai khoan cua ban khong phai la tai khoan thanh toan");
                                    }
                                    break;
                                    case 9:
                                    {
                                        if(taikhoan instanceof TaiKhoanThanhToan)
                                        {
                                            System.out.println("Nhap so tai khoan tiet kiem: ");
                                            String stkTietKiem = sc.nextLine();
                                            TaiKhoanTietKiem tkTietKiem = (TaiKhoanTietKiem) DS.searchAcount(stkTietKiem);
                                            if(tkTietKiem!=null)
                                            {
                                                System.out.println("Nhap so tien can gui tiet kiem: ");
                                                double soTienGuiTietKiem = sc.nextDouble();
                                                System.out.println("NHap ky han gui(theo thang): ");
                                                int kyHan = sc.nextInt();
                                                sc.nextLine();

                                                //Gửi tiền vào tài khoản tiết kiệm
                                                if(tkTietKiem.guiTietKiem((TaiKhoanThanhToan) taikhoan, soTienGuiTietKiem, kyHan))
                                                    System.out.println("Gui tien vao tai khoan tiet kiem thanh cong!");
                                                else
                                                    System.out.println("Gui tien thay bai. So du khong du!");
                                            }
                                            else
                                                System.out.println("Khong tim thay so tai khoan tiet kiem!");
                                        }
                                    }
                                    break;
                                    case 10:
                                    {
                                        if(taikhoan instanceof TaiKhoanTietKiem)
                                        {
                                            double lai = ((TaiKhoanTietKiem) taikhoan).tinhLaiGanNhat();
                                        }
                                        else
                                            System.out.println("Tai khoan khong phai la tai khoan tiet kiem");
                                    }
                                    case 0:
                                        exit = false;
                                    break;
                                    default:
                                        System.out.println("\nLua chon khong hop le.");  
                                }
                                if(!exit)
                                    break;
                            }
                        }
                        else
                            System.out.println("Tai khoan khong hop le.");
                        
                    }
                    else
                        System.out.println("Tai khoan khong ton tai!");
                }
                break;
                case 4:
                {
                    System.out.print("Nhap so tai khoan muon khoi phuc mat khau: ");
                    stk = sc.nextLine();
                    NganHang taikhoan = DS.searchAcount(stk);

                    if (taikhoan != null) 
                    {
                        System.out.print("Nhap ma khoi phuc de dat lai mat khau: ");
                        maKhoiPhuc = sc.nextLine();
                        dem=1;
                        boolean kt=true;
                        if (taikhoan.kiemTraMaKhoiPhuc(maKhoiPhuc)) 
                        {
                            do
                            {
                                System.out.printf("Nhap mat khau moi lan %d/3:",dem);
                                String matKhauMoi = sc.nextLine();
                                if(kiemTraMatKhauHopLe(matKhauMoi))
                                {
                                    taikhoan.doiMatKhau(matKhauMoi);
                                    System.out.println("Mat khau duoc doi thanh cong!");
                                    kt=false;
                                }
                                else    
                                {
                                    System.out.println("Nhap mat khau khong thoa man! Vui long nhap lai");
                                    dem++;
                                }
                            }while(kt && dem<=3);
                        } 
                        else 
                            System.out.println("\nMa khoi phuc khong dung");
                    } 
                    else 
                        System.out.println("\nSo tai khoan khong ton tai.");
                }
                break;
                case 0:
                    System.out.println("\nThoat chuong trinh.");
                    return;
                default: 
                    System.out.println("\nError! Nhap lai.");
                    break;
            }
        }
    }
}
