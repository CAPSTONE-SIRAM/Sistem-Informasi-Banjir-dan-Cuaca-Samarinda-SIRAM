/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Model.CuacaHujan;
import Model.CuacaPanas;
import Model.Daerah;
import Model.LevelPanas;
import Model.PotensiBanjir;
import Model.StatusCuaca;
import Util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author User
 */
public class InfoCuacaA extends javax.swing.JFrame {
    private int userId;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InfoCuacaA.class.getName());

    /**
     * Creates new form MenuUtama
     */
    
    public InfoCuacaA() {
        initComponents();
        loadKecamatan();
        cbStatus.setSelectedItem("hujan");
        refreshTable();
        setupTableClick();
    }

    public InfoCuacaA(int userId) {
        initComponents();
        this.userId = userId;
        loadKecamatan();
        cbStatus.setSelectedItem("hujan");
        refreshTable();
        setupTableClick();
    }
    private void loadKecamatan() {
        cbKecamatan.removeAllItems();

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Daerah> daerahList = session.createQuery("FROM Daerah", Daerah.class).list();
        session.close();

        for (Daerah d : daerahList) {
            String nama = null;
            try {
                nama = d.getKecamatan();
            } catch (Exception ex) {
                try { nama = d.getKecamatan(); } catch (Exception e) { nama = "Daerah-" + d.getIdDaerah(); }
            }
            cbKecamatan.addItem(d.getIdDaerah() + " - " + nama);
        }
    }

    private void refreshTable() {
        String status = cbStatus.getSelectedItem().toString();
    if (status.equalsIgnoreCase("panas")) {
        new CuacaPanas().tampilAdmin(tblCuaca);
        jLabel11.setText("Indeks UV");
    } else {
        new CuacaHujan().tampilAdmin(tblCuaca);
        jLabel11.setText("Curah Hujan");
    }
    }
    private void clearForm() {
    txtID.setText("");
    txtTanggal.setText("");
    txtSuhu.setText("");
    txtLembab.setText("");
    txtCurahIndeks.setText("");
    cbKecamatan.setSelectedIndex(0);
}

    private int getSelectedDaerahId() {
        Object sel = cbKecamatan.getSelectedItem();
        if (sel == null) return -1;
        String item = sel.toString();
        try {
            return Integer.parseInt(item.split(" - ")[0].trim());
        } catch (Exception ex) {
            return -1;
        }
    }
    private void setupTableClick() {
    tblCuaca.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int row = tblCuaca.getSelectedRow();
            if (row >= 0) {
                txtID.setText(tblCuaca.getValueAt(row, 0).toString());
                txtSuhu.setText(tblCuaca.getValueAt(row, 3).toString());
                txtLembab.setText(tblCuaca.getValueAt(row, 4).toString());
                txtCurahIndeks.setText(tblCuaca.getValueAt(row, 5).toString());
                txtTanggal.setText(tblCuaca.getValueAt(row, 1).toString());

                // Ambil value kolom kecamatan dari tabel (bisa berupa "id - nama", id saja, atau nama saja)
                Object kolomDaerah = tblCuaca.getValueAt(row, 2);
                if (kolomDaerah != null) {
                    selectKecamatanFromCell(kolomDaerah.toString());
                }
            }
        }
    });
}

