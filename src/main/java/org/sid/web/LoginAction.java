package org.sid.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.sid.entities.Users;
import org.sid.service.ICatalogueService;
import org.sid.service.IUserService;
import org.sid.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

   private int codeUser;
   private String login;
   private String pass;
   private String oldPass;
   private String securityQuestion;
   private String confirmPass;
   private String answer;
   public Users user=new Users();
	public List<Users> users;
	public int codeU;
	SessionMap<String,String> sessionmap;  
	private String message;


	
	
	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public int getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getCodeU() {
		return codeU;
	}

	public void setCodeU(int codeU) {
		this.codeU = codeU;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




	@Autowired
	private ICatalogueService catalogueService=SingletonService.getCatalogueService();

	@Autowired
	private IUserService userService =SingletonService.getUserServiceImpl();

	
	
   public String execute() {
	   ActionContext.getContext().getSession().clear();
	    sessionmap.invalidate();
       Map<String, Object> session = ActionContext.getContext().getSession();
       session.put("loggedInUser", null);


	   if (ActionContext.getContext().getSession().containsKey("user")) {
	        return "success";
	    }
	    Users user = userService.getUserByUsernameAndPassword(login, pass);
	    
	    if (user != null) {
	        // User successfully logged in
	        session.put("user", user);
            session.put("loggedInUser", user.getLogin() );
	        ActionContext.getContext().getSession().remove("loginErrorMessage");

	        // Clear the session errors

	        return "success";
	    } else {
	        // Login failed, display error message
	        message = "Nom d'utilisateur ou mot de passe incorrect";
	        ActionContext.getContext().put("message", message);

	        // Store the error message in the session to display it on the login page
	        ActionContext.getContext().getSession().put("loginErrorMessage", message);

	        return "error";
	    }
   }
   
   public String logout() {
	    // Clear the user session
	    ActionContext.getContext().getSession().clear();
	    sessionmap.invalidate();
       Map<String, Object> session = ActionContext.getContext().getSession();
       session.put("loggedInUser", null);

	    // Redirect to the login page
	    return "success";
	}
   
   
   public String addUsers() {
	    message = null;
	    ActionContext.getContext().getSession().remove("message");
	   if(userService.getUserByUsername(login) != null || !pass.equals(confirmPass)) {
			
			if (userService.getUserByUsername(login) != null) {
		        message = "Ce nom d'utilisateur est déjà utilisé. Veuillez en choisir un autre.";
		        ActionContext.getContext().put("message", message);
		    }
			if (!pass.equals(confirmPass)) {
		        message = "Les mots de passe ne correspondent pas.";
		        ActionContext.getContext().put("message", message);
		    }
	        return "error";
		}
	   Users newUser = new Users();
	    newUser.setLogin(login);
	    newUser.setPass(pass);
	    newUser.setSecurityQuestion(securityQuestion);
	    newUser.setAnswer(answer);
        message = "Utilisateur crée avec succes, vous pouvez vous connecter maintenant";
        ActionContext.getContext().put("message", message);

	   userService.addUser(newUser);
	   return "success";
   }
   
   public String updatePas() {
	   user=userService.getUserByUsername(login);
	   users=userService.listsUsers();
	   return SUCCESS;
   }
   
   public String indexUser() {
	   users=userService.listsUsers();
	   return SUCCESS;
	   
   }
   
   public String savePass() {
	    message = null;
	    ActionContext.getContext().getSession().remove("message");
	    Users user = userService.getUserByUsername(login);
	    if(user == null || !user.getPass().equals(oldPass) || !pass.equals(confirmPass)) {
	    	if (!user.getPass().equals(oldPass)) {
	    		message = "Mot de pass incorrecte";
			    ActionContext.getContext().put("message", message);
		    }
	    	if (!pass.equals(confirmPass)) {
	    		message = "Les mots de passe ne correspondent pas.";
		        ActionContext.getContext().put("message", message);
		    }
	        return "error";
	    }
	    user.setPass(pass);

	    if (userService.updateUser(user)) {
	        // Password update successful
	        message = "Votre mot de passe a été réinitialisé avec succès. Veuillez vous connecter avec votre nouveau mot de passe.";
	        ActionContext.getContext().put("message", message);
	        return "success";
	    } else {
	        // Password update failed
	        message = "Impossible de réinitialiser le mot de passe. Veuillez réessayer plus tard.";
	        ActionContext.getContext().put("message", message);
	        return "error";
	    }
		  
	    
	   
   }
   

   

	@Override
	public void setSession(Map map) {
		sessionmap=(SessionMap)map;  
	    sessionmap.put("","true");  
	}
	
	public String forgotPass() {
		message = null;
		 // Check if the provided username, security question, and answer are valid
	    Users user = userService.getUserByUsername(login);
	    
	    
	    if(user == null || !user.getSecurityQuestion().equals(securityQuestion) || !user.getAnswer().equals(answer) || !pass.equals(confirmPass)) {
	    	if (user == null) {
		        message = "Nom d'utilisateur incorrect.";
		        ActionContext.getContext().put("message", message);
		        return "fail";
		    }
	    	if (!user.getSecurityQuestion().equals(securityQuestion) || !user.getAnswer().equals(answer)) {
			    message = "Question de sécurité ou Réponse incorrecte.";
			    ActionContext.getContext().put("message", message);
		    }
	    	if (!pass.equals(confirmPass)) {
		        message = "Les mots de passe ne correspondent pas.";
		        ActionContext.getContext().put("message", message);
		    }
	        return "fail";
	    }
	    
	
	    user.setPass(pass);
	    
	    
	    // Update the user in the database (you need to implement this method)
	    if (userService.updateUser(user)) {
	        // Password update successful
	        message = "Votre mot de passe a été réinitialisé avec succès. Veuillez vous connecter avec votre nouveau mot de passe.";
	        ActionContext.getContext().put("message", message);
	        return "success";
	    } else {
	        // Password update failed
	        message = "Impossible de réinitialiser le mot de passe. Veuillez réessayer plus tard.";
	        ActionContext.getContext().put("message", message);
	        return "fail";
	    }
	

		
		
	}
	public String forgot() {
		
		return SUCCESS;
	}
	
	
	
	
	
}