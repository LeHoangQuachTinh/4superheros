import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, min;
        System.out.println("Nhap so a: ");
        a = sc.nextDouble();
        System.out.println("Nhap so b: ");
        b = sc.nextDouble();
        System.out.println("Nhap so c: ");
        c = sc.nextDouble();
        min = a;
        if (b < min)
        {
            min = b;
        }

        if (c < min)
        {
            min = c;
        }
        System.out.println("So nho nhat trong ba so a, b, c la: "+min);
    }
    
}
