/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DsCCCD {
    private HashMap<String,CanCuocCongDan> dsCCCD;

    public DsCCCD() {
        dsCCCD =new HashMap<>();
    }

    public CanCuocCongDan kiemTraCanCuocCongDan(String cccd){
        return dsCCCD.get(cccd);
    }
    
    public boolean kiemTraTuoi(LocalDate birthDate) {
        LocalDate hienTai = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthDate, hienTai);
        return age >= 18; 
    }
    
    public void nhap_cccd(Scanner scanner){
        System.out.print("Nhập số căn cước công dân:");
        String cccd = scanner.nextLine();
        if(dsCCCD.get(cccd)==null)
        {
            System.out.print("Nhập họ và tên:");
            String hoTen = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            LocalDate ngaySinh = null;
            boolean tt = false;
            while (!tt) {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                try {
                    ngaySinh = LocalDate.parse(input, formatter);
                    if (kiemTraTuoi(ngaySinh)) {
                        tt = true;
                        System.out.println("Ngày sinh hợp lệ, bạn đã đủ 18 tuổi.");
                    } else {
                        System.out.println("Bạn chưa đủ 18 tuổi. Vui lòng nhập lại.");
                    }
                } 
                catch (DateTimeParseException e) {
                    System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập lại.");
                }
            }
            System.out.print("Nhập giới tính:");
            String gioiTinh=scanner.nextLine();
            System.out.print("Nhập quê quán:");
            String queQuan =scanner.nextLine();
            System.out.print("Nhập dân tộc:");
            String danToc =scanner.nextLine();
            System.out.print("Nhập quốc tịch:");
            String quocTich =scanner.nextLine();
            CanCuocCongDan canCuocCongDan=new CanCuocCongDan(cccd,hoTen, ngaySinh, gioiTinh, queQuan, danToc, quocTich);
            dsCCCD.put(cccd,canCuocCongDan);
            System.out.println("Đã tạo thành công 1 căn cước công dân!");
        }   
        else
            System.out.println("Số căn cước công dân tồn tại trong danh sách cccd!");
        
    }
    
}
