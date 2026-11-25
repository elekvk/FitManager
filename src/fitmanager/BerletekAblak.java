/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitmanager;

/**
 *
 * @author User
 */
public class BerletekAblak extends javax.swing.JFrame {

    public BerletekAblak() {
        initComponents();
        tagokBetoltese();
        berletTipusokBetoltese();
        berletekListaFrissitese();
        Megjelenes.beallit(this);
        allapotokSzinezese();
        elrendezesBeallitasa();
    }

    private void elrendezesBeallitasa() {

        javax.swing.GroupLayout layout
                = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabel5, 300, 300, 300)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(cmbTagok, 300, 300, 300)
                                                .addComponent(jLabel3)
                                                .addComponent(txtKezdoDatum, 300, 300, 300))
                                        .addGap(178)
                                        .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(cmbBerletTipus, 300, 300, 300)
                                                .addComponent(jLabel4)
                                                .addComponent(txtLejaratiDatum, 300, 300, 300)))
                                .addComponent(btnBerletMentese, 136, 136, 136)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, 150, 150, 150)
                                        .addGap(18)
                                        .addComponent(txtBerletKereses, 610, 610, 610))
                                .addComponent(jScrollPane1, 778, 778, 778))
                        .addContainerGap(12, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(35)
                        .addComponent(jLabel5, 46, 46, 46)
                        .addGap(18)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, 28, 28, 28)
                                .addComponent(jLabel2, 28, 28, 28))
                        .addGap(14)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbTagok,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbBerletTipus,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, 24, 24, 24)
                                .addComponent(jLabel4, 24, 24, 24))
                        .addGap(12)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtKezdoDatum,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLejaratiDatum,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18)
                        .addComponent(btnBerletMentese, 35, 35, 35)
                        .addGap(12)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtBerletKereses,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addComponent(jScrollPane1, 150, 235, Short.MAX_VALUE)
                        .addGap(20)
        );

        setMinimumSize(new java.awt.Dimension(830, 600));
        setSize(900, 650);
        setLocationRelativeTo(null);
    }

    private void allapotokSzinezese() {
        tblBerletek.getColumnModel().getColumn(5).setCellRenderer(
                new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable tabla,
                    Object ertek,
                    boolean kijelolt,
                    boolean fokusz,
                    int sor,
                    int oszlop) {

                super.getTableCellRendererComponent(
                        tabla, ertek, kijelolt, fokusz, sor, oszlop);

                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                setFont(getFont().deriveFont(java.awt.Font.BOLD));

                if (!kijelolt) {
                    String allapot = String.valueOf(ertek);

                    if ("Aktív".equals(allapot)) {
                        setForeground(new java.awt.Color(0, 130, 70));
                    } else if ("Lejárt".equals(allapot)) {
                        setForeground(new java.awt.Color(190, 45, 45));
                    } else {
                        setForeground(new java.awt.Color(110, 110, 110));
                    }
                }

                return this;
            }
        }
        );
    }

    private void berletTipusokBetoltese() {
        cmbBerletTipus.removeAllItems();

        cmbBerletTipus.addItem("Napijegy");
        cmbBerletTipus.addItem("Heti bérlet");
        cmbBerletTipus.addItem("Havi bérlet");
        cmbBerletTipus.addItem("Háromhavi bérlet");
        cmbBerletTipus.addItem("Éves bérlet");

        cmbBerletTipus.setSelectedIndex(-1);
    }

    private void tagokBetoltese() {
        cmbTagok.removeAllItems();

        try {
            java.util.List<String> tagok
                    = AdatbazisKezelo.tagokNeveiLekerdezese();

            for (String tag : tagok) {
                cmbTagok.addItem(tag);
            }

            cmbTagok.setSelectedIndex(-1);

        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Nem sikerült betölteni a tagokat: "
                    + ex.getMessage(),
                    "Adatbázishiba",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void berletekListaFrissitese() {
        try {
            tblBerletek.setModel(
                    AdatbazisKezelo.berletekLekerdezese()
            );

            allapotokSzinezese();

        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Nem sikerült betölteni a bérleteket: "
                    + ex.getMessage(),
                    "Adatbázishiba",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

/**
 * A NetBeans által generált felület inicializálása. Az alatta következő
 * generált kódot nem módosítjuk.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbTagok = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbBerletTipus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtKezdoDatum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLejaratiDatum = new javax.swing.JTextField();
        btnBerletMentese = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBerletek = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBerletKereses = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FitManager - Bérletkezelés");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tag kiválasztása:");

        cmbTagok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTagok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTagok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTagokActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Bérlet típusa:");

        cmbBerletTipus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbBerletTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kezdő dátum:");

        txtKezdoDatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKezdoDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKezdoDatumActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lejárati dátum:");

        txtLejaratiDatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBerletMentese.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBerletMentese.setText("Bérlet mentése");
        btnBerletMentese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerletMenteseActionPerformed(evt);
            }
        });

        tblBerletek.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblBerletek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBerletek);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BÉRLETEK");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Bérlet keresése:");

        txtBerletKereses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBerletKeresesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKezdoDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTagok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(207, 207, 207)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLejaratiDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBerletTipus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBerletKereses, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBerletMentese, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbBerletTipus)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbTagok, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLejaratiDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKezdoDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBerletMentese, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBerletKereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTagokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTagokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTagokActionPerformed

    private void txtKezdoDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKezdoDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKezdoDatumActionPerformed

    private void btnBerletMenteseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerletMenteseActionPerformed
        // TODO add your handling code here:
        try {
            if (cmbTagok.getSelectedItem() == null
                    || cmbBerletTipus.getSelectedItem() == null) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Válassz tagot és bérlettípust!"
                );
                return;
            }

            String tag = cmbTagok.getSelectedItem().toString();
            String tipus = cmbBerletTipus.getSelectedItem().toString();

            int elvalaszto = tag.indexOf(" - ");

            if (elvalaszto == -1) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Hibás tagazonosító!"
                );
                return;
            }

            int tagId = Integer.parseInt(
                    tag.substring(0, elvalaszto)
            );

            String kezdo = txtKezdoDatum.getText().trim();
            String lejarati = txtLejaratiDatum.getText().trim();

            java.time.format.DateTimeFormatter datumFormatum
                    = java.time.format.DateTimeFormatter
                            .ofPattern("uuuu.MM.dd")
                            .withResolverStyle(
                                    java.time.format.ResolverStyle.STRICT);

            String kezdoSzoveg = kezdo.endsWith(".")
                    ? kezdo.substring(0, kezdo.length() - 1)
                    : kezdo;

            String lejaratiSzoveg = lejarati.endsWith(".")
                    ? lejarati.substring(0, lejarati.length() - 1)
                    : lejarati;

            java.time.LocalDate kezdoHelyiDatum
                    = java.time.LocalDate.parse(
                            kezdoSzoveg, datumFormatum);

            java.time.LocalDate lejaratiHelyiDatum
                    = java.time.LocalDate.parse(
                            lejaratiSzoveg, datumFormatum);

            java.sql.Date kezdoDatum
                    = java.sql.Date.valueOf(kezdoHelyiDatum);

            java.sql.Date lejaratiDatum
                    = java.sql.Date.valueOf(lejaratiHelyiDatum);

            if (lejaratiDatum.before(kezdoDatum)) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "A lejárati dátum nem lehet korábbi a kezdő dátumnál!"
                );
                return;
            }

            AdatbazisKezelo.berletMentese(
                    tagId,
                    tipus,
                    kezdoDatum,
                    lejaratiDatum
            );

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "A bérlet sikeresen elmentve!"
            );

            txtKezdoDatum.setText("");
            txtLejaratiDatum.setText("");
            berletekListaFrissitese();

        } catch (java.time.format.DateTimeParseException ex) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Hibás adat vagy dátum! A helyes formátum: ÉÉÉÉ.HH.NN."
            );

        } catch (java.sql.SQLException ex) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Adatbázishiba: " + ex.getMessage()
            );
        }

    }//GEN-LAST:event_btnBerletMenteseActionPerformed

    private void txtBerletKeresesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBerletKeresesKeyReleased
        // TODO add your handling code here:
        String keresettSzoveg = txtBerletKereses.getText().trim();

        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> rendezo
                = new javax.swing.table.TableRowSorter<>(tblBerletek.getModel());

        tblBerletek.setRowSorter(rendezo);

        if (!keresettSzoveg.isEmpty()) {
            rendezo.setRowFilter(
                    javax.swing.RowFilter.regexFilter(
                            "(?iu)" + java.util.regex.Pattern.quote(keresettSzoveg),
                            1
                    )
            );
        }   
    }//GEN-LAST:event_txtBerletKeresesKeyReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BerletekAblak.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BerletekAblak.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BerletekAblak.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BerletekAblak.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BerletekAblak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerletMentese;
    private javax.swing.JComboBox<String> cmbBerletTipus;
    private javax.swing.JComboBox<String> cmbTagok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBerletek;
    private javax.swing.JTextField txtBerletKereses;
    private javax.swing.JTextField txtKezdoDatum;
    private javax.swing.JTextField txtLejaratiDatum;
    // End of variables declaration//GEN-END:variables
}
