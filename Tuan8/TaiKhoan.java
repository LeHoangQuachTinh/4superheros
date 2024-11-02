/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nganhangtruutuong.dahinh;

/**
 *
 * @author 123
 */
import java.util.Scanner;

abstract class TaiKhoan 
{
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) 
    {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public void guiTien(double soTien) 
    {
        if (soTien > 0) 
        {
            soDu += soTien;
            System.out.println("Gui tien thanh cong. So du hien tai: " + soDu);
        } 
        else 
        
            System.out.println("So tien gui khong hop le.");
        
    }

    public void kiemTraSoDu() 
    {
        System.out.println("So du hien tai: " + soDu);
    }

    public void doiMatKhau(String matKhauCu, String matKhauMoi) 
    {
        if (this.matKhau.equals(matKhauCu)) 
        {
            this.matKhau = matKhauMoi;
            System.out.println("Doi mat khau thanh cong.");
        } 
        else 
        
            System.out.println("Mat khau cu khong dung.");
        
    }

    public String getSoTaiKhoan() 
    {
        return soTaiKhoan;
    }

    public String getMatKhau() 
    {
        return matKhau;
    }

    public double getSoDu() 
    {
        return soDu;
    }

    public void setSoDu(double soDu) 
    {
        this.soDu = soDu;
    }

    public abstract void rutTien(double soTien);
}

class TaiKhoanTietKiem extends TaiKhoan 
{
    private double laiSuat;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat) 
    {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
    }

    @Override
    public void rutTien(double soTien) 
    {
        if (soTien > 0 && soTien <= getSoDu()) 
        {
            setSoDu(getSoDu() - soTien);
            System.out.println("Rut tien thanh cong. So du hien tai: " + getSoDu());
        } 
        else 
        {
            System.out.println("So tien rut khong hop le hoac khong du so du.");
        }
    }

    public void tinhLai() 
    {
        double lai = getSoDu() * laiSuat / 100;
        setSoDu(getSoDu() + lai);
        System.out.println("Tinh lai thanh cong. So du hien tai: " + getSoDu());
    }
}

class TaiKhoanThanhToan extends TaiKhoan 
{
    private double hanMucThauChi;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double hanMucThauChi) 
    {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.hanMucThauChi = hanMucThauChi;
    }

    @Override
    public void rutTien(double soTien) 
    {
        if (soTien > 0 && soTien <= getSoDu() + hanMucThauChi) 
        {
            setSoDu(getSoDu() - soTien);
            System.out.println("Rut tien thanh cong. So du hien tai: " + getSoDu());
        } 
        else 
        
            System.out.println("So tien rut khong hop le hoac vuot qua han muc thau chi.");
    }

    public void thanhToanHoaDon(double soTien) 
    {
        if (soTien > 0 && soTien <= getSoDu() + hanMucThauChi) 
        {
            setSoDu(getSoDu() - soTien);
            System.out.println("Thanh toan hoa don thanh cong. So du hien tai: " + getSoDu());
        } 
        else 
        
            System.out.println("So tien thanh toan khong hop le hoac vuot qua han muc thau chi.");
    }
}
