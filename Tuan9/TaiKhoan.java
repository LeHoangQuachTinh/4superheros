package nganhang;

import java.util.ArrayList;

abstract class TaiKhoan 
{
    private String soTaiKhoan;
    private String chuTaiKhoan;
    protected double soDu;
    private String matKhau;
    private ArrayList<GiaoDich> lichSuGiaoDich = new ArrayList<>();

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
            System.out.println("Gui tien thanh cong. So du hien tai cua tai khoan nhan: " + soDu);
            themGiaoDich("Gui tien", soTien);
        } 
        else
            System.out.println("So tien gui khong hop le.");
    }

    public void kiemTraSoDu()
    {
        System.out.println("So du hien tai: " + soDu);
    }

    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
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

    protected void themGiaoDich(String loaiGiaoDich, double soTien)
    {
        GiaoDich giaoDich = new GiaoDich(loaiGiaoDich, soTien, soDu);
        lichSuGiaoDich.add(giaoDich);
    }

    public void xemLichSuGiaoDich()
    {
        System.out.println("Lich su giao dich:");
        for (GiaoDich giaoDich : lichSuGiaoDich) 
        {
            System.out.println(giaoDich);
        }
    }

    public abstract void rutTien(double soTien);
}

class TaiKhoanTietKiem extends TaiKhoan 
{
    private double laiSuat;

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
}

    @Override
    public void rutTien(double soTien) 
    {
        if (soTien > 0 && soTien <= soDu) 
        {
            soDu -= soTien;
            System.out.println("Rut tien thanh cong. So du hien tai cua tai khoan: " + soDu);
            themGiaoDich("Rut tien", soTien);
        } 
        else 
            System.out.println("So tien rut khong hop le hoac khong du so du.");
    }

    public void tinhLai() 
    {
        double lai = soDu * laiSuat / 100;
        soDu += lai;
        System.out.println("Tinh lai thanh cong. So du hien tai: " + soDu);
        themGiaoDich("Tinh lai", lai);
    }
}

class TaiKhoanThanhToan extends TaiKhoan 
{
    private double hanMucThauChi;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double hanMucThauChi) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.hanMucThauChi = hanMucThauChi;
}

    @Override
    public void rutTien(double soTien) 
    {
        if (soTien > 0 && soTien <= soDu + hanMucThauChi) 
        {
            soDu -= soTien;
            System.out.println("Rut tien thanh cong. So du hien tai cua tai khoan: " + soDu);
            themGiaoDich("Rut tien", soTien);
        } 
        else 
            System.out.println("So tien rut khong hop le hoac vuot qua han muc thau chi.");
    }

    public void thanhToanHoaDon(double soTien) 
    {
        if (soTien > 0 && soTien <= soDu + hanMucThauChi) 
        {
            soDu -= soTien;
            System.out.println("Thanh toan hoa don thanh cong. So du hien tai: " + soDu);
            themGiaoDich("Thanh toan hoa don", soTien);
        } 
        else 
            System.out.println("So tien thanh toan khong hop le hoac vuot qua han muc thau chi.");
    }
}