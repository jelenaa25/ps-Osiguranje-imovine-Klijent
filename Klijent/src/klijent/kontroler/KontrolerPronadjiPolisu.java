/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.Polisa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.forme.PolisaFrm;
import klijent.forme.OpstaEkranskaForma;
import klijent.forme.PretragaPolisaFrm;
import klijent.forme.modeli.ModelTabelePolise;
import klijent.komunikacija.Komunikacija;
import komunikacija.Odgovor;
import komunikacija.Operacije;
import komunikacija.TipOdgovora;
import komunikacija.Zahtev;

/**
 *
 * @author Korisnik
 */
public class KontrolerPronadjiPolisu extends OpstiKontroler {

    public KontrolerPronadjiPolisu(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isprazniGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ucitajSvePoliseUTabelu() {

        Zahtev zahtev = new Zahtev(Operacije.VRATI_POLISE, null);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                postaviUTbelu();

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da učita polise", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void postaviUTbelu() throws Exception {
        PretragaPolisaFrm ff = (PretragaPolisaFrm) oef;
        List<Polisa> lista1 = new ArrayList<>();
        for (OpstiDomenskiObjekat o : lista) {
            Polisa pp = (Polisa) o;
            Klijent k = vratiKl(pp.getKlijent().getId());
            pp.setKlijent(k);
            lista1.add(pp);
        }
        ModelTabelePolise mm = new ModelTabelePolise(lista1);
        ff.getTblPolise().setModel(mm);

    }

    public void nadjiPolise() {
        PretragaPolisaFrm ff = (PretragaPolisaFrm) oef;
        String klijent = ff.getTxtKlijent().getText();
        Klijent klijent1 = new Klijent();
        klijent1.setImePrezime(klijent);
        Zahtev zahtev = new Zahtev(Operacije.NADJI_POLISE, klijent1);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                postaviUTbelu();
                /*if (!lista.isEmpty()) {
                    JOptionPane.showMessageDialog(oef, "Sistem je našao polise po zadatoj vrednosti.");
                }*/

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da nađe polise po zadatoj vrednosti", "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ucitajPolisu() {
        PretragaPolisaFrm ff = (PretragaPolisaFrm) oef;
        if (ff.getTblPolise().getSelectedRow() != -1) {
            ModelTabelePolise mm = (ModelTabelePolise) ff.getTblPolise().getModel();

            Polisa poli = mm.getPolise().get(ff.getTblPolise().getSelectedRow());
            Zahtev zahtev = new Zahtev(Operacije.UCITAJ_POLISU, poli);
            Odgovor odgovor;
            try {
                odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
                if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                    Polisa polisa = (Polisa) odgovor.getRezultat();
                    PolisaFrm f1 = new PolisaFrm(null, true, null);
                    f1.popuniFormu(polisa);
                    f1.namestiDugme();
                    f1.setVisible(true);
                    //f1.prikaz("Sistem je učitao polisu.");
                    //JOptionPane.showMessageDialog(oef, "Sistem je učitao polisu.");

                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(oef, "Sistem ne može da učita polisu", "Greška", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(oef, "Niste izabrali polisu...", "Greška", JOptionPane.ERROR_MESSAGE);
        }

    }

    private Klijent vratiKl(int id) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KLIJENTE, null);
        Odgovor odgovor;

        odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
        if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
            lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
            for (OpstiDomenskiObjekat o : lista) {
                Klijent t = (Klijent) o;
                if (t.getId() == id) {
                    return t;
                }
            }

        }
        return null;

    }
}