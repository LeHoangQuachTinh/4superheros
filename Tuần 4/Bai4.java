import java.util.Scanner;

public class Bai4 {
    static boolean Songuyento(int n)
    {
        if(n<2)
            return false;
        for(int i = 2; i <= Math.sqrt(n); i++)
                if(n%i==0)
                    return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mot so: ");
        int n = sc.nextInt();
        if(Songuyento(n))
            System.out.println(n+" la so nguyen to");
        else
            System.out.println(n+" khong phai la so nguyen to");
    }
    
}
