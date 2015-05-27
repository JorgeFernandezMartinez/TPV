/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtpv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julen-PC
 */
public class HiloMonitor implements Runnable {

    public static final String fichero = "ventas.dat";
    private MTPVJFrame ventana;

    public HiloMonitor(MTPVJFrame f) {
        ventana = f;

    }

    @Override
    public void run() {
        while (true) {
            try {
                ventana.contarLineasFichero();
                Thread.sleep(500);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HiloMonitor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HiloMonitor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloMonitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
