/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitec.suarez;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Perfil {
    
    @Id
    private String id;
    
     private String Nombre;
     private String Paterno;
     private String email;
     private String celular;
     private int edad;

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", Nombre=" + Nombre + ", Paterno=" + Paterno + ", email=" + email + ", celular=" + celular + ", edad=" + edad + '}';
    }

     

    
     
     
    public Perfil() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

      
}
