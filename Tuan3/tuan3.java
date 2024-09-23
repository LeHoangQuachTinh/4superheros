package Tuan3;
import java.util.Scanner;

public class tuan3 {
   
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a,b,c,x1,x2,denlta;
        System.out.println("Nhập a:");
        a=sc.nextFloat();
        System.out.println("Nhập b:");
        b=sc.nextFloat();
        System.out.println("Nhập c:");
        c=sc.nextFloat();

        denlta=(b*b)-(4*a*c);
        if(denlta<0)
            System.out.println("Phương trình vô nghiệm!");
        else if(denlta==0)
            System.out.printf("Phương trình có nghiệm duy nhất x1=x2=%.2f\n",b/(2*a));
        else
        {
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            x1=(-b+Math.sqrt(denlta))/(2*a);
            x2=(-b-Math.sqrt(denlta))/(2*a);
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
        }
    }
}
