/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modele.dao.VisiteurDAO;
import modele.metier.Labo;
import modele.metier.Secteur;
import vue.VueVisiteur;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class CtrlVisiteur implements WindowListener, ActionListener {

    private VueVisiteur vue;
    private VisiteurDAO visiteurDAO;
    private CtrlPrincipal ctrlPrincipal;
//    private Ecouteur ecouteur = new Ecouteur();
    private ArrayList<Visiteur> lesVisiteurs;
    private final ArrayList<Visiteur> lesVisiteursTrouvee = new ArrayList<>();
    private ArrayList<Labo> lesLaboratoires;
    private ArrayList<Secteur> lesSecteurs;
    private final ArrayList<String> listeVisiteurs = new ArrayList<>();
    private int[] indexRecherche;
    private final DefaultComboBoxModel modeleJComboBoxSecteurs = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modeleJComboBoxLaboratoires = new DefaultComboBoxModel();

    public CtrlVisiteur(VueVisiteur vue, CtrlPrincipal ctrlPrincipal) {
        this.vue = vue;
        this.ctrlPrincipal = ctrlPrincipal;

        this.vue.addWindowListener(this);
        
        init();
        remplirJComboBoxs();
        
        vue.getjButton_BTN_Suivant().addActionListener(this);
        vue.getjButton_BTN_OK().addActionListener(this);
        vue.getjButton_BTN_Precedent().addActionListener(this);
        vue.getjButton_BTN_Quitter().addActionListener(this);

        Visiteur unVisiteur;

        unVisiteur = lesVisiteurs.get(0);
        vue.getjText_Nom().setText(unVisiteur.getNom());
        vue.getjText_Prenom().setText(unVisiteur.getPrenom());
        int i = 0;
        DefaultComboBoxModel dcbmVisit = new DefaultComboBoxModel();
        while (i < lesVisiteurs.size()) {
            Visiteur nomVisiteur;
            nomVisiteur = lesVisiteurs.get(i);
            String nom = nomVisiteur.getNom() + " " + nomVisiteur.getPrenom();
            dcbmVisit.addElement(nom);
            i++;
        }
        vue.getjComboBoxChercher().addActionListener(this);

//        vue.getjText_Adresse().setText(unVisiteur.getAdresse());
//        vue.getjText_CP().setText(unVisiteur.getCodePostal());
//        vue.getjText_Ville().setText(unVisiteur.getVille());
//        String codeSec = unVisiteur.getCodeSecteur();
//        if (codeSec != null) {
//            String secteur;
//            Secteur unSecteur;
//            unSecteur = secteurDAO.getOneById(cnx, codeSec);
//            secteur = unSecteur.getLibelleSecteur();
//            vue.getjTextFieldSecteur().setText(secteur);
//        } else {
//            String secteur = "NA";
//            vue.getjTextFieldSecteur().setText(secteur);
//        }
//        String codeLab = unVisiteur.getCodeLabo();
//        if (codeLab != null) {
//            String labo;
//            Labo unLabo;
//            unLabo = laboDAO.getOneById(cnx, codeLab);
//            labo = unLabo.getNomLabo();
//            vue.getjTextFieldLabo().setText(labo);
//        } else {
//            String labo = "NA";
//            vue.getjTextFieldLabo().setText(labo);
//        }
    }

    private void init() {
        try {
            lesVisiteurs = VisiteurDAO.getAllVisiteurs();
//            lesSecteurs = SecteurDAO.getAllSecteurs();
//            lesLaboratoires = LaboratoireDAO.getAllLaboratoires();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private Visiteur rechercherVisiteur(String extraitVisiteurs) {
//        Visiteur leVisiteur = null;
//        try {
//            leVisiteur = visiteurDAO.getOneByNom(extraitVisiteurs);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(getVue(), "échec de sélection du visiteur");
//        }
//        return leVisiteur;
//    }

    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == vue.getjButton_BTN_Quitter()) {
//            ctrlPrincipal.quitterApplication();
//        } else if (ae.getSource() == vue.getjButton_BTN_OK()) {
//            System.out.println("bouton appuyer");
//            if (vue.getjComboBoxChercher() != null) {
//                Visiteur leVisiteur = rechercherVisiteur(vue.getjComboBoxChercher().getValue());
//            }
//        }
//    }
    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == vue.getjButton_BTN_Quitter()) {
            ctrlPrincipal.quitterApplication();
            System.out.println("bouton quitter appuyer");
        } else if (evenement.getSource() == vue.getjButton_BTN_OK()) {
            afficherLeVisiteur(vue.getjComboBoxChercher().getSelectedIndex());
             System.out.println("bouton ok appuyer");
        } else if (evenement.getSource() == vue.getjButton_BTN_Precedent()) {
            int precedent = vue.getjComboBoxChercher().getSelectedIndex() - 1;
                afficherLeVisiteur(precedent);
        } else if (evenement.getSource() == vue.getjButton_BTN_Suivant()) {
            int suivant = vue.getjComboBoxChercher().getSelectedIndex() + 1;
                afficherLeVisiteur(suivant);
        } else if (evenement.getSource() == vue.getjComboBoxChercher()) {
            int index = vue.getjComboBoxChercher().getSelectedIndex();
            if (index != -1) {
                afficherLeVisiteur(index);
            }
                        } else if (evenement.getSource() == vue.getjComboBox_Labo()) {
                            
                        } else if (evenement.getSource() == vue.getjComboBox_Secteur()) {
                            
//                        } else if (evenement.getSource() == vue.getjButtonMenuGeneral()) {
//                            ctrlPrincipal.afficherMenuGeneral(vue);
//                        }
                    }
//
//                public void afficherUnVisiteur(Visiteur leVisiteur) {
//                    vue.getjText_Nom().setText(leVisiteur.getNom());
                }
    private void afficherLeVisiteur(int indexVisiteur) {
        if (lesVisiteursTrouvee.size() > 0) {
            Visiteur visiteurAffiche = lesVisiteursTrouvee.get(indexVisiteur);

            int indexSecteurVisiteur = 0;
            if (visiteurAffiche.getSecteur() != null) {
                String codeSecteurVisiteur = visiteurAffiche.getSecteur().getCodeSecteur();
                if (codeSecteurVisiteur != null) {
                    int indexSecteur = 1;
                    for (Secteur unSecteur : lesSecteurs) {
                        if (unSecteur.getCodeSecteur().equals(codeSecteurVisiteur)) {
                            indexSecteurVisiteur = indexSecteur;
                        }
                        indexSecteur++;
                    }
                }
            }

            String codeLaboratoireVisiteur = visiteurAffiche.getLaboratoire().getCodeLaboratoire();
            int indexLaboratoire = 0;
            int indexLaboratoireVisiteur = 0;
            for (Labo unLaboratoire : lesLaboratoires) {
                if (unLaboratoire.getCodeLaboratoire().equals(codeLaboratoireVisiteur)) {
                    indexLaboratoireVisiteur = indexLaboratoire;
                }
                indexLaboratoire++;
            }

            vue.getjComboBox_Secteur().setSelectedIndex(indexSecteurVisiteur);
            vue.getjComboBox_Labo().setSelectedIndex(indexLaboratoireVisiteur);
            vue.getjComboBoxChercher().setSelectedIndex(indexVisiteur);

            vue.getjText_Nom().setText(visiteurAffiche.getNom());
            vue.getjText_Prenom().setText(visiteurAffiche.getPrenom());
            vue.getjText_Adresse().setText(visiteurAffiche.getAdresse());
            vue.getjText_CP().setText(visiteurAffiche.getCodePostal());
            vue.getjText_Ville().setText(visiteurAffiche.getVille());
        }
    }
    private void remplirJComboBoxVisiteurs() {
        int index = -1;
        if (indexRecherche != null) {
            index = indexRecherche[vue.getjComboBoxChercher().getSelectedIndex()];
        }
        listeVisiteurs.clear();
        lesVisiteursTrouvee.clear();
        for (Visiteur unVisiteur : lesVisiteurs) {
            lesVisiteursTrouvee.add(unVisiteur);
            listeVisiteurs.add(unVisiteur.getNom() + " " + unVisiteur.getPrenom());
        }
    }
    
     private void remplirJComboBoxs() {
        remplirJComboBoxVisiteurs();

        modeleJComboBoxSecteurs.removeAllElements();
        modeleJComboBoxSecteurs.addElement("Aucun");
        for (Secteur unSecteur : lesSecteurs) {
            modeleJComboBoxSecteurs.addElement(unSecteur.getLibelleSecteur());
        }

        modeleJComboBoxLaboratoires.removeAllElements();
        for (Labo unLaboratoire : lesLaboratoires) {
            modeleJComboBoxLaboratoires.addElement(unLaboratoire.getNomLaboratoire());
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ctrlPrincipal.quitterApplication();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
