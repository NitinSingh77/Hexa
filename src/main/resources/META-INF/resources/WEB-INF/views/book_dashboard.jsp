<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.example.lba.LibraryBookManagement.model.Book" %>
<%@ page import ="com.example.lba.LibraryBookManagement.model.StatusCategory" %>
<html>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<body>
		<%
			List<Book> books = (List<Book>) request.getAttribute("listBooks"); 
		%>
	       <div class="container-fluid" style="margin: 0%; padding: 0px;">
	           <div class="row">
	               <div class="col-lg-12">
					<%@ include file="navbar.jsp" %>	
	               </div>
	           </div>
	           <div class="row" style="margin-left: 100px;">
	               <div class="col-md-10  mt-4">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="display-6">Available Books</h1>
							<hr>
						</div>
					</div>	
	                   <div class="row mb-4">
						<% 
						for(Book book : books) {
						%>
							<div class="col-sm-4">
							    <div class="card">
							        <div class="card-body">
							          <h5 class="card-title"><%=book.getTitle() %></h5>
							          <h6 class="card-subtitle mb-2 text-muted">Author: <%=book.getAuthor() %></h6>
							          <p class="card-text">Genre: <%=book.getGenre() %></p>
							          <p class="card-text">Publication Year: <%=book.getPubication_year() %></p>
							          <p class="card-text">Status: <%=book.getStatusCategory() %></p>
							          <a href="#" class="card-link">View Details</a>
							        </div>
							    </div>
							</div>							
						<%	
						}%>	                         
	                   </div>

	               </div>
	           </div>
	       </div>
	   </body>
</html>
