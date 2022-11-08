/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import Check.Check;
import LopHoc.ILopHocDAO;
import LopHoc.LopHoc;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Group3
 */
public class frmSinhVien extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    ArrayList<LopHoc> allClass = null;
    ArrayList<SinhVien> list = null;
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

    public frmSinhVien() {
        try {
            initComponents();
            dcbm = new DefaultComboBoxModel();
            dtm = new DefaultTableModel();
            ILopHocDAO lopHocDAO = (ILopHocDAO) Class.forName("LopHoc.LopHocDAO").newInstance();
            allClass = lopHocDAO.getAll();
            for (LopHoc lh : allClass) {
                dcbm.addElement(lh.getMalop());
            }
            jcblop.setModel(dcbm);

            dtm.addColumn("ID");
            dtm.addColumn("Họ Tên");
            dtm.addColumn("ID Lớp");
            dtm.addColumn("Hệ ĐT");
            dtm.addColumn("Ngày Sinh");
            dtm.addColumn("Địa Chỉ");
            dtm.addColumn("Giới Tính");
            dtm.addColumn("Số ĐT");
            loaddata();
        } catch (InstantiationException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfMaSV = new javax.swing.JTextField();
        jtfHoTen = new javax.swing.JTextField();
        jcblop = new javax.swing.JComboBox();
        jtfHeDaoTao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfDienThoai = new javax.swing.JTextField();
        jrbsex = new javax.swing.JRadioButton();
        jtfDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfngaysinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTTSV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbAdd = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Lớp");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Mã Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Họ Tên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Hệ Đào Tạo");

        jcblop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Số Điện Thoại");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Giới Tính");

        jrbsex.setText("Nam/Nữ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Địa Chỉ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Ngày Sinh");

        jLabel9.setText("(dd/MM/yyyy)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcblop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfHoTen)
                    .addComponent(jtfHeDaoTao, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jtfMaSV))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(jrbsex)
                    .addComponent(jtfDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcblop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHeDaoTao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jrbsex))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jtbTTSV.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Sinh Viên", "Họ Tên", "Lớp", "Hệ Đào Tạo", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTTSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbTTSVMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTTSV);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jbAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbAdd.setForeground(new java.awt.Color(255, 0, 0));
        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        jbAdd.setText("Add");
        jbAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jbUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbUpdate.setForeground(new java.awt.Color(255, 0, 0));
        jbUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
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
        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        jbDelete.setText("Delete");
        jbDelete.setEnabled(false);
        jbDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbDelete.setIconTextGap(2);
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbUpdate)
                    .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAdd, jbDelete, jbExit, jbUpdate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbAdd, jbDelete, jbExit, jbUpdate});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(204, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("THÔNG TIN SINH VIÊN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel10)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loaddata() {
        try {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
            list = new SinhVienDAO().getAll();
            for (SinhVien sv : list) {
                dtm.addRow(toObjectData(sv));
            }
            jtbTTSV.setModel(dtm);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jtbTTSVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTTSVMouseReleased
        // TODO add your handling code here:
        jtfMaSV.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 0).toString());
        jtfHoTen.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 1).toString());
        jcblop.setSelectedItem(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 2).toString());
        jtfHeDaoTao.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 3).toString());
        jtfngaysinh.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 4).toString());
        // jdate.setDateFormatString(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 4).toString());
        jtfDiaChi.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 5).toString());
        jtfDienThoai.setText(jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 7).toString());
        String sex = jtbTTSV.getValueAt(jtbTTSV.getSelectedRow(), 6).toString();
        if (sex.equals("true")) {
            jrbsex.setSelected(true);
        } else {
            jrbsex.setSelected(false);
        }
        jbAdd.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        jtfMaSV.setEnabled(false);
    }//GEN-LAST:event_jtbTTSVMouseReleased

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        String masv = jtfMaSV.getText();
        String tensv = jtfHoTen.getText();
        String hedt = jtfHeDaoTao.getText();
        String diachi = jtfDiaChi.getText();
        String sdt = jtfDienThoai.getText();
        String ngaysinh = jtfngaysinh.getText();
        boolean gioitinh = jrbsex.isSelected();
        String malop = allClass.get(jcblop.getSelectedIndex()).getMalop();
        Check c = new Check();
        if (!checkinfo()) {
            return;
        }


        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.showMessageDialog(null, "Lỗi ngày sinh");
            jtfngaysinh.setText("");
            jtfngaysinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        SinhVien sinhVien = new SinhVien(masv, tensv, malop, diachi, hedt, d, gioitinh, sdt);
        ArrayList<SinhVien> listCheck = new SinhVienDAO().CheckID(masv);
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Mã ID bị trùng. Vui lòng kiểm tra lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jtfMaSV.setText("");
            jtfMaSV.requestFocus();
        } else {

            SinhVien insert = new SinhVienDAO().addNew(sinhVien);

            if (insert != null) {

                showAll();
            }
        }

