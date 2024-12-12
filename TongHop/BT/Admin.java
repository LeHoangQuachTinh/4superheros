package BT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import BT.NganHang.TaiKhoan;
import BT.NganHang.TaiKhoanThanhToan;
import static BT.IListAccount.DS;
class Admin {
    private ListRestaurant listRestaurant;
    private ListCustomer listCustomer;
    private ListShipper listShipper;
    private String maQuanTri;
    private TaiKhoanThanhToan tkGoc;
    private boolean baoTri;


    public HashMap<String, Order> listDH = new HashMap<>();
    Admin() {
        this.listCustomer = new ListCustomer();
        this.listRestaurant = new ListRestaurant();
        this.listShipper = new ListShipper();
        this.maQuanTri = "NHOM4";
        tkGoc = getTaiKhoanThanhToan();
        this.tkGoc.setSodu(5000000);
        this.baoTri = true;
    }

    public ListRestaurant getListRestaurant() {
        return listRestaurant;
    }
    public ListShipper getListShipper() {
        return listShipper;
    }
    public ListCustomer getListCustomer() {
        return listCustomer;
    }


    public boolean isHoatDong() {
        return baoTri;
    }

    public TaiKhoanThanhToan getTkGoc() {
        return tkGoc;
    }

    public void setTkGoc(TaiKhoanThanhToan tkGoc) {
        this.tkGoc = tkGoc;
    }

    public void doiHoatDong() {
        this.baoTri = !baoTri;
    }

    public String getMaQuanTri() {
        return maQuanTri;
    }

    public void setMaQuanTri(String maQuanTri) {
        this.maQuanTri = maQuanTri;
    }

    public TaiKhoanThanhToan getTaiKhoanThanhToan() {
        TaiKhoan tk = DS.searchAcount("00000");
        TaiKhoanThanhToan tktt = (TaiKhoanThanhToan) (tk);
        return tktt;
    }
    public void docFileMonAn(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Restaurant nhaHang = null; 

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("#"))
                    continue;
        
                if (line.contains(",")) {
                    String[] nhaHangInfo = line.split(",");
                    String maNhaHang = nhaHangInfo[0].trim();
                    String tenNhaHang = nhaHangInfo[1].trim();
                    String chuNhaHang = nhaHangInfo[2].trim();
                    String matKhauNhaHang = nhaHangInfo[3].trim();
                    String sdtNhaHang = nhaHangInfo[4].trim();
                    String diaChiNhaHang = nhaHangInfo[5].trim();
                    String STK = nhaHangInfo[6].trim();

                  
                    nhaHang = new Restaurant(matKhauNhaHang, sdtNhaHang, diaChiNhaHang, maNhaHang, tenNhaHang,
                            chuNhaHang, STK);
                    this.listRestaurant.getListNhaHang().put(maNhaHang, nhaHang);
                }
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
                } else if (line.contains(":")) {
                    String[] khachHangInfo = line.split(":");
                    String maKH = khachHangInfo[0].trim();
                    String tenKH = khachHangInfo[1].trim();
                    String matkhau = khachHangInfo[2].trim();
                    String SDT = khachHangInfo[3].trim();
                    String diachi = khachHangInfo[4].trim();
                    String STK = khachHangInfo[5].trim();

                    Customer khachHang = new Customer(maKH, tenKH, matkhau, SDT, diachi, STK);
                    this.listCustomer.getListCustomer().put(maKH, khachHang);
                } else if (line.contains("_")) {
                    String[] vanChuyenInfo = line.split("_");
                    String maNVC = vanChuyenInfo[0].trim();
                    String tenNVC = vanChuyenInfo[1].trim();
                    String matkhau = vanChuyenInfo[2].trim();
                    String SDT = vanChuyenInfo[3].trim();
                    String diachi = vanChuyenInfo[4].trim();
                    String loaiXe = vanChuyenInfo[5].trim();
                    String STK = vanChuyenInfo[6].trim();

                    Shipper nguoiVanChuyen = new Shipper(maNVC, tenNVC, matkhau, SDT, diachi, loaiXe, STK);
                    this.listShipper.getListShipper().put(maNVC, nguoiVanChuyen);
                }
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong file: " + e.getMessage());
        }
    }
 

    public void GhiFile() {
        try (FileWriter fw = new FileWriter("BT/output.txt")) {
            fw.write("\nDanh sách tài khoản nhà hàng" + System.lineSeparator());
            for (Restaurant restaurant : this.listRestaurant.getListNhaHang().values()) {
                String infor = restaurant.toFileFormat();
                fw.write(infor + System.lineSeparator());
            }
            fw.write("\nDanh sách tài khoản khách hàng" + System.lineSeparator());
            for (Customer customer : this.listCustomer.getListCustomer().values()) {
                String infor = customer.toFileFormat();
                fw.write(infor + System.lineSeparator());
            }
            fw.write("\nDanh sách tài khoản shipper" + System.lineSeparator());
            for (Shipper shipper : this.listShipper.getListShipper().values()) {
                String infor = shipper.toFileFormat();
                fw.write(infor + System.lineSeparator());
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace.length > 0) {
                StackTraceElement errorLine = stackTrace[0];
                System.out.println("Lỗi xảy ra tại lớp: " + errorLine.getClassName());
                System.out.println("Phương thức: " + errorLine.getMethodName());
                System.out.println("Dòng lệnh: " + errorLine.getLineNumber());
            }
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

}