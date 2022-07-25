/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.forme.modeli;

import domen.Pokrice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePokrica extends AbstractTableModel{
    private List<Pokrice> pokrica;
    private String[] kolone= {"RB", "Naziv"};
    
    public ModelTabelePokrica() {
    }

    public ModelTabelePokrica(List<Pokrice> pokrica) {
        this.pokrica = pokrica;
    }
    
    @Override
    public int getRowCount() {
        return pokrica.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Pokrice pokrice = pokrica.get(row);
        switch(column){
            case 0: return pokrice.getPokriceID();
            case 1: return pokrice.getNaziv();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public List<Pokrice> getPokrica() {
        return pokrica;
    }

    public void setPokrica(List<Pokrice> pokrica) {
        this.pokrica = pokrica;
        fireTableDataChanged();
    }
    
    public void dodajPokrice(Pokrice pok){
        pokrica.add(pok); fireTableDataChanged();
    }
    
    
}
