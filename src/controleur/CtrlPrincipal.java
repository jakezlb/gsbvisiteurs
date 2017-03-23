/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.dao.VisiteurDAO;
import vue.VueConnexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author btssio
 */
public class CtrlPrincipal implements WindowListener, ActionListener {
    
    CtrlVisiteur ctrlVisiteur;
    CtrlMenu ctrlMenu;
    private VueConnexion vue; // LA VUE MAIN
    
    public void afficherLesVisiteurs(){
        this.ctrlMenu.getVue().setVisible(false);
        this.ctrlVisiteur.getVue().setVisible(true);
    }
     
    public void afficherMenu() {
        this.ctrlMenu.getVue().setVisible(true);
        this.ctrlVisiteur.getVue().setVisible(false);
    }
    
    // ACCESSEURS ET MUTATEURS
    public CtrlVisiteur getCtrlVisiteur(){
        return ctrlVisiteur;
    }
    
    public void setControleurVisiteur(CtrlVisiteur ctrlVisiteur) {
        this.ctrlVisiteur = ctrlVisiteur;
    }
   
    public CtrlMenu getCtrlMenu() {
        return ctrlMenu;
    }
    
    public void setControleurMenu(CtrlMenu ctrlMenu) {
        this.ctrlMenu = ctrlMenu;
    }
    
    public VueConnexion getVue() {
        return vue;
    }

    public void setVue(VueConnexion vue) {
        this.vue = vue;
    }
    
    // QUITTER L'APPLICATION
    public void quitterApplication() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "GSB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
    
}
