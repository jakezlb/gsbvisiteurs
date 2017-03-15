/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INT.controleurs;

/**
 *
 * @author btssio
 */
public class ControleurPrincipal {
    
    ControleurVisiteur ctrlVisiteur;
    
    public void afficherLesVisiteurs(){
        this.ctrlVisiteur.getVue().setVisible(true);
    }
    
    public ControleurVisiteur getCtrlVisiteur(){
        return ctrlVisiteur;
    }
    
    public void setControleurVisiteur(ControleurVisiteur ctrlVisiteur) {
        this.ctrlVisiteur = ctrlVisiteur;
    }
    
    
    
}
