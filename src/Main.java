/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modele.dao.Jdbc;
import vue.*;
import controleur.*;
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
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@//localhost:1521/", "xe", "GSB_LOCAL", "gsb");
        try {
            Jdbc.getInstance().connecter();
//            JOptionPane.showMessageDialog(null, "connexion réussie");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }

        CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();

        VueConnexion laVueConnexion = new VueConnexion();
        VueVisiteur laVueVisiteur = new VueVisiteur();

        CtrlMenu leControleurMenu = new CtrlMenu();
        CtrlVisiteur leControleurVisiteur = new CtrlVisiteur(laVueVisiteur, leControleurPrincipal);
        //leControleurPrincipal.setCtrlLesAdresses(leControleurLesAdresses);

//        VueLesClients laVueLesClients = new VueLesClients();
//        CtrlLesClients  leControleurLesClients = new CtrlLesClients(laVueLesClients, leControleurPrincipal);
//        leControleurPrincipal.setCtrlLesClients(leControleurLesClients);
        // afficher la vue
        laVueVisiteur.setVisible(true);

    }

}
