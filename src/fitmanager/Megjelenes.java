package fitmanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.JTableHeader;

public class Megjelenes {

    private static final Color HATTER =
            new Color(233, 245, 243);

    private static final Color TURKIZ =
            new Color(0, 143, 145);

    private static final Color ANTRACIT =
            new Color(24, 52, 62);

    private static final Color KERET =
            new Color(198, 218, 215);

    private static final Color KIJELOLES =
            new Color(204, 237, 231);

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
                                BorderFactory.createEmptyBorder(4, 7, 4, 7)
                        )
                );

            } else if (elem instanceof JComboBox) {
                JComboBox<?> lista = (JComboBox<?>) elem;

                lista.setUI(new BasicComboBoxUI() {
                    @Override
                    public void paintCurrentValueBackground(
                            Graphics g,
                            Rectangle bounds,
                            boolean hasFocus) {

                        g.setColor(Color.WHITE);
                        g.fillRect(
                                bounds.x,
                                bounds.y,
                                bounds.width,
                                bounds.height
                        );
                    }

                    @Override
                    protected JButton createArrowButton() {
                        BasicArrowButton nyil = new BasicArrowButton(
                                BasicArrowButton.SOUTH,
                                TURKIZ,
                                TURKIZ,
                                Color.WHITE,
                                TURKIZ
                        );

                        nyil.setBackground(TURKIZ);
                        nyil.setBorder(BorderFactory.createEmptyBorder());
                        nyil.setFocusPainted(false);
                        nyil.setCursor(
                                new Cursor(Cursor.HAND_CURSOR)
                        );

                        return nyil;
                    }
                });

                lista.setBackground(Color.WHITE);
                lista.setForeground(ANTRACIT);
                lista.setOpaque(true);
                lista.setBorder(
                        BorderFactory.createLineBorder(KERET)
                );

                lista.setRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(
                            JList<?> list,
                            Object value,
                            int index,
                            boolean isSelected,
                            boolean cellHasFocus) {

                        super.getListCellRendererComponent(
                                list, value, index,
                                isSelected, cellHasFocus
                        );

                        setOpaque(true);
                        setText(
                                value == null ? "" : value.toString()
                        );

                        if (index == -1) {
                            setBackground(Color.WHITE);
                            setForeground(ANTRACIT);
                        } else if (isSelected) {
                            setBackground(KIJELOLES);
                            setForeground(ANTRACIT);
                        } else {
                            setBackground(Color.WHITE);
                            setForeground(ANTRACIT);
                        }

                        return this;
                    }
                });

            } else if (elem instanceof JTable) {
                JTable tabla = (JTable) elem;

                tabla.setBackground(Color.WHITE);
                tabla.setForeground(ANTRACIT);
                tabla.setRowHeight(27);
                tabla.setGridColor(KERET);
                tabla.setSelectionBackground(KIJELOLES);
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
