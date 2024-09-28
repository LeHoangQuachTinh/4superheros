import java.util.Scanner;

public class Bai6 {
    static boolean Doixung(int n){
        int goc = n;
        int dao = 0;
        while (n!=0)
        {
            int moi = n%10;
            dao = dao*10+moi;
            n/=10;
        }
        return dao==goc;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao mot so: ");
        int num = sc.nextInt();
        if(Doixung(num))
            System.out.println(num+" la so doi xung");
        else
            System.out.println(num+" khong phai la so doi xung");   
    }
}
