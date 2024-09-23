package Tuan4;
import java.util.Scanner;
import java.util.Arrays;
public class bai4 {

    public static boolean ktSnt(int n){
        if(n<2)
          return false;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập n:");
        int n=sc.nextInt();

        // int[] ar=new int[n+1];
        // Arrays.fill(ar,1);
        // ar[0]=ar[1]=0;
        // for(int i=2;i<=Math.sqrt(n);i++)
        //     if(ar[i]==1)
        //         for(int j=i*i;j<=n;j+=i)
        //             ar[j]=0;
        // if(ar[n]==1)
        //     System.out.println(n+" là số nguyên tố!");
        // else
        //     System.out.println(n+" không phải là số nguyên tố!");
        
        if(ktSnt(n))
                  System.out.println(n+" là số nguyên tố!");
        else
                 System.out.println(n+" không phải là số nguyên tố!");

    }
}
