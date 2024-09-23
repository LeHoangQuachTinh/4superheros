package Tuan5;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class bai5 {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
    
        System.out.print("Nhập số lượng phần tử:");
        int n=sc.nextInt();
        Random rd=new Random();
        for(int i=0;i<n;i++)
            a.add(rd.nextInt(20));
        for(int i:a)
            System.out.print(i+" ");
        
    }
}
