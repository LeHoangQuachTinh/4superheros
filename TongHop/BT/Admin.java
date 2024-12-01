package BT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class Admin {
      public  ListRestaurant listRestaurant;
      public  ListCustomer listCustomer;
      public  ListShipper listShipper;
      private String maQuanTri;
    
       Admin()
      {
        this.listCustomer=new ListCustomer();
        this.listRestaurant=new ListRestaurant();
        this.listShipper=new ListShipper();
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
                    String STK = nhaHangInfo[6].trim();
    
                    // Create a new Restaurant object
                    nhaHang = new Restaurant(matKhauNhaHang, sdtNhaHang, diaChiNhaHang, maNhaHang, tenNhaHang, chuNhaHang,STK);
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
                else if(line.contains(":")){
                    String[] khachHangInfo = line.split(":");
                    String maKH=khachHangInfo[0].trim();
                    String tenKH=khachHangInfo[1].trim();
                    String matkhau=khachHangInfo[2].trim();
                    String SDT=khachHangInfo[3].trim();
                    String diachi=khachHangInfo[4].trim();
                    String STK=khachHangInfo[5].trim();

                    Customer khachHang=new Customer(maKH, tenKH, matkhau, SDT, diachi,STK);
                    this.listCustomer.getListCustomer().put(maKH, khachHang);
                }
                else if(line.contains("|")){
                    String[] vanChuyenInfo = line.split("|");
                    String maNVC=vanChuyenInfo[0].trim();
                    String tenNVC=vanChuyenInfo[1].trim();
                    String matkhau=vanChuyenInfo[2].trim();
                    String SDT=vanChuyenInfo[3].trim();
                    String diachi=vanChuyenInfo[4].trim();
                    String STK=vanChuyenInfo[5].trim();

                    Shipper nguoiVanChuyen=new Shipper(maNVC, tenNVC, matkhau,SDT, diachi, STK);
                    this.listShipper.getListShipper().put(maNVC, nguoiVanChuyen);
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

