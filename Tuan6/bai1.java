package Tuan6;
import java.util.Scanner;
class HinhChuNhat {
    private double chieudai;
    private double chieurong;

    HinhChuNhat(){

    };
    HinhChuNhat(double chieudai,double chieurong)
    {
        this.chieudai=chieudai;
        this.chieurong=chieurong;
    }

    public double dientich(){
        return chieudai*chieurong;
    }
    public double chuvi(){
        return (chieudai+chieudai)*2;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập chiều dài và chiều rộng:");
        this.chieudai=sc.nextDouble();
        this.chieurong=sc.nextDouble();
        
    }
    public void display(){
        System.out.println("Chu vi hình chũ nhật:"+this.chuvi());
        System.out.println("Diện tích hình chữ nhật:"+this.dientich());
      
    }
}
public class bai1 {

        public static void main(String[] args) {
            HinhChuNhat hcn=new HinhChuNhat();
            hcn.nhap();
            hcn.display();
        }
}