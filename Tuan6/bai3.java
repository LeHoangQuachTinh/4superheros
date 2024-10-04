package Tuan6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class NganHang{
    private String stk;
    private String chutk;
    private Double sodu;

    NganHang(){

    }
    NganHang(String stk,String chutk,double sodu)
    {
        this.stk=stk;
        this.chutk=chutk;
        this.sodu=sodu;
    }
    public String getStk(){
        return this.stk;
    }
    public Double getSodu(){
        return this.sodu;
    }
    public String getChuTK(){
        return this.chutk;
    }
   public void napTiep(double tien)
    {

        if(tien>=0)
        {
            this.sodu=this.sodu+tien;
            System.out.printf("Nạp thành công:%.0f₫\n",tien);
        }
        else
            System.out.println("Số tiền nạp không hợp lệ");

    }

    public void rutTien(double rut)
    {
        if(this.sodu>=rut)
        {
            this.sodu=this.sodu-rut;
            System.out.printf("Bạn đã rút thành công:%.0f₫\n",rut);
        }
        else
            System.out.println("Số tiền trong tài khoảng không đủ");
    }
    public void display(){
        System.out.printf("%-10s %-20s %-10.2f₫\n",stk,chutk,sodu);
    }

}
class DSTaiKhoang{
    List<NganHang> DS;

    DSTaiKhoang(){
        DS=new ArrayList<>();
    }
    public void addAcount(NganHang account)
    {
        this.DS.add(account);
    }
    public List<NganHang> searchAccounts(String stk) {
        return this.DS.stream().filter(o -> o.getStk().contains(stk)).collect(Collectors.toList());
    }
    public void showAccount(){
       this.DS.forEach(o->o.display());
    }
}
public class bai3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSTaiKhoang DS = new DSTaiKhoang();

        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Bạn chọn làm gì:");
            System.out.println("1. Nhập thông tin của khách hàng");
            System.out.println("2. Xuất danh sách thông tin của các khách hàng");
            System.out.println("3. Nạp tiền");
            System.out.println("4. Rút tiền");
            System.out.println("5. Chuyển khoản");
            System.out.println("0. Thoát chương trình");

            System.out.print("Nhập sự lựa chọn: ");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1: {
                    System.out.print("Nhập số tài khoản: ");
                    String stk = sc.nextLine();
                    System.out.print("Nhập chủ tài khoản: ");
                    String tentk = sc.nextLine();
                    System.out.print("Nhập số dư:");
                    double sodu=sc.nextDouble();
                    NganHang account = new NganHang(stk, tentk,sodu);
                    DS.addAcount(account);
                    System.out.printf("Tài khoản vừa mới thêm là: Account(stk: %s, tentk: %s,sodu:%.0f₫)\n", stk, tentk,sodu);
                }
                break;
                case 2: {
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
                    DS.showAccount();
                }
                break;
                case 3: {
                    System.out.print("Nhập số tài khoản khách hàng cần nộp: ");
                    String stk = sc.nextLine();
                    DS.searchAccounts(stk).forEach(account -> {
                        System.out.printf("Tài khoản bạn chọn là: %s\n", stk);
                        System.out.printf("Tên tài khoản là: %s\n" , account.getChuTK());
                        System.out.print("Nhập số tiền cần nạp: ");
                        double tienNop = sc.nextDouble();
                        account.napTiep(tienNop);
                    });
                }
                break;
                case 4: {
                    System.out.print("Nhập số tài khoản khách hàng cần rút tiền: ");
                    String stk = sc.nextLine();
                    DS.searchAccounts(stk).forEach(account -> {
                        System.out.printf("Tài khoản bạn chọn là: %s\n", stk);
                        System.out.printf("Tên tài khoản là:%s\n" , account.getChuTK());
                        System.out.print("Nhập số tiền cần rút: ");
                        double tienRut = sc.nextDouble();
                        account.rutTien(tienRut);
                    });
                }
                break;
                case 5: {
                    System.out.print("Nhập số tài khoản chuyển: ");
                    String stk1 = sc.nextLine();
                    System.out.print("Nhập số tài khoản nhận: ");
                    String stk2 = sc.nextLine();

                    List<NganHang> dsGui = DS.searchAccounts(stk1);
                    List<NganHang> dsNhan = DS.searchAccounts(stk2);
                    
                    if (!dsGui.isEmpty() && !dsNhan.isEmpty()) {
                        NganHang taiKhoanGui = dsGui.get(0);
                        NganHang taiKhoanNhan = dsNhan.get(0);
                        
                        System.out.printf("Tài khoản chuyển: %s - %s\n", taiKhoanGui.getStk(), taiKhoanGui.getChuTK());
                        System.out.printf("Tài khoản nhận: %s - %s\n", taiKhoanNhan.getStk(), taiKhoanNhan.getChuTK());
                        
                        System.out.print("Nhập số tiền cần chuyển: ");
                        double tienChuyen = sc.nextDouble();

                        if (taiKhoanGui.getSodu() >= tienChuyen) {

                            taiKhoanGui.rutTien(tienChuyen);
                            taiKhoanNhan.napTiep(tienChuyen);
                            System.out.println("Chuyển thành công!");
                        } 
                        else 
                            System.out.println("Số dư tài khoản không đủ để chuyển tiền!");
                    }
                    else    
                        System.out.println("Số tài khoản không hợp lệ!");
                
               }
                break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default: {
                    System.out.println("Error! Nhập lại, vui lòng.");
                    break;
                }
            }
        }
    }
}
