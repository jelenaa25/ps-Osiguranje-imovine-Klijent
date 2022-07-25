/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.Pokrice;
import domen.Polisa;
import domen.PredmetOsiguranja;
import domen.StavkaPolise;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeMath.round;
import klijent.forme.PolisaFrm;
import klijent.forme.OpstaEkranskaForma;
import klijent.forme.modeli.ModelTabeleStavkePolise;
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
public class KontrolerPolisa extends OpstiKontroler {

    private int rb;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public KontrolerPolisa(OpstaEkranskaForma oef) {
        this.oef = oef;
        rb = 1;
    }

    public void ucitajPokrica() {

        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_POKRICA, null);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                napuniCmb(lista);

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da učita pokrića", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ucitajPredmete() {

        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_PREDMETE, null);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                napuniCmb(lista);

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da učita predmete osiguranja", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() throws ValidationException, Exception {
        PolisaFrm f = (PolisaFrm) oef;
        Polisa p = (Polisa) odo;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            ModelTabeleStavkePolise mmm = (ModelTabeleStavkePolise) f.getTblStavkePolise().getModel();
            List<StavkaPolise> l = mmm.getStavke();
            Validator.startValidation()
                    .validateValueIsNumber(f.getTxtGradjVr().getText(), "Građevinska vrednost mora biti pozitivan broj.")
                    .validateNotNullOrEmpty(f.getTxtVrKvM().getText(), "Vrednost po KvM nije uneta.")
                    .validateValueIsNumber(f.getTxtVrKvM().getText(), "Vrednost po KvM mora biti pozitivan broj.")
                    .validateNotNullOrEmpty(f.getTxtPovrsina().getText(), "Površina stana nije uneta.")
                    .validateValueIsNumber(f.getTxtPovrsina().getText(), "Povrsina mora biti pozitivan broj.")
                    .validateListIsNotEmpty(l, "Polisa mora imati bar jednu stavku...")
                    .validateNotNullOrEmpty(f.getTxtDatumDo().getText(), "DatumDo nije unet.")
                    .validateValueIsDate(f.getTxtDatumDo().getText(), "dd.MM.yyyy.", "Format datumaDO nije dobar...")
                    .validateNotNullOrEmpty(f.getTxtDatumOd().getText(), "DatumOD nije unet.")
                    .validateValueIsDate(f.getTxtDatumOd().getText(), "dd.MM.yyyy.", "Format datumaOD nije dobar...")
                    .validateTwoDate(f.getTxtDatumOd().getText(), f.getTxtDatumDo().getText(), "dd.MM.yyyy.", "")
                    .throwIfInvalide();
            p.setDatumDO(sdf.parse(f.getTxtDatumDo().getText()));
            p.setDatumOD(sdf.parse(f.getTxtDatumOd().getText()));
            p.setKlijent((Klijent) f.getCmbKlijent().getSelectedItem());
            p.setAgentOsiguranja(f.getA());
            BigDecimal big; 
            big = new BigDecimal(f.getTxtVrKvM().getText());
            p.setVrednostPoKvM(big);
            big = new BigDecimal(f.getTxtPovrsina().getText());
            p.setPovrsinaStana(big);
            BigDecimal big11 = new BigDecimal(f.getTxtVrKvM().getText());
            BigDecimal mn = big.multiply(big11);
            p.setGradjevinskaVrednost(mn);
            BigDecimal uk = new BigDecimal(0.00);
            for (StavkaPolise l1 : l) {
                l1.setPolisa(p);
                uk = uk.add(l1.getPremija());
            }
            p.setStavkePolise(l);
            p.setUkupnaPremija(uk);
        } catch (NumberFormatException | ParseException | ValidationException ex) {
            throw ex;
        }
    }

    @Override
    public void KonvertujObjekatUGrafickeKomponente() {
        PolisaFrm f = (PolisaFrm) oef;
        Polisa polisa = (Polisa) odo;

        ucitajPokrica();
        for (OpstiDomenskiObjekat o : lista) {
            Pokrice pok = (Pokrice) o;
            for (StavkaPolise stavkaPolise : polisa.getStavkePolise()) {
                if (stavkaPolise.getPokrice().getPokriceID() == pok.getPokriceID()) {
                    stavkaPolise.setPokrice(pok);
                }
            }
        }
        ucitajPredmete();
        for (OpstiDomenskiObjekat o : lista) {
            PredmetOsiguranja pok = (PredmetOsiguranja) o;
            for (StavkaPolise stavkaPolise : polisa.getStavkePolise()) {
                if (stavkaPolise.getPredmetOsiguranja().getPredmetID() == pok.getPredmetID()) {
                    stavkaPolise.setPredmetOsiguranja(pok);
                }
            }
        }
        ucitajSveKlijente();
        for(OpstiDomenskiObjekat o : lista){
            Klijent k = (Klijent) o;
            if(polisa.getKlijent().getId() == k.getId()) polisa.setKlijent(k);
        }
       
        f.getTxtVrKvM().setText(polisa.getVrednostPoKvM() + "");
        f.getTxtPovrsina().setText(polisa.getPovrsinaStana() + "");
        f.getCmbKlijent().setSelectedItem(polisa.getKlijent());
        f.getTxtGradjVr().setText(polisa.getGradjevinskaVrednost() + "");
        SimpleDateFormat smf = new SimpleDateFormat("dd.MM.yyyy.");
        f.getTxtDatumOd().setText(smf.format(polisa.getDatumOD()));
        f.getTxtDatumDo().setText(smf.format(polisa.getDatumDO()));
        f.getTxtAmortizacija().setText("");
        ModelTabeleStavkePolise mmm = (ModelTabeleStavkePolise) f.getTblStavkePolise().getModel();

        mmm.setPolisa(polisa);

    }

    @Override
    public void isprazniGrafickiObjekat() {
        PolisaFrm f = (PolisaFrm) oef;
        ModelTabeleStavkePolise mm = (ModelTabeleStavkePolise) f.getTblStavkePolise().getModel();
        mm.setPolisa(new Polisa());
        f.getTxtVrKvM().setText("");
        f.getTxtPovrsina().setText("");
        f.getTxtGradjVr().setText("");
        f.getTxtDatumOd().setText("");
        f.getTxtDatumDo().setText("");
        f.getTxtAmortizacija().setText("");
    }

    private void napuniCmb(List<OpstiDomenskiObjekat> lista) {
        PolisaFrm fr = (PolisaFrm) oef;
        if (lista.get(0) instanceof Pokrice) {

            fr.getCmbPokrice().removeAllItems();
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
                fr.getCmbPokrice().addItem(opstiDomenskiObjekat);
            }
            
        }
        if (lista.get(0) instanceof PredmetOsiguranja) {

            fr.getCmbPredmet().removeAllItems();
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
                fr.getCmbPredmet().addItem(opstiDomenskiObjekat);
            }
        }

        if (lista.get(0) instanceof Klijent) {

            fr.getCmbKlijent().removeAllItems();
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
                fr.getCmbKlijent().addItem(opstiDomenskiObjekat);
            }
        }
    }

    public void dodajStavkuUTabelu() throws ValidationException {
        PolisaFrm ff = (PolisaFrm) oef;
        StavkaPolise st = new StavkaPolise();
        st.setPokrice((Pokrice) ff.getCmbPokrice().getSelectedItem());
        st.setPredmetOsiguranja((PredmetOsiguranja) ff.getCmbPredmet().getSelectedItem());
        Validator.startValidation()
                .validateValueIsNumber(ff.getTxtAmortizacija().getText(), "Amortizacija mora biti broj...")
                .validateValueIsNumber(ff.getTxtPovrsina().getText(), "Povrsina mora biti broj...")
                .validateValueIsNumber(ff.getTxtVrKvM().getText(), "Vr po KvM mora biti broj...")
                .throwIfInvalide();

        st.setProcenatAmortizacije(Integer.parseInt(ff.getTxtAmortizacija().getText()));
        BigDecimal b1 = new BigDecimal(ff.getTxtPovrsina().getText());
        BigDecimal b2 = new BigDecimal(ff.getTxtVrKvM().getText());
        BigDecimal grVr = b1.multiply(b2);
        BigDecimal suma;
        BigDecimal ponder = new BigDecimal(0.2);
        if (st.getPredmetOsiguranja().getNaziv().equals("Gradjevinski objekat")
                && st.getPokrice().getNaziv().equals("Osnovni rizik")) {
            suma = grVr;
        } else {
            suma = grVr.multiply(ponder);
        }
        
       BigDecimal amortizacija = new BigDecimal(st.getProcenatAmortizacije());
       BigDecimal premija = suma.multiply(amortizacija);
        st.setSumaOsiguranja(suma);
        st.setPremija(premija);
        st.setRb(rb++);
        ModelTabeleStavkePolise m1 = (ModelTabeleStavkePolise) ff.getTblStavkePolise().getModel();
        m1.dodajStavku(st);

    }

    public void obrisiStavkuIzTabele() {
        PolisaFrm ff = (PolisaFrm) oef;
        ModelTabeleStavkePolise m1 = (ModelTabeleStavkePolise) ff.getTblStavkePolise().getModel();
        if (ff.getTblStavkePolise().getSelectedRow() != -1) {
            m1.obrisiStavku(ff.getTblStavkePolise().getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(ff, "Izaberite red u tabeli...");
        }
    }

    public void sacuvajPolisu() throws Exception {

        try {
            odo = oef.kreirajObjekat();
            KonvertujGrafickiObjekatUDomenskiObjekat();
            Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_POLISU, odo);
            Odgovor odgovor;
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                JOptionPane.showMessageDialog(oef, "Sistem je zapamtio polisu.");
                isprazniGrafickiObjekat();
                rb = 1;
            } else {
                odgovor.getException().printStackTrace();
                JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti polisu", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne može da zapamti polisu. "+ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void obrisiPolisu() {
        Zahtev zahtev = new Zahtev(Operacije.OBRISI_POLISU, odo);
        System.out.println(odo);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                JOptionPane.showMessageDialog(oef, "Sistem je obrisao polisu.");
                oef.dispose();
            } else {
                JOptionPane.showMessageDialog(oef, "Sistem ne može da obriše polisu", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(oef, "Sistem ne može da obriše polisu", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pripremiTabelu() {
        PolisaFrm f = (PolisaFrm) oef;
        ModelTabeleStavkePolise mm = new ModelTabeleStavkePolise(new Polisa());
        f.getTblStavkePolise().setModel(mm);
    }

    public void izracunaj() throws ValidationException {
        PolisaFrm ff = (PolisaFrm) oef;
        Validator.startValidation()
                .validateNotNullOrEmpty(ff.getTxtPovrsina().getText(), "Niste uneli površinu...")
                .validateNotNullOrEmpty(ff.getTxtVrKvM().getText(), "Niste uneli vr po KvM...")
                .validateValueIsNumber(ff.getTxtPovrsina().getText(), "Površina mora biti broj...")
                .validateValueIsNumber(ff.getTxtVrKvM().getText(), "Vr po KvM mora biti broj...")
                .throwIfInvalide();
        
        BigDecimal b1 = new BigDecimal(ff.getTxtPovrsina().getText());
        BigDecimal b2 = new BigDecimal(ff.getTxtVrKvM().getText());
        BigDecimal grVr = b1.multiply(b2);
        ff.getTxtGradjVr().setText(grVr+"");
    }


    public void ucitajSveKlijente() {
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KLIJENTE, null);
        Odgovor odgovor;
        try {
            odgovor = Komunikacija.getInstanca().pozivSo(zahtev);
            if (odgovor.getTipOdgovora().equals(TipOdgovora.USPEH)) {
                lista = (List<OpstiDomenskiObjekat>) odgovor.getRezultat();
                napuniCmb(lista);

            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(oef, "Sistem ne može da učita klijente", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

}
