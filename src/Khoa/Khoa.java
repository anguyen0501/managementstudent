/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Khoa;

/**
 *
 * @author Group3
 */
public class Khoa {
    private String makhoa;
    private String tenkhoa;
    private String sdt;

    public Khoa() {
    }

    public Khoa(String makhoa, String tenkhoa, String sdt) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
        this.sdt = sdt;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
