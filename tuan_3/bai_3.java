/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập lần lươt 3 hệ số:");
        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
        double c=scanner.nextDouble();
        
        if(a==0)
            if(b==0)
                if(c==0)
                    System.out.println("phương trình vô số nghiệm");
                else
                    System.out.println("phương trình vô nghiệm");
            else
            {
                 double x=-c/b;
                 System.out.println("nghiệm của phương trình:x="+x);
            }  
        else
        {
            double denta=(b*b)-4*a*c;
            if(denta<0)
                System.out.println("phương trình vô nghiệm");
            else
                if(denta==0)
                {
                    double x=-b/(2*a);
                    System.out.println("nghiệm kép của phương trình là:x="+x);
                }   
                else
                {
                    double x1=(-b+Math.sqrt(denta))/(2*a);
                    double x2=(-b-Math.sqrt(denta))/(2*a);
                    System.out.println("nghiệm của phương trình là:x1="+x1+" "+"x2="+x2);
                }
            
        }
        scanner.close();
    }
}
