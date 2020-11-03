<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$pass = password_hash($_SESSION['password'],1);
$conn->query("INSERT INTO User (username,password) VALUES ('{$_SESSION['name']}','$pass')");

$conn->close();
