<%@include file="Menu.jsp" %>


<h3 align="center">Update Category</h3>

<form action="<c:url value="/updateCategory"/>" method="post">
<table align="center" class="table table-bordered">
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="catId" value="${category.categoryId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<center>
			<input type="submit" value="Update Category"/>
			</center>
		</td>
	</tr>
</table>
</form>

</div>
</body>
</html>