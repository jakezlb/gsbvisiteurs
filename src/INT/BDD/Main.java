/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INT.BDD;
import INT.modele.DAO.Jdbc;
import INT.vue.*;
import INT.controleurs.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author btssio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//               Jdbc.creer("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:","@localhost:1521:","orcl","gsb", "gsb");
       Jdbc.creer("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:","@localhost:1521:","xe","GSB_LOCAL", "gsb");
        try {
            Jdbc.getInstance().connecter();
            JOptionPane.showMessageDialog(null, "connexion réussie");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexionn");
        }
    }
   
}
