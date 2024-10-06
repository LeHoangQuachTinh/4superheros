import java.util.Scanner;

public class Bai1 {
    static void In(int[] A){
        for (int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+ " ");
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap kich thuoc cua mang: ");
        int n = sc.nextInt();
        int A[] = new int [n];
        for (int i = 1; i<=n; i++)
        {
            System.out.println("Nhap phan tu thu "+i+": ");
            A[i-1]=sc.nextInt();
        }
        System.out.print("Mang vua nhap la: ");
        In(A);
        int sum = 0;
        for (int i = 1; i<=n; i++)
            sum+=A[i-1];
        System.out.println("\nTong cac phan tu cua mang la: "+sum);

    }
}
