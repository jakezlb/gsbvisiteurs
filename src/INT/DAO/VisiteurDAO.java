/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INT.DAO;
import INT.modele.DAO.Jdbc;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import INT.modele.Metier.Visiteur;
import java.util.List;


/**
 *
 * @author btssio
 */
public class VisiteurDAO {
    
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
            unVisiteur = new Visiteur(id, nom, prenom,  adresse, ville, cp, dateEm);
        }
        return unVisiteur;
    }
    
    
    public static List<Visiteur> selectAll() throws SQLException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur = null;
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
            unVisiteur = new Visiteur(id, nom, prenom,  adresse, ville, cp, dateEm);
            lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }
    
}
