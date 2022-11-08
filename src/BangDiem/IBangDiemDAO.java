/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BangDiem;

import java.util.ArrayList;

/**
 *
 * @author
 */
public interface IBangDiemDAO {
    public ArrayList<BangDiem> getAll();
    public ArrayList<BangDiem> findByIDSinhVien(String masv);
    public ArrayList<BangDiem> findByIDMonHoc(String mamh);
    public BangDiem addNew(BangDiem bd);
    public BangDiem upDate(BangDiem bd);
   public boolean CheckID(String masv, String mamh, int lanthi);
   public ArrayList<BangDiem> findMaMH(String masv);
   public ArrayList<BangDiem> findMasv();
   public ArrayList<BangDiem> loaddiem(String masv, String maMon);
   
    
}
