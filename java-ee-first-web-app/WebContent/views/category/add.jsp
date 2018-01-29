<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:dashboard>

<form method="POST" action="${projetDir}/dashboard/category/add">

<div class="form-group">
	<label for="username">name</label>
	<input class="form-control" type="text" name="name" />
</div>

<div class="form-group">
	<button type="submit" class="btn btn-primary">Submit</button>
</div>

</form>

</t:dashboard>