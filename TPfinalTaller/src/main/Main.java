package main;

import controlador.Controlador;

import java.io.IOException;

import modelo.BaseDatos;
import modelo.Serializador;

public class Main {
    public Main() 
    {
        super();
    }

    public static void main(String[] args) {
        Main main = new Main();
        BaseDatos bd;
        Serializador sBD = new Serializador();
        try {
            bd = sBD.recuperarBaseDeDatos();
        } catch (ClassNotFoundException | IOException e) {
            bd = new BaseDatos();
        }
        Controlador controlador = new Controlador(bd);
    }
}
