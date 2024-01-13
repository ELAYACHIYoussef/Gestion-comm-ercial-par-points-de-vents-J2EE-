<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
      <title>Login</title>
		<link href="css/login.css" rel="stylesheet" />
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	 <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
 	 <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css'>
 	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 	 
   </head>



   
   <body>
       <div class="container">
         <div class="row align-items-center justify-content-center" style="height: 100vh;">
            <div class="col-md-4  bg-light" style="border-radius: 10px;">
       <s:form action="loginaction" method="post" class="login">
            	<center>
  <fieldset>
    <legend class="legend">Login</legend>
    
    <div class="input">
          <span><i class="fa fa-envelope-o"></i></span>
  			<s:textfield name="login" placeholder="Username" class="form-control" theme="simple"/>
    </div>
  							<div class="input">
          <span><i class="fa fa-lock"></i></span>
      <s:password name="pass" placeholder="Password" class="form-control" required="true" theme="simple" />
    </div>
							<s:submit value="Log in" class="btn btn-dark btn-lg" theme="simple"></s:submit>
							</fieldset>
														</center>
							
  			</s:form>
  			<form action = "New" method = "post">
  			<br>
      <div class="bottom text-center mb-5">
      <p class="sm-text mx-auto mb-3">Don't have an account?
      <input type = "submit" value = "Sign up" class="btn btn-outline-dark" /></p>
      </div>
      </form>

      <p align="center" class="text-danger"><s:property value="message"/></p>
  			
   
  		  </div>
         </div>
      </div>

           <br>
    
               <script src="js/login.js"></script>
    
   <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> 
  
   </body>
   
</html>