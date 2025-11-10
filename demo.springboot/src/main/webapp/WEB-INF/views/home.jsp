<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <link
      rel="icon"
      href="https://icon-library.com/images/erp-icon/erp-icon-25.jpg"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous"
    />
    <style>
      body {
        font-family: Arial, sans-serif;
        background-image: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }
      .table-container {
        border-radius: 10px 10px 0 0;
        overflow: hidden;
        box-shadow: 0 4px 8px #555555;
      }
      table {
        width: 100%;
        border-collapse: collapse;
      }
      .table {
        margin-bottom: 0;
      }
      thead.bg-info > tr > th {
        background-color: rgb(49, 132, 253);
        color: white;
      }
      border-white {
        color: white;
      }
      h2 {
        color: rgb(49, 132, 253);
      }
	  .attribute
	       {
	         position: sticky;
	         top:0;
	       }
		
    </style>
  </head>
  <body>
    <div class="w-75 m-auto">
      <div class="text-center">
        <h2><u>User Details</u></h2>
      </div>
	  <!-- Sucess Message -->
	        <c:if test="${not empty msg}">
	          <p class="fw-bolder text-light bg-success text-center">${msg}</p>
	        </c:if>
      <!-- Error Message -->
      <c:if test="${not empty error}">
        <p class="fw-bolder text-light bg-danger text-center">${error}</p>
      </c:if>
      <form method="get">
        <div class="table-container">
          <table
            class="table table-hover table-bordered border-white table-striped"
          >
            <thead class="bg-info attribute">
              <tr>
                <th>Select</th>
                <th>UserName</th>
                <th>Designation</th>
                <th>Address</th>
                <th class="text-center">Ph No</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Gender</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="u" items="${users}">
                <tr>
                  <td class="text-center">
                    <input type="radio" name="id" value="${u.id}" />
                  </td>
                  <td>${u.username}</td>
                  <td>${u.designation.role}</td>
                  <td>${u.address}</td>
                  <td class="text-center">${u.phno}</td>
                  <td>${u.dobFormatted}</td>
                  <td>${u.email}</td>
                  <td>${u.gender}</td>
                </tr>
              </c:forEach>
            </tbody>
            <tfoot>
              <!-- Pagination Buttons -->
              <tr>
                <td colspan="8" class="text-end">
                  <c:if test="${currentPage > 0}">
                    <a href="/?page=${currentPage - 1}" class="btn btn-outline-info"
                      >Previous</a
                    >
                  </c:if>
                  <c:if test="${currentPage < totalPages-1}">
                    <a href="/?page=${currentPage+1}" class="btn btn-outline-info"
                      >Next</a
                    >
                  </c:if>
                </td>
              </tr>
            </tfoot>
          </table>
        </div>
        <div class="buttons my-2 text-center">
          <button formaction="/addUser" class="btn btn-primary">Add</button>
          <button formaction="/update" class="btn btn-warning">Edit</button>

          <button
            class="btn btn-danger"
            onclick="return confirm('Are You Confirm to delete ?')"
            formaction="/delete"
          >
            Delete
          </button>
        </div>
      </form>
    </div>
  </body>
</html>
