/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurokami.monitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import malopezl.historial.Historial;

/**
 *
 * @author marcos
 */
public class Monitor {
    private ArrayList<Orden> ordenesPendientes;
    private ArrayList<String> ordenesHistorial = new ArrayList<String>();
    private ArrayList<String> horaHistorial = new ArrayList<String>();
    private final int TAMANO_TOTAL = 8;
    private int espaciosRestantes;
    private Date hora;
    
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
        ordenesHistorial.add("Productor");
        hora = new Date(System.currentTimeMillis());
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        horaHistorial.add(formatoHora.format(hora));
        ingresarListaOrdenes(ordenesHistorial);
        ingresarListaHoras(horaHistorial);
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
        ordenesHistorial.add("Consumidor");
        hora = new Date(System.currentTimeMillis());
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        horaHistorial.add(formatoHora.format(hora));
        ingresarListaOrdenes(ordenesHistorial);
        ingresarListaHoras(horaHistorial);
        if(espaciosRestantes == 1)
            notify();
        return regresar;
    }
    
    public void ingresarListaOrdenes(ArrayList<String> lo) {
        DefaultListModel ordenesModelo = new DefaultListModel();
        for (String i : lo) {
            ordenesModelo.addElement(i);
        }
        Historial.jList1.setModel(ordenesModelo);
    }
    
    public void ingresarListaHoras(ArrayList<String> lh) {
        DefaultListModel horasModelo = new DefaultListModel();
        for (String i : lh) {
            horasModelo.addElement(i);
        }
        Historial.jList2.setModel(horasModelo);
    }
}
