package Tuan3;
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Nhập điểm trung bình:");
        float dtb=sc.nextFloat();
        
        if(dtb>=8.5)
            System.out.println("Giỏi!");
        else
            if(dtb>=7)
               System.out.println("Khá!");
            else
                if(dtb>=5.5)
                    System.out.println("Trung bình!");
                else
                      System.out.println("Yếu!");
    
    }
}
