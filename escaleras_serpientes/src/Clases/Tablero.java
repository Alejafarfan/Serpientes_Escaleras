/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author farfa
 */
public class Tablero {

    private final List<Jugador> jugadores;
    private final List<Serpiente> serpientes;
    private final List<Escalera>escaleras;
    private String modo;

    public Tablero(String modo) {
        jugadores = new ArrayList<>();
        serpientes = new ArrayList<>();
        escaleras = new ArrayList<>();
        this.modo = modo;
       PosicionSerpientes();
       PosicionEscaleras();
    }

    public void crearJugador(int cantidad) {
        Color[] colores = {Color.PINK, Color.ORANGE, Color.BLUE, Color.GREEN}; // Colores definidos

        for (int i = 0; i < cantidad; i++) {
            // Asigna uno de los colores definidos a cada jugador
            Color color = colores[i % colores.length]; // Usa el índice para obtener el color
            jugadores.add(new Jugador(color));
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int tirarDado() {
        return (int) (Math.random() * 6) + 1;
    }

    private void PosicionSerpientes() {
       //
        if ("10x10".equals(modo)) {
        serpientes.add(new Serpiente(97, 12));
        serpientes.add(new Serpiente(22, 5));
        serpientes.add(new Serpiente(45, 15));
        serpientes.add(new Serpiente(33, 4));
        }
        if ("13x13".equals(modo)) {
        serpientes.add(new Serpiente(160, 56));
        serpientes.add(new Serpiente(140, 110));
        serpientes.add(new Serpiente(80, 49));
        serpientes.add(new Serpiente(18, 6));
        }
        if ("15x15".equals(modo)) {
        serpientes.add(new Serpiente(220, 80));
        serpientes.add(new Serpiente(112, 55));
        serpientes.add(new Serpiente(64, 5));
        serpientes.add(new Serpiente(49, 2));
        }
        
    }
    
    private void PosicionEscaleras() {
        //
        if ("10x10".equals(modo)) {
        escaleras.add(new Escalera(10, 30));
        escaleras.add(new Escalera(4, 67));
        escaleras.add(new Escalera(20, 28));
        escaleras.add(new Escalera(13, 64));

    }        if ("13x13".equals(modo)) {
        escaleras.add(new Escalera(2, 67));
        escaleras.add(new Escalera(80, 108));
        escaleras.add(new Escalera(15, 66));
        escaleras.add(new Escalera(120,153));

    }
            if ("15x15".equals(modo)) {
        escaleras.add(new Escalera(115, 210));
        escaleras.add(new Escalera(20, 85));
        escaleras.add(new Escalera(110, 200));
        escaleras.add(new Escalera(45, 98));

    }
    
    }

    public int verificarSerpiente(int posicion) {
        for (Serpiente serpiente : serpientes) {
            if (posicion == serpiente.getPosicionArriba()) {
                return serpiente.getPosicionBaja();
            }
        }
        return posicion;
    }
    
        public void mensaje() {
        System.out.println(modo);
    }
    
     public int verificarEscalera(int posicion) {
        for (Escalera escalera : escaleras) {
            if (posicion == escalera.getPosicionBaja()) {
                return escalera.getPosicionSube();
            }
        }
        return posicion;
    }

}