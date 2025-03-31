<%@page import="model.CategoryPojo"%>
<%@page import="java.util.List"%>
<%@page import="operationsImp.BookImp"%>
<%@page import="operationsImp.CartImp"%>
<%@page import="model.UserPojo"%>
<div class="container-fluid" style="height:5px;background-color: #303f9f">
 
</div>


<div class="container-fluid p-3 bg-light">
<div class="row">
   <div class="col-md-3 text-success">
   <h3>
   <i class="fas fa-book"></i> Book Commerce</h3>
   </div>
   <div class="col-md-4 text-center">
      <form action="search.jsp" class="form-inline my-2 my-lg-0" method="post">
      <input class="form-control mr-sm-2" type="search" name="ch" placeholder="Search" aria-label="Search">
      <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
      </form>
   </div>
   <%
        UserPojo userobj = (UserPojo) session.getAttribute("userobj");
        if (userobj != null) {
        %>
        <div class="col-md-5">
          <div class="row">
            <%
             CartImp cartImp=new CartImp();
             int count=cartImp.countCart(userobj.getId());
            
            %>
            <div class="col-md-4 text-right pt-1 pr-0">
              <span style="font-size:24px">(<%=count %>)</span>
              <a href="checkout.jsp">
              <i class="fas fa-cart-plus fa-2x"></i>
              </a>
            </div>
            <div class="col-md-8">
            <a href="#" class="btn btn-success"><i
							class="fas fa-user-plus"></i> ${userobj.name}</a> <a href="logout"
							class="btn btn-primary text-white"><i
							class="fas fa-sign-in-alt"></i> Logout</a>
            </div>
          </div>
        </div>
        
        
       <%
                    }else{
                    %>
                    <div class="col-md-3">
				<a href="login.jsp" class="btn btn-success"><i
					class="fas fa-sign-in-alt"></i> Login</a> <a href="register.jsp"
					class="btn btn-primary text-white"><i class="fas fa-user-plus"></i>
					Register</a>
			</div>
                    
                    
                    <%
                    }
                    %>
</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="#"><i class="fas fa-home"></i></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			 <li class="nav-item active"><a class="nav-link"
				href="all_recent_book.jsp"><i class="fas fa-book-open"></i>
					Recent Book</a></li>
     <li class="nav-item dropdown"><a
				class="nav-link active dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Categories </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<%
					BookImp bookImp=new BookImp();
					List<CategoryPojo> listx = bookImp.getAllCategory();
					for (CategoryPojo c : listx) {
					%>
					<a class="dropdown-item"
						href="catogory_book.jsp?ca=<%=c.getCategoryName()%>"><%=c.getCategoryName()%></a>
					<%
					}
					%>

				</div></li>

			<li class="nav-item active"><a class="nav-link disabled"
				href="all_old_book.jsp"><i class="fas fa-book-open"></i> Old
					Book</a></li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
			<a href="setting.jsp" class="btn btn-light my-2 my-sm-0"
				type="submit"> <i class="fas fa-cog"></i> Setting
			</a> <a href="helpline.jsp" class="btn btn-light my-2 my-sm-0 ml-1"
				type="submit"> <i class="fas fa-phone-square-alt"></i> Contact
				Us
			</a>
		</form>
  </div>
</nav>