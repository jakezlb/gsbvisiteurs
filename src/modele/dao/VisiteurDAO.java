/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class VisiteurDAO {

    /**
     * Extraction de tout les visiteurs
     *
     * @return ArrayList<Visiteur> : collection de visiteurs
     * @throws SQLException
     */
    public static ArrayList<Visiteur> getAllVisiteurs() throws SQLException {
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<>();
        Jdbc jdbc = Jdbc.getInstance();
        //préparer la requête
        String requete = "SELECT * FROM VISITEUR";
        PreparedStatement pstmt = jdbc.getConnexion().prepareStatement(requete);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("Vis_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String codePostal = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            String codeSecteur = rs.getString("SEC_CODE");
            String codeLaboratoire = rs.getString("LAB_CODE");
            Secteur leSecteur = SecteurDAO.getOneByCode(codeSecteur);
            Labo leLabo = LaboDAO.getOneByCode(codeLaboratoire);
            lesVisiteurs.add(new Visiteur(matricule, nom, prenom, adresse, codePostal, ville, dateEmbauche, leSecteur, leLabo));
        }
        rs.close();
        pstmt.close();
        return lesVisiteurs;
    }

    /**
     * Extraction d'un visiteur par son matricule
     *
     * @param unNom
     * @return leVisiteur
     * @throws SQLException
     */
    public static Visiteur getOneByNom(String unNom) throws SQLException {
        Visiteur leVisiteur = null;
        Jdbc jdbc = Jdbc.getInstance();
        //préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE VIS_NOM= ?";
        PreparedStatement pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, unNom);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("Vis_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String codePostal = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            String codeSecteur = rs.getString("SEC_CODE");
            String codeLaboratoire = rs.getString("LAB_CODE");
            Secteur leSecteur = SecteurDAO.getOneByCode(codeSecteur);
            Labo leLabo = LaboDAO.getOneByCode(codeLaboratoire);
            leVisiteur = new Visiteur(matricule, nom, prenom, adresse, codePostal, ville, dateEmbauche, leSecteur, leLabo);
        }
        rs.close();
        pstmt.close();
        return leVisiteur;
    }
}
