/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliodani.dni.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHard {
    @NotBlank
    private String nombreH;
    private long porcentaje;

    public dtoHard() {
    }

    public dtoHard(String nombreH, long porcentaje) {
        this.nombreH = nombreH;
        this.porcentaje = porcentaje;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }

    
    
}
