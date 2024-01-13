<%@ include file="header.jsp" %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Listes Commandes </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
</head>
<body>



<h3 class="text-center">Listes des Paniers Commandes</h3>
	<section class="container">
		<div class="row">
         	<div class="col-12">
				<table class="table" data-toggle="table" data-search="true" data-show-columns="true" data-pagination="true">
					<thead class="thead-dark">
					<tr>
					<th data-sortable="true" data-field="code Commande">code Commande </th>
					<th>Users</th>
					<th data-sortable="true" data-field="code Produit">code Produit</th>
					<th>Quantite total</th>
					<th data-sortable="true" data-field="date Commande">date Commande</th>
					<th>Modifier</th>
					<th>Supprimer</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="commandes">
					<tr>
						<td><s:property value="codeCmd"/></td>
						<td><s:property value="client"/></td>
						<td><s:property value="codePdt"/></td>
						<td><s:property value="qteCmd"/></td>
						<td>						
						  <s:property value="dateCmd"/>						
						</td>
						<td> 
						<s:url namespace="/" action="editCmd" var="lien8">
						<s:param name="codeC">
						<s:property value="codeCmd"/>
						</s:param>
						</s:url>
						<s:a href="%{lien8}" value="Modifier" class="btn btn-warning">Modifier</s:a>
						</td>
						<td> 
						<s:url namespace="/" action="deleteCmd" var="lien7">
						<s:param name="codeC">
						<s:property value="codeCmd"/>
						</s:param>
						</s:url>
						<s:a href="%{lien7}" value="Supprimer" class="btn btn-danger">Supprimer</s:a>
						</td>
					</tr>	
					</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
	<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/locale/bootstrap-table-fr-FR.min.js"></script>
</body>
</html>