/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliodani.dni.Repository;

import com.portfoliodani.dni.Entity.Hard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHard extends JpaRepository<Hard, Integer>{
    public Optional<Hard> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
    
}
