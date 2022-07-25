/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.forme;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Korisnik
 */
public abstract class OpstaEkranskaForma extends javax.swing.JDialog{

    public OpstaEkranskaForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);    
    }
    
    public abstract OpstiDomenskiObjekat kreirajObjekat();
}
