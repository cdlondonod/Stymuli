/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author crist
 */
public class vmodelo {
    
    private int idmodelo;
    private int idarea;
    private int idsubarea;
    private String tipo_estimulo;
    private Double estimulo;
    private String descripcion;

    public vmodelo() {
    }

    public vmodelo(int idmodelo, int idarea, int idsubarea, String tipo_estimulo, Double estimulo, String descripcion) {
        this.idmodelo = idmodelo;
        this.idarea = idarea;
        this.idsubarea = idsubarea;
        this.tipo_estimulo = tipo_estimulo;
        this.estimulo = estimulo;
        this.descripcion = descripcion;
    }

    public int getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public int getIdsubarea() {
        return idsubarea;
    }

    public void setIdsubarea(int idsubarea) {
        this.idsubarea = idsubarea;
    }

    public String getTipo_estimulo() {
        return tipo_estimulo;
    }

    public void setTipo_estimulo(String tipo_estimulo) {
        this.tipo_estimulo = tipo_estimulo;
    }

    public Double getEstimulo() {
        return estimulo;
    }

    public void setEstimulo(Double estimulo) {
        this.estimulo = estimulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
