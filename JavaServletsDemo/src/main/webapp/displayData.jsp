<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <form action="sort" method="get">
      <label for=""
        >Sort By
        <input type="text" name="sort" list="sortOpt" />
      </label>
      <datalist id="sortOpt" name="choice">
        <option value="age" ></option>
        <option value="name" ></option>
        <option value="email"></option>
      </datalist>
    </form>
  </body>
</html>
