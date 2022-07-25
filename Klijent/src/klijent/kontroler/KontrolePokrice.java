/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.Pokrice;
import javax.swing.JOptionPane;
import klijent.forme.PokriceFrm;
import klijent.forme.OpstaEkranskaForma;
import klijent.komunikacija.Komunikacija;
import komunikacija.Odgovor;
import komunikacija.Operacije;
import komunikacija.TipOdgovora;
import komunikacija.Zahtev;
import validator.ValidationException;
import validator.Validator;

/**
 *
 * @author Korisnik
 */
public class KontrolePokrice extends OpstiKontroler {

    public KontrolePokrice(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() throws ValidationException {
        Pokrice p = (Pokrice) odo;
        PokriceFrm f = (PokriceFrm) oef;
        
        Validator.startValidation()
                .validateNotNullOrEmpty(f.getTxtNaziv().getText(), "Naziv ne sme biti prazan...")
                .throwIfInvalide();
        p.setNaziv(f.getTxtNaziv().getText());
        p.setNapomena(f.getTxtNapomena().getText());
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        Pokrice p = (Pokrice) odo;
        PokriceFrm f = (PokriceFrm) oef;
        f.getTxtNaziv().setText(p.getNaziv());
        f.getTxtNapomena().setText(p.getNapomena());
    }

    @Override
    public void isprazniGrafickiObjekat() {
        PokriceFrm k = (PokriceFrm) oef;
        k.getTxtNaziv().setText("");
    }

    public void kreirajPokrice() throws ValidationException {
        try {
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_POKRICE, odo);
            Odgovor odgovor;
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio pokriće.");
                isprazniGrafickiObjekat();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti pokriće", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti pokriće. " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti pokriće. "+ex.getMessage() , "Greška", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void promeniPokrice() throws ValidationException {
        try {
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.PROMENI_POKRICE, odo);
            Odgovor odgovor;
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                JOptionPane.showMessageDialog(oef, "Sistem je promenio pokriće.");
                oef.dispose();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne može da promeni pokriće", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne može da promeni pokriće. "+ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

}
