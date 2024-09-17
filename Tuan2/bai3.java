import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner (System.in);

         System.out.print("Nhập số nguyên thứ nhất: ");
         int a = sc.nextInt();
         System.out.print("Nhập số nguyên thứ hai: ");
         int b = sc.nextInt();

         System.out.printf("Tổng:%d\n",a+b);
         System.out.printf("Hiệu:%d\n",a-b);
         System.out.printf("Tích:%d\n",a*b);
        if (b != 0) 
        {
             System.out.printf("Thương: %d\n",a/b);
             System.out.printf("Phần dư:%d\n",a%b);
        }
        else
            System.out.println("Error!");
    }
}