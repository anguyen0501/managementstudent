/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BangDiem;

/**
 *
 * @author 
 */
public class BangDiem {
    private String masv;
    private String mamh;
    private int lanthi;
    private int heso;
    private float diem;

    public BangDiem() {
    }

    public BangDiem(String masv, String mamh, int lanthi, int heso, float diem) {
        this.masv = masv;
        this.mamh = mamh;
        this.lanthi = lanthi;
        this.heso = heso;
        this.diem = diem;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public int getLanthi() {
        return lanthi;
    }

    public void setLanthi(int lanthi) {
        this.lanthi = lanthi;
    }

    public int getHeso() {
        return heso;
    }

    public void setHeso(int heso) {
        this.heso = heso;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }  
}
