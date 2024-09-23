package Tuan3;

import java.util.Scanner;

public class bai5 {

   public static bool kiemtra(int a,int b,int c){
        if((a+b>c)&&(a+c>b)&&(b+c>a))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập vào 3 cạnh:");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();
        if(kiemtra(a,b,c))
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
            System.out.println("3 cạnh vừa nhập không tạo thành tam giác!");
                        
    }
}
