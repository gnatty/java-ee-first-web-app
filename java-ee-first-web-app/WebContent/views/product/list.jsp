<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:dashboard>

<c:if test="${empty productList}">
	There is no product.
</c:if>

<c:if test="${not empty productList}">

	<table class="table table-striped">
		<thead>
	  		<tr>
     			<th scope="col">#ID</th>
      			<th scope="col">Name	</th>
      			<th scope="col">Description</th>
      			<th scope="col">Price</th>
      			<th></th>
      		</tr>
      	</thead>
      	<tbody>
      		<c:forEach items="${productList}" var="product"> 
	      		<tr>
		    			<td>
		    				<a href="${projetDir}/dashboard/product/detail/${product.id}"> ${product.id} </a>
		    			</td>
		    			<td>${product.name}</td>
		    			<td>${product.description}</td>
		    			<td>${product.price}</td>
		    			<th><a href="${projetDir}/dashboard/product/remove/${product.id}" class="btn btn-danger">remove</a></th>
		  		</tr>
	  		</c:forEach>
      	</tbody>
      </table>
      
</c:if>

</t:dashboard>