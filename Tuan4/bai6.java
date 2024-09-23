package Tuan4;
import java.util.Scanner;
public class bai6 {
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
   public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         System.out.print("Nhập số cần kiểm tra:");
         String str=sc.nextLine();
         String tmp=reverse(str);

        if(str.equals(tmp))
            System.out.println(str+" là số đối xứng!");
        else
            System.out.println(str+" không phải số đối xứng");
   }

    
}
