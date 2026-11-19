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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bérletkezelés - Fitmanager");

        jLabel1.setText("Tag kiválasztása:");

        cmbTagok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTagok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTagokActionPerformed(evt);
            }
        });

        jLabel2.setText("Bérlet típusa:");

        cmbBerletTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Kezdő dátum:");

        txtKezdoDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKezdoDatumActionPerformed(evt);
            }
        });

        jLabel4.setText("Lejárati dátum:");

        btnBerletMentese.setText("Bérlet mentése");
        btnBerletMentese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerletMenteseActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTagok, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(txtKezdoDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbBerletTipus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(txtLejaratiDatum)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBerletMentese))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTagok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBerletTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKezdoDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLejaratiDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnBerletMentese)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBerletek;
    private javax.swing.JTextField txtKezdoDatum;
    private javax.swing.JTextField txtLejaratiDatum;
    // End of variables declaration//GEN-END:variables
}
