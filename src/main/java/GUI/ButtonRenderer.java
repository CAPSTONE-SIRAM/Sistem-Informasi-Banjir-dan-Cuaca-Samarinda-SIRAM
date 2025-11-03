/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author User
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        boolean hasPhoto = (value instanceof byte[] && ((byte[]) value).length > 0);

        setText(hasPhoto ? "Lihat Foto" : "Tidak Ada");
        setEnabled(hasPhoto);

        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(Color.BLACK);
            setBackground(UIManager.getColor("Button.background"));
        }
        return this;
    }
}
