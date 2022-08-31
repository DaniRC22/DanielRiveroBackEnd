/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodani.dni.Service;

import com.portfoliodani.dni.Entity.Hard;
import com.portfoliodani.dni.Repository.RHard;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHard {
    @Autowired
    RHard rHard;
    
    public List<Hard> list(){
        return rHard.findAll();
    }
    
    public Optional<Hard> getOne(int id){
        return rHard.findById(id);
    }
    
    public Optional<Hard> getByNombreH(String nombreH){
        return rHard.findByNombreH(nombreH);
    }
    
    public void save(Hard hard){
        rHard.save(hard);
    }
    
    public void delete(int id){
        rHard.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHard.existsById(id);
    }
    
    public boolean existsByNombreH(String nombreH){
        return rHard.existsByNombreH(nombreH);
    }
}
