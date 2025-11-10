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
    <title>update</title>
  </head>
  <body>
    <div class="w-50 m-auto form-container p-2">
      <h2>Update User</h2>
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
            type="number"
            name="phno"
            id="Phone"
            value="${user.phno}"
            required
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
            class="btn btn-primary"
            type="submit"
            onclick="return confirm('Are you sure to update ?')"
          >
            Update
          </button>
          <button class="btn btn-warning" onclick="window.location.href='/';">
            Back
          </button>
        </div>
      </form>
    </div>
  </body>
</html>
