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
public class vresultados {
    
    private int idresultados;
    private int idkpi;
    private int idpersona;
    private Double resultado_kpi;
    private String mes;
    private int year;

    public vresultados() {
    }

    public vresultados(int idresultados, int idkpi, int idpersona, Double resultado_kpi, String mes, int year) {
        this.idresultados = idresultados;
        this.idkpi = idkpi;
        this.idpersona = idpersona;
        this.resultado_kpi = resultado_kpi;
        this.mes = mes;
        this.year = year;
    }

    public int getIdresultados() {
        return idresultados;
    }

    public void setIdresultados(int idresultados) {
        this.idresultados = idresultados;
    }

    public int getIdkpi() {
        return idkpi;
    }

    public void setIdkpi(int idkpi) {
        this.idkpi = idkpi;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public Double getResultado_kpi() {
        return resultado_kpi;
    }

    public void setResultado_kpi(Double resultado_kpi) {
        this.resultado_kpi = resultado_kpi;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
}
