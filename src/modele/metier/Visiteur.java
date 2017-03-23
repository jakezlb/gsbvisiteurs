package modele.metier;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe représentant les visiteurs
 *
 * @author btssio
 *
 */

public class Visiteur implements Serializable {

    //touts les éléments de la table sont de type NVARCHAR2 sauf la date embauche
    private String matricule; 
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private Date dateEmbauche;
    private Secteur secteur;
    private Labo laboratoire;
    
    /**
     * Constructeur avec les 9 attributs
     * @param matricule : matricule du visiteur
     * @param nom
     * @param prenom
     * @param adresse
     * @param codePostal
     * @param ville
     * @param dateEmbauche
     * @param secteur
     * @param laboratoire
     */
    public Visiteur(String matricule, String nom, String prenom, String adresse, String codePostal, String ville, Date dateEmbauche, Secteur secteur, Labo laboratoire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.dateEmbauche = dateEmbauche;
        this.secteur = secteur;
        this.laboratoire = laboratoire;
    }

    /**
     *
     * @return
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     *
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     *
     * @param codePostal
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     *
     * @return
     */
    public String getVille() {
        return ville;
    }

    /**
     *
     * @param ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    /**
     *
     * @return
     */
    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    /**
     *
     * @param dateEmbauche
     */
    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    /**
     *
     * @return
     */
    public Secteur getSecteur() {
        return secteur;
    }

    /**
     *
     * @param secteur
     */
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    /**
     *
     * @return
     */
    public Labo getLaboratoire() {
        return laboratoire;
    }

    /**
     *
     * @param laboratoire
     */
    public void setLaboratoire(Labo laboratoire) {
        this.laboratoire = laboratoire;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Visiteur{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + ", code secteur=" + secteur.getCodeSecteur() + ", code laboratoire=" + laboratoire.getCodeLaboratoire() + '}';
    }
}