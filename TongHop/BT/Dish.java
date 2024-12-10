package BT;

public class Dish {
    private String idDish;
    private String nameDish;
    private double price;
    private int quality;
    private boolean uuDai;
    private double giamGia;
    private boolean isBestSeller;
    private long discountDeadline;


    public Dish(String idDish, String nameDish, double price, int quality) {
        this.idDish = idDish;
        this.nameDish = nameDish;
        this.price = price;
        this.quality = quality;
        this.uuDai = false;
        this.giamGia = 0;
    }

    public String getNameDish() {
        return nameDish;
    }

    public String getIdDish() {
        return idDish;
    }

    public double getPrice() {
        return price;
    }

    public void setIdDish(String idDish) {
        this.idDish = idDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public boolean isUuDai() {
        return uuDai;
    }

    public void setUuDai(boolean uuDai, double giamGia, long tgian) {
        this.uuDai = uuDai;
        if (uuDai) {
            this.giamGia = giamGia;
            this.discountDeadline = System.currentTimeMillis() + tgian;
            batDauDemNguoc(tgian);
        } else {
            this.giamGia = 0;
            this.discountDeadline = 0;
        }
    }

    public void setUuDai(boolean uuDai, double giamGia) {
        this.uuDai = uuDai;
        if (uuDai) {
            this.giamGia = giamGia;
        } else {
            this.giamGia = 0;
        }
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double giaGiam() {
        return price * (1 - giamGia / 100);
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    // Tính giá tổng cộng cho món ăn
    public double getTotalPrice() {
        return giaGiam() * quality;
    }

    public void giamSoLuong(int soluong) {
        if (soluong <= 0) {
            System.out.println("Số lượng giảm phải lớn hơn 0.");
            return;
        }

        if (soluong <= this.quality) {
            this.quality -= soluong; // Cập nhật số lượng sau khi giảm
            System.out
                    .println("Đã giảm " + soluong + " món '" + this.nameDish + "'. Số lượng còn lại: " + this.quality);
        } else {
            System.out.println(
                    "Số lượng cần giảm vượt quá số lượng hiện có (" + this.quality + "). Không thể thực hiện.");
        }
    }

    public void tangSoLuong(int soluong) {
        if (soluong <= 0) {
            System.out.println("Số lượng tăng phải lớn hơn 0.");
            return;
        }
        // Tăng số lượng món ăn
        this.quality += soluong;
        System.out.println("Đã tăng " + soluong + " món '" + this.nameDish + "'. Số lượng hiện tại: " + this.quality);
    }

    public double giaSauKhiGiam() {
        return uuDai ? price * (1 - giamGia / 100) : price;
    }

    public String displayDish() {
        // Xác định cờ best seller
        String bestSellerFlag = isBestSeller() ? " <<BEST SELLER>>" : "";

        // Kiểm tra thời hạn ưu đãi
        String trangThaiGiamGia = uuDai ? "Đang giảm" : "Không giảm";
        if (uuDai && System.currentTimeMillis() > discountDeadline) {
            trangThaiGiamGia = "Hết hạn";
            this.uuDai = false;
            this.giamGia = 0;
        }

        // Tính giá sau khi giảm (nếu có)
        double discountedPrice = giaSauKhiGiam(); // Tính giá sau khi giảm giá nếu có
        String discountPercentage = uuDai ? String.format("%.0f%%", giamGia) : "0%"; 
        return String.format("| %-10s | %-40s | %-15.0f | %-8d | %-8s | %-15.0f | %-10s |",
                idDish, nameDish + bestSellerFlag, price, quality, discountPercentage, discountedPrice,
                trangThaiGiamGia);
    }

    public long getDiscountDeadline() {
        return discountDeadline;
    }

    public void setDiscountDeadline(long deadline) {
        this.discountDeadline = deadline;
    }

    private void batDauDemNguoc(long tgian) {
        new Thread(() -> {
            try {
                Thread.sleep(tgian);
                this.uuDai = false;
                this.giamGia = 0;
                this.discountDeadline = 0;
                System.out.println("Ưu đãi của món " + this.getNameDish() + " đã hết hạn. Giá quay về giá gốc!");
            } catch (Exception e) {
                System.out.println("Lỗi khi thiết lập thời hạn ưu đãi!");
            }
        }).start();
    }

}
