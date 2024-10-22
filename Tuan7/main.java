package Tuan7;
import java.util.List;
import java.util.Scanner;
public class main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSTaiKhoang DS = new DSTaiKhoang();

        while (true) 
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Bạn chọn làm gì:");
            System.out.println("1.Đăng kí tài khoản");
            System.out.println("2.Xuất danh sách thông tin của các tài khoảng");
            System.out.println("3.Đăng nhập tài khoản");
            System.out.println("0. Thoát chương trình");

            System.out.print("Nhập sự lựa chọn: ");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                {
                    System.out.print("Tạo số tài khoản: ");
                    String stk = sc.nextLine();
                    System.out.print("Tạo chủ tài khoản: ");
                    String tentk = sc.nextLine();
                    System.out.print("Tạo mật khẩu cho tài khoản: ");
                    String matkhau = sc.nextLine();

                    System.out.print("Nhập số dư:");
                    double sodu=sc.nextDouble();

                    NganHang account = new NganHang(stk, tentk,sodu,matkhau);
                    DS.addAcount(account);
                    System.out.printf("Tài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:%.0f₫)\n", stk, tentk,matkhau,sodu);
                }
                break;
                case 2: 
                {
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
                    DS.showAccount();
                }
                break;
                case 3: 
                {
                    System.out.print("Nhập số tài khoản cần đăng nhập:");
                    String stk = sc.nextLine();
                    int dem=0;
                    List<NganHang> accountList = DS.searchAccounts(stk);
                    
                    System.out.print("Nhập mật khẩu tài khoản cần đăng nhập:");
                    String matkhau = sc.nextLine();
                    
                    if (!accountList.isEmpty()) 
                    {         
                        NganHang taikhoan = accountList.get(0);
                        while(!taikhoan.getMatKhau().equals(matkhau))
                        {
                            dem++;
                            System.out.printf("Mật khẩu sai.Nhập lại mật khẩu tài khoản cần đăng nhập lần %d:",dem);
                            matkhau = sc.nextLine();
                            if(dem>=5)
                                break;
                        }
                        if(taikhoan.getMatKhau().equals(matkhau)) 
                            {

                                System.out.printf("Tài khoản bạn chọn là: %s\n", stk);
                                System.out.printf("Tên chủ tài khoản là: %s\n", taikhoan.chutk);
                                while (true) 
                                {                         
                                    System.out.println("1.Nạp tiền");
                                    System.out.println("2.Rút tiền");
                                    System.out.println("3.Xem số dư");
                                    System.out.println("4.Đổi mật khẩu");
                                    System.out.println("0.Thoát!");
                                    System.out.print("Nhập lựa chọn: ");
                                    int m = sc.nextInt();
                    
                                    boolean exit = true;
                                    switch (m)
                                    {
                                        case 1:
                                        {
                                            System.out.print("Nhập số tiền cần nạp: ");
                                            double tienNop = sc.nextDouble();
                                            taikhoan.napTiep(tienNop);
                                            System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n", taikhoan.getSodu());  
                                        }                      
                                            break;
                                        case 2:
                                        {
                                            System.out.print("Nhập số tiền cần rút: ");
                                            double tienRut = sc.nextDouble();
                                            if (taikhoan.getSodu() >= tienRut)
                                            {
                                                taikhoan.rutTien(tienRut);
                                                System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n", taikhoan.getSodu());
                                            }
                                            else 
                                                System.out.println("Số dư không đủ để thực hiện giao dịch.");
                                        }
                                            break;
                                        case 3:
                                            System.out.printf("Số dư của bạn là:%.0f\n",taikhoan.getSodu());
                                            break;
                                        case 4:
                                            {
                                                sc.nextLine();
                                                System.out.print("Nhập mật khẩu mới cần đổi:");
                                                String mkMoi=sc.nextLine();
                                                taikhoan.doiMatKhau(mkMoi);
                                            }
                                            break;
                                        case 0:
                                            exit=false;
                                            break;
                                        default:
                                            System.out.println("Lựa chọn không hợp lệ.");
                                            break;
                                    }               
                                    if (!exit)
                                        break;
                                }
                            }
                            else
                                System.out.println("Mật khẩu không đúng.Vui lòng nhập lại!");
                        } 
                        else 
                            System.out.println("Số tài khoản không tồn tại.");
                }   
                break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default: 
                    System.out.println("Error! Nhập lại.");
                    break;
            }
        }
    }
}
