/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.OpstiDomenskiObjekat;
import domen.Pokrice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.forme.PokriceFrm;
import klijent.forme.OpstaEkranskaForma;
import klijent.forme.PretragaPokricaFrm;
import klijent.forme.modeli.ModelTabelePokrica;
import klijent.komunikacija.Komunikacija;
import komunikacija.Odgovor;
import komunikacija.Operacije;
import komunikacija.TipOdgovora;
import komunikacija.Zahtev;

/**
 *
 * @author Korisnik
 */
public class KontrolerPronadjiPokrice extends OpstiKontroler {

    public KontrolerPronadjiPokrice(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {

    }

    @Override
    public void isprazniGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ucitajSvaPokrica() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_POKRICA, null);
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
            JOptionPane.showMessageDialog(oef, "Sistem ne može da učita pokrića", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void postaviUTbelu() {
        PretragaPokricaFrm ff = (PretragaPokricaFrm) oef;
        List<Pokrice> lista1 = new ArrayList<>();
        for (OpstiDomenskiObjekat o : lista) {
            Pokrice pp = (Pokrice) o;
            lista1.add(pp);
        }
        ModelTabelePokrica mm = new ModelTabelePokrica(lista1);
        ff.getTblPokrice().setModel(mm);
    }

    public void nadjiPokrica() {
        PretragaPokricaFrm ff = (PretragaPokricaFrm) oef;
        String naziv = ff.getTxtNaziv().getText();
        Zahtev zahtev = new Zahtev(Operacije.NADJI_POKRICA, naziv);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                //System.out.println("Listaaa: "+lista);
                //System.out.println("ODG: "+odgovor.getTipOdgovora());
                postaviUTbelu();
                JOptionPane.showMessageDialog(oef, "Sistem je našao pokriće po zadatoj vrednosti.");

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da nađe pokrića po zadatoj vrednosti", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ucitajPokrice() {
        PretragaPokricaFrm ff = (PretragaPokricaFrm) oef;
        if (ff.getTblPokrice().getSelectedRow() != -1) {
            ModelTabelePokrica mm = (ModelTabelePokrica) ff.getTblPokrice().getModel();

            Pokrice poli = mm.getPokrica().get(ff.getTblPokrice().getSelectedRow());
            Zahtev zahtev = new Zahtev(Operacije.UCITAJ_POKRICE, poli);
            Odgovor odgovor;
            try {
                odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
                if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                    Pokrice pokrice = (Pokrice) odgovor.getRezultat();
                    PokriceFrm f1 = new PokriceFrm(null, true);
                    f1.popuniFormu(pokrice);
                    f1.namestiDugme();
                    JOptionPane.showMessageDialog(oef, "Sistem je učitao pokriće.");
                    f1.setVisible(true);
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(oef, "Sistem ne može da učita pokriće", "Greška", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(oef, "Niste odabrali pokriće", "Greška", JOptionPane.ERROR_MESSAGE);

        }
    }

}