private void selectKecamatanFromCell(String cell) {
    if (cell == null) return;

    String idPart = null;
    String namePart = null;
    cell = cell.trim();

    if (cell.contains(" - ")) {
        String[] parts = cell.split(" - ", 2);
        idPart = parts[0].trim();
        namePart = parts[1].trim();
    } else {
        try {
            Integer.parseInt(cell);
            idPart = cell;
        } catch (NumberFormatException ex) {
            namePart = cell;
        }
    }

    for (int i = 0; i < cbKecamatan.getItemCount(); i++) {
        String item = cbKecamatan.getItemAt(i);
        if (item == null) continue;
        String it = item.trim();

        if (idPart != null && it.startsWith(idPart + " - ")) {
            cbKecamatan.setSelectedIndex(i);
            return;
        }
        if (namePart != null && it.endsWith(" - " + namePart) ) {
            cbKecamatan.setSelectedIndex(i);
            return;
        }
        if (namePart != null && it.contains(" - " + namePart)) {
            cbKecamatan.setSelectedIndex(i);
            return;
        }
        if (namePart != null && it.toLowerCase().contains(namePart.toLowerCase())) {
            cbKecamatan.setSelectedIndex(i);
            return;
        }
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuaca = new javax.swing.JTable();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSuhu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLembab = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbKecamatan = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCurahIndeks = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnPerbarui = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 33)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("DAERAH YANG MENGALAMI HUJAN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 590, -1));

        tblCuaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblCuaca.setRowHeight(30);
        jScrollPane1.setViewportView(tblCuaca);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 177, 730, 230));

        cbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "panas", "hujan" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });
        jPanel2.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 109, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("ID Cuaca");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Suhu(°C)");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel2.add(txtSuhu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Kelembapan(%)");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        txtLembab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLembabActionPerformed(evt);
            }
        });
        jPanel2.add(txtLembab, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 110, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Kecamatan");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));
        jPanel2.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 140, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Tanggal (YYYY-MM-DD)");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        cbKecamatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbKecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 140, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Curah Hujan(mm)");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));
        jPanel2.add(txtCurahIndeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 110, 30));

        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 110, 35));

        btnHapus.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 110, 35));

        btnPerbarui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPerbarui.setText("Perbarui");
        btnPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaruiActionPerformed(evt);
            }
        });
        jPanel2.add(btnPerbarui, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 110, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 760, 420));

        btnKembali.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 35));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Logo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KELOLA INFORMASI CUACA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/BG BIRU.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        MenuAdmin MenuAdmin = new MenuAdmin(userId);
        MenuAdmin.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        String status = cbStatus.getSelectedItem().toString();

    if (status.equalsIgnoreCase("panas")) {
        new CuacaPanas().tampilAdmin(tblCuaca);

        jLabel11.setText("Indeks UV");
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/BG PANAS.jpg")));
        jLabel3.setText("Daerah Yang Mengalami Panas");
        jLabel3.setForeground(new java.awt.Color(255, 87, 34));
    } else {
        new CuacaHujan().tampilAdmin(tblCuaca);

        jLabel11.setText("Curah Hujan");
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/BG BIRU.jpg")));
        jLabel3.setText("Daerah Yang Mengalami Hujan");
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
    }

    refreshTable();
    }//GEN-LAST:event_cbStatusActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    if (txtSuhu.getText().isBlank() || txtLembab.getText().isBlank() || txtCurahIndeks.getText().isBlank()) {
        JOptionPane.showMessageDialog(this, "Lengkapi semua data yang diperlukan.");
        return;
    }

    float suhu, kelembapan, curahIndeks;
    try {
        suhu = Float.parseFloat(txtSuhu.getText().trim());
        kelembapan = Float.parseFloat(txtLembab.getText().trim());
        curahIndeks = Float.parseFloat(txtCurahIndeks.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Suhu, kelembapan, dan Curah hujan atau indeks UV harus berupa angka!");
        return;
    }

    String status = cbStatus.getSelectedItem().toString().toLowerCase();

if (status.equals("hujan")) {
    if (suhu < 15 || suhu > 30) {
        JOptionPane.showMessageDialog(this,"Suhu cuaca hujan/dingin harus 15–30°C!");
        return;
    }
} else { // panas
    if (suhu < 30 || suhu > 45) {
        JOptionPane.showMessageDialog(this,"Suhu cuaca panas harus 30–45°C!");
        return;
    }
}

if (kelembapan < 0 || kelembapan > 100) {
    JOptionPane.showMessageDialog(this, "Kelembapan harus 0–100%!");
    return;
}

if (status.equals("hujan")) {
    if (curahIndeks < 0 || curahIndeks > 500) {
        JOptionPane.showMessageDialog(this, "Curah hujan harus 0–500 mm/hari!");
        return;
    }
} else { // panas
    if (curahIndeks < 0 || curahIndeks > 15) {
        JOptionPane.showMessageDialog(this, "Indeks UV harus 0–15!");
        return;
    }
}

    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        int idDaerah = getSelectedDaerahId();
        if (idDaerah == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kecamatan yang valid.");
            return;
        }
        Daerah daerah = session.get(Daerah.class, idDaerah);
        if (daerah == null) {
            JOptionPane.showMessageDialog(this, "Daerah tidak ditemukan.");
            return;
        }

        if (status.equals("hujan")) {
            String potensi;
            if (curahIndeks < 20) potensi = "rendah";
            else if (curahIndeks <= 50) potensi = "sedang";
            else potensi = "tinggi";

            CuacaHujan cuaca = new CuacaHujan();
            cuaca.setSuhu(suhu);
            cuaca.setKelembapan(kelembapan);
            cuaca.setCurahHujan(curahIndeks);
            cuaca.setDaerah(daerah);
            cuaca.setStatusCuaca(StatusCuaca.hujan);
            cuaca.setPotensiBanjir(PotensiBanjir.valueOf(potensi));
            session.persist(cuaca);

        } else { // panas
            String level;
            if (curahIndeks < 3) level = "normal";
            else if (curahIndeks <= 6) level = "tinggi";
            else level = "ekstrem";

            CuacaPanas cuaca = new CuacaPanas();
            cuaca.setSuhu(suhu);
            cuaca.setKelembapan(kelembapan);
            cuaca.setIndeksUV(curahIndeks);
            cuaca.setDaerah(daerah);
            cuaca.setStatusCuaca(StatusCuaca.panas);
            cuaca.setLevelPanas(LevelPanas.valueOf(level));
            session.persist(cuaca);
            
        }

        tx.commit();
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.");
        refreshTable();
        clearForm();

    } catch (Exception ex) {
        if (tx != null) tx.rollback();
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + ex.getMessage());
    } finally {
        if (session != null) session.close();
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (txtID.getText().isBlank()) {
        JOptionPane.showMessageDialog(this, "Pilih data dari tabel terlebih dahulu.");
        return;
    }

    int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus data ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION);

    if (konfirmasi != JOptionPane.YES_OPTION) return;

    Session session = null;
    Transaction tx = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        int idCuaca = Integer.parseInt(txtID.getText());
        String status = cbStatus.getSelectedItem().toString().toLowerCase();

        if (status.equals("hujan")) {
            CuacaHujan cuaca = session.get(CuacaHujan.class, idCuaca);
            if (cuaca != null) session.remove(cuaca);
        } else {
            CuacaPanas cuaca = session.get(CuacaPanas.class, idCuaca);
            if (cuaca != null) session.remove(cuaca);
        }

        tx.commit();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        refreshTable();
        clearForm();
        
    } catch (Exception ex) {
        if (tx != null) tx.rollback();
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaruiActionPerformed
        if (txtID.getText().isBlank()) {
        JOptionPane.showMessageDialog(this, "Pilih data dari tabel terlebih dahulu.");
        return;
    }

    float suhu, kelembapan, curahIndeks;
    LocalDate tanggal;

    try {
        suhu = Float.parseFloat(txtSuhu.getText().trim());
        kelembapan = Float.parseFloat(txtLembab.getText().trim());
        curahIndeks = Float.parseFloat(txtCurahIndeks.getText().trim());
        tanggal = LocalDate.parse(txtTanggal.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Suhu, kelembapan, dan Curah hujan atau indeks UV harus berupa angka!");
        return;
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Tanggal harus format yyyy-MM-dd! \n Contoh 2025-10-02");
        return;
    }

    String status = cbStatus.getSelectedItem().toString().toLowerCase();

if (status.equals("hujan")) {
    if (suhu < 15 || suhu > 30) {
        JOptionPane.showMessageDialog(this,
        "Suhu cuaca hujan/dingin harus 15–30°C!");
        return;
    }
} else { // panas
    if (suhu < 30 || suhu > 45) {
        JOptionPane.showMessageDialog(this,
        "Suhu cuaca panas harus 30–45°C!");
        return;
    }

    }
    if (kelembapan < 0 || kelembapan > 100) {
        JOptionPane.showMessageDialog(this, "Kelembapan harus 0–100%!");
        return;
    }

if (status.equals("hujan")) {
    if (curahIndeks < 0 || curahIndeks > 500) {
        JOptionPane.showMessageDialog(this, "Curah hujan harus 0–500 mm/hari!");
        return;
    }
} else {
    if (curahIndeks < 0 || curahIndeks > 15) {
        JOptionPane.showMessageDialog(this, "Indeks UV harus 0–15!");
        return;
    }
}


    Session session = null;
    Transaction tx = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        int idCuaca = Integer.parseInt(txtID.getText());
        int idDaerah = getSelectedDaerahId();

        if (idDaerah == -1) {
            JOptionPane.showMessageDialog(this, "Pilih Daerah yang valid!");
            return;
        }

        Daerah daerah = session.get(Daerah.class, idDaerah);
        if (daerah == null) {
            JOptionPane.showMessageDialog(this, "Daerah tidak ditemukan di database.");
            return;
        }

        if (status.equals("hujan")) {
            CuacaHujan cuaca = session.get(CuacaHujan.class, idCuaca);
            if (cuaca == null) throw new Exception("Data hujan tidak ditemukan!");

            String potensi;
            if (curahIndeks < 20) potensi = "rendah";
            else if (curahIndeks <= 50) potensi = "sedang";
            else potensi = "tinggi";

            cuaca.setTanggal(tanggal);
            cuaca.setSuhu(suhu);
            cuaca.setKelembapan(kelembapan);
            cuaca.setCurahHujan(curahIndeks);
            cuaca.setPotensiBanjir(PotensiBanjir.valueOf(potensi));
            cuaca.setDaerah(daerah);
            

            session.merge(cuaca);

        } else {
            CuacaPanas cuaca = session.get(CuacaPanas.class, idCuaca);
            if (cuaca == null) throw new Exception("Data panas tidak ditemukan!");

            String level;
            if (curahIndeks < 3) level = "normal";
            else if (curahIndeks <= 6) level = "tinggi";
            else level = "ekstrem";

            cuaca.setTanggal(tanggal);
            cuaca.setSuhu(suhu);
            cuaca.setKelembapan(kelembapan);
            cuaca.setIndeksUV(curahIndeks);
            cuaca.setLevelPanas(LevelPanas.valueOf(level));
            cuaca.setDaerah(daerah);

            session.merge(cuaca);
        }

        tx.commit();
        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
        refreshTable();
        clearForm();

    } catch (Exception ex) {
        if (tx != null) tx.rollback();
        JOptionPane.showMessageDialog(this, "Gagal memperbarui: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    }//GEN-LAST:event_btnPerbaruiActionPerformed

    private void txtLembabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLembabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLembabActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPerbarui;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbKecamatan;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuaca;
    private javax.swing.JTextField txtCurahIndeks;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLembab;
    private javax.swing.JTextField txtSuhu;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
