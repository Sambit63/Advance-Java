<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home Page</title>
    <!-- Icon -->
    <link
      rel="icon"
      href="https://icon-library.com/images/erp-icon/erp-icon-25.jpg"
    />
    <!-- Boootstrap -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous"
    />
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- DataTables CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"
    />
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <style>
  body {
    background: linear-gradient(135deg, #c9d6ff 0%, #e2e2e2 100%);
    min-height: 100vh;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: flex-start;
    padding-top: 40px;
    font-family: 'Segoe UI', sans-serif;
  }

  .page-wrapper {
    background: #ffffff;
    width: 85%;
    border-radius: 12px;
    box-shadow: 0 6px 18px rgba(0,0,0,0.1);
    padding: 25px 35px;
    animation: fadeIn 0.5s ease-in-out;
  }

  @keyframes fadeIn {
    from { opacity: 0; transform: translateY(10px); }
    to { opacity: 1; transform: translateY(0); }
  }

  h2 {
    text-align: center;
    font-weight: 600;
    color: #316bff;
    margin-bottom: 20px;
    letter-spacing: .5px;
  }

  .messages p {
    border-radius: 6px;
    padding: 8px;
    font-size: 15px;
  }

  .buttons button{
    padding: 8px 28px;
    margin: 0 8px;
    font-weight: 500;
  }
  thead.bg-info > tr > th {
        background-color: rgb(49, 132, 253);
        color: white;
      }
</style>

<body>
  <div class="page-wrapper">

    <h2><u>User Details</u></h2>

    <!-- Success / Error Messages -->
    <div class="messages">
      <c:if test="${not empty msg}">
        <p class="fw-bold text-light bg-success text-center">${msg}</p>
      </c:if>
      <c:if test="${not empty error}">
        <p class="fw-bold text-light bg-danger text-center">${error}</p>
      </c:if>
    </div>

    <!-- Your FORM + TABLE stays SAME -->
    <!-- ↓ DO NOT CHANGE ANYTHING BELOW THIS LINE ↓ -->


      <form method="get">
        <div class="table-container">
          <table
            class="table table-hover table-bordered border-white table-striped"
            id="myTable"
          >
            <thead class="bg-info">
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
    <script>
      $(document).ready(function () {
        $("#myTable").DataTable({
          paging: true,
          searching: true,
          ordering: true,
          info: true,
          lengthMenu: [5, 10, 25, 50, 100], // Rows per page dropdown
          pageLength: 5, // Default rows per page
          columnDefs: [
            { orderable: false, targets: 0 }, // Prevent sorting on radio button column
          ],
        });
      });
    </script>
  </body>
</html>
