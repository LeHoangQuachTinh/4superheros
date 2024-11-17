package order_online;

public class Dish {
    private String idDish;
    private String nameDish;
    private double price;
    private int quality;

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
}
