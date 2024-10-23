package Tuan7;

class NganHang{
    private String stk;
    public String chutk;
    private Double sodu;
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
    public Double getSodu(){
        return this.sodu;
    }
    public void doiMatKhau(String MatKhauMoi){
        this.matkhau=MatKhauMoi;
        System.out.println("Mật khẩu mới của bạn là:"+this.matkhau);
    }
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

    public void rutTien(double rut)
    {
        if(this.sodu>=rut)
        {
            this.sodu=this.sodu-rut;
            System.out.printf("\nBạn đã rút thành công:%.0f₫\n",rut);
        }
        else
            System.out.println("\nSố tiền trong tài khoảng không đủ");
    }
    public void display(){
        System.out.printf("%-10s %-20s %-10.2f₫\n",stk,chutk,sodu);
    }
    public void chuyenTien(NganHang tkNhan, double soTien) {
        if (this.sodu >= soTien) {
            if(soTien>=0)
            {
                this.sodu -= soTien;  
                tkNhan.sodu += soTien; 
                System.out.printf("Chuyển thành công %dđ\n",soTien);
            }
            else
                System.out.println("Số tiền không hợp lệ!");
        }
        else
            System.out.println("Số tiền không đủ");
    }

}
