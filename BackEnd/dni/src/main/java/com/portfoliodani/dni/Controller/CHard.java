/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodani.dni.Controller;

import com.portfoliodani.dni.Dto.dtoHard;
import com.portfoliodani.dni.Entity.Hard;
import com.portfoliodani.dni.Security.Controller.Mensaje;
import com.portfoliodani.dni.Service.SHard;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hard")
@CrossOrigin(origins = "http://localhost:4200")
public class CHard {
    @Autowired
    SHard sHard;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hard>> list(){
        List<Hard> list = sHard.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hard> getById(@PathVariable("id")int id){
        if(!sHard.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Hard hard = sHard.getOne(id).get();
        return new ResponseEntity(hard, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHard.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sHard.delete(id);
        return new ResponseEntity(new Mensaje("H&S eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHard dtohard){
        if(StringUtils.isBlank(dtohard.getNombreH())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHard.existsByNombreH(dtohard.getNombreH())){
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Hard hard = new Hard(
        dtohard.getNombreH(), dtohard.getPorcentaje());
        sHard.save(hard);
        return new ResponseEntity(new Mensaje("Hard & Soft creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHard dtohard){
        if(!sHard.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sHard.existsByNombreH(dtohard.getNombreH()) && sHard.getByNombreH(dtohard.getNombreH()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohard.getNombreH())){
            return new ResponseEntity(new Mensaje("el campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Hard hard = sHard.getOne(id).get();
        hard.setNombreH(dtohard.getNombreH());
        hard.setPorcentaje(dtohard.getPorcentaje());
        
        sHard.save(hard);
        return new ResponseEntity(new Mensaje("Hard & Soft actualizado"), HttpStatus.OK);
    }
    
}
