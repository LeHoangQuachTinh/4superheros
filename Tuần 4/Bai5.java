import java.util.Scanner;

public class Bai5 {
    static int Ucln(int a, int b) {
        while(b!=0)
        {
            int tam = b;
            b = a%b;
            a = tam;
        }
        return a;
    }
    static int Bcnn(int a, int b){
        int bcnn= (a*b)/Ucln(a, b);
        return bcnn;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so thu nhat: ");
        int a = sc.nextInt();
        System.out.println("Nhap vao so thu hai: ");
        int b = sc.nextInt();
        System.out.println("Uoc chung lon nhat cua "+a+" va "+b+" la "+Ucln(a,b));
        System.out.println("Boi chung nho nhat cua "+a+" va "+b+" la "+Bcnn(a,b));
    }
}
