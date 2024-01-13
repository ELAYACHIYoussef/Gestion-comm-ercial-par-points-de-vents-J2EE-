package org.sid.dao;

import java.util.List;

import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Article_Approvisionnement;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;

public interface ICatalogueDAO {
	public void addProduit(Articles_Stock p);
	public List<Articles_Stock> listsProduits();
	public List<Articles_Prix> listsProduitsP();
	public Articles_Stock getProduits (int codePdt);
	public void deleteProduit(int codePdt);
	public void updateProduit(Articles_Stock p);
	
	public void addApprovisionnement(Article_Approvisionnement a);
	public List<Article_Approvisionnement> listsApprovisionnements();	
	public Article_Approvisionnement getApprovisionnement (int codePdt);
	public void deleteApprovisionnement(int codePdt);
	public void updateApprovisionnement(Article_Approvisionnement a);
}
