<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2 align="center"> Registering Form</h2>
<form action="verify" align="center" >
Enter the name : <input type="text" name="uname"><br><br>
Enter the password : <input type ="password" name="password"> <br><br>
<input type ="submit" value="Register" align="center"/><br><br><br>
<h2 align="center"> Display information</h2>
</form>
<form action="disp" align="center">
Enter the name : <input type="text" name="name"><br><br>
<input type ="submit" value="Display" align="center"/><br><br><br>
</form>
<h2 align="center"> Remove Account</h2>
<form action="remove" align="center">
Enter the name : <input type="text" name="rename"><br><br>
<input type ="submit" value="Remove" align="center"/><br><br><br>
</form>
</body>
</html>
