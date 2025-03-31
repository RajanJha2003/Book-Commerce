<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookCommerce:Register</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}

.error {
	color: red;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
				<div class="card-body">
				<h4 class="text-center">Registration Page</h4>
				<%
						String succMsg = (String) session.getAttribute("succMsg");
						if (succMsg != null) {
						%>
						<p class="text-center text-success"><%= succMsg %></p>
						<%
							session.removeAttribute("succMsg");
						}
						String failedMsg = (String) session.getAttribute("failedMsg");
						if (failedMsg != null) {
						%>
						<p class="text-center text-danger"><%= failedMsg %></p>
						<%
							session.removeAttribute("failedMsg");
						}
						%>
						
						<form action="register" method="post" id="register" novalidate>
						
						  <div class="form-group">
						    <label for="exampleInputEmail">Enter Full Name</label>
						    <input type="text" class="form-control" name="name">
						  
						  </div>
						  
						  <div class="form-group">
						    <label for="exampleInputEmail">Email address</label>
						    <input type="email" class="form-control" name="email">
						  
						  </div>
						  
						   <div class="form-group">
						    <label for="exampleInputEmail">Phone No</label>
						    <input type="number" class="form-control" name="phno">
						  
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">Password</label>
						    <input type="password" class="form-control" id="exampleInputPassword1" name="password" required="required">
						  
						  </div>
						  <div class="form-check">
								<input type="checkbox" class="form-check-input" name="check"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Agree terms & Condition</label>
							</div>
							<div class="text-center p-2">
								<button type="submit" class="btn btn-primary btn-block btn-sm">Register</button>
							</div>
						</form>
				
				</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="all_component/footer.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/script.js"></script>

</body>
</html>