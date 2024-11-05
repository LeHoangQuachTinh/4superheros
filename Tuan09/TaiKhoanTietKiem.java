package nganhang;

import java.util.Scanner;

public class TaiKhoanTietKiem extends NganHang{
    private int soNamGui;
    private int tongSoThang;
    private double laiSuat;
    private int kyHan; //Kì hạn gửi tiền theo tháng
    private double soTienTietKiemGui;
    private double soTienGuiGanNhat;
    private int kyHanGanNhat;

    public TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maKhoiPhuc, double laiSuat, int kyHan) {
        super(stk, chutk, matkhau, maKhoiPhuc);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.laiSuat=laiSuat;
    }

    public int getSoNamGui() {
        return soNamGui;
    }


    public void setSoNamGui(int soNamGui) {
        this.soNamGui = soNamGui;
    }


    public double getLaiSuat() {
        return laiSuat;
    }


    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }


    public int getKyHan() {
        return kyHan;
    }


    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }


    public double getSoTienTietKiemGui() {
        return soTienTietKiemGui;
    }


    public void setSoTienTietKiemGui(double soTienTietKiemGui) {
        this.soTienTietKiemGui = soTienTietKiemGui;
    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tien can gui tiet kiem: ");
        this.soTienTietKiemGui = sc.nextDouble();
        System.out.println("Nhap so nam: ");
        this.soNamGui=sc.nextInt();
        if(getSodu() >= this.soTienTietKiemGui)
            sodu-=this.soTienTietKiemGui;
        else    
            System.out.println("So du khong du de gui tien!");
    }
    public void tinhLaiGopHangThang()
    {
        double soDuTietKiem = this.soTienTietKiemGui;
        tongSoThang = soNamGui*12;

        System.out.println("Tinh lai gop hang thang: ");
        for(int thang = 1; thang<=tongSoThang; thang++)
        {
            double tienLaiThang = soDuTietKiem * (laiSuat/12);
            soDuTietKiem+=tienLaiThang;

            System.out.printf("Thang %d: So tien lai la %.0f d\n", thang, tienLaiThang);
            System.out.printf("So du sau thang %d: %.0f d\n", thang, soDuTietKiem);
            System.out.println("*------------*");
        }
        //Cộng tổng số tiền sau kỳ hạn vào tài khoản chính
        sodu+=soDuTietKiem;
        System.out.printf("Tong so du trong tai khoan sau ky han %d nam la: %.0f d\n", soNamGui, sodu);
    }

    //Phương thức tính lãi đơn và lãi kép vẫn được giữ lại
    public void laiDon()
    {
        double tienLaiDon = this.soTienTietKiemGui * (1 + this.laiSuat * this.soNamGui);
        System.out.println("So tien lai don: "+tienLaiDon);
        sodu+=tienLaiDon;
    }

    public void laiKep()
    {
        double tienLaiKep = this.soTienTietKiemGui * Math.pow((1 + this.laiSuat), this.soNamGui);
        System.out.println("So tien lai kep: "+tienLaiKep);
        sodu+=tienLaiKep;
    }

    public boolean guiTietKiem(TaiKhoanThanhToan taiKhoanThanhToan, double soTienGui, int kyHan)
    {
        if(taiKhoanThanhToan.getSodu()>=soTienGui)
        {
            taiKhoanThanhToan.rutTien(soTienGui);
            this.soTienTietKiemGui+=soTienGui;
            this.soTienGuiGanNhat = soTienGui;
            this.kyHanGanNhat=kyHan;
            return true;
        }
        else
            return false;
    }

    public double tinhLaiGanNhat()
    {
        double lai = 0;

        double laiSuat=0;
        if(kyHanGanNhat <=3 )
            laiSuat=3;
        else if(kyHanGanNhat <= 6)
            laiSuat=4;
        else if(kyHanGanNhat<=12)
            laiSuat=5;
        else
            laiSuat=6;
        if(soTienGuiGanNhat>0)
        {
            lai = soTienGuiGanNhat * (laiSuat*0.01) * kyHanGanNhat;
            System.out.printf("Lai suat cho so tien %.2f d voi ky han %d thang va lai suat %.2f%% la: %.2f d\n", soTienGuiGanNhat, kyHanGanNhat, laiSuat, lai);
        }
        else
            System.out.println("Chua co so tien gui nao!");
        return lai;
    }
    @Override
    public void display()
    {
        super.display();
        System.out.printf("Lai suat           : %.2f%%\n", laiSuat);
        System.out.printf("So tien tiet kiem   : %.0f d\n", soTienTietKiemGui);
        System.out.println("-------------------------------");
    }

    @Override
    public void rutTien(double rut) {
        if(this.soTienTietKiemGui>=rut)
        {
            this.soTienTietKiemGui-=rut;
            System.out.printf("Ban da rut thanh cong: %.0f d tu tai khoan tiet kiem.\n", rut);
        }
        else
            System.out.println("So tien trong tai khoan tiet kiem khong du!");
    }

    @Override
    public String getType() {
        return "Tai khoan tiet kiem";
    }
}
