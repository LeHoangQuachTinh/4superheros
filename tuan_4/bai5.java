package Tuan4;

import java.util.Scanner;
public class bai5 {
    public static int UCLN(int a,int b)
    {
       while(a!=b)
       {
            if(a>b)
                a=a-b;
            else if(a<b)
                b=b-a;
       }
       return a;

    }
    public static int BCNN(int a,int b){
        return (a*b)/UCLN(a, b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập a,b:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.printf("UCLN của %d và %d là:%d\n",a,b,UCLN(a,b));
        System.out.printf("BCNN của %d và %d là:%d\n",a,b,BCNN(a,b));

    }
}