//        else{
//        JOptionPane.showMessageDialog(this, "Mã ID bị trùng", "vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_jbAddActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        String masv = jtfMaSV.getText();
        String tensv = jtfHoTen.getText();
        String hedt = jtfHeDaoTao.getText();
        String diachi = jtfDiaChi.getText();
        String sdt = jtfDienThoai.getText();
        String ngaysinh = jtfngaysinh.getText();
        // String ngaysinh = jdate.getDateFormatString();
        // String strPattern = "[^a-z ]";
        boolean gioitinh = jrbsex.isSelected();

        String malop = allClass.get(jcblop.getSelectedIndex()).getMalop();

        Check c = new Check();
        if (!checkinfo()) {
            return;
        }

        Date d = null;
        if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY)) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.showMessageDialog(null, "Lỗi ngày sinh");
            jtfngaysinh.setText("");
            jtfngaysinh.requestFocus();
            return;
        } else {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            } catch (ParseException ex) {
                Logger.getLogger(frmSinhVien.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        SinhVien sinhVien = new SinhVien(masv, tensv, malop, diachi, hedt, d, gioitinh, sdt);
        SinhVien updateByID = new SinhVienDAO().updateByID(sinhVien);
        if (updateByID != null) {
            showAll();
        }
        jbAdd.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        jtfMaSV.setEnabled(true);

    }//GEN-LAST:event_jbUpdateActionPerformed
    private static Object[] toObjectData(SinhVien sv) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(sv.getNgaysinh());

        boolean flag = sv.isGioitinh();
        String gioitinh = "Nam";
        if (!flag) {
            gioitinh = "Nữ";
        }
        Object[] objectData = {sv.getMasv(), sv.getTensv(), sv.getMalop(),
            sv.getHedaotao(), date, sv.getDiachi(), gioitinh, sv.getSodt()};
        return objectData;
    }
    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {

                String masv = jtfMaSV.getText();
                new SinhVienDAO().deleteIDSinhVien(masv);
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, "Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                  JOptionPane.showMessageDialog(this, "Sinh viên này có điểm, hãy xóa điểm của sinh viên này trước", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);

            }
            loaddata();
            resetForm();
            jbAdd.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
            jtfMaSV.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed
    public void resetForm() {
        jtfMaSV.setText("");
        jtfHoTen.setText("");
        jtfDienThoai.setText("");
        jtfDiaChi.setText("");
        jtfHeDaoTao.setText("");
        jtfngaysinh.setText("");
        jtfMaSV.requestFocus();
    }

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    private void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);

        }
        int selectedIndex = jcblop.getSelectedIndex();
        LopHoc getLopHoc = allClass.get(selectedIndex);
        ArrayList<SinhVien> svs = new SinhVienDAO().findByIDLop(getLopHoc.getMalop());
        //ArrayList<SinhVien> sinhViens = new SinhVienDAO().CheckID(g)
        for (SinhVien sv : svs) {
            Vector vector = new Vector();
            vector.add(sv.getMasv());
            vector.add(sv.getTensv());
            vector.add(sv.getMalop());
            vector.add(sv.getHedaotao());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(sv.getNgaysinh()));
            vector.add(sv.getDiachi());
            // vector.add(sv.isGioitinh());
            if (sv.isGioitinh() == true) {
                vector.add("Nam");
            } else {
                vector.add("Nữ");
            }
            vector.add(sv.getSodt());
            dtm.addRow(vector);

        }
        resetForm();
    }

    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(jtfMaSV.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfMaSV.setText("");
            jtfMaSV.requestFocus();
            return false;
        } else if (!c.checkSpace(jtfHoTen.getText()) || !c.check(jtfHoTen.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập tên sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfHoTen.setText("");
            jtfHoTen.requestFocus();
            return false;

        } else if (!c.checkSpace(jtfHeDaoTao.getText()) || !c.check(jtfHeDaoTao.getText())) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại nhập hệ đào tạo", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfHeDaoTao.setText("");
            jtfHeDaoTao.requestFocus();
            return false;

//        } else if (!c.checkSpace(jtfngaysinh.getText())|| !c.check(jtfHeDaoTao.getText()) || !c.checkDate(jtfngaysinh.getText())) {
//            JOptionPane.showMessageDialog(this, "Kiểm tra lại ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcblop;
    private javax.swing.JRadioButton jrbsex;
    private javax.swing.JTable jtbTTSV;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfDienThoai;
    private javax.swing.JTextField jtfHeDaoTao;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfMaSV;
    private javax.swing.JTextField jtfngaysinh;
    // End of variables declaration//GEN-END:variables
}
