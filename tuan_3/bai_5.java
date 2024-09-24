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
public class bai_5 {
    public static int kiemtra(int a,int b,int c){
        if((a+b>c)&&(a+c>b)&&(b+c>a))
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập vào 3 cạnh:");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();
        if(kiemtra(a,b,c)==1)
        {
            if(a==b&&a==c)
                System.out.println("Đây là tam giác đều");
            else
                if(a==b||a==c||b==c)
                    System.out.println("Đây là tam giác cân");
                else
                    if((a*a)+(b*b)==(c*c)||(a*a)+(c*c)==(b*b)||(c*c)+(b*b)==(a*a))
                        System.out.println("Đây là tam giác vuông");
                    else
                        System.out.println("Đây là tam giác thường");
        }    
        else
            System.out.println("Đây không phải là 3 cạnh của tam giác");
                        
    }
}
