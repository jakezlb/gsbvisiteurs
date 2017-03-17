/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.*;
import modele.dao.VisiteurDAO;
import vue.VueVisiteur;

/**
 *
 * @author btssio
 */
public class CtrlVisiteur implements WindowListener, ActionListener {

    private VueVisiteur vue;
    private VisiteurDAO visiteurDAO;
    private CtrlPrincipal ctrlPrincipal;
    private Ecouteur ecouteur = new Ecouteur();

    public CtrlVisiteur(VueVisiteur vue, CtrlPrincipal ctrlPrincipal) {
        this.vue = vue;
        this.ctrlPrincipal = ctrlPrincipal;
        vue.getjButton_BTN_Quitter().addActionListener(ecouteur);
    }

    private class Ecouteur implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == vue.getjButton_BTN_Quitter()) {
                ctrlPrincipal.quitterApplication();
            }
        }
    }

//    ACCESSEURS et MUTATEURS
    public VueVisiteur getVue() {
        return vue;
    }

    public void setVue(VueVisiteur vue) {
        this.vue = vue;
    }

    public VisiteurDAO getVisiteurDAO() {
        return visiteurDAO;
    }

    public void setVisiteurDAO(VisiteurDAO visiteurDAO) {
        this.visiteurDAO = visiteurDAO;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }

//    REACTIONS EVENEMENTIELLES
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
