/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.komunikacija;

import domen.AgentOsiguranja;
import java.net.Socket;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author Korisnik
 */
public class Komunikacija {
    
    static Komunikacija instanca;
    Socket socket;
    AgentOsiguranja trenutniKorisnik;

    private Komunikacija() {

    }

    public void setTrenutniKorisnik(AgentOsiguranja trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

    public AgentOsiguranja getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    public Odgovor pozivSo(Zahtev zahtev) throws Exception {
        System.out.println("SOKET :::" + socket);
        new Posiljalac(socket).posalji(zahtev);
        return (Odgovor) new Primalac(socket).primi();
    }
}
