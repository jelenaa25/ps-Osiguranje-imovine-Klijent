/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.forme;

import domen.AgentOsiguranja;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Korisnik
 */
public class GlavnaFrm extends javax.swing.JFrame{
    private AgentOsiguranja agentOsiguranja;
    public GlavnaFrm( AgentOsiguranja  agentOsiguranja) {
        //super(parent, modal);
        initComponents();  setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.agentOsiguranja =agentOsiguranja;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgent = new javax.swing.JLabel();
        txtAgent = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnPolisa = new javax.swing.JMenu();
        miKreiraj = new javax.swing.JMenuItem();
        miPretrazi = new javax.swing.JMenuItem();
        mnPokrice = new javax.swing.JMenu();
        miKreirajPok = new javax.swing.JMenuItem();
        miPretraziPok = new javax.swing.JMenuItem();
        mnPredmetOsig = new javax.swing.JMenu();
        miKreirajPredOsig = new javax.swing.JMenuItem();
        mnKlijent = new javax.swing.JMenu();
        miKreirajKlijenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Osiguranje");

        lblAgent.setText("Agent osiguranja:");

        txtAgent.setEditable(false);

        mnPolisa.setText("Polisa");

        miKreiraj.setText("Kreiraj");
        miKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKreirajActionPerformed(evt);
            }
        });
        mnPolisa.add(miKreiraj);

        miPretrazi.setText("Pretraži");
        miPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretraziActionPerformed(evt);
            }
        });
        mnPolisa.add(miPretrazi);

        jMenuBar1.add(mnPolisa);

        mnPokrice.setText("Pokriće");

        miKreirajPok.setText("Kreiraj");
        miKreirajPok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKreirajPokActionPerformed(evt);
            }
        });
        mnPokrice.add(miKreirajPok);

        miPretraziPok.setText("Pretraži");
        miPretraziPok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretraziPokActionPerformed(evt);
            }
        });
        mnPokrice.add(miPretraziPok);

        jMenuBar1.add(mnPokrice);

        mnPredmetOsig.setText(" Predmet osiguranja");

        miKreirajPredOsig.setText("Kreiraj");
        miKreirajPredOsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKreirajPredOsigActionPerformed(evt);
            }
        });
        mnPredmetOsig.add(miKreirajPredOsig);

        jMenuBar1.add(mnPredmetOsig);

        mnKlijent.setText("Klijent");

        miKreirajKlijenta.setText("Kreiraj");
        miKreirajKlijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKreirajKlijentaActionPerformed(evt);
            }
        });
        mnKlijent.add(miKreirajKlijenta);

        jMenuBar1.add(mnKlijent);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgent)
                    .addComponent(txtAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKreirajActionPerformed
        // TODO add your handling code here:
        PolisaFrm ff = new PolisaFrm(null, true, agentOsiguranja);
        ff.iskljuciObrisiDugme();
        ff.setVisible(true);
    }//GEN-LAST:event_miKreirajActionPerformed

    private void miPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretraziActionPerformed
        // TODO add your handling code here:
        new PretragaPolisaFrm(this, true).setVisible(true);
    }//GEN-LAST:event_miPretraziActionPerformed

    private void miKreirajPokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKreirajPokActionPerformed
        // TODO add your handling code here:
        new PokriceFrm(this, true).setVisible(true);
    }//GEN-LAST:event_miKreirajPokActionPerformed

    private void miKreirajPredOsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKreirajPredOsigActionPerformed
        // TODO add your handling code here:
        
        new PredmetOsiguranjaFrm(this, true).setVisible(true);
    }//GEN-LAST:event_miKreirajPredOsigActionPerformed

    private void miPretraziPokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretraziPokActionPerformed
        // TODO add your handling code here:
        new PretragaPokricaFrm(this, true).setVisible(true);
    }//GEN-LAST:event_miPretraziPokActionPerformed

    private void miKreirajKlijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKreirajKlijentaActionPerformed
        // TODO add your handling code here:
        new KlijentFrm(this, true).setVisible(true);
    }//GEN-LAST:event_miKreirajKlijentaActionPerformed

    public JTextField getTxtAgent() {
        return txtAgent;
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblAgent;
    private javax.swing.JMenuItem miKreiraj;
    private javax.swing.JMenuItem miKreirajKlijenta;
    private javax.swing.JMenuItem miKreirajPok;
    private javax.swing.JMenuItem miKreirajPredOsig;
    private javax.swing.JMenuItem miPretrazi;
    private javax.swing.JMenuItem miPretraziPok;
    private javax.swing.JMenu mnKlijent;
    private javax.swing.JMenu mnPokrice;
    private javax.swing.JMenu mnPolisa;
    private javax.swing.JMenu mnPredmetOsig;
    private javax.swing.JTextField txtAgent;
    // End of variables declaration//GEN-END:variables

    public AgentOsiguranja getAgentOsiguranja() {
        return agentOsiguranja;
    }
    
}

