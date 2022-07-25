/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.kontroler;

import domen.AgentOsiguranja;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import klijent.forme.OpstaEkranskaForma;

/**
 *
 * @author Korisnik
 */
public abstract class OpstiKontroler {

    protected OpstiDomenskiObjekat odo;
    protected OpstaEkranskaForma oef;
    protected List<OpstiDomenskiObjekat> lista = new ArrayList<>();

    public abstract void KonvertujGrafickiObjekatUDomenskiObjekat() throws Exception;

    public abstract void KonvertujObjekatUGrafickeKomponente();

    public abstract void isprazniGrafickiObjekat();

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }
    
    

}
