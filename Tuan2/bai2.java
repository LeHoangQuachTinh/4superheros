
import java.util.Scanner;
public class bai2 {
    public static void main(String[] args) {
        char[] name={'t','i','n','h'};
        int age=19;
        double height=1.72;
        boolean isLike=true;

        System.out.print("Tên của tôi là:");
        for(char c:name)
            System.out.print(c);
        System.out.println("\nTuổi của tôi là:"+age);
        System.out.println("Chiều cao của tôi là:"+height);
        System.out.println("Có thích lập trình không:"+(isLike ? "Có" :"Không"));
        
    }
}

