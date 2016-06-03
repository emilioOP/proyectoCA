/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Emilio
 */
public class Partido {
    private int id;
    private int idSeleccion1;
    private int idSeleccion2;
    private int arbitro;
    private int arbitroL1;
    private int arbitroL2;
    private int cuartoArbitro;
    private int idEstadio;
    private int publico;
    private String fecha;
    private String horaInicio;
    private String horaTermino;
    private int fase;

    public Partido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSeleccion1() {
        return idSeleccion1;
    }

    public void setIdSeleccion1(int idSeleccion1) {
        this.idSeleccion1 = idSeleccion1;
    }

    public int getIdSeleccion2() {
        return idSeleccion2;
    }

    public void setIdSeleccion2(int idSeleccion2) {
        this.idSeleccion2 = idSeleccion2;
    }

    public int getArbitro() {
        return arbitro;
    }

    public void setArbitro(int arbitro) {
        this.arbitro = arbitro;
    }

    public int getArbitroL1() {
        return arbitroL1;
    }

    public void setArbitroL1(int arbitroL1) {
        this.arbitroL1 = arbitroL1;
    }

    public int getArbitroL2() {
        return arbitroL2;
    }

    public void setArbitroL2(int arbitroL2) {
        this.arbitroL2 = arbitroL2;
    }

    public int getCuartoArbitro() {
        return cuartoArbitro;
    }

    public void setCuartoArbitro(int cuartoArbitro) {
        this.cuartoArbitro = cuartoArbitro;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
    
    
}
