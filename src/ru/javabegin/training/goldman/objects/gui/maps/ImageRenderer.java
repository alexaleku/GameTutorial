package ru.javabegin.training.goldman.objects.gui.maps;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import ru.javabegin.training.goldman.abstracts.AbstractGameObject;


public class ImageRenderer extends DefaultTableCellRenderer {

    private JLabel lbl = new JLabel();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        lbl.setText(null);
        lbl.setIcon(((AbstractGameObject) value).getIcon());
        
        return lbl;
    }
}