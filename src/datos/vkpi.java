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
public class vkpi {
    
    private int idkpi;
    private String nombre;
    private String descripcion;

    public vkpi() {
    }

    public vkpi(int idkpi, String nombre, String descripcion) {
        this.idkpi = idkpi;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdkpi() {
        return idkpi;
    }

    public void setIdkpi(int idkpi) {
        this.idkpi = idkpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
