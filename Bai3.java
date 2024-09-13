import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);

         // Nhập vào hai số nguyên
         System.out.print("Nhập số nguyên thứ nhất: ");
         int num1 = sc.nextInt();
         System.out.print("Nhập số nguyên thứ hai: ");
         int num2 = sc.nextInt();
 
         // Tính toán tổng, hiệu, tích, thương và phần dư
         int tong = num1 + num2;
         int hieu = num1 - num2;
         int tich = num1 * num2;
         double thuong = 0;
         int du = 0;
 
         // Kiểm tra chia cho 0
         if (num2 != 0) {
            thuong = (double) num1 / num2;
            du = num1 % num2;
         } 
         else
            System.out.println("Không thể chia cho 0.");
 
         // In kết quả ra màn hình
         System.out.println("Tổng: " +tong);
         System.out.println("Hiệu: " +hieu);
         System.out.println("Tích: " +tich);
         
         if (num2 != 0) 
        {
             System.out.printf("Thương: %.2f\n", thuong);
             System.out.println("Phần dư: " +du);
        }
    }
}
