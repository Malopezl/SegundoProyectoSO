/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productor;

import java.util.logging.Level;
import java.util.logging.Logger;
import kurokami.monitor.Monitor;
import kurokami.monitor.Orden;
import kurokami.monitor.TiempoPreparacion;

/**
 *
 * @author sharon
 */
public class productor extends Thread{
    
    public Monitor monitor; 
    boolean correr= true;
    private boolean nuevaOrden;
    public static Orden cafe=null;
    
    @Override
    public void run() {
    
    while(correr){
       
        if(this.nuevaOrden)
        {
            monitor.agregarOrden(cafe);
            System.out.println("nueva orden: "+cafe.getID()+ "-"+cafe.getNombre());
           try {
              Thread.sleep(250);
           } catch (InterruptedException ex) {
               Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
           }
           this.nuevaOrden=false;
        }
        else
        {
            System.out.println("esperando");
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
     }
    }  
        
    public void nuevaOrden(int num, int numOrden)
    {
        switch(num)
       {
           case 1:{ cafe = new Orden(TiempoPreparacion.tiempoChemex, "Chemex", numOrden);}break;
           case 2:{ cafe = new Orden(TiempoPreparacion.tiempoV60, "V60", numOrden);}break;
           case 3:{ cafe = new Orden(TiempoPreparacion.tiempoExpreso , "Expresso", numOrden);}break;
           case 4:{ cafe = new Orden(TiempoPreparacion.tiempoFrench , "French Press", numOrden);}break;
           case 5:{ cafe = new Orden(TiempoPreparacion.tiempoMoka , "Moka", numOrden);}break;
           case 6:{ cafe = new Orden(TiempoPreparacion.tiempoLate , "Latte", numOrden);}break;
           default: {  } break;
        }
        this.nuevaOrden=true;
       
    }
    
    public productor(Monitor monitor)
    {
       this.monitor = monitor;
    }
    
}
