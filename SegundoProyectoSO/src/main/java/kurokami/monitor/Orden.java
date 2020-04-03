/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurokami.monitor;

/**
 *
 * @author marcos
 */
public class Orden {
    private int tiempoConsumo;
    private String nombre;
    private final int ID;
    public Orden(int tiempoConsumo, String nombre, int id){
        this.tiempoConsumo = tiempoConsumo;
        this.nombre = nombre;
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public int getTiempoConsumo() {
        return tiempoConsumo;
    }

    public String getNombre() {
        return nombre;
    }
    
}
