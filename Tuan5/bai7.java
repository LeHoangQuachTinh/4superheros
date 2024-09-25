package Tuan5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
class Student{
    String msv;
    String name;
    double dtb;

    Student(String msv,String name,double dtb)
    {
        this.msv=msv;
        this.name=name;
        this.dtb=dtb;
    }
    public void show(){
        System.out.printf("MSV:%s \t Name:%s \t DTB:%.2f\n",msv,name,dtb);
    }
}
class QuanLiHS {
    private List<Student> ST;

    // Constructor to initialize the student list
    public QuanLiHS() {
        ST = new ArrayList<>();
    }

    public void addStudent(Student st) {
        ST.add(st);
    }

    public void deleteStudent(String msv) {
        ST.removeIf(st1 -> st1.msv.equals(msv));
    }

    public List<Student> searchStudent(String msv1) {
        return this.ST.stream().filter(st -> st.msv.contains(msv1)).collect(Collectors.toList());
    }

    public void Display() {
        ST.forEach(st -> st.show());
    }

    public void sortStudent() {
        Collections.sort(ST, (st1, st2) -> Double.compare(st1.dtb, st2.dtb));
    }
}
public class bai7 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        QuanLiHS QLHS=new QuanLiHS();
        while (true) {
            System.out.println("\n-----------------------------");
            System.out.println("Chương trình quản lí học sinh");
            System.out.println("1.Thêm sinh viên");
            System.out.println("2.Xoá sinh viên");
            System.out.println("3.Tìm kiếm sinh viên theo msv");
            System.out.println("4.Sắp xếp sinh viên theo dtb");
            System.out.println("5.Duyệt danh sách sinh viên");
            System.out.println("6.Thoát!");

            int n=sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    {
                    
                        System.out.print("Nhập msv: ");
                        String msv=sc.nextLine();
                        System.out.print("Nhập tên sinh viên:");
                        String name=sc.nextLine();
                        System.out.print("Nhập điểm trung bình:");
                        double dtb=sc.nextDouble();

                        Student ST=new Student(msv, name, dtb);
                        QLHS.addStudent(ST);
                    }
                    break;
                case 2:
                    {
                        System.out.print("Nhập msv cần xoá:");
                        String msv=sc.nextLine();
                        QLHS.deleteStudent(msv);
                    }
                    break;
                case 3:
                    {
                        System.out.println("Nhập msv cần tìm kiếm");
                        String msv=sc.nextLine();
                        if(!QLHS.searchStudent(msv).isEmpty())
                            QLHS.searchStudent(msv).forEach(o->o.show());
                        else 
                            System.out.println("Không tìm thấy!");           
                    }
                    break;
                case 4:
                    {
                        QLHS.sortStudent();
                    }
                    break;
                case 5:
                    {
                        QLHS.Display();
                    }
                    break;
                case 6:
                        return;
                default:
                    System.out.println("Sai!Vui lòng nhập lại");
                    break;
            }
        }


    }
}
