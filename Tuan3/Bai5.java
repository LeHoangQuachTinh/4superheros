import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        System.out.println("Nhap do dai canh thu nhat : ");
        a = sc.nextDouble();
        System.out.println("Nhap do dai canh thu hai: ");
        b = sc.nextDouble();
        System.out.println("Nhap do dai canh thu ba: ");
        c = sc.nextDouble();
        if (a+b>c && a+c>b && b+c>a)
        {
            System.out.println("Ba canh vua nhap tao thanh mot tam giac");
            if(a==b && a==c )
            {
                System.out.println("Day la tam giac deu");
            }
            else if (a==b || a==c || b==c)
            {
                System.out.println("Day la tam giac can");
            }
            else if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a)
            {
                System.out.println("Day la tam giac vuong");
            }
            else
            {
                System.out.println("Day la tam giac thuong");
            }

        }
        else
        {
            System.out.println("Ba canh khong tao thanh mot tam giac!");
        }

    }
    
}
