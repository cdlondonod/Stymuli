/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author crist
 */
public class conexion {

    static public String formsubarea;
    static public int frmabierto;
    fconfiguration con = new fconfiguration();
    public String db = con.GetProp("database");
    public String dbip = "jdbc:mysql://"+con.GetProp("ipdatabase")+"/" + db;
    public String user = con.GetProp("userdatabase");
    public String pass = con.GetProp("passworddatabase");

    public conexion() {
    }

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.dbip, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        return link;
    }
    
}
