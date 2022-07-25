/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.forme.modeli;

import domen.Polisa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePolise extends AbstractTableModel{
    private List<Polisa> polise;
    String[] kolone = {"Klijent", "Površina stana", "Vrednost po KvM", "Ukupna premija"};
    
    public ModelTabelePolise(List<Polisa> polise) {
        this.polise = polise;
    }

    public void setPolise(List<Polisa> polise) {
        this.polise = polise;
        fireTableDataChanged();
    }

    public List<Polisa> getPolise() {
        return polise;
    }
    
    @Override
    public int getRowCount() {
        if(polise == null) return 0;
        return polise.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Polisa p = polise.get(red);
        switch(kolona){
            case 0: return p.getKlijent().getImePrezime();
            case 1: return p.getPovrsinaStana();
            case 2: return p.getVrednostPoKvM();
            case 3: return p.getUkupnaPremija();
                default: return "";
        }
    }
    public void dodajPolisu(Polisa p){
        polise.add(p);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    
}
