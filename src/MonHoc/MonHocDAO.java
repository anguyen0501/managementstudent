/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonHoc;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anonymous
 */
public class MonHocDAO implements IMonHocDAO {

    @Override
    public ArrayList<MonHoc> getAll() {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblMonHoc");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    MonHoc mh = new MonHoc();
                    mh.setMamh(rs.getString(1));
                    mh.setTenmh(rs.getString(2));
                    mh.setSotrinh(rs.getInt(3));
                    mh.setHinhthucthi(rs.getString(4));
                    mh.setHocky(rs.getInt(5));
                    mh.setPhonghoc(rs.getString(6));

                    list.add(mh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;

    }

    @Override
    public ArrayList<MonHoc> findIDMaMH(String maMH) {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblMonHoc where fldMaMH =?");
                ps.setString(1, maMH);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    MonHoc mh = new MonHoc();
                    mh.setMamh(rs.getString(1));
                    mh.setTenmh(rs.getString(2));
                    mh.setSotrinh(rs.getInt(3));
                    mh.setHinhthucthi(rs.getString(4));
                    mh.setHocky(rs.getInt(5));
                    mh.setPhonghoc(rs.getString(6));

                    list.add(mh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public MonHoc addNew(MonHoc mh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into tblMonHoc(fldMaMH, fldTenMH,fldSoTrinh, fldHinhThucThi,fldHocKy,fldPhongHoc) values (?,?,?,?,?,?)");
                ps.setString(1, mh.getMamh());
                ps.setString(2, mh.getTenmh());
                ps.setInt(3, mh.getSotrinh());
                ps.setString(4, mh.getHinhthucthi());
                ps.setInt(5, mh.getHocky());
                ps.setString(6, mh.getPhonghoc());

                int row = ps.executeUpdate();
                if (row < 1) {
                    mh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                mh = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return mh;
    }

    @Override
    public MonHoc updateByID(MonHoc mh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblMonHoc set fldTenMH=?,fldSoTrinh=?, fldHinhThucThi =?,fldHocKy =?,fldPhongHoc =? where fldMaMH =?");

                ps.setString(1, mh.getTenmh());
                ps.setInt(2, mh.getSotrinh());
                ps.setString(3, mh.getHinhthucthi());
                ps.setInt(4, mh.getHocky());
                ps.setString(5, mh.getPhonghoc());
                ps.setString(6, mh.getMamh());
                int row = ps.executeUpdate();
                if (row < 1) {
                    mh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                mh = null;
            } finally {
                DBConnect.close();
            }
        }
        return mh;
    }

    public void delMonHoc(String MonHocID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblMonHoc where fldMaMH= ?");
            ps.setString(1, MonHocID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<MonHoc> CheckID(String mamh) {
       // throw new UnsupportedOperationException("Not supported yet.");
         ArrayList<MonHoc> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblMonHoc where fldMaMH=?");
               psCheck.setString(1, mamh);
                rs = psCheck.executeQuery();
                    list = new ArrayList<MonHoc>();
                    while (rs.next()) {
                        MonHoc monHoc = new MonHoc();
                        monHoc.setMamh(rs.getString(1));
                        list.add(monHoc);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }
}
