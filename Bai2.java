import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        double height;
        boolean question = true;
        System.out.println("Nhap ten cua ban: ");
        name = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        age = sc.nextInt();
        System.out.println("Nhap chieu cao: ");
        height = sc.nextDouble();
        System.out.println("Ban co thich lap trinh khong? ");
        question=sc.nextBoolean();
        System.out.println("Ten: "+name);
        System.out.println("Tuoi: "+age);
        System.out.println("Chieu cao:"+height);
        System.out.println("Co thich lap trinh khong: "+question);


    }
}
