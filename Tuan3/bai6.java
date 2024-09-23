package Tuan3;
import java.util.Scanner;

public class bai6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Nhập số thứ nhất:");
        double a=sc.nextDouble();
        System.out.print("Nhập số thứ hai:");
        double b=sc.nextDouble();

        System.out.print("Nhập phép tính");
        sc.nextLine();
        String cal=sc.nextLine();
        System.out.println(cal);
        if(cal.equals("+"))
            System.out.printf("%.1f+%..1f=%.2f\n",a,b,a+b);
        else if (cal.equals("-")) 
            System.out.printf("%.1f+%.1f=%.2f\n",a,b,a-b);
        else if(cal.equals("*"))
            System.out.printf("%.1f+%.1f=%.2f\n",a,b,a*b);
        else if(cal.equals("/"))
            System.out.printf("%.1f+%.1f=%.2f\n",a,b,a/b);
        else 
            System.out.println("Error!");

    }
}
