public class Bai7 {
    private String maSinhVien;
    private String hoVaTen;
    private int nam;
    private float dtb;
    public Bai7(String maSinhVien, String hoVaTen, int nam, float dtb) {
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.nam = nam;
        this.dtb = dtb;
    }
    public String getMaSinhVien() {
        return maSinhVien;
    }
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public String getHoVaTen() {
        return hoVaTen;
    }
    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
    public int getNam() {
        return nam;
    }
    public void setNam(int nam) {
        this.nam = nam;
    }
    public float getDtb() {
        return dtb;
    }
    public void setDtb(float dtb) {
        this.dtb = dtb;
    }
    
}
