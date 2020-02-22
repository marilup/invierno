/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.invierno;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class ControladorAlumno {
   @Autowired AlumnoRepositorio alumnRepo;
   //Este metodo busca a todos los alumnos guardados si esque hay
   @GetMapping ("/alumno")
   public List<Alumno> buscarTodos() throws Exception {
       
       return alumnRepo.findAll();
   }
       //El metodo para guardar un nuevo alumno
 
       @PostMapping("/alumno")
       public Estatus guardar (@RequestBody String json)throws Exception{
               ObjectMapper maper=new ObjectMapper();
               Alumno a=maper.readValue(json,Alumno.class);
               alumnRepo.save(a);
               Estatus e =new Estatus();
               e.setMensaje("Guardar con exito");
               e.setSucess(true);
               return e;
               
       
   }
       }
