package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Article_Approvisionnement;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;
import org.sid.entities.Users;

public class CatalogueDAOJPAImpl  implements ICatalogueDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Articles_Stock> listsProduits() {
			Query req=em.createQuery("SELECT p from Articles_Stock p where p.qtePdt>0");
			return req.getResultList();
	}

	@Override
	public List<Articles_Prix> listsProduitsP() {
		Query req=em.createQuery("SELECT p from Articles_Prix p");
		return req.getResultList();
	}

	@Override
	public void addProduit(Articles_Stock p) {
		em.persist(p);			
	}

	@Override
	public Articles_Stock getProduits(int codePdt) {
		if (em != null) {
	        return em.find(Articles_Stock.class, codePdt);
	    } else {
	        // Gérer le cas où em est null
	        return null;
	    }
	}

	@Override
	public void deleteProduit(int codePdt) {
		Articles_Stock p=getProduits(codePdt);
		em.remove(p);	
	}

	@Override
	public void updateProduit(Articles_Stock p) {
		em.merge(p);
	}


	

	@Override
	public void addApprovisionnement(Article_Approvisionnement a) {
		em.persist(a);
		
	}

	@Override
	public List<Article_Approvisionnement> listsApprovisionnements() {
		Query req=em.createQuery("SELECT a from Article_Approvisionnement a");
		return req.getResultList();
	}

	@Override
	public Article_Approvisionnement getApprovisionnement(int codePdt) {
		return em.find(Article_Approvisionnement.class, codePdt);
	}

	@Override
	public void deleteApprovisionnement(int codePdt) {
		Article_Approvisionnement a=getApprovisionnement(codePdt);
		em.remove(a);
		
	}

	@Override
	public void updateApprovisionnement(Article_Approvisionnement a) {
		em.merge(a);
		
	}

	
	

}
