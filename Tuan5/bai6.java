package Tuan5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class bai6 {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
    
 
        while(true)
        {
            System.out.println("Mời bạn đưa ra lựa chọn!");
            System.out.println("1.Thêm một phần tử vào vị trí chỉ định");
            System.out.println("2.Xoá một phần tử tại vị trí chỉ định");
            System.out.println("3.In danh sách");
            System.out.println("4.Thoát!");
            int n=sc.nextInt();
            switch (n) {
                case 1:
                    {
                        System.out.print("Bạn muốn thêm vào phần tử nào:");
                        int value=sc.nextInt();
                        a.add(value);
                    }
                    break;
                case 2:
                    {

                        System.out.print("Bạn muốn xoá vị trí thứ mấy:");
                        int vt=sc.nextInt();
                        a.remove(vt);
                    }
                    break;
                case 3:
                {    for(int i:a)
                        System.out.print(i+" ");
                    System.out.println();
                }
                    break;
                case 4:
                    return;
                    // break;
                default:
                    System.out.println("Không hợp lệ!Vui lòng thử lại");
                    break;
            }
        }
        
    }
}
