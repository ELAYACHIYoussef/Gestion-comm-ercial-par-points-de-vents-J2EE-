<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<html>
   <head>
      <title>Inscrire</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	  <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
   </head>
   
   <body>
<section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

   			 	<s:form class="mx-1 mx-md-4" name="signupForm" action="addUser" method = "post">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <s:textfield id="form3Example1c" name="login" class="form-control" theme="simple" />
                      <label class="form-label" for="form3Example1c">Username</label>
                    </div>
                  </div>
                  
                  <div class="form-group">
                                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                    <label class="form-label" for="form3Example3c">Security Question</label>
                                    <s:select id="form3Example3c" class="form-control" 
                                              list="#{'In what city did you meet your spouse/significant other?':'In what city did you meet your spouse/significant other?', 'In what city or town did your mother and father meet?':'In what city or town did your mother and father meet?', 'What was the first exam you failed?':'What was the first exam you failed?', 'What is your favorite movie?':'What is your favorite movie?'}" 
                                              name="securityQuestion" 
                                              value="In what city did you meet your spouse/significant other?" />
                                 </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <s:textfield id="form3Example1c" name="answer" class="form-control" theme="simple" />
                      <label class="form-label" for="form3Example3c">Answer</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4c" class="form-control" />
                      <label class="form-label" for="form3Example4c">Password</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="form3Example4cd" class="form-control" />
                      <label class="form-label" for="form3Example4cd">Repeat your password</label>
                    </div>
                  </div>

                  <div class="form-check d-flex justify-content-center mb-5">
                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                    <label class="form-check-label" for="form2Example3">
                      I agree all statements in <a href="#!">Terms of service</a>
                    </label>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="button" class="btn btn-primary btn-lg">Register</button>
                  </div>

                </s:form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                  class="img-fluid" alt="Sample image">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
       
       <div class="container px-4 py-5 mx-auto">
   			 <div class="card card0">  
   			 <center>
   			 	<s:form name="signupForm" action="addUser" method = "post">
   				 <div class="row justify-content-center my-auto">
       				   <div class="col-md-8 col-10 my-5">
            			 <h3 class="mb-5 text-center heading">Inscrire</h3>
            		<s:textfield class="form-control" name="login" label="Username "/>
    				<s:select label="Select a Security Question" 
						list="#{'In what city did you meet your spouse/significant other?':'In what city did you meet your spouse/significant other?', 'In what city or town did your mother and father meet?':'In what city or town did your mother and father meet?', 'What was the first exam you failed?':'What was the first exam you failed?', 'What is your favorite movie?':'What is your favorite movie?'}" 
						name="securityQuestion" 
						value="In what city did you meet your spouse/significant other?" />
    				<s:textfield class="form-control" name="answer" label="Enter Answer "/>
            		<s:password class="form-control" name="pass" label="Enter Password " />
            		<s:password class="form-control" name="confirmPass" label="Confirm Password " />
            		<s:submit value="Inscrire" class="btn btn-warning" />
            		</div>
      			</div>
  			</s:form>   
  		</center>     
     		  </div>
     	</div>
     	
      <s:property value="message"/>
        
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
   </body>
</html>