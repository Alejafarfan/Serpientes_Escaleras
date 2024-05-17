/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author farfa
 */
public class Serpiente {
    
    private final int posicionArriba;
    private final int posicionBaja;

    public Serpiente(int posicionArriba, int posicionBaja) {
        this.posicionArriba = posicionArriba;
        this.posicionBaja = posicionBaja;
    }

    public int getPosicionArriba() {
        return posicionArriba;
    }

    public int getPosicionBaja() {
        return posicionBaja;
    }
}
