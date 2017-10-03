package logica;

import UI.INICIO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author crist
 */
public class fperfilusuario {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    String year = timeStamp.substring(0, 4);
    String mes = Integer.toString(Integer.parseInt(timeStamp.substring(4, 6)) - 1);
    String messtring;
    public static Double ganadomespasado;

    public DefaultPieDataset proyeccion() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (mes.equals("0")) {
            messtring = "12";
            year = Integer.toString(Integer.parseInt(timeStamp.substring(0, 4)) - 1);
        } else {
            messtring = mes;
        }

        sSQL = "  SELECT tbcomp.documento,tbcomp.nombre,tbcomp.estimulokpi,tbcomp.apaterno,(SUM(obtiene))AS sumob, "
                + "(IF((COUNT(habilita)-SUM(habilita))=0,1,0))AS habs,(SUM(obtiene)* IF((COUNT(habilita)-SUM(habilita))=0,1,0))"
                + "AS obtreal,tbcomp.idpersona,tbcomp.year,tbcomp.mes ,tbcomp.area,tbcomp.idarea, tbcomp.kpi,tbcomp.subarea FROM   "
                + " (SELECT p.nombre,p.apaterno,p.idpersona,p.documento,r.mes,r.year,a.idarea as idarea,a.nombre AS area,k.nombre AS kpi,s.nombre "
                + "AS subarea,   "
                + fanalisis.bigquery
                + " )AS tbcomp   "
                + " WHERE "
                + " tbcomp.year LIKE '%" + year + "%'"
                + " AND tbcomp.mes LIKE '%" + messtring + "%'"
                + " AND tbcomp.idpersona=" + INICIO.lblinicioidpersona.getText() + " "
                + " GROUP BY tbcomp.documento,tbcomp.year,tbcomp.mes";
        Double valueob;
        Double valuenoob;
        ganadomespasado = 0.0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                if (rs.getString("obtreal") != null) {
                    valueob = Double.parseDouble(rs.getString("obtreal"));
                } else {
                    valueob = 0.0;
                }
                if (rs.getString("obtreal") != null && rs.getString("estimulokpi") != null) {
                    valuenoob = Double.parseDouble(rs.getString("estimulokpi"))
                            - Double.parseDouble(rs.getString("obtreal"));
                } else {
                    valuenoob = 0.0;
                }

