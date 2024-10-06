
package baitaptuan5_1;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
        System.out.println("Mang sau khi dao nguoc la:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        
        scanner.close();
    }
}

    

