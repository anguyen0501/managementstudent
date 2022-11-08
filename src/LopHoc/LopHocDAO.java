/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LopHoc;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group3
 */
public class LopHocDAO implements ILopHocDAO {

    @Override
    public ArrayList<LopHoc> getAll() {
        ArrayList<LopHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblLop");
                rs = ps.executeQuery();
                list = new ArrayList<LopHoc>();
                while (rs.next()) {
                    LopHoc lh = new LopHoc();
                    lh.setMalop(rs.getString(1));
                    lh.setTenlop(rs.getString(2));
                    lh.setMakhoa(rs.getString(3));
                    lh.setKhoahoc(rs.getString(4));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<LopHoc> findByIDKhoa(String maKhoa) {
        ArrayList<LopHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblLop where fldMaKhoa = ?");
               ps.setString(1, maKhoa);
                rs = ps.executeQuery();
                list = new ArrayList<LopHoc>();
                while (rs.next()) {
                    LopHoc lh = new LopHoc();
                    lh.setMalop(rs.getString(1));
                    lh.setTenlop(rs.getString(2));
                    lh.setMakhoa(rs.getString(3));
                    lh.setKhoahoc(rs.getString(4));
                    list.add(lh);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public LopHoc addNew(LopHoc lh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into tblLop(fldMaLop,fldTenLop,fldMaKhoa,fldKhoaHoc) values(?,?,?,?)");
                ps.setString(1, lh.getMalop());
                ps.setString(2, lh.getTenlop());
                ps.setString(3, lh.getMakhoa());
                ps.setString(4, lh.getKhoahoc());
                int row = ps.executeUpdate();
                if (row < 1) {
                    lh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                lh = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return lh;
    }

    @Override
    public LopHoc updateByID(LopHoc lh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblLop set fldTenLop = ?,fldMaKhoa=?, fldKhoaHoc = ? where fldMaLop = ?");
               
                ps.setString(1, lh.getTenlop());
                ps.setString(2, lh.getMakhoa());
                ps.setString(3, lh.getKhoahoc());
                 ps.setString(4, lh.getMalop());
                int row = ps.executeUpdate();
                if (row < 1) {
                    lh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                lh = null;
            } finally {
                DBConnect.close();
            }
        }
        return lh;
    }
    public void deleteLopHoc(String LopID)throws SQLException, ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblLop where fldMaLop= ?");
            ps.setString(1, LopID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<LopHoc> checkID(String malop) {
      ArrayList<LopHoc> list = null;
      PreparedStatement psCheck = null;
      ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblLop where fldMaLop");
                psCheck.setString(1, malop);
                rs = psCheck.executeQuery();
                list = new ArrayList<LopHoc>();
                while (rs.next()) {
                    LopHoc lh = new LopHoc();
                    lh.setMalop(rs.getString(1));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    
}
