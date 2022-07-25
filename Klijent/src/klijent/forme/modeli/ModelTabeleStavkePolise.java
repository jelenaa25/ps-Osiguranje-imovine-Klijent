/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.forme.modeli;

import domen.Polisa;
import domen.StavkaPolise;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleStavkePolise extends AbstractTableModel {

    private Polisa polisa;
    String kolone[] = {"RB", "Predmet", "Pokriće", "Suma osiguranja", "Procenat amortizacije", "Premija"};

    public ModelTabeleStavkePolise(Polisa polisa) {
        this.polisa = polisa;

    }

    public Polisa getPolisa() {
        return polisa;
    }

    public void setPolisa(Polisa polisa) {
        this.polisa = polisa;
        
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (polisa == null) {
            return 0;
        }
        return polisa.getStavkePolise().size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    

    @Override
    public Object getValueAt(int red, int kolona) {
        StavkaPolise s = polisa.getStavkePolise().get(red);
        switch (kolona) {
            case 0:
                return s.getRb();
            case 1:
                return s.getPredmetOsiguranja().getNaziv();
            case 2:
                return s.getPokrice().getNaziv();
            case 3:
                return s.getSumaOsiguranja();
            case 4:
                return s.getProcenatAmortizacije() + "%";
            case 5:
                return s.getPremija();
            default:
                return "";

        }
    }

    public void dodajStavku(StavkaPolise st) {
        List<StavkaPolise> st1 = polisa.getStavkePolise(); st1.add(st);
        fireTableDataChanged();
    }

    public void obrisiStavku(int selectedRow) {
        polisa.getStavkePolise().remove(selectedRow);
        fireTableDataChanged();
    }
    
    public List<StavkaPolise> getStavke(){
        return polisa.getStavkePolise();
    }

}
