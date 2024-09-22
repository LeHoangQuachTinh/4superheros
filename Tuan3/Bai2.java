import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem trung binh: ");
        double dtb = sc.nextDouble();
        if(dtb>=8.5)
        {
            System.out.println("Xep loai: Gioi");
        }
        else if(dtb>=6.5)
        {
            System.out.println("Xep loai: Kha");
        }
        else if(dtb>=5.0)
        {
            System.out.println("Xep loai: Trung binh");
        }
        else
        {
            System.out.println("Xep loai: Yeu");
        }
    }
}