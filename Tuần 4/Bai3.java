import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mot so duong: ");
        int n = sc.nextInt();
        if(n<0)
            System.out.println("Vui long nhap so nguyen duong");
        else
        {
            long gt=1;
            for (int i=1;i<=n;i++)
                gt*=i;
            System.out.println(+n+"! = "+gt);
        }    
        
    }
    
}
