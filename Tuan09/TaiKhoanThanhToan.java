package nganhang;

import java.util.Scanner;

public class TaiKhoanThanhToan extends NganHang{
    private double hanMucTinDung;
    private double soNo;

    public TaiKhoanThanhToan(String stk, String chutk, String matkhau, String maKhoiPhuc, double hanMucTinDung) {
        super(stk, chutk, matkhau, maKhoiPhuc);
        this.hanMucTinDung = hanMucTinDung;
        this.soNo=0;
    }

    public double getHanMucTinDung() {
        return hanMucTinDung;
    }

    public void setHanMucTinDung(double hanMucTinDung) {
        this.hanMucTinDung = hanMucTinDung;
    }

    public double getSoNo(){
        return soNo;
    }

    @Override
    public void rutTien(double soTien)
    {
        Scanner sc = new Scanner(System.in);
        if(this.sodu>= soTien)
        {
            System.out.println("So du cua ban du de rut tien: ");
            this.sodu-=soTien;
            System.out.printf("Rut thanh cong: %.0f d\n", soTien);
        }
        else if(this.sodu + hanMucTinDung >= soTien)
        {
            System.out.println("So du cua ban khong du. Ban co muon rut bang han muc tin dung khong ?");
            System.out.println("""
                    1. Co
                    2. Khong""");
            System.out.println("Nhap lua chon: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1)
            {
                double tienRutTuTinDung = soTien - this.sodu;
                this.sodu=0;
                hanMucTinDung -= tienRutTuTinDung;
                soNo += tienRutTuTinDung;
                System.out.printf("Rut thanh cong: %.0f d\n", soTien);
                System.out.printf("Han muc tin dung con lai: %.0f d\n", hanMucTinDung);
                if(hanMucTinDung<=0)
                    System.out.println("Ban da su dung het han muc tin dung!");
            }
            else if(choice == 2)
            {
                System.out.println("Giao dich bi huy. Ban da chon khong su dung han muc tin dung.");
            }
        }
        else if(this.sodu + hanMucTinDung < soTien)
        {
            System.out.println("So du va han muc tin dung khong du de thuc hien giao dich!");
        }
    }
    public void napTien(double soTien)
    {
        System.out.printf("Ban vua nap: %.0f d\n", soTien);

        if(soNo>0)
        {
            double soTienTraNo=Math.min(soTien, soNo);
            soNo-=soTienTraNo;
            hanMucTinDung+=soTienTraNo; //Khôi phục hạn mức tín dụng
            soTien-=soTienTraNo;
            System.out.printf("Da tra no tu han muc tin dung: %.0f d\n", soTienTraNo);
        }

        //Số tiền còn lại sẽ cộng vào số dư
        if(soTien>0)
        {
            this.sodu+=soTien;
            System.out.printf("So du hien tai cua ban la: %.0f d\n", this.sodu);
        }
        if(soNo==0)
            System.out.println("Ban da tra het no.");
    }
    @Override
    public void display()
    {
        super.display();
        System.out.printf("Han muc tin dung   :%.2f d\n", hanMucTinDung);
        System.out.println("---------------------------------");
    }

    @Override
    public String getType() {
        return "Tai khoan thanh toan";
    }
}
