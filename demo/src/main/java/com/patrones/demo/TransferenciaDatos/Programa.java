package com.patrones.demo.TransferenciaDatos;

// Clase Programa
public class Programa {
    private String nombre;
    private int numeroSemestres;

    public Programa(String nombre, int numeroSemestres) {
        this.nombre = nombre;
        this.numeroSemestres = numeroSemestres;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroSemestres() {
        return numeroSemestres;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "nombre='" + nombre + '\'' +
                ", numeroSemestres=" + numeroSemestres +
                '}';
    }
}