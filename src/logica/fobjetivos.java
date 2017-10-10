/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.frmmodelo;
import datos.vobjetivos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class fobjetivos {
fconfiguration con=new fconfiguration();
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    static public Double totalponderado;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IDmodelo", "IDkpi", "Nombre KPI", "Relación", "Objetivo", "Tipo de KPI", "Peso"};

        String[] registro = new String[8];

        totalponderado = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = " SELECT o.idobjetivos, o.idmodelo, o.idkpi, k.nombre, o.comparacion, o.valor_objetivo, "
                + "o.tipo_objetivo, o.valor_ponderado FROM objetivos o INNER JOIN modelo m ON o.idmodelo=m.idmodelo "
                + "INNER JOIN kpi k ON k.idkpi=o.idkpi "
                + "where "
                + "k.nombre like '%" + buscar + "%' and o.idmodelo=" + frmmodelo.txtidmodelo.getText()
                + " order by o.idkpi";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idobjetivos");
                registro[1] = rs.getString("idmodelo");
                registro[2] = rs.getString("idkpi");
                registro[3] = rs.getString("k.nombre");
                registro[4] = rs.getString("comparacion");
                registro[5] = con.numberFormatDisplay(Double.parseDouble(rs.getString("valor_objetivo")));
                registro[6] = rs.getString("tipo_objetivo");
                registro[7] = con.numberFormatDisplay(Double.parseDouble(rs.getString("valor_ponderado"))) + "%";

                if (rs.getString("tipo_objetivo").toString().equals("Ponderado")) {
                    totalponderado = totalponderado + rs.getDouble("valor_ponderado");
                }

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vobjetivos dts) {
        sSQL = "insert into objetivos (idmodelo,idkpi,comparacion,valor_objetivo,tipo_objetivo,valor_ponderado)"
                + "values (?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdmodelo());
            pst.setInt(2, dts.getIdkpi());
            pst.setString(3, dts.getComparacion());
            pst.setDouble(4, dts.getValor_objetivo());
            pst.setString(5, dts.getTipo_objetivo());
            pst.setDouble(6, dts.getValor_ponderado());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(vobjetivos dts) {
        sSQL = "update objetivos set idmodelo=?,idkpi=?,comparacion=?,valor_objetivo=?,tipo_objetivo=?,valor_ponderado=?"
                + " where idobjetivos=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdmodelo());
            pst.setInt(2, dts.getIdkpi());
            pst.setString(3, dts.getComparacion());
            pst.setDouble(4, dts.getValor_objetivo());
            pst.setString(5, dts.getTipo_objetivo());
            pst.setDouble(6, dts.getValor_ponderado());

            pst.setInt(7, dts.getIdobjetivos());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(vobjetivos dts) {
        sSQL = "delete from objetivos where idobjetivos=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdobjetivos());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
}
