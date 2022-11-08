/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoVien;

import Check.Check;
import MonHoc.IMonHocDAO;
import MonHoc.MonHoc;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Group3
 */
public class frmGiaoVien extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    ArrayList<MonHoc> listmh = null;
    ArrayList<GiaoVien> listgv = null;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

    public frmGiaoVien() {
        try {
            initComponents();
            dcbm = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("MonHoc.MonHocDAO").newInstance();
            listmh = monHocDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbm.addElement(mh.getMamh());
            }
            jcbgiangday.setModel(dcbm);

            dtm.addColumn("ID Giáo Viên");
            dtm.addColumn("Họ Tên");
            dtm.addColumn("Môn Dạy");
            dtm.addColumn("Ngày Sinh");
            dtm.addColumn("Giới Tính");
            dtm.addColumn("Email");
            dtm.addColumn("Địa Chỉ");
            dtm.addColumn("Số ĐT");
            data();
            // loaddata();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void data() {
        try {
            IGiaoVienDAO giaoVienDAO = (IGiaoVienDAO) Class.forName("GiaoVien.GiaoVienDAO").newInstance();
            listgv = new GiaoVienDAO().getAll();
            for (GiaoVien gv : listgv) {
                dtm.addRow(toObjectsData(gv));
            }
            jtbTTGV.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Object[] toObjectsData(GiaoVien gv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(gv.getNgaysinh());
        boolean flag = gv.isGioitinh();
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }

        Object[] objectsData = {gv.getMagv(), gv.getHotengv(), gv.getMamh(), date, gioitinh, gv.getEmail(), gv.getDiachi(), gv.getSdt()};
        return objectsData;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTTGV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfngaysinh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfHoTen = new javax.swing.JTextField();
        jtfMaGV = new javax.swing.JTextField();
        jtfDienThoai = new javax.swing.JTextField();
        jrbsex = new javax.swing.JRadioButton();
        jtfDiaChi = new javax.swing.JTextField();
        jcbgiangday = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jtbTTGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã GV", "Họ Tên", "Email", "Môn Dạy", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTTGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTTGVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTTGV);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Ngày Sinh");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Giới Tính");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Điện Thoại");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Địa Chỉ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Mã Giảng Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Họ Tên");

        jrbsex.setText("Nam/Nữ");

        jcbgiangday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Môn Giảng Dạy");

        jLabel3.setText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbgiangday, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfDienThoai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jrbsex))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jtfMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jrbsex)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbgiangday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jbUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbUpdate.setForeground(new java.awt.Color(255, 0, 0));
        jbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Update.png"))); // NOI18N
        jbUpdate.setText("Update");
        jbUpdate.setEnabled(false);
        jbUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbDelete.setForeground(new java.awt.Color(255, 0, 0));
        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        jbDelete.setText("Delete");
        jbDelete.setEnabled(false);
        jbDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbDelete.setIconTextGap(2);
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        jbAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbAdd.setForeground(new java.awt.Color(255, 0, 0));
        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        jbAdd.setText("AddNew");
        jbAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jbExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit.setForeground(new java.awt.Color(255, 0, 0));
        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        jbExit.setText("Reset");
        jbExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAdd, jbDelete, jbExit, jbUpdate});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(204, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("THÔNG TIN GIÁO VIÊN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel11)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(jtfMaGV.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfMaGV.setText("");
            jtfMaGV.requestFocus();
            return false;
        } else if (!c.checkSpace(jtfHoTen.getText()) || !c.check(jtfHoTen.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfHoTen.setText("");
            jtfHoTen.requestFocus();
            return false;

        } else if (!c.checkSpace(jtfEmail.getText()) || !c.check(jtfEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Email nhập sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfEmail.setText("");
            jtfEmail.requestFocus();
            return false;

//        } else if (!c.checkSpace(jtfngaysinh.getText()) || !c.check(jtfngaysinh.getText()) || c.checkDate(jtfngaysinh.getText())) {
//            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
//            jtfngaysinh.setText("");
//            jtfngaysinh.requestFocus();
//            return false;

        } else if (!c.checkSpace(jtfDiaChi.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập địa chỉ sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDiaChi.setText("");
            jtfDiaChi.requestFocus();
            return false;

        } else if (!c.checkSpace(jtfDienThoai.getText()) || !c.checkPhone(jtfDienThoai.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập phone sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDienThoai.setText("");
            jtfDienThoai.requestFocus();
            return false;
        }
        return true;
    }
    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        String magv = jtfMaGV.getText();
        String hoten = jtfHoTen.getText();
        String email = jtfEmail.getText();
        String sdt = jtfDienThoai.getText();
        String ngaysinh = jtfngaysinh.getText();
        boolean gioitinh = jrbsex.isSelected();
        String diachi = jtfDiaChi.getText();
        String mamh = listmh.get(jcbgiangday.getSelectedIndex()).getMamh();
        Check c = new Check();
        if (!checkinfo()) {
            return;
        }


        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaysinh.setText("");
            jtfngaysinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        GiaoVien giaoVien = new GiaoVien(magv, hoten, d, gioitinh, email, diachi, sdt, mamh);
        ArrayList<GiaoVien> listCheck = new GiaoVienDAO().CheckID(magv);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            jtfMaGV.setText("");
            jtfMaGV.requestFocus();

        } else {
            GiaoVien insert = new GiaoVienDAO().addNew(giaoVien);
            if (insert != null) {
                showAll();
            }
        }



    }//GEN-LAST:event_jbAddActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        String magv = jtfMaGV.getText();
        String hoten = jtfHoTen.getText();
        String email = jtfEmail.getText();
        String sdt = jtfDienThoai.getText();
        String ngaysinh = jtfngaysinh.getText();
        boolean gioitinh = jrbsex.isSelected();
        String diachi = jtfDiaChi.getText();
        String mamh = listmh.get(jcbgiangday.getSelectedIndex()).getMamh();

        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfngaysinh.setText("");
            jtfngaysinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Nhập ngày sinh sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        GiaoVien giaoVien = new GiaoVien(magv, hoten, d, gioitinh, email, diachi, sdt, mamh);
        GiaoVien update = new GiaoVienDAO().updateByID(giaoVien);
        if (update != null) {
            showAll();
        }
        jbAdd.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        jtfMaGV.setEnabled(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtbTTGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTGVMouseClicked
        jtfMaGV.setText(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 0).toString());
        jtfHoTen.setText(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 1).toString());
        jcbgiangday.setSelectedItem(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 2).toString());
        jtfngaysinh.setText(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 3).toString());
        String sex = jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 4).toString();
        if (sex.equals("true")) {
            jrbsex.setSelected(true);
        } else {
            jrbsex.setSelected(false);
        }
        jtfEmail.setText(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 5).toString());
        jtfDiaChi.setText(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 6).toString());
        jtfDienThoai.setText(jtbTTGV.getValueAt(jtbTTGV.getSelectedRow(), 7).toString());


        jbAdd.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        jtfMaGV.setEnabled(false);
    }//GEN-LAST:event_jtbTTGVMouseClicked
    public void resetForm() {
        jtfMaGV.setText("");
        jtfHoTen.setText("");
        jtfEmail.setText("");
        jtfDiaChi.setText("");
        jtfDienThoai.setText("");
        jtfngaysinh.setText("");
        jtfMaGV.requestFocus();
    }
    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {

            String magv = jtfMaGV.getText();
            try {
                new GiaoVienDAO().deleteIDGV(magv);
            } catch (SQLException ex) {
                Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            data();
            jbAdd.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
            jtfMaGV.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbgiangday;
    private javax.swing.JRadioButton jrbsex;
    private javax.swing.JTable jtbTTGV;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfDienThoai;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfMaGV;
    private javax.swing.JTextField jtfngaysinh;
    // End of variables declaration//GEN-END:variables

    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        int selectedIndex = jcbgiangday.getSelectedIndex();
        MonHoc getmh = listmh.get(selectedIndex);
        ArrayList<GiaoVien> list = new GiaoVienDAO().findByIDMonHoc(getmh.getMamh());
        for (GiaoVien gv : list) {
            Vector vector = new Vector();
            vector.add(gv.getMagv());
            vector.add(gv.getHotengv());
            vector.add(gv.getMamh());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(gv.getNgaysinh()));
            if (gv.isGioitinh() == true) {
                vector.add("Nam");
            } else {
                vector.add("Nữ");
            }
            vector.add(gv.getEmail());
            vector.add(gv.getDiachi());
            vector.add(gv.getSdt());
            dtm.addRow(vector);
        }
        resetForm();

    }
}
