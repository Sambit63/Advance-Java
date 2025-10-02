<%@ page session="true" %> <%@ page import="model.User" %> <% User user = (User)
session.getAttribute("user"); if (user == null ||
!"admin".equalsIgnoreCase(user.getRole())) {
response.sendRedirect("signUp.jsp"); return; } %> <%@ page
import="java.util.List, model.Flight" %> <% List<Flight>
  flights = (List<Flight
    >) request.getAttribute("flights"); %>
    <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Flight Booking</title>
        <style>
          @import url(https://fonts.googleapis.com/css2?family=Montserrat&display=swap);
          @import url(https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined);
        </style>
      </head>
      <body>
        <div id="webcrumbs">
          <div class="bg-gray-100 min-h-screen">
            <header class="bg-white shadow-md">
              <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                <div class="flex justify-between items-center py-4">
                  <div class="flex items-center">
                    <span
                      class="material-symbols-outlined text-primary-600 text-3xl mr-2"
                      >flight</span
                    >
                    <h1 class="text-xl font-bold text-gray-800">
                      FlightAdmin Dashboard
                    </h1>
                  </div>
                  <div class="flex items-center">
                    <div class="relative mr-4">
                      <input
                        type="text"
                        placeholder="Search..."
                        class="pl-10 pr-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                      />
                      <span
                        class="material-symbols-outlined absolute left-3 top-2.5 text-gray-400"
                        >search</span
                      >
                    </div>
                    <div class="flex items-center">
                      <div class="relative">
                        <button class="flex items-center focus:outline-none">
                          <img
                            src="${pageContext.request.contextPath}/images/admin.jpg"
                            alt="Admin profile"
                            class="h-8 w-8 rounded-full object-cover border-2 border-primary-500"
                          />

                          <span
                            class="ml-2 font-medium text-gray-700 hidden md:block"
                            >Admin User</span
                          >
                          <span
                            class="material-symbols-outlined text-gray-400 ml-1"
                            >expand_more</span
                          >
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </header>
            <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
              <div class="grid grid-cols-1 md:grid-cols-3 lg:grid-cols-4 gap-6">
                <!-- Navbar Starts Here -->
                <div class="col-span-1 bg-white rounded-lg shadow-md p-4 h-fit">
                  <nav>
                    <ul>
                      <li class="mb-1">
                        <a
                          href="#"
                          class="flex items-center px-4 py-3 text-gray-800 bg-primary-100 rounded-lg font-medium transition hover:bg-primary-200"
                        >
                          <span class="material-symbols-outlined mr-3"
                            >dashboard</span
                          >
                          Dashboard
                        </a>
                      </li>
                      <li class="mb-1">
                        <a
                          href="viewAllFlights"
                          class="flex items-center px-4 py-3 text-gray-700 rounded-lg font-medium transition hover:bg-gray-100"
                        >
                          <span class="material-symbols-outlined mr-3"
                            >airplane_ticket</span
                          >
                          Flights
                        </a>
                      </li>

                      <li class="mb-1">
                        <a
                          href="#"
                          class="flex items-center px-4 py-3 text-gray-700 rounded-lg font-medium transition hover:bg-gray-100"
                        >
                          <span class="material-symbols-outlined mr-3"
                            >schedule</span
                          >
                          Schedules
                        </a>
                      </li>
                      <li class="mb-1">
                        <a
                          href="#"
                          class="flex items-center px-4 py-3 text-gray-700 rounded-lg font-medium transition hover:bg-gray-100"
                        >
                          <span class="material-symbols-outlined mr-3"
                            >groups</span
                          >
                          Passengers
                        </a>
                      </li>
                      <li class="mb-1">
                        <a
                          href="#"
                          class="flex items-center px-4 py-3 text-gray-700 rounded-lg font-medium transition hover:bg-gray-100"
                        >
                          <span class="material-symbols-outlined mr-3"
                            >settings</span
                          >
                          Settings
                        </a>
                      </li>
                      <li class="mt-6">
                        <a
                          href="logout"
                          class="flex items-center px-4 py-3 text-red-600 rounded-lg font-medium transition hover:bg-red-50"
                        >
                          <span class="material-symbols-outlined mr-3"
                            >logout</span
                          >
                          Logout
                        </a>
                      </li>
                    </ul>
                  </nav>
                </div>
                <div class="col-span-1 md:col-span-2 lg:col-span-3 space-y-6">
                  <div
                    class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4"
                  >
                    <div
                      class="bg-white rounded-lg shadow-md p-6 transform hover:scale-105 transition duration-300"
                    >
                      <div class="flex items-center justify-between">
                        <div>
                          <p class="text-gray-500 text-sm">Total Flights</p>
                          <h3 class="text-2xl font-bold mt-1">2,534</h3>
                          <p
                            class="text-green-500 text-sm mt-2 flex items-center"
                          >
                            <span class="material-symbols-outlined text-sm mr-1"
                              >trending_up</span
                            >
                            4.7% from last week
                          </p>
                        </div>
                        <div class="bg-primary-100 p-3 rounded-full">
                          <span
                            class="material-symbols-outlined text-primary-600 text-2xl"
                            >flight_takeoff</span
                          >
                        </div>
                      </div>
                    </div>
                    <div
                      class="bg-white rounded-lg shadow-md p-6 transform hover:scale-105 transition duration-300"
                    >
                      <div class="flex items-center justify-between">
                        <div>
                          <p class="text-gray-500 text-sm">Active Flights</p>
                          <h3 class="text-2xl font-bold mt-1">186</h3>
                          <p
                            class="text-green-500 text-sm mt-2 flex items-center"
                          >
                            <span class="material-symbols-outlined text-sm mr-1"
                              >trending_up</span
                            >
                            2.1% from yesterday
                          </p>
                        </div>
                        <div class="bg-green-100 p-3 rounded-full">
                          <span
                            class="material-symbols-outlined text-green-600 text-2xl"
                            >radar</span
                          >
                        </div>
                      </div>
                    </div>
                    <div
                      class="bg-white rounded-lg shadow-md p-6 transform hover:scale-105 transition duration-300"
                    >
                      <div class="flex items-center justify-between">
                        <div>
                          <p class="text-gray-500 text-sm">Delayed Flights</p>
                          <h3 class="text-2xl font-bold mt-1">24</h3>
                          <p
                            class="text-red-500 text-sm mt-2 flex items-center"
                          >
                            <span class="material-symbols-outlined text-sm mr-1"
                              >trending_down</span
                            >
                            1.3% from last week
                          </p>
                        </div>
                        <div class="bg-red-100 p-3 rounded-full">
                          <span
                            class="material-symbols-outlined text-red-600 text-2xl"
                            >schedule</span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="bg-white rounded-lg shadow-md overflow-hidden">
                    <div class="border-b">
                      <div class="flex">
                        <button
                          id="btnAdd"
                          type="button"
                          onclick="showForm('add')"
                          class="px-6 py-3 font-medium flex items-center border-b-2"
                        >
                          <span class="material-symbols-outlined mr-2"
                            >add_circle</span
                          >
                          Add Flight
                        </button>
                        <button
                          id="btnUpdate"
                          type="button"
                          onclick="showForm('update')"
                          class="px-6 py-3 font-medium flex items-center border-b-2"
                        >
                          <span class="material-symbols-outlined mr-2"
                            >edit</span
                          >
                          Update Flight
                        </button>
                        <button
                          id="btnDelete"
                          type="button"
                          onclick="showForm('delete')"
                          class="px-6 py-3 font-medium flex items-center border-b-2"
                        >
                          <span class="material-symbols-outlined mr-2"
                            >delete</span
                          >
                          Delete Flight
                        </button>
                      </div>
                    </div>

                    <!-- Add Flight Form -->
                    <div id="addForm" class="p-6">
                      <h2 class="text-xl font-semibold mb-6">Add New Flight</h2>
                      <form action="addFlight" method="post">
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Flight Number</label
                            >
                            <input
                              type="text"
                              name="flight_number"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              placeholder="e.g. FL2345"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Airline</label
                            >
                            <input
                              type="text"
                              name="airline"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              placeholder="e.g. Indigo"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >From</label
                            >
                            <input
                              type="text"
                              name="source"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              placeholder="e.g. New York (JFK)"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >To</label
                            >
                            <input
                              type="text"
                              name="destination"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              placeholder="e.g. London (LHR)"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Departure Date</label
                            >
                            <input
                              type="date"
                              name="departure_date"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Departure Time</label
                            >
                            <input
                              type="time"
                              name="departure_time"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Arrival Time</label
                            >
                            <input
                              type="time"
                              name="arrival_time"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Price</label
                            >
                            <input
                              type="number"
                              name="price"
                              step="0.01"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              placeholder="e.g. 4500.00"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Seats</label
                            >
                            <input
                              type="number"
                              name="seats"
                              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-primary-500 focus:border-transparent transition"
                              placeholder="Number of seats"
                              required
                            />
                          </div>
                        </div>
                        <div class="mt-6 flex justify-end space-x-4">
                          <button
                            type="reset"
                            class="px-6 py-2 rounded-lg text-gray-700 border border-gray-300 hover:bg-gray-50 transition"
                          >
                            Clear Form
                          </button>
                          <button
                            type="submit"
                            class="px-6 py-2 rounded-lg bg-primary-600 text-white hover:bg-primary-700 focus:ring-4 focus:ring-primary-300 transition"
                          >
                            Add Flight
                          </button>
                        </div>
                      </form>
                    </div>

                    <!-- Update Flight Form -->
                    <div id="updateForm" class="p-6 hidden">
                      <h2 class="text-xl font-semibold mb-6">
                        Update Flight Details
                      </h2>
                      <form action="updateFlight" method="post">
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Flight Number</label
                            >
                            <input
                              type="text"
                              name="flight_number"
                              class="w-full px-4 py-2 border rounded-lg"
                              placeholder="Enter Flight Number"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Departure Date</label
                            >
                            <input
                              type="date"
                              name="departure_date"
                              class="w-full px-4 py-2 border rounded-lg"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Departure Time</label
                            >
                            <input
                              type="time"
                              name="departure_time"
                              class="w-full px-4 py-2 border rounded-lg"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Arrival Time</label
                            >
                            <input
                              type="time"
                              name="arrival_time"
                              class="w-full px-4 py-2 border rounded-lg"
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                              >Price</label
                            >
                            <input
                              type="number"
                              step="0.01"
                              name="price"
                              class="w-full px-4 py-2 border rounded-lg"
                              required
                            />
                          </div>
                        </div>
                        <div class="mt-6 flex justify-end space-x-4">
                          <button
                            type="reset"
                            class="px-6 py-2 rounded-lg border"
                          >
                            Clear
                          </button>
                          <button
                            type="submit"
                            class="px-6 py-2 rounded-lg bg-blue-600 text-white"
                          >
                            Update Flight
                          </button>
                        </div>
                      </form>
                    </div>
                    <!-- Delete Flight Form -->
                    <div id="deleteForm" class="p-6 hidden">
                      <h2 class="text-xl font-semibold mb-6">Delete Flight</h2>
                      <form action="deleteFlight" method="post">
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                            >
                              Flight Number
                            </label>
                            <input
                              type="text"
                              name="flight_number"
                              class="w-full px-4 py-2 border rounded-lg"
                              placeholder="Enter Flight Number"
                              required
                            />
                          </div>
                          <div>
                            <label
                              class="block text-sm font-medium text-gray-700 mb-1"
                            >
                              Airline
                            </label>
                            <input
                              type="text"
                              name="airline"
                              class="w-full px-4 py-2 border rounded-lg"
                              placeholder="Enter Airline Name"
                              required
                            />
                          </div>
                        </div>
                        <div class="mt-6 flex justify-end space-x-4">
                          <button
                            type="reset"
                            class="px-6 py-2 rounded-lg border"
                          >
                            Clear
                          </button>
                          <button
                            type="submit"
                            class="px-6 py-2 rounded-lg bg-red-600 text-white hover:bg-red-700"
                          >
                            Delete Flight
                          </button>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Recent Flight Records Page  Starts-->

          <div id="recentFlights" class="p-6">
            <h2 class="text-xl font-semibold mb-4">All Flights</h2>
            <table
              class="min-w-full border border-gray-200 rounded-lg overflow-hidden shadow-md"
            >
              <thead class="bg-primary-600 text-white">
                <tr>
                  <th class="px-4 py-2">Flight Number</th>
                  <th class="px-4 py-2">Airline</th>
                  <th class="px-4 py-2">From</th>
                  <th class="px-4 py-2">To</th>
                  <th class="px-4 py-2">Departure Date</th>
                  <th class="px-4 py-2">Departure Time</th>
                  <th class="px-4 py-2">Arrival Time</th>
                  <th class="px-4 py-2">Price</th>
                  <th class="px-4 py-2">Seats</th>
                </tr>
              </thead>
              <tbody class="bg-white">
                <% if (flights != null && !flights.isEmpty()) { for (Flight f :
                flights) { %>
                <tr class="border-b hover:bg-gray-50">
                  <td class="px-4 py-2"><%= f.getFlightNumber() %></td>
                  <td class="px-4 py-2"><%= f.getAirline() %></td>
                  <td class="px-4 py-2"><%= f.getSource() %></td>
                  <td class="px-4 py-2"><%= f.getDestination() %></td>
                  <td class="px-4 py-2"><%= f.getDepartureDate() %></td>
                  <td class="px-4 py-2"><%= f.getDepartureTime() %></td>
                  <td class="px-4 py-2"><%= f.getArrivalTime() %></td>
                  <td class="px-4 py-2"><%= f.getPrice() %></td>
                  <td class="px-4 py-2"><%= f.getSeats() %></td>
                </tr>
                <% } } else { %>
                <tr>
                  <td colspan="9" class="px-4 py-2 text-center text-gray-500">
                    No flights available.
                  </td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>

          <!-- Recent Flight Records Ends -->
        </div>

        <script src="https://cdn.tailwindcss.com"></script>
        <script>
          tailwind.config = {
            content: ["./src/**/*.{html,js}"],
            theme: {
              name: "Forest",
              fontFamily: {
                sans: [
                  "Montserrat",
                  "ui-sans-serif",
                  "system-ui",
                  "sans-serif",
                  '"Apple Color Emoji"',
                  '"Segoe UI Emoji"',
                  '"Segoe UI Symbol"',
                  '"Noto Color Emoji"',
                ],
              },
              extend: {
                fontFamily: {
                  title: [
                    "Montserrat",
                    "ui-sans-serif",
                    "system-ui",
                    "sans-serif",
                    '"Apple Color Emoji"',
                    '"Segoe UI Emoji"',
                    '"Segoe UI Symbol"',
                    '"Noto Color Emoji"',
                  ],
                  body: [
                    "Montserrat",
                    "ui-sans-serif",
                    "system-ui",
                    "sans-serif",
                    '"Apple Color Emoji"',
                    '"Segoe UI Emoji"',
                    '"Segoe UI Symbol"',
                    '"Noto Color Emoji"',
                  ],
                },
                colors: {
                  neutral: {
                    50: "#171212",
                    100: "#161111",
                    200: "#161111",
                    300: "#151010",
                    400: "#141010",
                    500: "#140F0F",
                    600: "#090707",
                    700: "#070505",
                    800: "#050404",
                    900: "#020202",
                    DEFAULT: "#171212",
                  },
                  primary: {
                    50: "#E9F8EE",
                    100: "#DDF4E5",
                    200: "#B9E9CA",
                    300: "#1EB853",
                    400: "#1BA64B",
                    500: "#189342",
                    600: "#178A3E",
                    700: "#126E32",
                    800: "#0D5325",
                    900: "#0B401D",
                    DEFAULT: "#1EB853",
                  },
                },
              },
              fontSize: {
                xs: ["12px", { lineHeight: "19.200000000000003px" }],
                sm: ["14px", { lineHeight: "21px" }],
                base: ["16px", { lineHeight: "25.6px" }],
                lg: ["18px", { lineHeight: "27px" }],
                xl: ["20px", { lineHeight: "28px" }],
                "2xl": ["24px", { lineHeight: "31.200000000000003px" }],
                "3xl": ["30px", { lineHeight: "36px" }],
                "4xl": ["36px", { lineHeight: "41.4px" }],
                "5xl": ["48px", { lineHeight: "52.800000000000004px" }],
                "6xl": ["60px", { lineHeight: "66px" }],
                "7xl": ["72px", { lineHeight: "75.60000000000001px" }],
                "8xl": ["96px", { lineHeight: "100.80000000000001px" }],
                "9xl": ["128px", { lineHeight: "134.4px" }],
              },
              borderRadius: {
                none: "0px",
                sm: "1.5px",
                DEFAULT: "3px",
                md: "4.5px",
                lg: "6px",
                xl: "9px",
                "2xl": "12px",
                "3xl": "18px",
                full: "9999px",
              },
              spacing: {
                0: "0px",
                1: "5px",
                2: "10px",
                3: "15px",
                4: "20px",
                5: "25px",
                6: "30px",
                7: "35px",
                8: "40px",
                9: "45px",
                10: "50px",
                11: "55px",
                12: "60px",
                14: "70px",
                16: "80px",
                20: "100px",
                24: "120px",
                28: "140px",
                32: "160px",
                36: "180px",
                40: "200px",
                44: "220px",
                48: "240px",
                52: "260px",
                56: "280px",
                60: "300px",
                64: "320px",
                72: "360px",
                80: "400px",
                96: "480px",
                px: "1px",
                0.5: "2.5px",
                1.5: "7.5px",
                2.5: "12.5px",
                3.5: "17.5px",
              },
            },
            plugins: [],
            important: "#webcrumbs",
          };

          function showForm(form) {
            // hide all forms
            document.getElementById("addForm").classList.add("hidden");
            document.getElementById("updateForm").classList.add("hidden");
            document.getElementById("deleteForm").classList.add("hidden");

            // reset button styles
            ["btnAdd", "btnUpdate", "btnDelete"].forEach((id) => {
              document
                .getElementById(id)
                .classList.remove("text-primary-600", "border-primary-500");
              document.getElementById(id).classList.add("text-gray-500");
            });

            // show selected form + active styles
            if (form === "add") {
              document.getElementById("addForm").classList.remove("hidden");
              document
                .getElementById("btnAdd")
                .classList.add("text-primary-600", "border-primary-500");
              document
                .getElementById("btnAdd")
                .classList.remove("text-gray-500");
            } else if (form === "update") {
              document.getElementById("updateForm").classList.remove("hidden");
              document
                .getElementById("btnUpdate")
                .classList.add("text-primary-600", "border-primary-500");
              document
                .getElementById("btnUpdate")
                .classList.remove("text-gray-500");
            } else if (form === "delete") {
              document.getElementById("deleteForm").classList.remove("hidden");
              document
                .getElementById("btnDelete")
                .classList.add("text-primary-600", "border-primary-500");
              document
                .getElementById("btnDelete")
                .classList.remove("text-gray-500");
            }
          }

          // Toggle flights section when clicking "Flights" link
          document
            .querySelector("a[href='#recentFlights']")
            .addEventListener("click", function (e) {
              e.preventDefault();
              const section = document.getElementById("recentFlights");
              section.classList.toggle("hidden");
            });
        </script>
      </body>
    </html>
  </Flight></Flight
>
