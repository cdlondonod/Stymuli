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
public class vtrabajador extends vpersona {
    
    private int idarea;
    private int idsubarea;
    private Double salario;
    private String acceso;

    private String password;
    private String estado;
    private String  cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public vtrabajador(String cargo) {
        this.cargo = cargo;
    }

    public vtrabajador() {
    }

    public vtrabajador(int idarea, int idsubarea, Double salario, String acceso, String password, String estado) {
        this.idarea = idarea;
        this.idsubarea = idsubarea;
        this.salario = salario;
        this.acceso = acceso;
   
        this.password = password;
        this.estado = estado;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

  


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
