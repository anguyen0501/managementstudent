/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BangDiem;

import Check.Check;
import LopHoc.ILopHocDAO;
import LopHoc.LopHoc;
import MonHoc.IMonHocDAO;
import MonHoc.MonHoc;
import SinhVien.ISinhVienDAO;
import SinhVien.SinhVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Group3
 */
public class frmBangDiem extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbmHS;
    private DefaultComboBoxModel dcbmLanThi;
    private DefaultComboBoxModel dcbmMaSV;
    private DefaultComboBoxModel dcbmMaMH;
    private DefaultComboBoxModel dcbmMaLop;
    ArrayList<SinhVien> listsv = null;
    ArrayList<MonHoc> listmh = null;
    ArrayList<BangDiem> listbdiem = null;
    ArrayList<LopHoc> listML = null;

    public frmBangDiem() {
        try {
            initComponents();
            dtm = new DefaultTableModel();
            dcbmHS = new DefaultComboBoxModel();
            dcbmLanThi = new DefaultComboBoxModel();
            dcbmMaSV = new DefaultComboBoxModel();
            dcbmMaMH = new DefaultComboBoxModel();
            dcbmMaLop = new DefaultComboBoxModel();
            new DefaultButtonModel();

            //Load Mon Hoc
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("MonHoc.MonHocDAO").newInstance();
            listmh = monHocDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbmMaMH.addElement(mh.getMamh());
            }
            jcbMaMH.setModel(dcbmMaMH);
            //Load Ma Lop
            ILopHocDAO lopHocDAO = (ILopHocDAO) Class.forName("LopHoc.LopHocDAO").newInstance();
            listML = lopHocDAO.getAll();
            for (LopHoc lopHoc : listML) {
                dcbmMaLop.addElement(lopHoc.getMalop());
            }
            jcbMaLop.setModel(dcbmMaLop);
            //Load Ma sv
            try {
                ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
                listsv = sinhVienDAO.getAll();
                dcbmMaSV.removeAllElements();
                for (SinhVien sv : listsv) {
                    dcbmMaSV.addElement(sv.getMasv());


                }

                jcbMasv.setModel(dcbmMaSV);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Load Lan Thi
            dcbmLanThi.addElement("0");
            dcbmLanThi.addElement("1");
            dcbmLanThi.addElement("2");
            dcbmLanThi.addElement("3");
            dcbmLanThi.addElement("4");
            dcbmLanThi.addElement("5");
            dcbmLanThi.addElement("6");
            jcbLanthi.setModel(dcbmLanThi);

            //Load He So
            dcbmHS.addElement("0");
            dcbmHS.addElement("1");
            dcbmHS.addElement("2");
            dcbmHS.addElement("3");
            dcbmHS.addElement("4");
            jcbHeSo.setModel(dcbmHS);

            //Ten Bang
            dtm.addColumn("Mã Sinh Viên");
            dtm.addColumn("Mã Môn Học");
            dtm.addColumn("Lần Thi");
            dtm.addColumn("Hệ Số");
            dtm.addColumn("Điểm");
            loadData();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadData() {

        try {
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("BangDiem.BangDiemDAO").newInstance();
            listbdiem = bangDiemDAO.getAll();
            for (BangDiem bd : listbdiem) {
                dtm.addRow(toObjectData(bd));

            }
            jtbbangdiem.setModel(dtm);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Object[] toObjectData(BangDiem bd) {
        Object[] objects = {bd.getMasv(), bd.getMamh(), bd.getLanthi(), bd.getHeso(), bd.getDiem()};
        return objects;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtfDiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbLanthi = new javax.swing.JComboBox();
        jcbHeSo = new javax.swing.JComboBox();
        jcbMasv = new javax.swing.JComboBox();
        jcbMaMH = new javax.swing.JComboBox();
        jcbMaLop = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbNew = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbbangdiem = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÔNG TIN ĐIỂM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(330, 330, 330))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Mã Môn Học");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Lần Thi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Hệ Số");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Điểm");

        jcbLanthi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbHeSo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbMaMH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbMaLop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMaLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcbMaLopMouseReleased(evt);
            }
        });
        jcbMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMaLopActionPerformed(evt);
            }
        });
        jcbMaLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbMaLopKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Mã Lớp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbMaMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbMaLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbMasv, 0, 116, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbLanthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(jcbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jcbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jcbLanthi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(30, 30, 30)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        jbNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbNew.setForeground(new java.awt.Color(255, 0, 0));
        jbNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        jbNew.setText("Add");
        jbNew.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExit)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jtbbangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbbangdiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbbangdiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtbbangdiemMouseReleased(evt);
            }
        });
        jtbbangdiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbbangdiemKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtbbangdiem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        if (!checkinfo()) {
            return;
        }
        String diem = jtfDiem.getText();
        int lanthi = jcbLanthi.getSelectedIndex();
        int heso = jcbHeSo.getSelectedIndex();
        String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
        String mamh = listmh.get(jcbMasv.getSelectedIndex()).getMamh();

        float diemsv;
        diemsv = Float.parseFloat(diem);
        if (diemsv > 10 || diemsv < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 9. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (lanthi == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0.Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (heso == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0.Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv);
        boolean result = new BangDiemDAO().CheckID(masv, mamh, lanthi);
        if (result) {
            JOptionPane.showMessageDialog(this, "Dữ liệu bị trùng, vui lòng kiểm tra lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            BangDiem insert = new BangDiemDAO().addNew(bd);
            if (insert != null) {
                showAll();
            }


        }


    }//GEN-LAST:event_jbNewActionPerformed
    public void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        ArrayList<BangDiem> bangDiems = new BangDiemDAO().getAll();
        for (BangDiem bd : bangDiems) {
            Vector v = new Vector();
            v.add(bd.getMasv());
            v.add(bd.getMamh());
            v.add(bd.getLanthi());
            v.add(bd.getHeso());
            v.add(bd.getDiem());
            dtm.addRow(v);
        }
        resetForm();
    }

    public void resetForm() {
        jtfDiem.setText("");
        //   jcbHeSo.setSelectedItem(null);
        //   jcbLanthi.setSelectedItem(null);
        //   jcbMaMH.setSelectedItem(null);
        // jcbMaLop.setSelectedItem(null);
        //    jcbMasv.setSelectedItem(null);

    }
    private void jtbbangdiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbbangdiemKeyReleased
    }//GEN-LAST:event_jtbbangdiemKeyReleased

    private void jtbbangdiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbbangdiemMouseReleased
        jcbMasv.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 0).toString());
        jcbMaMH.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 1).toString());
        jcbLanthi.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 2).toString());
        jcbHeSo.setSelectedItem(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 3).toString());
        jtfDiem.setText(jtbbangdiem.getValueAt(jtbbangdiem.getSelectedRow(), 4).toString());
        jbNew.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        jcbMasv.setEnabled(false);
        jcbMaMH.setEnabled(false);
        jcbLanthi.setEnabled(false);
        jcbMaLop.setEnabled(false);
    }//GEN-LAST:event_jtbbangdiemMouseReleased

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
            String mamh = listmh.get(jcbMasv.getSelectedIndex()).getMamh();
            int lanthi = jcbLanthi.getSelectedIndex();
            try {
                new BangDiemDAO().delBangDiem(masv, mamh, lanthi);
            } catch (SQLException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            loadData();
            jbNew.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
            jcbMasv.setEnabled(true);
            jcbMaMH.setEnabled(true);
            jcbLanthi.setEnabled(true);
            jcbMaLop.setEnabled(true);
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jcbMaLopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMaLopMouseReleased
    }//GEN-LAST:event_jcbMaLopMouseReleased

    private void jcbMaLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMaLopKeyReleased
    }//GEN-LAST:event_jcbMaLopKeyReleased

    private void jcbMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMaLopActionPerformed
        jcbMasv.setSelectedItem("");
        try {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("SinhVien.SinhVienDAO").newInstance();
            listsv = sinhVienDAO.findByIDLop(listML.get(jcbMaLop.getSelectedIndex()).getMalop());
            dcbmMaSV.removeAllElements();
            for (SinhVien sv : listsv) {
                dcbmMaSV.addElement(sv.getMasv());


            }

            jcbMasv.setModel(dcbmMaSV);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbMaLopActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkSpace(jtfDiem.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập điểm sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            jtfDiem.setText("");
            jtfDiem.requestFocus();
            return false;
        }
        return true;
    }
    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        if (!checkinfo()) {
            return;
        }
        String diem = jtfDiem.getText();
        int lanthi = jcbLanthi.getSelectedIndex();
        int heso = jcbHeSo.getSelectedIndex();
        String masv = listsv.get(jcbMasv.getSelectedIndex()).getMasv();
        String mamh = listmh.get(jcbMasv.getSelectedIndex()).getMamh();

        float diemsv;
        diemsv = Float.parseFloat(diem);
        if (diemsv > 10 || diemsv < 0) {
            JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 9. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jtfDiem.requestFocus();
            return;
        }

        if (lanthi == 0) {
            JOptionPane.showMessageDialog(this, "Lần Thi phải lớn hơn 0. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (heso == 0) {
            JOptionPane.showMessageDialog(this, "Hệ số phải lớn hơn 0. Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv);
        BangDiem updateID = new BangDiemDAO().upDate(bd);
        if (updateID != null) {
            showAll();
        }
        jbNew.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        jcbMasv.setEnabled(true);
        jcbMaMH.setEnabled(true);
        jcbLanthi.setEnabled(true);
        jcbMaLop.setEnabled(true);

    }//GEN-LAST:event_jbUpdateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbNew;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox jcbHeSo;
    private javax.swing.JComboBox jcbLanthi;
    private javax.swing.JComboBox jcbMaLop;
    private javax.swing.JComboBox jcbMaMH;
    private javax.swing.JComboBox jcbMasv;
    private javax.swing.JTable jtbbangdiem;
    private javax.swing.JTextField jtfDiem;
    // End of variables declaration//GEN-END:variables
}
