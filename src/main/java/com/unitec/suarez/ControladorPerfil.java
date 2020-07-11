/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitec.suarez;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ControladorPerfil {

    //Esta es la inversionde control o inyecion de dependencia
    @Autowired
    RepoPerfil repoPerfil;

    @GetMapping("/hola")
    public Saludo saludar() {

        Saludo s = new Saludo();
        s.setNombre("Edwin Suarez");
        s.setMensaje("Primer Mensaje en Spring rest");
        return s;
    }

    //El siguiente metodo va servir para guardar en un BACKEND nuestros datos
    //del perfil
    //Para guardar Siempre debes usar el Metdoo POST post=Guardar
    @PostMapping("/perfil")

    public Estatus guardar(@RequestBody String json) throws Exception {

//Paso 1: Para recibir ese objeto JSON, es LEERLO y CONVERTIRLO en
//OBJETO JAVA a esto se le llama des-serialización
        ObjectMapper maper = new ObjectMapper();
        Perfil perfil = maper.readValue(json, Perfil.class);
        //Antes de guardar ,tenemos que checar que llego bien
        //todo el objeto Json y se leyo bien

        System.out.println("Pefil leido" + perfil);

        //Aqui este objeto perfil, despues se guarda con una sola linea
        //mongodb, linea para guardar:
        repoPerfil.save(perfil);

        //Despues enviamos un mensaje de estatus al cliente para que
        //se informe si se guardo o no su Perfil
        Estatus e = new Estatus();
        e.setSucces(true);
        e.setMensaje("Perfil guardado con exito!!!");
        return e;
    }

    // Vamos a generar nuestro servicio para actualizar un perfil
    @PutMapping("/perfil")

    public Estatus actualizar(@RequestBody String json) throws Exception {

        ObjectMapper maper = new ObjectMapper();
        Perfil perfil = maper.readValue(json, Perfil.class);
        //Antes de guardar ,tenemos que checar que llego bien
        //todo el objeto Json y se leyo bien

        System.out.println("Pefil leido" + perfil);

        //Aqui este objeto perfil, despues se guarda con una sola linea
        //mongodb, linea para guardar:
        repoPerfil.save(perfil);

        //Despues enviamos un mensaje de estatus al cliente para que
        //se informe si se guardo o no su Perfil
        Estatus e = new Estatus();
        e.setSucces(true);
        e.setMensaje("Perfil Actualizado con exito!!!");
        return e;

    }

    //El metodo para BORRAR un PERFIL
    @DeleteMapping("/perfil/{id}")

//metodo
    public Estatus borrar(@PathVariable String id) {
//Invocamos el repositorio

        repoPerfil.deleteById(id);

//Generamos el mensaje de estatus , para que este informado el cliente
        Estatus e = new Estatus();
        e.setMensaje("Perfil Borrado con Éxito");
        e.setSucces(true);
        return e;

    }

    //METDO PARA BUSCAR TODOS
    @GetMapping("/perfil")

    public List<Perfil> buscarTodos() {
        return repoPerfil.findAll();
    }

    
    //Finalmente el de BUSCAR por ID 
    
    @GetMapping("/perfil/{id}")
    
    public Perfil buscarporID(@PathVariable String id){
    
    return repoPerfil.findById(id).get();
    }
    
    
}


//A este tipo de conrolador estilo REST es muy poderoso y se usa en todas
//las arquitecturas estilo REST, se le denomina CONSTRUCCION DE API'S

//API== Aplication Programing Interface.

//La interface es la union entre cliente(Android) y Servidor( Java)

//subir nuevamente el proyecto a github
//subur