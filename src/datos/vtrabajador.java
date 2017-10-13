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
    private int idpersonaupdatedt;
    private Double salario;
    private String acceso;

    private String password;
    private String estado;
    private String  cargo;

    public vtrabajador() {
    }

    public vtrabajador(int idarea, int idsubarea, int idpersonaupdatedt, Double salario, String password, String estado, String cargo) {
        this.idarea = idarea;
        this.idsubarea = idsubarea;
        this.idpersonaupdatedt = idpersonaupdatedt;
        this.salario = salario;
        this.password = password;
        this.estado = estado;
        this.cargo = cargo;
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

    public int getIdpersonaupdatedt() {
        return idpersonaupdatedt;
    }

    public void setIdpersonaupdatedt(int idpersonaupdatedt) {
        this.idpersonaupdatedt = idpersonaupdatedt;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    
    
}
