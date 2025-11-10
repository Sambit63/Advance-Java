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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <style>
        body {
        font-family: Arial, sans-serif;
        background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
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
      <form action="/updated" method="post">
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
          />
          <small id="nameError" style="color: red;display: none;">Name Should not contain more spaces</small>
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
          />
          <small id="phoneError" style="color: red;display: none;">Phone Number must be 10-digits</small>
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

       // Clent Side Phone Validation
      $(document).ready(() => {
        $("#Phone").on("input", (e) => {
          e.target.value = e.target.value.replace(/[^0-9]/g, "");
          if (e.target.value.length > 10) {
            e.target.value = e.target.value.slice(0, 10);
          }
        });
        $("#Phone").on("blur", (e) => {
          if (e.target.value.length !== 10) {
            $("#phoneError").show();
            e.target.focus();
          } else {
            $("#phoneError").hide();
          }
        });
      });

      // Client Side Name Validation
      $(document).ready(() => {
        $("#name").on("input", (e) => {
          let val = e.target.value;
          //  Only Alphabets
          val = val.replace(/[^A-Za-z\s]/g, "");
          // No Leading Space
          val = val.replace(/^\s+/g, "");
          // No More than one space
          val = val.replace(/\s{2,}/g, " ");
          // No Trailing space
          // val = val.replace(/\s+$/g, "");
          e.target.value = val;
        });
        $("#name").on("blur", (e) => {
          const val = e.target.value.trim();
          const pattern = /^[A-Za-z]+(?:\s[A-Za-z]+)*$/;

          if (!pattern.test(val)) {
            $("#nameError").show();
            e.target.focus();
          } else {
            $("#nameError").hide();
          }
        });
      });
	</script>
  </body>
</html>