package com.aziz.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.aziz.entities.voyage;
import com.aziz.util.JPAutil;
//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class voyageDao {
private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA");
//méthode ajouter d'une entité à la bd
public void ajouter(voyage c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(c);

tx.commit();
}
//méthode modifier d'une entité à partir de la bd
public void modifier(voyage c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(c);
tx.commit();
}
//méthode Supprimer d'une entité à partir de la bd
public void supprimer(voyage c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
c=entityManager.merge(c); // important
entityManager.remove(c);
tx.commit();
}
//méthode Consulter d'une entité à partir de la bd
public voyage consulter(voyage c,Object id)
{
return entityManager.find(c.getClass(), id);
}
//méthode pour lister tous les objets à partir de la bd
public List<voyage> listerTous() {
List<voyage> voyages =
entityManager.createQuery(
"select c from voyage c").getResultList();

return voyages;
}
//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
public List<voyage> listerParNom(String nom) {List<voyage> voyages
=entityManager.createQuery( "select c from voyage c where c.nom like :pnom")
.setParameter("pnom","%"+nom+"%").getResultList();

return voyages; }}
