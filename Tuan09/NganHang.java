package nganhang;
import java.text.DecimalFormat;

public abstract class NganHang {
    private String stk;
    public String chutk;
    protected double sodu;
    private String matkhau;
    private String maKhoiPhuc;
   
    public void setMaKhoiPhuc(String maKhoiPhuc) {
        this.maKhoiPhuc = maKhoiPhuc;
    }
    NganHang(){

    }
    NganHang(String stk,String chutk,String matkhau,String maKhoiPhuc)
    {
        this.stk=stk;
        this.chutk=chutk;
        this.sodu=50000.0;
        this.matkhau=matkhau;
        this.maKhoiPhuc=maKhoiPhuc;
    }
    public String getStk(){
        return this.stk;
    }
    public double getSodu(){
        return this.sodu;
    }
    public void doiMatKhau(String MatKhauMoi){
        this.matkhau=MatKhauMoi;
        System.out.println("Mật khẩu mới của bạn là:"+this.matkhau);
    }
    //quyền chỉnh cái này
    public boolean kiemtraMatKhau(String matkhau){
        return this.matkhau.equals(matkhau);
    }
    public boolean kiemTraMaKhoiPhuc(String maKhoiPhuc){
        return this.maKhoiPhuc.equals(maKhoiPhuc);
    }
    public void napTiep(double tien)
    {

        if(tien>=0)
        {
            this.sodu=this.sodu+tien;
            System.out.printf("\nNạp thành công:%.0f₫\n",tien);
        }
        else
            System.out.println("\nSố tiền nạp không hợp lệ");

    }

    public abstract void rutTien(double soTien);
    public void display(){
        System.out.println("So tai khoan      : " + stk);
        System.out.println("Ten tai khoan     : " + chutk);
        System.out.printf("So du              : %.1f đ\n", sodu);
    };
    public void chuyenTien(NganHang tkNhan, double soTien) {
        if (this.sodu >= soTien) {
            if(soTien>=0)
            {
                this.sodu -= soTien;  
                tkNhan.sodu += soTien; 
                System.out.printf("Chuyen tien thanh cong! So tien da chuyen: %.0f₫\n", soTien);
                System.out.printf("So du hien tai cua ban la: %.0f₫\n", this.sodu);
            }
            else
                System.out.println("Số tien khong hop le!");
        }
        else
            System.out.println("So tien khong du");
    }

    public abstract String getType();

}
