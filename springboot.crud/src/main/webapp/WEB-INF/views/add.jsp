<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Page</title>
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
      .form-container {
        border-radius: 5px;
        box-shadow: 0px 4px 8px #555555;
        background-color: #ccc;
      }
      .text-center {
        position: sticky;
        top: 0;
      }
      .error {
        position: sticky;
        top: 40px;
      }
    </style>
  </head>
  <body>
    <!-- Parent Div -->
    <div class="w-25 m-auto form-container p-2">
      <h2 class="text-center"><u>Add New User</u></h2>
      <!-- Error Message -->
      <c:if test="${not empty error}">
        <p class="fw-bolder text-light bg-danger text-center">${error}</p>
      </c:if>
      <form action="save" method="post">
        <!-- Inside form div Starts -->

        <div class="mb-1">
          <label for="name" class="form-label">Name: </label
          ><input
            class="form-control"
            type="text"
            id="name"
            name="username"
            placeholder="Enter Your Name"
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
          ></textarea>
        </div>

        <div class="mb-1">
          <label class="form-label" for="desg">Designation: </label>
          <select class="form-control" name="designation.id" id="desg" required>
            <c:forEach var="d" items="${desig}">
              <option value="${d.id}">${d.role}</option>
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
            required
            maxlength="10"
            oninput="this.value = this.value.replace(/[^0-9]/g,'').slice(0,10)"
          />
        </div>

        <div class="mb-1">
          <label class="form-label" for="DOB">DOB: </label>
          <input
            class="form-control"
            type="date"
            id="DOB"
            name="dob"
            required
          />
        </div>

        <div class="mb-1">
          <label class="form-label" for="mail">Email: </label>
          <input
            type="email"
            id="mail"
            name="email"
            placeholder="ex:sam@gmail.com"
            required
            class="form-control"
          />
        </div>

        <div class="mb-1">
          <label class="form-label" for="gender">Gender: </label>
          <input
            class="form-check-input"
            type="radio"
            value="male"
            name="gender"
          />Male
          <input
            class="form-check-input"
            type="radio"
            value="female"
            name="gender"
          />Female
          <input
            class="form-check-input"
            type="radio"
            value="others"
            name="gender"
          />Others
        </div>

        <div class="w-50 m-auto">
          <button
            class="btn btn-primary"
            type="submit"
            onclick="return confirm('Are You Confirm to Add ?')"
          >
            Submit
          </button>
          <button class="btn btn-warning" onclick="window.location.href='/';">
            Back
          </button>
        </div>

        <!-- Inside form ends -->
      </form>
    </div>
	<script>
	  const today = new Date().toISOString().split("T")[0];
	  document.getElementById("DOB").setAttribute("max", today);
	</script>
  </body>
</html>
