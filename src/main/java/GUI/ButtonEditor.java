/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author User
 */
public class ButtonEditor extends DefaultCellEditor {

    private final JButton button;
    private byte[] fotoBytes;
    private final int photoColumnIndex;

    public ButtonEditor(JCheckBox checkBox, int columnIndex) {
        super(checkBox);
        this.photoColumnIndex = columnIndex;

        button = new JButton("Lihat Foto");
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // ✅ Validasi: jika tidak ada foto, tampilkan pesan
                if (fotoBytes == null || fotoBytes.length == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Foto tidak tersedia",
                            "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                    fireEditingStopped();
                    return;
                }

                ImageIcon icon = new ImageIcon(fotoBytes);
Image image = icon.getImage();

// Ambil ukuran layar
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int maxWidth = screenSize.width - 200;
int maxHeight = screenSize.height - 200;

// Ukuran asli foto
int imgWidth = icon.getIconWidth();
int imgHeight = icon.getIconHeight();

// Hitung skala jika foto lebih besar dari layar
if (imgWidth > maxWidth || imgHeight > maxHeight) {
    double scale = Math.min((double) maxWidth / imgWidth, (double) maxHeight / imgHeight);
    imgWidth = (int) (imgWidth * scale);
    imgHeight = (int) (imgHeight * scale);
    image = image.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
}

// Tampilkan foto dengan ukuran final
JLabel label = new JLabel(new ImageIcon(image));
JScrollPane scrollPane = new JScrollPane(label);

JFrame frame = new JFrame("Preview Foto");
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.add(scrollPane);

// Sesuaikan ukuran frame dengan foto
frame.setSize(imgWidth + 50, imgHeight + 80);
frame.setLocationRelativeTo(null);
frame.setVisible(true);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {

        fotoBytes = null;
    Object obj = table.getValueAt(row, photoColumnIndex);

    if (obj instanceof byte[] && ((byte[]) obj).length > 0) {
        fotoBytes = (byte[]) obj;
        button.setEnabled(true);
        button.setText("Lihat Foto");
    } else {
        button.setEnabled(false);
        button.setText("Tidak Ada");
    }

    return button;
}

    @Override
public Object getCellEditorValue() {
    return fotoBytes; // Kembalikan data asli, bukan string!
}

@Override
public boolean stopCellEditing() {
    return super.stopCellEditing(); // pastikan tidak merusak value
}
}