                dataset.setValue("Obtenido", valueob);
                dataset.setValue("No Obtenido", valuenoob);
                ganadomespasado = ganadomespasado + Double.parseDouble(rs.getString("obtreal"));
            }

            return dataset;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultCategoryDataset evolutivodinero() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        sSQL = "  SELECT tbcomp.documento,tbcomp.nombre,tbcomp.estimulokpi,tbcomp.apaterno,(SUM(obtiene))AS sumob, "
                + "(IF((COUNT(habilita)-SUM(habilita))=0,1,0))AS habs,(SUM(obtiene)* IF((COUNT(habilita)-SUM(habilita))=0,1,0))"
                + "AS obtreal,tbcomp.idpersona,tbcomp.year,tbcomp.mes ,tbcomp.area,tbcomp.idarea, tbcomp.kpi,tbcomp.subarea FROM   "
                + " (SELECT p.nombre,p.apaterno,p.idpersona,p.documento,r.mes,r.year,a.idarea as idarea,a.nombre AS area,k.nombre AS kpi,s.nombre "
                + "AS subarea,   "
                + fanalisis.bigquery
                + " )AS tbcomp   "
                + " WHERE "
                + " tbcomp.idpersona=" + INICIO.lblinicioidpersona.getText() + " "
                + " GROUP BY tbcomp.documento,tbcomp.mes,tbcomp.year"
                + " ORDER BY tbcomp.year,tbcomp.mes";
        Double valueob;
        Double valuenoob;
        String fecha = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                if (rs.getString("obtreal") != null) {
                    valueob = Double.parseDouble(rs.getString("obtreal"));
                } else {
                    valueob = 0.0;
                }
                if (rs.getString("obtreal") != null && rs.getString("estimulokpi") != null) {
                    valuenoob = Double.parseDouble(rs.getString("estimulokpi"))
                            - Double.parseDouble(rs.getString("obtreal"));
                } else {
                    valuenoob = 0.0;
                }

                String completeyear = rs.getString("tbcomp.year");
                String shortyear = completeyear.substring(2, 4);
                String completemes = rs.getString("tbcomp.mes");
                String shortmes = completemes.substring(0, 6);

                fecha = shortyear + "/ " + shortmes;

                dataset.addValue(valueob, "Obtenido", fecha);
                dataset.addValue(valuenoob, "No Obtenido", fecha);
            }

            return dataset;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultCategoryDataset frecuenciacumpli() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        sSQL = " SELECT AVG(ta.cumplimiento) AS promcumplimiento, ta.idpersona, ta.mes,ta.year"
                + " FROM ( SELECT p.nombre,p.apaterno,p.documento,p.salario,a.nombre AS area,s.nombre AS subarea,"
                + "m.tipo_estimulo,m.estimulo,"
                + "k.nombre AS kpi, r.resultado_kpi,o.comparacion,o.valor_objetivo,o.tipo_objetivo,"
                + "o.valor_ponderado,r.mes,r.year, p.idpersona,"
                + fanalisis.bigquery
                + " ) AS ta WHERE "
                + " ta.idpersona=" + INICIO.lblinicioidpersona.getText() + " "
                + "GROUP BY ta.mes,ta.year"
                + " ORDER BY ta.year,ta.mes";
        Double fre;
        String fecha = "";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                if (rs.getString("promcumplimiento") != null) {
                    fre = Double.parseDouble(rs.getString("promcumplimiento")) / 100;
                } else {
                    fre = 0.0;
                }

                String completeyear = rs.getString("ta.year");
                String shortyear = completeyear.substring(2, 4);
                String completemes = rs.getString("ta.mes");
                String shortmes = completemes.substring(0, 6);

                fecha = shortyear + "/ " + shortmes;

                dataset.addValue(fre, "Promedio de Cumplimiento", fecha);

            }

            return dataset;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultCategoryDataset mixmaxavg() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        sSQL = "  SELECT AVG(ta.obtreal) AS midobt,MAX(ta.obtreal) AS maxobt,MIN(NULLIF(ta.obtreal,0)) AS minobt,ta.mes,ta.year,ta.idsubarea FROM (SELECT tbcomp.documento,tbcomp.nombre,tbcomp.estimulokpi,tbcomp.apaterno,(SUM(obtiene))AS sumob, "
                + " (IF((COUNT(habilita)-SUM(habilita))=0,1,0))AS habs,(SUM(obtiene)* IF((COUNT(habilita)-SUM(habilita))=0,1,0))"
                + " AS obtreal,tbcomp.idpersona,tbcomp.idsubarea,tbcomp.year,tbcomp.mes ,tbcomp.area,tbcomp.idarea, tbcomp.kpi,tbcomp.subarea FROM   "
                + " (SELECT p.nombre,p.apaterno,p.idpersona,p.documento,r.mes,r.year,a.idarea as idarea,a.nombre AS area,k.nombre AS kpi,s.nombre "
                + " AS subarea, s.idsubarea, "
                + fanalisis.bigquery
                + " )AS tbcomp "
                + "GROUP BY tbcomp.documento,tbcomp.mes,tbcomp.year) AS ta "
                + " WHERE ta.idsubarea=" + INICIO.lblinicioidsubarea.getText()
                + " GROUP BY ta.mes,ta.year"
                + " ORDER BY ta.year,ta.mes";
        sSQL2 = "  SELECT AVG(ta.obtreal) AS midobt,MAX(ta.obtreal) AS maxobt,MIN(NULLIF(ta.obtreal,0)) AS minobt,ta.mes,ta.year,ta.idsubarea FROM (SELECT tbcomp.documento,tbcomp.nombre,tbcomp.estimulokpi,tbcomp.apaterno,(SUM(obtiene))AS sumob, "
                + " (IF((COUNT(habilita)-SUM(habilita))=0,1,0))AS habs,(SUM(obtiene)* IF((COUNT(habilita)-SUM(habilita))=0,1,0))"
                + " AS obtreal,tbcomp.idpersona,tbcomp.idsubarea,tbcomp.year,tbcomp.mes ,tbcomp.area,tbcomp.idarea, tbcomp.kpi,tbcomp.subarea FROM   "
                + " (SELECT p.nombre,p.apaterno,p.idpersona,p.documento,r.mes,r.year,a.idarea as idarea,a.nombre AS area,k.nombre AS kpi,s.nombre "
                + " AS subarea, s.idsubarea, "
                + fanalisis.bigquery
                + " )AS tbcomp "
                + "GROUP BY tbcomp.documento,tbcomp.mes,tbcomp.year) AS ta "
                + " WHERE ta.idpersona=" + INICIO.lblinicioidpersona.getText()
                + " GROUP BY ta.mes,ta.year"
                + " ORDER BY ta.year,ta.mes";
        Double maxobt;
        Double minobt;
        Double midobt;
        String fecha = "";
        Double tumid;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sSQL2);

            while (rs.next()) {
                if (rs.getString("maxobt") != null) {
                    maxobt = Double.parseDouble(rs.getString("maxobt"));
                } else {
                    maxobt = 0.0;
                }
                if (rs.getString("minobt") != null) {
                    minobt = Double.parseDouble(rs.getString("minobt"));
                } else {
                    minobt = 0.0;
                }
                if (rs.getString("midobt") != null) {
                    midobt = Double.parseDouble(rs.getString("midobt"));
                } else {
                    midobt = 0.0;
                }

                String completeyear = rs.getString("ta.year");
                String shortyear = completeyear.substring(2, 4);
                String completemes = rs.getString("ta.mes");
                String shortmes = completemes.substring(0, 6);

                fecha = shortyear + "/ " + shortmes;

                dataset.addValue(midobt, "Med", fecha);
                dataset.addValue(minobt, "Min", fecha);
                dataset.addValue(maxobt, "Max", fecha);
            }
            while (rs2.next()) {
                if (rs2.getString("midobt") != null) {
                    tumid = Double.parseDouble(rs2.getString("midobt"));
                } else {
                    tumid = 0.0;
                }

                String completeyear = rs2.getString("ta.year");
                String shortyear = completeyear.substring(2, 4);
                String completemes = rs2.getString("ta.mes");
                String shortmes = completemes.substring(0, 6);

                fecha = shortyear + "/ " + shortmes;
                
                dataset.addValue(tumid, "Tu Med", fecha);
            }

            return dataset;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
