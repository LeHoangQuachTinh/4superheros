package Tuan5;

import java.util.Scanner;
import java.util.Random;

import java.util.Arrays;
public class bai3 {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử:");
        int n=sc.nextInt();
        int[] a=new int[n];
        Random rand=new Random();
        for(int i=0;i<n;i++)
             a[i]=rand.nextInt(20);
        MereSort(a, 0, n-1);

        System.out.println();
        for(int i:a)
            System.out.print(i+" ");
    }

    public static void Merge(int a[],int l,int m,int r){
        int[] x=Arrays.copyOfRange(a,l,m+1);
        int[] y=Arrays.copyOfRange(a,m+1,r+1);
        int i=0;
        int j=0;
        while(i<x.length && j<y.length)
        {
            if(x[i]<y[j])
            {
                a[l]=x[i];
                l++;
                i++;
            }
            else
            {
                a[l]=y[j];
                l++;
                j++;
            }
          
        }
        while(i<x.length)
        {
            a[l]=x[i];
            l++;
            i++;
        }
        while(j<y.length)
        {
            a[l]=y[j];
            l++;
            j++;
        }
    }
    public static void MereSort(int a[],int l,int r)
    {
        if(l>=r)
            return;
        int m=(l+r)/2;
        MereSort(a,l,m);
        MereSort(a,m+1,r);
        Merge(a,l,m,r);
    }
}
