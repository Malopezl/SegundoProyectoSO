/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumidor;

import kurokami.monitor.Orden;

/**
 *
 * @author Gilda
 */
public class Preparacion extends Thread {

    private int tiempo;
    private String nombre;
    private int id;

    public Preparacion(Orden orden) {
        this.tiempo = orden.getTiempoConsumo();
        this.nombre = orden.getNombre();
        this.id = orden.getID();
        
    }

    public int getTiempo() {
        return tiempo;
    }



    public String getNombre() {
        return nombre;
    }

    public int Id(){
      return id;  
    }


    

}
