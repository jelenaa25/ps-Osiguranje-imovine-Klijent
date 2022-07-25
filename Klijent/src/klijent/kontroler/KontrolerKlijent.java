/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.Klijent;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.forme.KlijentFrm;
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
public class KontrolerKlijent extends OpstiKontroler {

    public KontrolerKlijent(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() throws ValidationException, Exception {
        Klijent k = (Klijent) odo;
        KlijentFrm f = (KlijentFrm) oef;
        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(f.getTxtImePrezime().getText(), "Niste uneli ime i prezime.")
                    .validateNotNullOrEmpty(f.getTxtJMBG().getText(), "Niste uneli JMBG.")
                    .validateJMBGDuzina(f.getTxtJMBG().getText(), "JMBG nije dobro unet.").throwIfInvalide();

            k.setImePrezime(f.getTxtImePrezime().getText());
            k.setJMBG(Long.parseLong(f.getTxtJMBG().getText()));
            k.setMesto((Mesto) f.getCmbMesto().getSelectedItem());
        } catch (NumberFormatException | ValidationException ex) {
            throw ex;
        }

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        Klijent k = (Klijent) odo;
        KlijentFrm f = (KlijentFrm) oef;
        f.getTxtJMBG().setText(k.getJMBG() + "");
        f.getTxtImePrezime().setText(k.getImePrezime());
        f.getCmbMesto().setSelectedItem(k.getMesto());
    }

    @Override
    public void isprazniGrafickiObjekat() {
        KlijentFrm f = (KlijentFrm) oef;
        f.getTxtJMBG().setText("");
        f.getTxtImePrezime().setText("");
    }

    public void ucitajMesta() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_MESTA, null);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                napuni(lista);

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da učita mesta", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sacuvaj() {
        try {
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_KLIJENTA, odo);
            Odgovor odgovor;
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio klijenta.");
                isprazniGrafickiObjekat();

            } else {
                odgovor.getException().printStackTrace();
                JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti klijenta", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti polisu. " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti klijenta. "+ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void napuni(List<OpstiDomenskiObjekat> lista) {
        KlijentFrm f = (KlijentFrm) oef;
        f.getCmbMesto().removeAllItems();
        for (OpstiDomenskiObjekat o : lista) {
            Mesto m = (Mesto) o;
            f.getCmbMesto().addItem(m);
        }
    }

}
