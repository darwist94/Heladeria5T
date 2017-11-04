
package clases;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {
    
    public String db="db_Heladeria";
    public String url="jdbc:mysql://localhost/"+db;
    public String user="root";
    public String pass="";

    public ConexionMySQL() {
    }
    public Connection conectar(){
        Connection link=null;
        
        try{
           //cargamos el drivers MySQL
            Class.forName("org.gjt.mm.mysql.Driver");
           //creamos un enlace hacia la base de datos
            link=DriverManager.getConnection(this.url,this.user,this.pass);
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return link;
    }
    
}
