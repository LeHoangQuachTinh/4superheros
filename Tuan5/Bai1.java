
package baitaptuan5_1;

import java.util.*;

public class Bai1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.printf("Nhap vao so phan tu mang:");
        int n = sc.nextInt();
        int [] mang = new int[n];      
        System.out.println("Nhap vao cac phan tu mang:");
        for(int i =0;i<n;i++){
            mang[i] = sc.nextInt();
        }
        int s=0;            
        for(int i=0;i<n;i++){
            s = s + mang[i];
        }
        System.out.println("Tong mang do la:" + s);
        sc.close();
    }
    
}
