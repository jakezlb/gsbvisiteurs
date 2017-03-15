/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INT.controleurs;

import javax.swing.JOptionPane;

/**
 *
 * @author btssio
 */
public class ControleurPrincipal {
    
    ControleurVisiteur ctrlVisiteur;
    ControleurMenu ctrlMenu;
    
    public void afficherLesVisiteurs(){
        this.ctrlMenu.getVue().setVisible(false);
        this.ctrlVisiteur.getVue().setVisible(true);
    }
     
    public void afficherMenu() {
        this.ctrlMenu.getVue().setVisible(true);
        this.ctrlVisiteur.getVue().setVisible(false);
    }
    
    // ACCESSEURS ET MUTATEURS
    public ControleurVisiteur getCtrlVisiteur(){
        return ctrlVisiteur;
    }
    
    public void setControleurVisiteur(ControleurVisiteur ctrlVisiteur) {
        this.ctrlVisiteur = ctrlVisiteur;
    }
   
    public ControleurMenu getCtrlMenu() {
        return ctrlMenu;
    }
    
    public void setControleurMenu(ControleurMenu ctrlMenu) {
        this.ctrlMenu = ctrlMenu;
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
    
    
}
