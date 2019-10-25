package com.android.miprimerapp.herencia;

public class Persona extends Animal {
    public String direccion;
    public String estadoCivil;
    public String nombre;
    public String nacionalidad;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String getRaza() {
        String miRaza = super.getRaza();
        return "soy humano, pero mi raza es: " + miRaza;
    }
}
