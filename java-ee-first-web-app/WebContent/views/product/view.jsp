<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:dashboard>

<c:if test="${empty product}">
	No product id selected
</c:if>

<c:if test="${not empty product}">
	<div class="card">
	
		<img class="card-img-top" src="http://via.placeholder.com/500x150">
		<div class="card-body">
	    		<h4 class="card-title">${product.name}</h4>
	    		<p class="card-text">${product.description}</p>
	  	</div>
	  	
	  	<ul class="list-group list-group-flush">
	    		<li class="list-group-item">${product.price}$</li>
	  	</ul>
	  </div>
</c:if>

</t:dashboard>
