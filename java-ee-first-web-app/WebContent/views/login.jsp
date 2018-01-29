<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

<div class="container col-5">

<h1>Log In</h1>

<form method="POST" action="${projetDir}/login">

<div class="form-group">
	<label for="username">Username</label>
	<input class="form-control" type="text" name="username" />
</div>

<div class="form-group">
	<label for="username">Password</label>
	<input class="form-control" type="text" name="password" />
</div>

<div class="form-group">
	<button type="submit" class="btn btn-primary">Submit</button>
</div>

</form>

</div>

</t:template>