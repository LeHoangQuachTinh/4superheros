package BT;

public class Dish {
    private String idDish;
    private String nameDish;
    private double price;
    private int quality;

    public Dish(){}
    public Dish(String idDish, String nameDish, double price,int quality) {
        this.idDish = idDish;
        this.nameDish = nameDish;
        this.price = price;
        this.quality=quality;
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

       // Tính giá tổng cộng cho món ăn
    public double getTotalPrice() {
        return price * quality;
    }
    public void giamSoLuong(int soluong) {
        if (soluong <= 0) {
            System.out.println("Số lượng giảm phải lớn hơn 0.");
            return;
        }
    
        if (soluong <= this.quality) {
            this.quality -= soluong; // Cập nhật số lượng sau khi giảm
            // System.out.println("Đã giảm " + soluong + " món '" + this.nameDish + "'. Số lượng còn lại: " + this.quality);
        } else {
            System.out.println("Số lượng cần giảm vượt quá số lượng hiện có (" + this.quality + "). Không thể thực hiện.");
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
}
