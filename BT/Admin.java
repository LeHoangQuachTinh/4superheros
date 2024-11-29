package BT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class Admin {
      public  ListRestaurant listRestaurant;
      public  ListCustomer listCustomer;
      public ListShipper listShipper;
      private String maQuanTri;
    
       Admin()
      {
        this.listCustomer=new ListCustomer();
        this.listRestaurant=new ListRestaurant();
        this.maQuanTri="anhem";
      }
      public String getMaQuanTri() {
       return maQuanTri;
       }
       public void setMaQuanTri(String maQuanTri) {
           this.maQuanTri = maQuanTri;
       }
       public void docFileMonAn(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Restaurant nhaHang = null; // Keeps track of the current restaurant
    
            while ((line = reader.readLine()) != null) {
                line = line.trim();
    
                // Skip empty lines or comments
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
    
                // Restaurant information line
                if (line.contains(",")) {
                    String[] nhaHangInfo = line.split(",");
                    String maNhaHang = nhaHangInfo[0].trim();
                    String tenNhaHang = nhaHangInfo[1].trim();
                    String chuNhaHang = nhaHangInfo[2].trim();
                    String matKhauNhaHang = nhaHangInfo[3].trim();
                    String sdtNhaHang = nhaHangInfo[4].trim();
                    String diaChiNhaHang = nhaHangInfo[5].trim();
    
                    // Create a new Restaurant object
                    nhaHang = new Restaurant(matKhauNhaHang, sdtNhaHang, diaChiNhaHang, maNhaHang, tenNhaHang, chuNhaHang);
                    this.listRestaurant.getListNhaHang().put(maNhaHang, nhaHang);
                } 
                // Dish information line
                else if (line.contains(";")) {
                    if (nhaHang == null) {
                        System.out.println("Lỗi: Dòng món ăn xuất hiện trước khi định nghĩa nhà hàng.");
                        continue;
                    }
                    String[] monAnInfo = line.split(";");
                    String idMon = monAnInfo[0].trim();
                    String tenMon = monAnInfo[1].trim();
                    double giaTien = Double.parseDouble(monAnInfo[2].trim());
                    int soLuong = Integer.parseInt(monAnInfo[3].trim());
    
                    // Add the dish to the current restaurant
                    nhaHang.addDish(new Dish(idMon, tenMon, giaTien, soLuong));
                }
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong file: " + e.getMessage());
        }
    }
    
}

    // public void GhiFile() {
    //     try (FileWriter fw = new FileWriter(FileName)) {
    //         for (Staff staff : DS.values()) 
    //         {
    //             String infor = staff.toFileFormat();
    //             fw.write(infor + System.lineSeparator());
    //         }
    //         System.out.println("Ghi file thành công!");
    //     } catch (IOException e) {
    //         StackTraceElement[] stackTrace = e.getStackTrace();
    //         if (stackTrace.length > 0) {
    //             StackTraceElement errorLine = stackTrace[0]; 
    //             System.out.println("Lỗi xảy ra tại lớp: " + errorLine.getClassName());
    //             System.out.println("Phương thức: " + errorLine.getMethodName());
    //             System.out.println("Dòng lệnh: " + errorLine.getLineNumber());
    //         }
    //         System.out.println("Lỗi ghi file: " + e.getMessage());
    //     }
    // }

