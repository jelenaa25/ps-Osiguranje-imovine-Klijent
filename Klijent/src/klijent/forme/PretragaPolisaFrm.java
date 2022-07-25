/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.forme;

import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import javax.swing.JTable;
import javax.swing.JTextField;
import klijent.forme.modeli.ModelTabelePolise;
import klijent.kontroler.KontrolerPronadjiPolisu;

/**
 *
 * @author Korisnik
 */
public class PretragaPolisaFrm extends OpstaEkranskaForma{

    private final KontrolerPronadjiPolisu kontrolerPronadjiPolisu;
    public PretragaPolisaFrm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
        this.setLocationRelativeTo(null);
        ModelTabelePolise mm = new ModelTabelePolise(null);
        tblPolise.setModel(mm);
        kontrolerPronadjiPolisu = new KontrolerPronadjiPolisu(this);
        ucitajSvePolise();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKlijent = new javax.swing.JLabel();
        txtKlijent = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPolise = new javax.swing.JTable();
        btnUcitajPolisu = new javax.swing.JButton();
        btnPronadji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Polise");

        lblKlijent.setText("Unesite klijenta:");

        tblPolise.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPolise);

        btnUcitajPolisu.setText("Učitaj polisu");
        btnUcitajPolisu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajPolisuActionPerformed(evt);
            }
        });

        btnPronadji.setText("Pronađi");
        btnPronadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblKlijent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPronadji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUcitajPolisu)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKlijent)
                    .addComponent(txtKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPronadji))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUcitajPolisu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPronadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiActionPerformed
        // TODO add your handling code here:
        kontrolerPronadjiPolisu.nadjiPolise();
    }//GEN-LAST:event_btnPronadjiActionPerformed

    private void btnUcitajPolisuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajPolisuActionPerformed
        // TODO add your handling code here:
        kontrolerPronadjiPolisu.ucitajPolisu();
        kontrolerPronadjiPolisu.ucitajSvePoliseUTabelu(); txtKlijent.setText("");
    }//GEN-LAST:event_btnUcitajPolisuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPronadji;
    private javax.swing.JButton btnUcitajPolisu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JTable tblPolise;
    private javax.swing.JTextField txtKlijent;
    // End of variables declaration//GEN-END:variables

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return (OpstiDomenskiObjekat) new Polisa();
    }

    public JTable getTblPolise() {
        return tblPolise;
    }

    public JTextField getTxtKlijent() {
        return txtKlijent;
    }

    
    private void ucitajSvePolise() {
        kontrolerPronadjiPolisu.ucitajSvePoliseUTabelu();
    }
}
