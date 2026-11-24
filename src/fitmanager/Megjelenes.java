package fitmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.JTableHeader;

public class Megjelenes {

    private static final Color HATTER
            = new Color(233, 245, 243);

    private static final Color TURKIZ
            = new Color(0, 143, 145);

    private static final Color ANTRACIT
            = new Color(24, 52, 62);

    private static final Color KERET
            = new Color(198, 218, 215);

    private static final Color KIJEOLES
            = new Color(204, 237, 231);

    public static void beallit(JFrame ablak) {
        ablak.getContentPane().setBackground(HATTER);
        formaz(ablak.getContentPane());
        ablak.setLocationRelativeTo(null);
    }

    private static void formaz(Container szulo) {

        for (Component elem : szulo.getComponents()) {

            if (elem instanceof JButton) {
                JButton gomb = (JButton) elem;

                gomb.setBackground(TURKIZ);
                gomb.setForeground(Color.WHITE);
                gomb.setFocusPainted(false);
                gomb.setOpaque(true);
                gomb.setBorderPainted(false);
                gomb.setCursor(new Cursor(Cursor.HAND_CURSOR));

            } else if (elem instanceof JLabel) {
                JLabel felirat = (JLabel) elem;

                felirat.setForeground(ANTRACIT);

            } else if (elem instanceof JTextField) {
                JTextField mezo = (JTextField) elem;

                mezo.setBackground(Color.WHITE);
                mezo.setForeground(ANTRACIT);

                mezo.setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(KERET),
                                BorderFactory.createEmptyBorder(
                                        4, 7, 4, 7)
                        )
                );

            } else if (elem instanceof JComboBox) {
                JComboBox lista = (JComboBox) elem;

            } else if (elem instanceof JComboBox) {
            } else if (elem instanceof JComboBox) {
                JComboBox lista = (JComboBox) elem;

                lista.setBackground(Color.WHITE);
                lista.setForeground(ANTRACIT);

                lista.putClientProperty("Nimbus.Overrides.InheritDefaults",
                        Boolean.TRUE);

                lista.setBackground(Color.WHITE);
                lista.setForeground(ANTRACIT);
                lista.setOpaque(true);
                javax.swing.SwingUtilities.updateComponentTreeUI(lista);

                lista.setRenderer(new javax.swing.DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(
                            javax.swing.JList<?> list,
                            Object value,
                            int index,
                            boolean isSelected,
                            boolean cellHasFocus) {

                        Component elem = super.getListCellRendererComponent(
                                list, value, index, isSelected, cellHasFocus);

                        if (index == -1) {
                            elem.setBackground(Color.WHITE);
                            elem.setForeground(ANTRACIT);
                        }

                        return elem;
                    }
                });

            } else if (elem instanceof JTable) {
                JTable tabla = (JTable) elem;

                tabla.setBackground(Color.WHITE);
                tabla.setForeground(ANTRACIT);
                tabla.setRowHeight(27);
                tabla.setGridColor(KERET);
                tabla.setSelectionBackground(KIJEOLES);
                tabla.setSelectionForeground(ANTRACIT);
                tabla.setShowVerticalLines(false);

                JTableHeader fejlec = tabla.getTableHeader();

                fejlec.setBackground(TURKIZ);
                fejlec.setForeground(Color.WHITE);

            } else if (elem instanceof JPanel) {
                JPanel panel = (JPanel) elem;
                panel.setBackground(HATTER);

            } else if (elem instanceof JScrollPane) {
                JScrollPane gorgeto = (JScrollPane) elem;
                gorgeto.setBackground(Color.WHITE);

            } else if (elem instanceof JViewport) {
                JViewport viewport = (JViewport) elem;
                viewport.setBackground(Color.WHITE);
            }

            if (elem instanceof Container) {
                formaz((Container) elem);
            }
        }
    }
}
