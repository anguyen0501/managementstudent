/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LopHoc;

/**
 *
 * @author Group3
 */
public class LopHoc {
    private String malop;
    private String tenlop;
        private String makhoa;
    private String khoahoc;

    public LopHoc() {
    }

    public LopHoc(String malop, String tenlop, String makhoa, String khoahoc) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.makhoa = makhoa;
        this.khoahoc = khoahoc;
    }

   

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }



    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }
    
}
