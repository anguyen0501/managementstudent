/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonHoc;

/**
 *
 * @author Anonymous
 */
public class MonHoc {
    private String mamh;
    private int sotrinh;
    private String tenmh;
    private String hinhthucthi;
    private int hocky;
    private String phonghoc;


    public MonHoc() {
    }

    public MonHoc(String mamh, int sotrinh, String tenmh, String hinhthucthi, int hocky, String phonghoc) {
        this.mamh = mamh;
        this.sotrinh = sotrinh;
        this.tenmh = tenmh;
        this.hinhthucthi = hinhthucthi;
        this.hocky = hocky;
        this.phonghoc = phonghoc;
    }

   

    public int getHocky() {
        return hocky;
    }

    public void setHocky(int hocky) {
        this.hocky = hocky;
    }

    

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public int getSotrinh() {
        return sotrinh;
    }

    public void setSotrinh(int sotrinh) {
        this.sotrinh = sotrinh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public String getHinhthucthi() {
        return hinhthucthi;
    }

    public void setHinhthucthi(String hinhthucthi) {
        this.hinhthucthi = hinhthucthi;
    }



    public String getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }

   

  
    
    
    
    
}
