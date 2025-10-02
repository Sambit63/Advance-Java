<!DOCTYPE html>
<html lang="en">
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <title>Calculator</title>
    <style>
      
      .bi-eye-fill,
      .bi-eye-slash-fill {
        cursor: pointer;
      }
      .bi-x-circle:hover {
        background-color: red;
        border-radius: 50%;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-dark bg-dark p-3">
      <a href="" class="navbar-brand">Area and perimeter calculator</a>
      <button class="btn btn-warning me-5" id="login-btn">Calculator</button>
    </nav>
    <div class="mt-5 m-auto w-50 hide" id="display-form">
      <div class="card p-2">
        <div class="card-header text-center bg-dark text-white">
          <div class="row">
            <div class="col-10">
              <h2>Area Of Circle</h2>
            </div>
            <div class="col-2">
              <h2 class="text-white" id="collapse">
                <i class="bi bi-x-circle"></i>
              </h2>
            </div>
          </div>
        </div>
        <div class="card-body text-center">
          <form action="calculate">
           <input
  type="text"
  placeholder="Enter the Radius"
  class="form-control"
  name="radius"
  value="<%= request.getParameter("radius") != null ? request.getParameter("radius") : "" %>"
  required
/>

            <button type="submit" class="btn btn-dark mt-3">calculate</button>
          </form>
        </div>
        <div class="card-footer text-center">
          <%-- Show results only if present --%> <% Double area = (Double)
          request.getAttribute("area"); Double perimeter = (Double)
          request.getAttribute("perimeter"); if (area != null && perimeter !=
          null) { %>
          <div class="mt-3 text-start">
            <h4 class="text-success">Area of Circle: <%= area %></h4>
            <h4 class="text-success">Perimeter of Circle: <%= perimeter %></h4>
          </div>
          <% } %>
        </div>
      </div>
    </div>
    <script>
      let loginBtn = document.getElementById("login-btn");
      let displayEle = document.getElementById("display-form");
      let collapse = document.getElementById("collapse");

      loginBtn.addEventListener("click", function () {
        displayEle.classList.remove("hide");
      });
      collapse.addEventListener("click", function () {
        displayEle.classList.add("hide");
      });
    </script>
  </body>
</html>
