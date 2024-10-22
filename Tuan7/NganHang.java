package Tuan7;

class NganHang{
    private String stk;
    public String chutk;
    private Double sodu;
    private String matkhau;
    NganHang(){

    }
    NganHang(String stk,String chutk,double sodu,String matkhau)
    {
        this.stk=stk;
        this.chutk=chutk;
        this.sodu=sodu;
        this.matkhau=matkhau;
    }
    public String getStk(){
        return this.stk;
    }
    public Double getSodu(){
        return this.sodu;
    }
    public void doiMatKhau(String MatKhauMoi){
        this.matkhau=MatKhauMoi;
    }
    public String getMatKhau(){
        return this.matkhau;
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
