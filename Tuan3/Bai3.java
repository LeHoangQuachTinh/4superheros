import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d, x1, x2, x;
        System.out.println("Nhap he so thu nhat:" );
        a = sc.nextDouble();
        System.out.println("Nhap he so thu hai: ");
        b = sc.nextDouble();
        System.out.println("Nhap he so thu ba: ");
        c = sc.nextDouble();
        if(a==0)
        {
            System.out.println("Day khong phai la phuong trinh bac 2!");
            if(b!=0)
            {
                x = -c / b;
                System.out.println("Phuong trinh bac nhat co nghiem la: "+x);
            }
            else if(c==0)
            {
                System.out.println("Phuong trinh co vo so nghiem!");
            }
            else 
            {
                System.out.println("Phuong trinh vo nghiem!");
            }
        }
        else {
            d = b * b - 4 * a * c;
            if(d>0)
            {
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("Phuong trinh bac hai co hai nghiem phan biet: ");
                System.out.println("x1 = "+x1);
                System.out.println("x2 = "+x2);
            }
            else if(d==0)
            {
                x = -b / 2*a;
                System.out.println("Phuong trinh bac hai co nghiem kep: ");
                System.out.println("x = "+x);
            }
            else
            {
                System.out.println("Phuong trinh vo nghiem!");
            }
        }
    }
}
