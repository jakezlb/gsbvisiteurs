/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;
import java.sql.Date;
/**
 *
 * @author btssio
 */
public class TestVisiteur {
    public static void main(String[] args) {
        Visiteur visit;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        Secteur secteur = new Secteur("1","secteur 1");
        Labo labo = new Labo("l1", "labo1","chef1");
        visit = new Visiteur("a131", "Villechalane", "Louis", "8 cours lafontaine", "Brest", "29000", Date.valueOf("01-01-2000"), secteur,labo);
        System.out.println(visit);
        System.out.println("\nTest n°2 : mutateurs");
        visit.setMatricule("b323");
        visit.setNom("Dupont");
        visit.setPrenom("Jacques");
        visit.setAdresse("13 rue lachance");
        visit.setVille("Nantes");
        visit.setCodePostal("44000");
        visit.setDateEmbauche(Date.valueOf("27-10-2006"));
        System.out.println(visit);
    }
    
}
