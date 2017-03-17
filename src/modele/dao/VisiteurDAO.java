/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import modele.dao.Jdbc;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import modele.metier.Visiteur;
import java.util.List;

/**
 *
 * @author btssio
 */
public class VisiteurDAO {

    /**
     * Extraction d'un visiteur, sur son matricule
     *
     * @param matricule
     * @return objet Visiteur
     * @throws SQLException
     */
    public static Visiteur selectOne(String matricule) throws SQLException {

        Visiteur unVisiteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, matricule);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEm = rs.getDate("VIS_DATEEMBAUCHE");
            unVisiteur = new Visiteur(id, nom, prenom, adresse, ville, cp, dateEm);
        }
        return unVisiteur;
    }

    /**
     * Extraction de tous les visiteurs dont le nom contient la chaîne
     * recherchée
     *
     * @param nomVisiteur
     * @return collection de visiteurs
     * @throws SQLException
     */
    public static List<Visiteur> selectAllByNom(String nomVisiteur) throws SQLException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE nom LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%" + nomVisiteur + "%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEm = rs.getDate("VIS_DATEEMBAUCHE");
            unVisiteur = new Visiteur(id, nom, prenom, adresse, ville, cp, dateEm);
            lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }

    /**
     * Extraction de tous les visiteurs
     *
     * @return
     * @throws SQLException
     */
    public static List<Visiteur> selectAll() throws SQLException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEm = rs.getDate("VIS_DATEEMBAUCHE");
            unVisiteur = new Visiteur(id, nom, prenom, adresse, ville, cp, dateEm);
            lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }
    /**
     * Extraction de tous les visiteurs, ordonnées
     * @param cleTri 1=>ID ; 2=>NOM
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection des visiteurs
     * @throws SQLException 
     */
    public static List<Visiteur> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISTEUR";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID";
                break;
            case 2: // Tri par nom
                requete += " ORDER BY NOM";
                break;
        }
        if (cleTri == 1 || cleTri == 2) {
            switch (ordreTri) {
                case 1: // Tri croissant
                    requete += " ASC";
                    break;
                case 2: // Tri décroissant
                    requete += " DESC";
                    break;
            }
        }
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEm = rs.getDate("VIS_DATEEMBAUCHE");
            unVisiteur = new Visiteur(id, nom, prenom, adresse, ville, cp, dateEm);
            lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }
    
    public static boolean connexionUser(String nom, String mdp) throws SQLException {
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE VIS_NOM = ? AND VIS_DATEEMBAUCHE = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, nom);
        pstmt.setString(2, mdp);
        rs = pstmt.executeQuery();
        return rs.first();
    }
}
