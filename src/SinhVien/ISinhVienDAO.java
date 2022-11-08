/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import java.util.ArrayList;

/**
 *
 * @author Group3
 */
public interface ISinhVienDAO {
    public ArrayList<SinhVien> getAll();
    public ArrayList<SinhVien>findByIDLop(String maLop);
    public SinhVien addNew(SinhVien sv);
    public SinhVien updateByID(SinhVien sv);
    public ArrayList<SinhVien> CheckID(String masv);
   
  
     
}
