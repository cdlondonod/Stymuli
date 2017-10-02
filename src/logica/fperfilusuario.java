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
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author crist
 */
public class fperfilusuario {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
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
                + " GROUP BY tbcomp.documento,tbcomp.mes,tbcomp.year";
        Double valueob;
        Double valuenoob;
        ganadomespasado=0.0;
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
                ganadomespasado=ganadomespasado+Double.parseDouble(rs.getString("obtreal"));
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
                + " GROUP BY tbcomp.documento,tbcomp.mes,tbcomp.year";
        Double valueob;
        Double valuenoob;
        String fecha="";
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
                
                String completeyear=rs.getString("tbcomp.year");
                String shortyear=completeyear.substring(2, 4);
                String completemes=rs.getString("tbcomp.mes");
                String shortmes=completemes.substring(0, 6);
                
                    fecha= shortyear+ "/ " + shortmes;

                dataset.addValue(valueob, "Obtenido", fecha);
                dataset.addValue(valuenoob, "No Obtenido", fecha);
            }
            

            return dataset;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
}
