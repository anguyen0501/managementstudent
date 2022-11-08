/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import ConnectDatabase.DBConnect;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Group3
 */
public class SinhVienDAO implements ISinhVienDAO {

    @Override
    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblSinhVien");
                rs = ps.executeQuery();

                list = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString(1));
                    sv.setTensv(rs.getString(2));
                    sv.setMalop(rs.getString(3));
                    sv.setHedaotao(rs.getString(4));
                    sv.setNgaysinh(new Date(rs.getDate(5).getTime()));
                    sv.setDiachi(rs.getString(6));

                    sv.setGioitinh(rs.getBoolean(7));

                    sv.setSodt(rs.getString(8));
                    list.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ArrayList<SinhVien> findByIDLop(String maLop) {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblSinhVien where fldMaLop = ?");
                ps.setString(1, maLop);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString(1));
                    sv.setTensv(rs.getString(2));
                    sv.setMalop(rs.getString(3));
                    sv.setHedaotao(rs.getString(4));
                    sv.setNgaysinh(new Date(rs.getDate(5).getTime()));
                    sv.setDiachi(rs.getString(6));
                    sv.setGioitinh(rs.getBoolean(7));
                    sv.setSodt(rs.getString(8));
                    list.add(sv);
                }

            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }

        return list;
    }

    @Override
    public SinhVien addNew(SinhVien sv) {
        PreparedStatement ps = null;

        if (DBConnect.open()) {
            try {

                ps = DBConnect.cnn.prepareStatement("insert into tblSinhVien(fldMaSV,fldHoTen,fldMaLop,fldHeDaoTao,fldNgaySinh,fldDiaChi,fldGioiTinh,fldSDT) values (?,?,?,?,?,?,?,?)");
                ps.setNString(1, sv.getMasv());
                ps.setNString(2, sv.getTensv());
                ps.setNString(3, sv.getMalop());
                ps.setNString(4, sv.getHedaotao());
                ps.setDate(5, new java.sql.Date(sv.getNgaysinh().getTime()));
                ps.setNString(6, sv.getDiachi());
                ps.setBoolean(7, sv.isGioitinh());
                ps.setNString(8, sv.getSodt());
                int row = ps.executeUpdate();
                if (row < 1) {
                    sv = null;
                }

            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                sv = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return sv;

    }

    @Override
    public SinhVien updateByID(SinhVien sv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblSinhVien set fldHoTen = ?, fldMaLop = ?, fldHeDaoTao = ?, fldNgaySinh = ?, fldDiaChi = ?, fldGioiTinh = ?, fldSDT = ? where fldMaSV = ?");
                ps.setString(1, sv.getTensv());
                ps.setString(2, sv.getMalop());
                ps.setString(3, sv.getHedaotao());
                ps.setDate(4, new java.sql.Date(sv.getNgaysinh().getTime()));
                ps.setString(5, sv.getDiachi());
                ps.setBoolean(6, sv.isGioitinh());
                ps.setString(7, sv.getSodt());
                ps.setString(8, sv.getMasv());
                if (ps.executeUpdate() < 1) {
                    sv = null;
                }

            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close();
            }
        }
        return sv;
    }

    public void deleteIDSinhVien(String SinhVienID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblSinhVien where fldMaSV= ?");
            ps.setString(1, SinhVienID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienDAO().findByIDLop("CN4").get(0).getMalop());

    }

    @Override
    public ArrayList<SinhVien> CheckID(String masv) {
        ArrayList<SinhVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblSinhVien where fldMaSV=?");
                psCheck.setString(1, masv);
                rs = psCheck.executeQuery();
                list = new ArrayList<SinhVien>();
                while (rs.next()) {
                    SinhVien sinhVien = new SinhVien();
                    sinhVien.setMasv(rs.getString(1));
                    list.add(sinhVien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;
    }
}
