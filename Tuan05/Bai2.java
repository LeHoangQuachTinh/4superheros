
import java.util.Scanner;

public class Bai2 {
    static void Trans(int[] A){
        int first = 0;
        int last = A.length - 1;
        while (first < last)
        {
            int tam = A[first];
            A[first]=A[last];
            A[last]=tam;

            first++;
            last--;
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
        System.out.println("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();
        int B[]= new int[n];
        for (int i=1; i<=n;i++)
        {
            System.out.println("Nhap phan tu thu: "+i);
            B[i-1]=sc.nextInt();
        }
        System.out.print("Mang ban dau: ");
        In(B);
        Trans(B);
        System.out.print("\nMang sau khi sap xep la: ");
        In(B);
    }
}
