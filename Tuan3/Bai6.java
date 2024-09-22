import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;
        System.out.println("Nhap so thu nhat: ");
        a = sc.nextDouble();
        System.out.println("Nhap so thu hai: ");
        b = sc.nextDouble();
        System.out.println("Lua chon phep tinh:");
        System.out.println("1. Cong: +");
        System.out.println("2. Tru: -");
        System.out.println("3. Nhan: *");
        System.out.println("4. Chia: /");
        System.out.println("Nhap lua chon phep tinh: ");
        int option = sc.nextInt();
        double ketqua;
        if (option == 1)
        {
            ketqua = a + b;
            System.out.println(a+ " + "+b+ " = "+ketqua);
        }
        else if (option == 2)
        {
            ketqua = a - b;
            System.out.println(a+ " - "+b+ " = "+ketqua);
        }
        else if (option == 3)
        {
            ketqua = a*b;
            System.out.println(a+ " * "+b+ " = "+ketqua);
        }
        else if ( option == 4)
        {
            if (b==0)
            {
                System.out.println("Khong the chia cho 0");
            }
            else
            {
                ketqua = a/b;
                System.out.println(a+ " / "+b+ " = "+ketqua);
            }
        }
    }   
}
