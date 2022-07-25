/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.PredmetOsiguranja;
import javax.swing.JOptionPane;
import klijent.forme.PredmetOsiguranjaFrm;
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
public class KontrolerPredmetOsiguranja extends OpstiKontroler {

    public KontrolerPredmetOsiguranja(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() throws ValidationException {
        PredmetOsiguranjaFrm ff = (PredmetOsiguranjaFrm) oef;
        PredmetOsiguranja predmet = (PredmetOsiguranja) odo;
        Validator.startValidation()
                .validateNotNullOrEmpty(ff.getTxtNaziv().getText(), "Naziv ne sme biti prazan...")
                .throwIfInvalide();
        predmet.setNaziv(ff.getTxtNaziv().getText());
        predmet.setNapomena(ff.getTxtNapomena().getText());
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isprazniGrafickiObjekat() {
        PredmetOsiguranjaFrm ff = (PredmetOsiguranjaFrm) oef;
        ff.getTxtNaziv().setText("");
        ff.getTxtNapomena().setText("");
    }

    public void zapamtiPredmet() {

        try {
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_PREDMET, odo);
            Odgovor odgovor;
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio predmet osiguranja.");
                isprazniGrafickiObjekat();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti predmet osiguranja", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti predmet osiguranja. "+ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

}
