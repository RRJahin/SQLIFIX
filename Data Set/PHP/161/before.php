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
$salt = 50;
$conn->query("INSERT INTO User (username,password,salt) VALUES ('{$_POST['name']}','{$_POST['password']}',$salt)");

$conn->close();
?>