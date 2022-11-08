/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LopHoc;

import java.util.ArrayList;

/**
 *
 * @author Group3
 */
public interface ILopHocDAO {
    public ArrayList<LopHoc> getAll();
    public ArrayList<LopHoc> findByIDKhoa(String maKhoa);
    public LopHoc addNew(LopHoc lh);
    public LopHoc updateByID(LopHoc lh);
    public ArrayList<LopHoc> checkID(String malop);
   }
