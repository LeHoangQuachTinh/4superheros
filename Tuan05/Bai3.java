import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {
    static void Sapxep(int[] A){
        int n = A.length;
        for (int i = 0; i<n-1; i++)
            for (int j = 0; j<n-i-1; j++)
            {
                if(A[j]>A[j+1])
                {
                    int tam = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tam;
                }
            }
    }
    static void In(int[] A){
        for (int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+ " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
        {
            System.out.println("Nhap phan tu thu "+(i+1)+": ");
            A[i]=sc.nextInt();
        }
        System.out.print("Mang ban dau la: ");
        In(A);
        Sapxep(A);
        System.out.print("\nMang sap xep theo thu tu tang dan la: ");
        In(A);
    }
}
