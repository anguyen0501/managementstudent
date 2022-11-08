/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoVien;

import MonHoc.MonHoc;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Group3
 */
public class GiaoVien {
    private String magv;
    private String hotengv;
    private Date ngaysinh;
    private boolean  gioitinh;
    private String email;
    private String diachi;
    private String sdt;
    private String mamh;
    private ArrayList<MonHoc> listMh;

    public ArrayList<MonHoc> getListMh() {
        return listMh;
    }

    public void setListMh(ArrayList<MonHoc> listMh) {
        this.listMh = listMh;
    }
    
    

    public GiaoVien() {
    }

    public GiaoVien(String magv, String hotengv, Date ngaysinh, boolean gioitinh, String email, String diachi, String sdt, String mamh) {
        this.magv = magv;
        this.hotengv = hotengv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.email = email;
        this.diachi = diachi;
        this.sdt = sdt;
        this.mamh = mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getMamh() {
        return mamh;
    }



    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getHotengv() {
        return hotengv;
    }

    public void setHotengv(String hotengv) {
        this.hotengv = hotengv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
