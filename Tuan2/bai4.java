import java.util.Scanner;

public class bai4 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập vào số tiền gửi:");
        double sotiengui=sc.nextDouble();
        System.out.print("Nhập vào lãi suất hàng năm:");
        double laisuat=sc.nextDouble();
        System.out.print("Nhập số tháng gửi:");
        int sothanggui=sc.nextInt();

        double tienlai=sotiengui*(laisuat/100)*(sothanggui/12);
        double tiengocck=sotiengui+tienlai;

        System.out.println("Số tiền lãi là:"+tienlai);
        System.out.println("Số tiền gốc cuối kỳ là:"+tiengocck);

    }
    
}