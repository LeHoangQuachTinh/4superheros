package Tuan6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class SinhVien{
    private String msv;
    private String name;
    private String date;
    private double dtb;

    SinhVien(){

    };
    SinhVien(String msv,String name,String date,double dtb){
        this.msv=msv;
        this.name=name;
        this.date=date;
        this.dtb=dtb;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập msv:");
        this.msv=sc.nextLine();
        System.out.print("Nhập tên sv:");
        this.name=sc.nextLine();
        System.out.print("Nhập ngày sinh:");
        this.date=sc.nextLine();
        System.out.print("Nhập dtb:");
        this.dtb=sc.nextDouble();
    }
    public void xuat(){
        System.out.println("MSV:"+this.msv);
        System.out.println("Name:"+this.name);
        System.out.println("Date:"+this.date);
        System.out.println("Dtb:"+this.dtb);
        System.out.println();
    }
    public double getDtb(){
        return this.dtb;
    }

    
}
class DSSinhVien{
    List<SinhVien> DS;
    DSSinhVien(){
        DS=new ArrayList<>();
    }
    public void addSinhvien(SinhVien sv)
    {
        this.DS.add(sv);
    }
    public void sapxep(){
       
        int n = DS.size();
        for (int i=0;i<n-1;i++) {
            for (int j=0;j<n-i-1;j++) {
                if (DS.get(j).getDtb() < DS.get(j+1).getDtb()) {
                    SinhVien temp = DS.get(j);
                    DS.set(j,DS.get(j+1));
                    DS.set(j+1,temp);
                }
            }
        }
    }
    public void display(){
        DS.forEach(sv->sv.xuat());
    }
    
}

public class bai2 {
    public static void main(String[] args) {
        DSSinhVien DS=new DSSinhVien();
        double x=9.2;
        while (true) {
            Scanner sc=new Scanner(System.in);
            System.out.println("------------------------------");
            System.out.println("1.Nhập thông tin sinh viên:");
            System.out.println("2.Sắp xếp sinh viên:");
            System.out.println("3.In danh sách sinh viên:");
            System.out.println("4.Thoát!");

            System.out.print("Nhập sự lựa chọn:");
            int n=sc.nextInt();
            switch (n) {
                case 1:
                    {
                        SinhVien sv=new SinhVien();
                        sv.nhap();
                        DS.addSinhvien(sv);
                    }
                    break;
                case 2:
                        DS.sapxep();
                    break;
                case 3:
                        DS.display();
                    break;
                case 4:
                    return;
                default:
                    break;
            }

        }
    }
}
