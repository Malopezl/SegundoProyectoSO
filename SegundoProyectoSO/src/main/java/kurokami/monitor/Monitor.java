/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurokami.monitor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class Monitor {
    private ArrayList<Orden> ordenesPendientes;
    private final int TAMANO_TOTAL = 8;
    private int espaciosRestantes;
    
    public Monitor(){
        ordenesPendientes = new ArrayList<>();
        espaciosRestantes = this.TAMANO_TOTAL;
    }

    public ArrayList<Orden> getOrdenesPendientes() {
        return ordenesPendientes;
    }

    public int getEspaciosRestantes() {
        return espaciosRestantes;
    }
    
    public synchronized void agregarOrden(Orden nuevaOrden){
        while(this.espaciosRestantes == 0){
            try{
                wait();
            }catch(InterruptedException ex){}
        }
        espaciosRestantes -= 1;
        ordenesPendientes.add(nuevaOrden);
        if(espaciosRestantes == 7)
            notify();
    }
    public synchronized Orden atenderOrden(){
        if(espaciosRestantes == 8){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Orden regresar = ordenesPendientes.remove(0);
        espaciosRestantes += 1;
        if(espaciosRestantes == 1)
            notify();
        return regresar;
    }
}
