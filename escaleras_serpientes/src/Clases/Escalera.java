/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author farfa
 */
public class Escalera {
    
    private int PosicionSube;
    private int posicionBaja;

    public Escalera(int posicionBaja, int PosicionSube) {
        this.PosicionSube = PosicionSube;
        this.posicionBaja = posicionBaja;
    }

    public int getPosicionSube() {
        return PosicionSube;
    }

    public int getPosicionBaja() {
        return posicionBaja;
    }
    
    
}
