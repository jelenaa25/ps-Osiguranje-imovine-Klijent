package klijent.forme;

import domen.AgentOsiguranja;
import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import klijent.kontroler.KontrolerPolisa;
import validator.ValidationException;

/**
 *
 * @author Korisnik
 */
public class PolisaFrm extends OpstaEkranskaForma {

    private AgentOsiguranja a;
    private final KontrolerPolisa kontrolerKS;

    public PolisaFrm(java.awt.Frame parent, boolean modal, AgentOsiguranja a) {
        super(parent, modal);
        initComponents();
        kontrolerKS = new KontrolerPolisa(this);
        this.a = a;
        this.setLocationRelativeTo(null);
        prepared();
    }

    public PolisaFrm(Polisa polisa) {
        super(null, false);
        this.kontrolerKS = new KontrolerPolisa(this);

        //popuniFormu(polisa);
    }

    public AgentOsiguranja getA() {
        return a;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKlijent = new javax.swing.JLabel();
        lblPovrsina = new javax.swing.JLabel();
        txtPovrsina = new javax.swing.JTextField();
        txtVrKvM = new javax.swing.JTextField();
        lblVrKvM = new javax.swing.JLabel();
        txtGradjVr = new javax.swing.JTextField();
        lblGradjVr = new javax.swing.JLabel();
        lblDatOD = new javax.swing.JLabel();
        txtDatumOd = new javax.swing.JTextField();
        txtDatumDo = new javax.swing.JTextField();
        lblDatDo = new javax.swing.JLabel();
        lblPredmet = new javax.swing.JLabel();
        cmbPredmet = new javax.swing.JComboBox();
        lblPokrice = new javax.swing.JLabel();
        cmbPokrice = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavkePolise = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnObrisiPolisu = new javax.swing.JButton();
        lblProcenatAmortizacije = new javax.swing.JLabel();
        txtAmortizacija = new javax.swing.JTextField();
        btnIzracunaj = new javax.swing.JButton();
        cmbKlijent = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Polisa");

        lblKlijent.setText("Klijent:");

        lblPovrsina.setText("Površina stana(m2):");

        lblVrKvM.setText("Vrednost po KvM:");

        txtGradjVr.setEditable(false);

        lblGradjVr.setText("Građevinska vrednost:");

        lblDatOD.setText("Datum od(dd.MM.yyyy)");

        lblDatDo.setText("Datum do(dd.MM.yyyy)");

        lblPredmet.setText("Predmet:");

        cmbPredmet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPredmet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPredmetActionPerformed(evt);
            }
        });

        lblPokrice.setText("Pokriće:");

        cmbPokrice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblStavkePolise.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavkePolise);

        btnSacuvaj.setText("Sačuvaj polisu osiguranja");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj stavku polise");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši stavku polise");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnObrisiPolisu.setText("Obriši polisu osiguranja");
        btnObrisiPolisu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPolisuActionPerformed(evt);
            }
        });

        lblProcenatAmortizacije.setText("Procenat amortizacije:");

        txtAmortizacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmortizacijaActionPerformed(evt);
            }
        });

        btnIzracunaj.setText("Izračunaj");
        btnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSacuvaj)
                        .addGap(32, 32, 32)
                        .addComponent(btnObrisiPolisu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblPovrsina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                                .addComponent(lblKlijent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblVrKvM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(lblDatOD, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPovrsina, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDatumOd)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtGradjVr, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnIzracunaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txtVrKvM)
                                            .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPokrice, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDatDo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtAmortizacija, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(cmbPokrice, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbPredmet, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDatumDo))))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDodaj)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnObrisi))
                                    .addComponent(lblGradjVr, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProcenatAmortizacije, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKlijent)
                    .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPovrsina)
                    .addComponent(txtPovrsina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVrKvM)
                    .addComponent(txtVrKvM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGradjVr)
                    .addComponent(txtGradjVr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzracunaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatOD)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatDo)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPredmet)
                    .addComponent(cmbPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPokrice)
                    .addComponent(cmbPokrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProcenatAmortizacije)
                    .addComponent(txtAmortizacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSacuvaj)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnObrisiPolisu)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            // TODO add your handling code here:
            kontrolerKS.dodajStavkuUTabelu();
        } catch (ValidationException ex) {
            Logger.getLogger(PolisaFrm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne može da doda stavku. " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
        kontrolerKS.obrisiStavkuIzTabele();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            // TODO add your handling code here:
            kontrolerKS.sacuvajPolisu();
        } catch (Exception ex) {
            Logger.getLogger(PolisaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnObrisiPolisuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPolisuActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete polisu?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            kontrolerKS.obrisiPolisu();
            
        } /*else {
            //remove(dialogButton);
            System.exit(0);
        }*/

    }//GEN-LAST:event_btnObrisiPolisuActionPerformed

    private void txtAmortizacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmortizacijaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmortizacijaActionPerformed

    private void cmbPredmetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPredmetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPredmetActionPerformed

    private void btnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunajActionPerformed

        try {
            // TODO add your handling code here:
            kontrolerKS.izracunaj();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PolisaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzracunajActionPerformed

    public JTextField getTxtAmortizacija() {
        return txtAmortizacija;
    }

    public JButton getBtnDodaj() {
        return btnDodaj;
    }

    public void setBtnDodaj(JButton btnDodaj) {
        this.btnDodaj = btnDodaj;
    }

    public JButton getBtnObrisi() {
        return btnObrisi;
    }

    public JButton getBtnIzracunaj() {
        return btnIzracunaj;
    }

    public void setBtnIzracunaj(JButton btnIzracunaj) {
        this.btnIzracunaj = btnIzracunaj;
    }

    public void setBtnObrisi(JButton btnObrisi) {
        this.btnObrisi = btnObrisi;
    }

    public JButton getBtnObrisiPolisu() {
        return btnObrisiPolisu;
    }

    public void setBtnObrisiPolisu(JButton btnObrisiPolisu) {
        this.btnObrisiPolisu = btnObrisiPolisu;
    }

    public JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public void setBtnSacuvaj(JButton btnSacuvaj) {
        this.btnSacuvaj = btnSacuvaj;
    }

    public JComboBox getCmbPokrice() {
        return cmbPokrice;
    }

    public void setCmbPokrice(JComboBox cmbPokrice) {
        this.cmbPokrice = cmbPokrice;
    }

    public JComboBox getCmbPredmet() {
        return cmbPredmet;
    }

    public void setCmbPredmet(JComboBox cmbPredmet) {
        this.cmbPredmet = cmbPredmet;
    }

    public JTable getTblStavkePolise() {
        return tblStavkePolise;
    }

    public void setTblStavkePolise(JTable tblStavkePolise) {
        this.tblStavkePolise = tblStavkePolise;
    }

    public JTextField getTxtDatumDo() {
        return txtDatumDo;
    }

    public void setTxtDatumDo(JTextField txtDatumDo) {
        this.txtDatumDo = txtDatumDo;
    }

    public JTextField getTxtDatumOd() {
        return txtDatumOd;
    }

    public void setTxtDatumOd(JTextField txtDatumOd) {
        this.txtDatumOd = txtDatumOd;
    }

    public JTextField getTxtGradjVr() {
        return txtGradjVr;
    }

    public void setTxtGradjVr(JTextField txtGradjVr) {
        this.txtGradjVr = txtGradjVr;
    }

    public JComboBox getCmbKlijent() {
        return cmbKlijent;
    }


    public JTextField getTxtPovrsina() {
        return txtPovrsina;
    }

    public void setTxtPovrsina(JTextField txtPovrsina) {
        this.txtPovrsina = txtPovrsina;
    }

    public JTextField getTxtVrKvM() {
        return txtVrKvM;
    }

    public void setTxtVrKvM(JTextField txtVrKvM) {
        this.txtVrKvM = txtVrKvM;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzracunaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiPolisu;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JComboBox cmbPokrice;
    private javax.swing.JComboBox cmbPredmet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatDo;
    private javax.swing.JLabel lblDatOD;
    private javax.swing.JLabel lblGradjVr;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblPokrice;
    private javax.swing.JLabel lblPovrsina;
    private javax.swing.JLabel lblPredmet;
    private javax.swing.JLabel lblProcenatAmortizacije;
    private javax.swing.JLabel lblVrKvM;
    private javax.swing.JTable tblStavkePolise;
    private javax.swing.JTextField txtAmortizacija;
    private javax.swing.JTextField txtDatumDo;
    private javax.swing.JTextField txtDatumOd;
    private javax.swing.JTextField txtGradjVr;
    private javax.swing.JTextField txtPovrsina;
    private javax.swing.JTextField txtVrKvM;
    // End of variables declaration//GEN-END:variables

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return (OpstiDomenskiObjekat) new Polisa();
    }

    private void prepared() {
        kontrolerKS.ucitajPokrica();
        kontrolerKS.ucitajPredmete();
        kontrolerKS.ucitajSveKlijente();
        kontrolerKS.pripremiTabelu();
        
    }

    public void popuniFormu(Polisa polisa) {
        kontrolerKS.setOdo((OpstiDomenskiObjekat) polisa);
        kontrolerKS.KonvertujObjekatUGrafickeKomponente();
    }

    public void namestiDugme() {
        btnSacuvaj.setEnabled(false);
        btnSacuvaj.setVisible(false);
        btnObrisiPolisu.setEnabled(true);
        btnObrisiPolisu.setVisible(true);
        btnDodaj.setVisible(false);
        btnObrisi.setVisible(false);
        txtDatumDo.setEnabled(false);
        txtDatumOd.setEnabled(false);
        txtGradjVr.setEnabled(false);
     
        txtPovrsina.setEnabled(false);
        txtVrKvM.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Sistem je učitao polisu.");

    }

    public void iskljuciObrisiDugme() {
        btnObrisiPolisu.setEnabled(false);
        btnObrisiPolisu.setVisible(false);
    }

}
