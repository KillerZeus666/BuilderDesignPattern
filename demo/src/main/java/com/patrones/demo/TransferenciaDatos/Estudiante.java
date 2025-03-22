/*
 * Asignatura: Patrones de Diseño de Software 
 * Patrón Creacional - > Builder
 * Clase: Estudiante - Java.
 */
package com.patrones.demo.TransferenciaDatos;

import java.util.ArrayList;
import java.util.List;

import com.patrones.demo.patronbuilder.InterfaceBuilder;

/**
 *
 * @author Fabrizio Bolaño
 */
public class Estudiante {
    
    private String nombre;
    private int edad;
    private String genero;
    private Direccion direccion;
    private List<Telefonos> telefonos;
    private List<Contactos> contactos;
    
    private Estudiante(String nombre, int edad, String genero, Direccion direccion, 
            List<Telefonos> telefonos, List<Contactos> contactos) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contactos = contactos;
    }

    private Estudiante(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        
    }
    
     public Estudiante() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Telefonos> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefonos> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" + "Nombre=" + nombre + ", Edad=" + edad + ", Genero=" 
                + genero + ", \nDirección=" + direccion + ", \nTelefono=" + telefonos 
                + ", \nContactos=" + contactos + '}';
    }
    
    public static class EstudianteBuilder implements InterfaceBuilder<Estudiante>{

         private String nombre;
         private int edad;
         private String genero;
         private Direccion direccion;
         private final List<Telefonos> telefonos = new ArrayList<>();
         private final List<Contactos> contactos = new ArrayList<>();
        
         public EstudianteBuilder() {
        }

        public EstudianteBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EstudianteBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

       
        public EstudianteBuilder setGenero(String genero) {
            this.genero = genero;
            return this;
        }

     
        public EstudianteBuilder setDireccion(String direccion, String ciudad,String pais, String localidad) {
            this.direccion = new Direccion(direccion, ciudad, pais,localidad);
            return this;
        }
         
         public EstudianteBuilder addTelefonos(String numeroTelefono, String extension, 
                String tipo) {
            telefonos.add(new Telefonos(numeroTelefono, extension, tipo));
            return this;
        } 
         
         public EstudianteBuilder addContactos(String nombres, String numeroTelefono, 
                String extension, String tipo,String direccion, String ciudad, 
                String pais, String localidad) {
            contactos.add(new Contactos(nombres, new Telefonos(numeroTelefono, extension, tipo)
                    ,new Direccion(direccion, ciudad, pais, localidad)));
            return this;
        }
         
         public EstudianteBuilder addContactos(String nombres, String numeroTelefono, 
                String extension, String tipo) {
            contactos.add(new Contactos(nombres, new Telefonos(numeroTelefono, extension, tipo)));
            return this;
        }
         
        @Override
        public Estudiante build() {
            return new Estudiante(nombre, edad, genero, direccion, telefonos, contactos);
        }
        
    }
}



