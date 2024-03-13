package com.aziz.test;

import com.aziz.dao.voyageDao;
import com.aziz.entities.voyage;

public class voyageTest {
	    public static void main(String[] args) {
	        // créer un objet voyage
	        voyage c = new voyage();
	        c.setNom("hello Becheikh");
	        c.setVille("Nabeul");

	        // ajouter l'objet voyage à la BD
	        voyageDao cltDao = new voyageDao();
	        cltDao.ajouter(c);

	        // Afficher les équipes avant modification
	        System.out.println("Appel de la méthode listerTous avant modification :");
	        for (voyage cl : cltDao.listerTous())
	            System.out.println(cl.getCode() + " " + cl.getNom());

	        // Modifier l'équipe
	        c.setNom("Aziz");
	        cltDao.modifier(c);
	        System.out.println("Appel de la méthode listerTous après modification :");
	        for (voyage cl : cltDao.listerTous())
	            System.out.println(cl.getCode() + " " + cl.getNom());

	        // Supprimer l'équipe
	        //cltDao.supprimer(c);
	        System.out.println("Appel de la méthode listerTous après suppression :");
	        for (voyage cl : cltDao.listerTous())
	            System.out.println(cl.getCode() + " " + cl.getNom());

	       
	    }
	}