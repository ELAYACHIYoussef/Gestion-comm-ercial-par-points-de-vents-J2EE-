package org.sid.web;

import java.util.List;

import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;
import org.sid.service.ICatalogueService;
import org.sid.service.IUserService;
import org.sid.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component
public class ProduitAction extends ActionSupport{
	public Articles_Stock produit= new Articles_Stock();//1
	public Articles_Prix produitp=new Articles_Prix();//2
	public int codeUser; public String login; public String pass;
	public Users user=new Users();
	public List<Articles_Stock> produits;
	public List<Articles_Prix> produitsP;//3
	
	public List<Users> users;
	public commandes commande =new commandes();
	public List<commandes> commandes;
	public int code;
	public int codeU;
	
	@Autowired
	private ICatalogueService catalogueService= SingletonService.getCatalogueService();
	
	@Autowired
	private IUserService userService =SingletonService.getUserServiceImpl();
	
	public String indexH() {
		users=userService.listsUsers();
		return SUCCESS;
	}
	
	public String indexP() {
		users=userService.listsUsers();
		return SUCCESS;
	}
	
	public String New() {
		
		return SUCCESS;
	}
	
		public String cos() {
			produits=catalogueService.listsProduits();
			
			//commandes=service.listsCommandes();
		return SUCCESS;
	}
	
	public String loginPass() {
		
		return SUCCESS;
	}
	
	public String addUser(){
		 
		userService.addUser(user);
		return SUCCESS;
		
	}

	public String index() {
		
		produits=catalogueService.listsProduits();
		produitsP=catalogueService.listsProduitsP();
		users=userService.listsUsers();
		return SUCCESS;
	}

	public String comande() {
		
		produit=catalogueService.getProduits(code);
		produits=catalogueService.listsProduits();
		return SUCCESS;
	}
	
	
	public String acmd() {
		
		//service.addCommande(commande);
		//commandes=service.listsCommandes();
		
		return SUCCESS;
	}
	
	public String indexCmd() {
		
		
		//commandes=service.listsCommandes();
		return SUCCESS;
	}
	
	public String facture() {

		//service.addCommande(commande);
		//commandes=service.listsCommandes();
		return SUCCESS;
	}
	
	
	
	private String username;
	private String password;
 
	
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}

}
