# Weather Info Spring Boot Application

This application provides current weahter for given pincode in <u>**India**</u>.<br>


To Run this App you need **MySQL** database on your machine. <br>
Also, you need to create a blank Schema named **weatherapp**.<br>

For this project I'm using 3rd party API for fetching the weather information: https://openweathermap.org/api <br>
The API key is required and need to add into the **application.properties** file .<br>

-------------------------------------------------------------------------

To test this application you need any HTTP client like postman, thunder client, fast API etc. <br>
Make the request as shown below: <br>
<summary><code>GET</code> <code><b>-</b></code> <code>http://localhost:8080/api/{pincode}</code></summary>

-------------------------------------------------------------------------
