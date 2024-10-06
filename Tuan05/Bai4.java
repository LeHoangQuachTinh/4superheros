import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    static void In(int[] A){
        for (int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+ " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phan tu trong mang: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Nhap phan tu thu "+(i+1)+": ");
            A[i]=sc.nextInt();
        }
        System.out.print("Mang: ");
        In(A);

        int max = 0;
        int mostNum = A[0];
        for (int i = 0; i < n; i++)
        {
            int dem = 0;
            for (int j = 0; j < n; j++)
            {
                if(A[i]==A[j])
                    dem++;
            }
            if(dem > max)
            {
                max = dem;
                mostNum = A[i];
            }
        }
        System.out.println("\nSo xuat hien nhieu nhat la "+mostNum+" ,xuat hien "+max+" lan");

    }
}
