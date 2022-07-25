/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent.main;

import java.io.IOException;
import java.net.Socket;
import klijent.forme.PrijavaNaSistemFrm;
import klijent.komunikacija.Komunikacija;
import komunikacija.Konstanta;

/**
 *
 * @author Korisnik
 */
public class Main {
    private Socket socket;
    public static void main(String[] args) throws IOException {
        new Main().connect();
        new PrijavaNaSistemFrm(null, true).setVisible(true);
    }
    
    public void connect() throws IOException{
        socket = new Socket("localhost", Konstanta.PORT);
        Komunikacija.getInstanca().setSocket(socket);
    }
    
}
