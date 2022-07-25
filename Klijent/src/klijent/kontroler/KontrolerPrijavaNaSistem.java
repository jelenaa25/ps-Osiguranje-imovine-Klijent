/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.AgentOsiguranja;
import javax.swing.JOptionPane;
import klijent.forme.GlavnaFrm;
import klijent.forme.OpstaEkranskaForma;
import klijent.forme.PrijavaNaSistemFrm;
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
public class KontrolerPrijavaNaSistem extends OpstiKontroler {

    public KontrolerPrijavaNaSistem(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() throws ValidationException {
        PrijavaNaSistemFrm f = (PrijavaNaSistemFrm) oef;
        AgentOsiguranja a = (AgentOsiguranja) odo;
        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(f.getTxtKorisnicko().getText(), "Korisnicko ime ne sme biti prazno...")
                    .validateNotNullOrEmpty(String.valueOf(f.getTxtSifra().getText()), "Password nije unet...")
                    .throwIfInvalide();
            a.setUsername(f.getTxtKorisnicko().getText());
            a.setPassword(String.valueOf(f.getTxtSifra().getText()));
        } catch (ValidationException ex) {
            throw ex;
        }

    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isprazniGrafickiObjekat() {

    }

    public void prijaviSe() {

        try {
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.PRIJAVA, odo);
            Odgovor odgovor;
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                PrijavaNaSistemFrm f = (PrijavaNaSistemFrm) oef;
                GlavnaFrm j = new GlavnaFrm((AgentOsiguranja) odgovor.getRezultat());
                AgentOsiguranja ao = (AgentOsiguranja) odgovor.getRezultat();
                j.getTxtAgent().setText(ao.getIme() + " " + ao.getPrezime());
                j.setVisible(true);
                f.setVisible(false);
            } else {

                isprazniGrafickiObjekat();
                //JOptionPane.showMessageDialog(oef, "Neuspešna prijava... ", "Greška", JOptionPane.ERROR_MESSAGE);
                throw odgovor.getException();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Neuspešna prijava... "+ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
