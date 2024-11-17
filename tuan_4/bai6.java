package Tuan4;
import java.util.Scanner;
public class bai6 {
    //cách 1
   //  public static String reverse(String str) {
   //      StringBuilder sb = new StringBuilder(str);
   //      return sb.reverse().toString();
   //  }
   // public static void main(String[] args) {
   //       Scanner sc=new Scanner(System.in);
   //       System.out.print("Nhập số cần kiểm tra:");
   //       String str=sc.nextLine();
   //       String tmp=reverse(str);

   //      if(str.equals(tmp))
   //          System.out.println(str+" là số đối xứng!");
   //      else
   //          System.out.println(str+" không phải số đối xứng");
   // }

    //cách2
   public static int reverse(int n)
    {
       int num=0;
       while(n!=0){
            int du=a%10;
            num=num*10+du;
            n/=10;
        }
        return num;
    }  
   public static void main(String[] args) {
        System.out.println("Nhập vào một số nguyên:");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(); 
        if(reverse(n)==n)
            System.out.println(n+" là số đối xứng");
        else
            System.out.println(n+" không phải là số đối xứng");
    }

    
}
