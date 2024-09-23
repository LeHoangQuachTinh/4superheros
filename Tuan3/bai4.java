package Tuan3;
import java.util.Scanner;
public class bai4 {

    public static double Min(double a,double b,double c){
        if(a<b && a<c)
                return a;
        else if(b<a && b<c) 
                return b;
        return c;
        // return  (a<b ? (a<c?a:c) : (b<c?b:c));

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Nhập a,b,c:");
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        System.out.println("Số nhỏ nhất là:"+Min(a,b,c));
    }

}
