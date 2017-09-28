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
public class vobjetivos {
    
    private int idobjetivos;
    private int idmodelo;
    private int idkpi;
    private String comparacion;
    private Double valor_objetivo;
    private String tipo_objetivo;
    private Double valor_ponderado =100.0;

    public vobjetivos() {
    }

    public vobjetivos(int idobjetivos, int idmodelo, int idkpi, String comparacion, Double valor_objetivo, String tipo_objetivo, Double valor_ponderado) {
        this.idobjetivos = idobjetivos;
        this.idmodelo = idmodelo;
        this.idkpi = idkpi;
        this.comparacion = comparacion;
        this.valor_objetivo = valor_objetivo;
        this.tipo_objetivo = tipo_objetivo;
        this.valor_ponderado = valor_ponderado;
    }

    public int getIdobjetivos() {
        return idobjetivos;
    }

    public void setIdobjetivos(int idobjetivos) {
        this.idobjetivos = idobjetivos;
    }

    public int getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    public int getIdkpi() {
        return idkpi;
    }

    public void setIdkpi(int idkpi) {
        this.idkpi = idkpi;
    }

    public String getComparacion() {
        return comparacion;
    }

    public void setComparacion(String comparacion) {
        this.comparacion = comparacion;
    }

    public Double getValor_objetivo() {
        return valor_objetivo;
    }

    public void setValor_objetivo(Double valor_objetivo) {
        this.valor_objetivo = valor_objetivo;
    }

    public String getTipo_objetivo() {
        return tipo_objetivo;
    }

    public void setTipo_objetivo(String tipo_objetivo) {
        this.tipo_objetivo = tipo_objetivo;
    }

    public Double getValor_ponderado() {
        return valor_ponderado;
    }

    public void setValor_ponderado(Double valor_ponderado) {
        this.valor_ponderado = valor_ponderado;
    }


   
}
