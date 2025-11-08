<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <link rel="icon" href="https://icon-library.com/images/erp-icon/erp-icon-25.jpg">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous"
    />
    <style>
      .table-container {
        border-radius: 10px 10px 0 0;
        overflow: hidden;
        box-shadow: 0 4px 8px #555555;
      }
      table {
        width: 100%;
        border-collapse: collapse;
      }
    </style>
  </head>
  <body>
    <div class="w-75 m-auto">
      <h2>User Details</h2>
	  <!-- Error Message -->
	        <c:if test="${not empty error}">
	          <p class="fw-bolder text-light bg-danger text-center">${error}</p>
	        </c:if>
      <form method="get">
        <div class="table-container">
          <table class="table table-hover table-bordered border-dark">
            <thead class="table-dark">
              <tr class="table-active">
                <th>Select</th>
                <th>UserName</th>
                <th>Designation</th>
                <th>Address</th>
                <th>Ph No</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Gender</th>
              </tr>
            </thead>
            <c:forEach var="u" items="${users}">
              <tbody>
                <tr>
                  <td>
                    <input
                      type="radio"
                      name="id"
                      value="${u.id}"
                      
                    />
                  </td>
                  <td>${u.username}</td>
                  <td>${u.designation.role}</td>
                  <td>${u.address}</td>
                  <td>${u.phno}</td>
                  <td>${u.dob}</td>
                  <td>${u.email}</td>
                  <td>${u.gender}</td>
                </tr>
              </tbody>
            </c:forEach>
          </table>
        </div>
        <div class="buttons my-2 m-auto w-50">
          <button formaction="/addUser" class="btn btn-primary">
            Add User
          </button>
          <button formaction="/update" class="btn btn-success">
            Edit User
          </button>

          <button
            class="btn btn-danger"
            onclick="return confirm('Are You Confirm to delete ?')"
            formaction="/delete"
          >
            Delete User
          </button>
        </div>
      </form>
    </div>
  </body>
</html>
