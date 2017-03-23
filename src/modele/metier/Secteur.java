package modele.metier;

import java.io.Serializable;

/**
 * Classe représentant les secteurs
 *
 * @author jlebars
 *
 */
public class Secteur implements Serializable {

    private String codeSecteur;
    private String libelleSecteur;

    /**
     *
     * @param codeSecteur
     * @param libelleSecteur
     */
    public Secteur(String codeSecteur, String libelleSecteur) {
        this.codeSecteur = codeSecteur;
        this.libelleSecteur = libelleSecteur;
    }

    /**
     *
     * @return
     */
    public String getCodeSecteur() {
        return codeSecteur;
    }

    /**
     *
     * @param codeSecteur
     */
    public void setCodeSecteur(String codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    /**
     *
     * @return
     */
    public String getLibelleSecteur() {
        return libelleSecteur;
    }

    /**
     *
     * @param libelleSecteur
     */
    public void setLibelleSecteur(String libelleSecteur) {
        this.libelleSecteur = libelleSecteur;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Secteur{" + "codeSecteur=" + codeSecteur + ", libelleSecteur=" + libelleSecteur + '}';
    }
}
