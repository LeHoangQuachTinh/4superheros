
public class HINHCHUNHAT {
    private double cd;
    private double cr;
    public static int count=0;
    //Constructor
    public HINHCHUNHAT(double cd, double cr)
    {
        this.cd=cd;
        this.cr=cr;
        count++;
    }
    public HINHCHUNHAT(){
        count++;
    }

    public double getCd() {
        return cd;
    }

    public double getCr() {
        return cr;
    }
    public void setCd(double CD){
        this.cd=CD;
    }
    public void setCr(double CR){
        this.cr=CR;
    }
    //Tính diện tích
    public double tinhDienTich(){
        return cd*cr;
    }
    //Tính chu vi
    public double tinhChuVi(){
        return (2*(cd+cr));
    }
    //Hàm nhập
    public void Nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap do dai chieu dai hinh chu nhat thu "+count+": ");
        cd = sc.nextDouble();
        System.out.println("Nhap do dai chieu rong hinh chu nha thu "+count+": ");
        cr=sc.nextDouble();
    }
    //Hàm in kết quả
    public void inKetQua(){
        System.out.println("Dien tich hinh chu nhat thu "+count+" la : "+tinhDienTich());
        System.out.println("Chu vi hinh chu nhat thu "+count+" la: "+tinhChuVi());
    }
  
    
    
    
    
    
}
