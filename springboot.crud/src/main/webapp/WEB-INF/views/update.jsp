<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
      crossorigin="anonymous"
    />
    <link
      rel="icon"
      href="https://icon-library.com/images/erp-icon/erp-icon-25.jpg"
    />
    <style>
        body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        }
        .form-container
        {          
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 20px auto;
            color: rgb(13, 202, 240);
        }
    </style>
    <title>update</title>
  </head>
  <body>
    <div class="w-25 m-auto form-container p-2">
      <div class="bg-info text-white text-center"><h2>Update User</h2></div>
      <!-- Error Message -->
      <c:if test="${not empty error}">
        <p class="fw-bolder text-light bg-danger text-center">${error}</p>
      </c:if>
      <form action="/save" method="post">
        <input type="hidden" name="id" value="${user.id}" />
        <div class="mb-1">
          <label class="form-label" for="name">Name</label>
          <input
            type="text"
            name="username"
            id="name"
            value="${user.username}"
            class="form-control"
            required
			oninput="this.value = this.value.replace(/[^A-Za-z\s]/g,'')"
          />
        </div>
        <div class="mb-1">
          <label class="form-label" for="address">Address: </label>
          <textarea
            class="form-control"
            name="address"
            rows="3"
            id="address"
            required
          >
${user.address}</textarea
          >
        </div>

        <div class="mb-1">
          <label class="form-label" for="desg">Designation: </label>
          <select class="form-control" name="designation.id" id="desg" required>
            <c:forEach var="d" items="${desig}">
              <option value="${d.id}" ${user.designation.id==d.id ?"selected":""}>${d.role}</option>
            </c:forEach>
          </select>
        </div>
        <div class="mb-1">
          <label class="form-label" for="Phone">Ph No: </label>
          <input
            class="form-control"
            type="text"
            name="phno"
            id="Phone"
            value="${user.phno}"
            required
			maxlength="10"
			oninput="this.value = this.value.replace(/[^0-9]/g,'').slice(0,10)"
          />
        </div>
        <div class="mb-1">
          <label class="form-label" for="date">DOB</label>
          <input class="form-control" type="date" id="date" name="dob" value="${user.dob}" />
        </div>
        <!-- <input type="hidden" id="date" name="dob" value="${user.dob}" /> -->
        <div class="mb-1">
          <label class="form-label" for="mail">Email: </label>
          <input
            type="email"
            id="mail"
            name="email"
            placeholder="ex:sam@gmail.com"
            value="${user.email}"
            required
            class="form-control"
          />
        </div>
        <input type="hidden" name="gender" value="${user.gender}" />

        <div class="w-50 m-auto">
          <button
            class="btn btn-warning"
            type="submit"
            onclick="return confirm('Are you sure to update ?')"
          >
            Update
          </button>
          <button type="button" class="btn btn-info" onclick="window.location.href='/';">
            Back
          </button>
        </div>
      </form>
    </div>
	<script>
		  const today = new Date().toISOString().split("T")[0];
		  document.getElementById("date").setAttribute("max", today);
	</script>
  </body>
</html>