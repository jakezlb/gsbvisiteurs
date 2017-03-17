/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.dao.VisiteurDAO;
import vue.VueConnexion;

/**
 *
 * @author btssio
 */
public class CtrlConnexion {
    
    private VueConnexion vueConnexion;
    private CtrlPrincipal ctrlPrincipal;
    private VisiteurDAO visiteurDAO;

    public VisiteurDAO getVisiteurDAO() {
        return visiteurDAO;
    }

    public void setVisiteurDAO(VisiteurDAO visiteurDAO) {
        this.visiteurDAO = visiteurDAO;
    }

    public VueConnexion getVueConnexion() {
        return vueConnexion;
    }

    public void setVueConnexion(VueConnexion vueConnexion) {
        this.vueConnexion = vueConnexion;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
//    public void connexionUser(){
//        this.CtrlConnexion.getVue().setVisible(false);
//        this.CtrlMenu.getVue().setVisible(true);
//    }
    
}
