<!DOCTYPE html>
<html lang="en">
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <title>Customer Registration</title>
    <style>
      .hide {
        display: none;
      }
      .bi-eye-fill,
      .bi-eye-slash-fill {
        cursor: pointer;
      }
      .bi-x-circle:hover {
        color: red;
        cursor: pointer;
      }
      .bg-dark {
        background: linear-gradient(45deg, black, cyan);
      }

      /* Dark Mode */
      .dark-mode {
        background-color: #121212 !important;
        color: white !important;
      }

      .dark-mode .card {
        background-color: #1e1e1e;
        color: white;
        box-shadow: 0 0 10px 5px #00f7ff;
      }

      .dark-mode input,
      .dark-mode button {
        background-color: #2b2b2b;
        color: white;
        border: 1px solid #555;
      }

      /* Make placeholders visible in dark mode */
      .dark-mode input::placeholder {
        color: #bbb;
        opacity: 1;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-dark bg-dark p-3">
      <a href="" class="navbar-brand">Flight Management</a>
      <div>
        <button class="btn btn-warning" id="register-btn">Register</button>
        <button class="btn btn-warning" id="login-btn">Login</button>
      </div>
      <div>
        <button id="dark-btn" class="btn text-white">
          <i class="bi bi-moon-stars-fill fs-4"></i>
        </button>
      </div>
    </nav>

    <!-- SignUP Form -->
    <div class="mt-5 m-auto w-50 hide" id="register-form">
      <div class="card p-2">
        <div class="card-header text-center bg-dark text-white">
          <div class="row">
            <div class="col-10">
              <h2>Registration form</h2>
            </div>
            <div class="col-2">
              <h2 class="text-white close-btn">
                <i class="bi bi-x-circle"></i>
              </h2>
            </div>
          </div>
        </div>
        <div class="card-body text-center">
          <form action="signup" method="post">
            <input
              type="text"
              placeholder="Enter the username"
              class="form-control mb-3"
              name="name"
              required
            />
            <input
              type="number"
              placeholder="Enter the Age"
              class="form-control mb-3"
              name="age"
              min="18"
              required
            />
            <input
              type="email"
              placeholder="Enter the email"
              class="form-control mb-3"
              name="email"
              required
            />
            <input
              type="password"
              placeholder="Enter the Password"
              class="form-control mb-3"
              name="password"
              required
            />
            <input
              type="number"
              placeholder="Enter the Phone Number"
              class="form-control mb-3"
              name="phone"
            />
            <input
              type="text"
              placeholder="Enter role"
              class="form-control mb-3"
              name="role"
              list="roleOptions"
            />

            <datalist id="roleOptions">
              <option value="admin"></option>
            </datalist>

            <button type="submit" class="btn btn-primary w-100">
              Register
            </button>
          </form>
        </div>
      </div>
    </div>
    <!-- SignUp form ends here -->

    <!-- Login Form starts -->
    <div class="mt-5 m-auto w-50 hide" id="login-form">
      <div class="card p-2">
        <div class="card-header text-center bg-dark text-white">
          <div class="row">
            <div class="col-10">
              <h2>Login form</h2>
            </div>
            <div class="col-2">
              <h2 class="text-white close-btn">
                <i class="bi bi-x-circle"></i>
              </h2>
            </div>
          </div>
        </div>
        <div class="card-body text-center">
          <form action="login" method="post">
            <input
              type="text"
              placeholder="Enter the email"
              class="form-control mb-3"
              name="email"
              required
            />
            <input
              type="password"
              placeholder="Enter the Password"
              class="form-control mb-3"
              name="password"
              required
            />

            <button type="submit" class="btn btn-primary w-100">Login</button>
          </form>
        </div>
      </div>
    </div>
    <!-- Login form ends here -->

    <script>
      let registerBtn = document.getElementById("register-btn");
      let loginBtn = document.getElementById("login-btn");
      let registerForm = document.getElementById("register-form");
      let loginForm = document.getElementById("login-form");
      let closeBtns = document.querySelectorAll(".close-btn");

      registerBtn.addEventListener("click", function () {
        registerForm.classList.remove("hide");
        loginForm.classList.add("hide");
      });

      loginBtn.addEventListener("click", function () {
        loginForm.classList.remove("hide");
        registerForm.classList.add("hide");
      });

      closeBtns.forEach((btn) => {
        btn.addEventListener("click", function () {
          registerForm.classList.add("hide");
          loginForm.classList.add("hide");
        });
      });

      // Dark mode toggle
      let darkBtn = document.getElementById("dark-btn");
      let isDark = false;

      darkBtn.addEventListener("click", () => {
        if (!isDark) {
          document.body.classList.add("dark-mode");
          darkBtn.querySelector("i").classList.remove("bi-moon-stars-fill");
          darkBtn.querySelector("i").classList.add("bi-brightness-high-fill");
          isDark = true;
        } else {
          document.body.classList.remove("dark-mode");
          darkBtn
            .querySelector("i")
            .classList.remove("bi-brightness-high-fill");
          darkBtn.querySelector("i").classList.add("bi-moon-stars-fill");
          isDark = false;
        }
      });
    </script>
  </body>
</html>
