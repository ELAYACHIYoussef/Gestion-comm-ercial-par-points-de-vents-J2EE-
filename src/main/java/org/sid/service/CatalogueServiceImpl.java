package org.sid.service;

import java.util.List;

import org.sid.dao.ICatalogueDAO;
import org.sid.dao.ICommandeDAO;
import org.sid.dao.IUsersDAO;
import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Article_Approvisionnement;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CatalogueServiceImpl implements ICatalogueService {

	private ICatalogueDAO catalogueDAO;
	


	public ICatalogueDAO getCatalogueDAODAO() {
		return catalogueDAO;
	}

	public void setCatalogueDAO(ICatalogueDAO catalogueDAO) {
		this.catalogueDAO = catalogueDAO;
	}

	

	@Override
	public void addProduit(Articles_Stock p) {
		catalogueDAO.addProduit(p);
	}

	@Override
	public List<Articles_Stock> listsProduits() {
		
		return catalogueDAO.listsProduits();
	}
	@Override
	public List<Articles_Prix> listsProduitsP() {
		// TODO Auto-generated method stub
		return catalogueDAO.listsProduitsP();
	}
	@Override
	public Articles_Stock getProduits(int codePdt) {
		// TODO Auto-generated method stub
		return catalogueDAO.getProduits(codePdt);
	}

	@Override
	public void deleteProduit(int codePdt) {
		// TODO Auto-generated method stub
		catalogueDAO.deleteProduit(codePdt);
	}

	@Override
	public void updateProduit(Articles_Stock p) {
		// TODO Auto-generated method stub
	}

	

	


}
