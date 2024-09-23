package Tuan3;

import java.util.Scanner;

public class bai5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = scanner.nextDouble();
        
        if (ktTamgiac(a, b, c)) {
            System.out.println("Ba cạnh tạo thành một tam giác.");
            
            if (ktDeu(a, b, c)) 
                System.out.println("Đây là tam giác đều.");
            else if (ktCan(a, b, c))
                System.out.println("Đây là tam giác cân.");
            else if (ktVuong(a, b, c))
                System.out.println("Đây là tam giác vuông.");
            else 
                System.out.println("Đây là tam giác thường.");
        } 
        else 
            System.out.println("Ba cạnh không tạo thành một tam giác.");
        
    }

    public static boolean ktTamgiac(double a, double b, double c) {
        return (a+b>c) && (a+c>b) && (b+c>a);
    }

    public static boolean ktDeu(double a, double b, double c) {
        return (a==b) && (b==c);
    }

    public static boolean ktCan(double a, double b, double c) {
        return (a==b) || (b==c) || (a==c);
    }

    public static boolean ktVuong(double a, double b, double c) {
        double aSquared = a * a;
        double bSquared = b * b;
        double cSquared = c * c;
        return (aSquared + bSquared == cSquared) || (aSquared + cSquared == bSquared) || (bSquared + cSquared == aSquared);
    }
}
