import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       double sotiengui, laisuat, tongtien, tienlai;
       int sothang;
       System.out.println("Nhap so tien gui: ");
       sotiengui=sc.nextDouble();
       System.out.println("Nhap lai suat hang nam (%): ");
       laisuat=sc.nextDouble();
       System.out.println("Nhap so thang gui: ");
       sothang=sc.nextInt();
       tienlai = (sotiengui * laisuat * sothang)/(12 * 100);
       tongtien = sotiengui + tienlai;
       System.out.printf("So tien lai: %.2f\n", tienlai);
       System.out.printf("So tien goc cuoi ki: %.2f\n", tongtien);
    }
}
