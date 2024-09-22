import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao mot so: ");
        int num = sc.nextInt();

        // Kiểm tra số là âm, dương hay bằng 0
        if (num > 0) {
            System.out.println(num + " la so duong");
        } else if (num < 0) {
            System.out.println(num + " la so am");
        } else {
            System.out.println("So bang 0");
        }
    }
}
